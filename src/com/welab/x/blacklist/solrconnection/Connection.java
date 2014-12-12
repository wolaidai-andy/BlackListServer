/**
 *
 * Connection.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.solrconnection;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

import com.welab.x.blacklist.common.ErrorMessage;

/**
 * This class to get connection from expected server and try to sending a
 * request to that server to check if connection is available.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public final class Connection
{
	private Connection()
	{}

	private static final Logger LOG = Logger.getLogger(Connection.class);

	/**
	 * Build a connection to expected server by given url.
	 * 
	 * @param url
	 * @return SolrServer object
	 * @throws SolrServerException
	 * @throws Exception
	 */
	public static SolrServer getConnection(final String url) throws SolrServerException, Exception
	{
		// create HttpSolrServer object.
		SolrServer server = new HttpSolrServer(url);
		try
		{
			server.ping();
			LOG.info("connection to solr server successfully....");
		}
		catch (SolrServerException e)
		{
			LOG.error(ErrorMessage.CONNECTION_ERROR, e);
			throw e;
		}
		catch (Exception e)
		{
			LOG.error(ErrorMessage.CONNECTION_ERROR, e);
			throw e;
		}

		return server;
	}
}
