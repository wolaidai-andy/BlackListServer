/**
 *
 * ConnectionManager.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.solrconnection;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * ConnectionManager class to manage solr server connection, will use cache to
 * save an available cache and just return the connection if there's one
 * available in cache.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public final class ConnectionManager
{
	private ConnectionManager()
	{}

	private static final String SOLR_UNIQUE_KEY = "SOLR";
	private static final ConcurrentHashMap<String, SolrServer> SERVER_CACHE = new ConcurrentHashMap<String, SolrServer>();

	/**
	 * Manager connection resource.
	 * 
	 * @param url
	 * @return SolrServer
	 * @throws SolrServerException
	 * @throws Exception
	 */
	public static SolrServer getConnection(final String url) throws SolrServerException, Exception
	{
		synchronized (SERVER_CACHE)
		{
			SolrServer solrServer = SERVER_CACHE.get(SOLR_UNIQUE_KEY);

			if (solrServer == null)
			{
				solrServer = Connection.getConnection(url);
				SERVER_CACHE.put(SOLR_UNIQUE_KEY, solrServer);
			}
			return solrServer;
		}
	}
}
