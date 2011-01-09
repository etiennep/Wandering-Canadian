package com.hellomvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloMVP implements EntryPoint
{
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// Create ClientFactory using deferred binding so we can replace with different
		// impls in gwt.xml
		HelloGinjector ginjector = GWT.create(HelloGinjector.class);
		RootPanel.get().add(ginjector.getAppWidget());
		// Goes to place represented on URL or default place
		ginjector.getPlaceHistoryHandler().handleCurrentHistory();
	}
}
