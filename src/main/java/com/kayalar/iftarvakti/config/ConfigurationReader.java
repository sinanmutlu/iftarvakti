package com.kayalar.iftarvakti.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
	String result = "";
	InputStream inputStream;

	public Configurations getPropValues() throws IOException {

		Properties prop = new Properties();
		String propFileName = "config.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		Configurations config = new Configurations();

		config.setBotToken(prop.getProperty("bot.token"));
		config.setBotUserId(prop.getProperty("bot.user.id"));

		inputStream.close();

		return config;
	}
}