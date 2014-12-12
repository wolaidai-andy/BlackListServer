/**
 *
 * IBlackList.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.inter;

import org.apache.solr.client.solrj.SolrServerException;

import com.welab.x.blacklist.pojo.QueryResultSet;

/**
 *
 * IBlackList defined methods to search black list.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public interface IBlackList
{
	/**
	 * Search blacklist information by given person name.
	 *
	 * @param name
	 * @return QueryResultSet
	 * @throws SolrServerException
	 * @throws Exception
	 */
	QueryResultSet searchByName(String name) throws SolrServerException, Exception;

	/**
	 * Search blacklist information by given identity card number.
	 *
	 * @param identityNumber
	 * @return QueryResultSet
	 * @throws SolrServerException
	 * @throws Exception
	 */
	QueryResultSet searchByID(String identityNumber) throws SolrServerException, Exception;
}
