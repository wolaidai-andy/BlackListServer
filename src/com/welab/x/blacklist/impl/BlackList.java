/**
 *
 * BlackList.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.welab.x.blacklist.inter.IBlackList;
import com.welab.x.blacklist.pojo.QueryResult;
import com.welab.x.blacklist.pojo.QueryResultSet;
import com.welab.x.blacklist.util.SearchEngine;
import com.welab.x.blacklist.util.Utility;

/**
 * BlackList class to search black list by given parameter.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public class BlackList implements IBlackList
{
	/**
	 * @see com.welab.x.blacklist.inter.IBlackList#searchByName(java.lang.String)
	 */
	@Override
	public final QueryResultSet searchByName(final String name) throws SolrServerException,
			Exception
	{
		/*
		 * send request to solr server, add quotation marks(i.e. "") for
		 * name,because we expected solr treat it as exact query.
		 */

		final SolrDocumentList docs = SearchEngine.search(Utility.addQuotationMarks(name)
				.toString());
		return buildQueryResultSet(docs);
	}

	/**
	 * @see com.welab.x.blacklist.inter.IBlackList#searchByID(java.lang.String)
	 */
	@Override
	public final QueryResultSet searchByID(final String identityNumber) throws SolrServerException,
			Exception
	{
		final SolrDocumentList docs = SearchEngine.search(Utility.addAsterisk(identityNumber)
				.toString());
		return buildQueryResultSet(docs);
	}

	/**
	 * Common method to build a query result set.
	 * 
	 * @param docs
	 * @return QueryResultSet
	 */
	private QueryResultSet buildQueryResultSet(final SolrDocumentList docs)
	{
		QueryResultSet queryResultSet = new QueryResultSet();
		if (docs != null)
		{
			queryResultSet.setNumberFound(docs.getNumFound());
			queryResultSet.setIsExists(docs.getNumFound() == 0 ? false : true);
			List<QueryResult> queryResultList = new ArrayList<QueryResult>();
			QueryResult qresult;

			Iterator<SolrDocument> iter = docs.iterator();
			while (iter.hasNext())
			{
				qresult = new QueryResult();
				SolrDocument resultDoc = iter.next();
				if (resultDoc.getFieldValue("content") != null)
				{
					qresult.setContent(resultDoc.getFieldValue("content").toString());
				}
				if (resultDoc.getFieldValue("id") != null)
				{
					qresult.setId(resultDoc.getFieldValue("id").toString());
				}
				if (resultDoc.getFieldValue("segment") != null)
				{
					qresult.setSegment(resultDoc.getFieldValue("segment").toString());
				}
				if (resultDoc.getFieldValue("tstamp") != null)
				{
					qresult.setTimeStamp(resultDoc.getFieldValue("tstamp").toString());
				}
				if (resultDoc.getFieldValue("title") != null)
				{
					qresult.setTitle(resultDoc.getFieldValue("title").toString());
				}
				if (resultDoc.getFieldValue("url") != null)
				{
					qresult.setUrl(resultDoc.getFieldValue("url").toString());
				}
				queryResultList.add(qresult);
			}
			queryResultSet.setQueryResult(queryResultList);
		}

		return queryResultSet;
	}
}
