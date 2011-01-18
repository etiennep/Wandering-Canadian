package com.hellomulti.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.hellomulti.client.place.HelloPlace;
import com.hellomulti.client.ui.HelloView;

public class HelloActivity extends AbstractActivity {

  private HelloView view;
  
  @Inject
  public HelloActivity(HelloView view) {
    super();
    this.view = view;
  }

  public HelloActivity withPlace(HelloPlace place) {
    view.setName(place.getHelloName());
    return this;
  }


  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(view);
  }

}
