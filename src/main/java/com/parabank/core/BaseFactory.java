package com.parabank.core;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * BaseFactory is responsible for initializing and managing Playwright instances
 * per test thread using ThreadLocal.  
 * 
 * It provides:
 * - Playwright instance
 * - Browser instance (Chromium, Firefox, WebKit)
 * - BrowserContext with video recording
 * - Page instance for test execution
 * 
 * This setup ensures thread-safe parallel execution.
 */
public class BaseFactory {

	// Thread-local containers for parallel-safe Playwright execution
	private static ThreadLocal<Playwright> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    /**
     * Initializes the Playwright browser based on the provided browser name and headless mode.
     *
     * Steps performed:
     * 1. Creates a Playwright instance for the current thread.
     * 2. Selects the desired browser type (chromium, firefox, webkit).
     * 3. Launches the browser in headless/headed mode.
     * 4. Creates a BrowserContext with video recording enabled.
     * 5. Opens a new Page and returns it.
     *
     * @param browserName Browser type to run ("chromium", "firefox", "webkit")
     * @param headless    true → run without UI, false → run with UI
     * @return Page object for interacting with the web application
     */
    
    public static Page initBrowser(String browserName, boolean headless) {
    	threadLocal.set(Playwright.create());

        BrowserType browserType;
        switch (browserName.toLowerCase()) {
            case "firefox": browserType = threadLocal.get().firefox(); 
            break;
            case "webkit": browserType = threadLocal.get().webkit(); 
            break;
            default: browserType = threadLocal.get().chromium();
        }

     // Create context with video recording enabled
        browser.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless)));
        
        
        context.set(browser.get().newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("target/videos")) 
                .setRecordVideoSize(1280, 720)
            ));
        
     // Create a new page
        page.set(context.get().newPage());
        return page.get();
    }

    /**
     * Returns the Page object for the current thread.
     *
     * @return Page instance
     */
    
    public static Page getPage() { 
    	return page.get(); 
    	}
    
    /**
     * Returns the BrowserContext for the current test execution.
     *
     * @return BrowserContext instance for current thread
     */
    
    public static BrowserContext getContext() {
        return context.get();
    }

    /**
     * Closes the Browser and Playwright instances for the current thread.
     * Should be called at the end of each test run.
     */
    
    public static void close() {
        browser.get().close();
        threadLocal.get().close();
    }
}
