package com.hellomulti.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.hellomulti.client.place.HelloPlace;
import com.hellomulti.client.ui.SayGoodbyeView;

public class SayGoodbyeActivity extends AbstractActivity implements SayGoodbyeView.Presenter {

  private SayGoodbyeView view;
  private PlaceController placeController;
  
  @Inject
  public SayGoodbyeActivity(SayGoodbyeView view, PlaceController placeController) {
    super();
    this.view = view;
    this.placeController = placeController;
    view.setPresenter(this);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(view);

  }

  @Override
  public void sayHello() {
    placeController.goTo(new HelloPlace("User"));    
  }

}
