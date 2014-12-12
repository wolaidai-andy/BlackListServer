/**
 *
 * QueryResult.java
 *
 * Copyright 2014 WeLend, Inc. All rights reserved.
 * WELEND PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.welab.x.blacklist.pojo;

/**
 * QueryResult to store search result, and expose data for each element.
 *
 * @author <a href="mailto:andy.zhang@wolaidai.com">andy.zhang</a>
 *
 */
public class QueryResult
{
	private String timeStamp;
	private String segment;
	private String id;
	private String title;
	private String url;
	private String content;

	public String getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public String getSegment()
	{
		return segment;
	}

	public void setSegment(String segment)
	{
		this.segment = segment;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

}
