
package com.welab.x.blacklist.client;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.welab.x.blacklist.common.ErrorMessage;
import com.welab.x.blacklist.impl.BlackList;
import com.welab.x.blacklist.inter.IBlackList;
import com.welab.x.blacklist.pojo.QueryResult;
import com.welab.x.blacklist.pojo.QueryResultSet;

public class Test
{
	private static final Logger LOG = Logger.getLogger(Test.class);

	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties");
		IBlackList blackList = new BlackList();

		try
		{
			QueryResultSet resultSet = blackList.searchByID("232101198501200821");
			// QueryResultSet resultSet = blackList.searchByName("白丽丽");

			System.out.println(resultSet.isExists());
			System.out.println(resultSet.getNumberFound());
			List<QueryResult> resultList = resultSet.getQueryResult();
			Iterator<QueryResult> queryResults = resultList.iterator();
			while (queryResults.hasNext())
			{
				QueryResult queryResult = queryResults.next();
				System.out.println(queryResult.getTimeStamp());
				System.out.println(queryResult.getId());
				System.out.println(queryResult.getSegment());
				System.out.println(queryResult.getTitle());
				System.out.println(queryResult.getUrl());
				System.out.println(queryResult.getContent() + "\n\n\n");
			}
		}
		catch (Exception e)
		{
			LOG.error(ErrorMessage.INTERNAL_ERROR, e);
		}
	}
}
