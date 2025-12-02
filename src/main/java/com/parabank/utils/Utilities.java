package com.parabank.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

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
