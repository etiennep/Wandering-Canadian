package com.hellomulti.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class HelloMultiMVP implements EntryPoint {

  @Override
  public void onModuleLoad() {
    HelloGinjector ginjector = GWT.create(HelloGinjector.class);
    RootLayoutPanel.get().add(ginjector.getMainView());
    // Goes to place represented on URL or default place
    ginjector.getPlaceHistoryHandler().handleCurrentHistory();

  }


}
