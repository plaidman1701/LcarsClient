package com.plaidman1701.lcarsclient03.ui;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class PresentationUtil {
	
	private static Logger log = Logger.getLogger(PresentationUtil.class);	
	private static final String BUNDLE_NAME = "starship-presentation-client";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getString(String key)
	{
		System.out.println("getString called");
		try
		{
			// return either the environment variable (not likely), or the value from
			// the presentation properties file
			if (System.getenv(key) != null)
			{
				return System.getenv(key);
			}
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (MissingResourceException e)
		{
			System.err.println("Unable to find key [" + key + "] in " + BUNDLE_NAME);
			//log.error("Unable to find key [" + key + "] in " + BUNDLE_NAME);
			return '!' + key + '!';
		}
	}
	
	// same as above, for format response per arguments
	public static String getString(String key, Object... args)
	{
		try
		{
			// per above,
			// return either the environment variable (not likely), or the value from
			// the presentation properties file
			if (System.getenv(key) != null)
			{
				return System.getenv(key);
			}
			String s = RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(s, args);
		}
		catch (MissingResourceException e)
		{
			log.error("Unable to find key [" + key + "] in " + BUNDLE_NAME);
			return '!' + key + '!';
		}
	}
}
