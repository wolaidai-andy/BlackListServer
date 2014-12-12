/**
 *
 * ErrorMessage.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.common;

/**
 * Common error message.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public final class ErrorMessage
{
	private ErrorMessage()
	{}

	// unexpected error
	public static final String INTERNAL_ERROR = "Internal server error.";

	// error related to connect solr server
	public static final String CONNECTION_ERROR = "error occurred when initialization of solr server.";

	// error related to search solr server.
	public static final String SEARCH_SOLR_ERROR = "error occurred when searching data from solr.";

	// error related to IO operation
	public static final String LOAD_FILE_ERROR = "error occurred when load environment properties file.";

}
