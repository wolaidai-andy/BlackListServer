/**
 *
 * QueryResultSet.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.pojo;

import java.util.List;

/**
 * It is a collection of query result object, expose some common elements and query result list.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public class QueryResultSet
{
	private long numberFound;
	private Boolean isExists;
	private List<QueryResult> queryResult;

	public long getNumberFound()
	{
		return numberFound;
	}

	public void setNumberFound(long numberFound)
	{
		this.numberFound = numberFound;
	}

	public Boolean isExists()
	{
		return isExists;
	}

	public void setIsExists(Boolean isExists)
	{
		this.isExists = isExists;
	}

	public List<QueryResult> getQueryResult()
	{
		return queryResult;
	}

	public void setQueryResult(List<QueryResult> queryResult)
	{
		this.queryResult = queryResult;
	}
}
