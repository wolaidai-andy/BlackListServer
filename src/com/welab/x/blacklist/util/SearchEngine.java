/**
 *
 * SearchEngine.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.util;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.welab.x.blacklist.common.ErrorMessage;
import com.welab.x.blacklist.solrconnection.Connection;

/**
 * SolrSearchEngine sends request to solr server and get search result from solr
 * server.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public class SearchEngine
{
	private SearchEngine()
	{}

	private static final Logger LOG = Logger.getLogger(SearchEngine.class);

	/**
	 * Query result from server.
	 * 
	 * @param statement
	 * @return SolrDocumentList
	 * @throws SolrServerException
	 * @throws Exception
	 */
	public static SolrDocumentList search(String statement) throws SolrServerException, Exception
	{
		// get current environment information
		String environment = Utility.getCurrentEnvironment();
		// get the connection url for current environment
		String url = Utility.getUrlByEnvironment(environment);

		SolrQuery query = new SolrQuery();
		query.setQuery(statement);
		try
		{
			QueryResponse rsp = Connection.getConnection(url).query(query);
			return rsp.getResults();
		}
		catch (SolrServerException se)
		{
			LOG.error(ErrorMessage.SEARCH_SOLR_ERROR, se);
			throw se;
		}
	}
}
