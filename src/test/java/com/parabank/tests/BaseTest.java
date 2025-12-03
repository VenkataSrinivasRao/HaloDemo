package com.parabank.tests;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserContext;
import com.parabank.core.BaseFactory;
import com.parabank.utils.Utilities;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * BaseTest - Handles cleanup operations after each Cucumber scenario.
 * 
 * Responsibilities:
 *  - Capture screenshots for every scenario (pass/fail)
 *  - Capture video only for failed scenarios
 *  - Attach media to Allure reports
 *  - Close Page, BrowserContext, and Playwright safely
 */

public class BaseTest {

	/**
     * Tear down method executed after every scenario.
     * Handles screenshot capture, video saving, Allure attachment,
     * and browser session cleanup.
     */
	
	@After
    public void tearDown(Scenario scenario) {
        
		// Get Playwright Page and Context for the current thread
		
		Page page = BaseFactory.getPage();
        BrowserContext context = BaseFactory.getContext();
        
     // Timestamp appended to media file names to avoid overwriting
        
        String timeStampForCapture = Utilities.generateTimestamp("yyyyMMddHHmmss");

     // Construct screenshot file path
        
        Path screenshotPath = Paths.get("target/screenshots", scenario.getName() + timeStampForCapture + ".png");
        try {
			Files.createDirectories(screenshotPath.getParent());
			byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
	        Files.write(screenshotPath, screenshot);
	        Allure.addAttachment("Screenshot", Files.newInputStream(screenshotPath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        Path videoPath = null;
     // Capture video file path only if scenario failed
        if (scenario.isFailed()) {
            if (page.video() != null) {
                videoPath = page.video().path();
            }
        }
        
     // Close Page + Context (always close before accessing video)

        page.close();
        context.close();
        
     // Save video if available

        if (videoPath != null && Files.exists(videoPath)) {
            try {
                Path targetPath = Paths.get("target/videos", scenario.getName() + timeStampForCapture + ".webm");
                Files.createDirectories(targetPath.getParent());
                Files.move(videoPath, targetPath);
                scenario.attach(Files.readAllBytes(targetPath), "video/webm", "video");
            
                // Attach video to Allure report
                Allure.addAttachment("Video", new ByteArrayInputStream(Files.readAllBytes(targetPath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       
     // Close browser and Playwright instance
        
        BaseFactory.close();
    }
}