package com.google.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
		
		static String configFilePath = new String("sd.properties");
	    static Properties properties = new Properties();
	    static InputStream input = null;
		
		public static String sdpropertiesReader(String propertyKey)
	    {
	    	System.out.println("..TestPropertiesReader.propertersReader()..");
	    	String propertyValue = new String();

			try
			{
			    input = new FileInputStream(configFilePath);
			    properties.load(input);
		
			    propertyValue = properties.getProperty(propertyKey);
		
			} 
			catch (IOException ex) {
			    ex.printStackTrace();
			} 
			finally 
			{
			    if (input != null) {
				try
				{
				    input.close();
				} 
				catch (IOException e) {
				    e.printStackTrace();
				}
			}
		}
			return propertyValue;
	    }
		
		public static String getBrowserTypeProperty()
	    {
			return new String(sdpropertiesReader("browserType"));
	    }
		
		public static String getUrl()
		{
			return new String(sdpropertiesReader("url"));
		}
		
		public static String getName()
		{
			return new String(sdpropertiesReader("userName"));
		}
		
		public static String getEmailid()
		{
			return new String(sdpropertiesReader("emailId"));
		}
		
		

	}
