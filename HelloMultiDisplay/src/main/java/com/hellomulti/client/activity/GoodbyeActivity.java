package com.hellomulti.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.hellomulti.client.place.GoodbyePlace;
import com.hellomulti.client.ui.GoodbyeView;

public class GoodbyeActivity extends AbstractActivity {

  private GoodbyeView view;
  
  @Inject
  public GoodbyeActivity(GoodbyeView view) {
    super();
    this.view = view;
  }

  public GoodbyeActivity withPlace(GoodbyePlace place) {
    view.setName(place.getGoodbyeName());
    return this;
  }
  

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(view);
  }

}
