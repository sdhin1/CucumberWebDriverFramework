package com.saudhing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

	protected FileInputStream input = null;
	protected Properties prop = new Properties();
	protected File src = null;

	public ReadConfigFile() {

		try {

			//ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			//prop = new Properties();
			src = new File(Constant.CONFIG_PROPERTIES_DIRECTORY);
			input = new FileInputStream(src);
			prop.load(input);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} 

	}
	
	public String getBrowser() {
		
		if (prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
		
	}

}
