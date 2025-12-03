package com.parabank.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

	/**
	 * Retrieves a configuration value from the project's config.properties file.
	 *
	 * @param key the property key whose value needs to be fetched
	 * @return the value associated with the provided key, or an empty string if the key is not found
	 *
	 * This method:
	 *  - Loads the config.properties file from the project root directory
	 *  - Reads all properties into a Properties object
	 *  - Returns the value mapped to the provided key
	 *
	 * If any IOException occurs (e.g., file not found, read error),
	 * it prints the stack trace and returns an empty string.
	 */
	public static Object getConfigProperty(String key) {
		String data = "";
		try {

			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/config.properties");

			Properties prop = new Properties();
			prop.load(file);
			data = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * Method to generate timestamp in specific format
	 *
	 * @param format
	 * @return
	 */
	public static String generateTimestamp(String format) {
		String timeStamp = new SimpleDateFormat(format).format(new Timestamp(System.currentTimeMillis()));
		return timeStamp;
	}

	/**
	 * Method to generate timestamp
	 *
	 * @param format
	 * @return
	 */
	public static String generateTimestamp() {

		Date d = new Date();
		String genTS = d.toString().replace(":", "_").replace(" ", "_");
		return genTS;
	}
	
}
