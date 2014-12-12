/**
 *
 * UtilityTest.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UtilityTest to test utility class.
 * 
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public class UtilityTest
{
	@Test
	public void testGetUrlByEnvironment()
	{
		assertEquals("http://localhost:8983/solr", Utility.getUrlByEnvironment("dev"));
	}

	@Test
	public void testAddQuotationMarks()
	{
		String name = Utility.addQuotationMarks("张三").toString();
		assertEquals("\"张三\"", name);

		name = Utility.addQuotationMarks("\"张三\"").toString();
		assertEquals("\"张三\"", name);
	}

	@Test
	public void testAddAsterisk()
	{
		String id = Utility.addAsterisk("34566456435654345654345").toString();
		assertEquals("*34566456435654345654345*", id);

	}

}
