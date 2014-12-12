/**
 *
 * Utility.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.welab.x.blacklist.common.ErrorMessage;

/**
 * Utility class provide some common tool kit method, such as get the current
 * environment information and etc.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public final class Utility
{
	private Utility()
	{}

	private static final Logger LOG = Logger.getLogger(Utility.class);
	private static String quotationMark = "\"";
	private static String asterisk = "*";

	/**
	 * Get the url of current solr environment.
	 * 
	 * @param environment
	 * @return environment url
	 */
	public static String getUrlByEnvironment(String environment)
	{
		Properties props = new Properties();
		try
		{
			InputStream in = new BufferedInputStream(new FileInputStream(
					"solrserver.config.properties"));
			props.load(in);
			return props.getProperty("endpoint_" + environment);
		}
		catch (Exception e)
		{
			LOG.error(ErrorMessage.LOAD_FILE_ERROR, e);
		}

		return null;
	}

	/**
	 * Get the current environment name, the name is set in properties file.
	 * 
	 * @return environment name
	 */
	public static String getCurrentEnvironment()
	{
		Properties props = new Properties();
		try
		{
			InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
			props.load(in);
			return props.getProperty("environment");
		}
		catch (Exception e)
		{
			LOG.error(ErrorMessage.LOAD_FILE_ERROR, e);
		}

		return null;
	}

	/**
	 * Add quotation marks for given param.
	 * 
	 * @param param
	 * @return StringBuilder
	 */
	public static StringBuilder addQuotationMarks(String param)
	{
		if (!"".equals(param) && null != param)
		{
			StringBuilder sbuild = new StringBuilder(quotationMark);

			for (int i = 0; i < param.length(); i++)
			{
				if (isChinese(param.charAt(i)))
				{
					sbuild.append(param.charAt(i));
				}
			}
			sbuild.append(quotationMark);
			
			return sbuild;
		}
		return null;
	}

	/**
	 * Add asterisk for given param.
	 * 
	 * @param param
	 * @return StringBuilder
	 */
	public static StringBuilder addAsterisk(String param)
	{
		if (!"".equals(param) && null != param)
		{
			StringBuilder sbuild = new StringBuilder(asterisk);
			sbuild.append(param);
			sbuild.append(asterisk);
			return sbuild;
		}
		return null;
	}

	/**
	 * Check if it's Chinese.
	 * 
	 * @param c
	 * @return true or false
	 */
	private static boolean isChinese(char c)
	{
		Character.UnicodeBlock ublock = Character.UnicodeBlock.of(c);
		if (ublock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ublock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ublock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ublock == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ublock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ublock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)
		{
			return true;
		}
		return false;
	}
}
