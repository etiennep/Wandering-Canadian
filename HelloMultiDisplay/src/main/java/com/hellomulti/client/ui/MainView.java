package com.hellomulti.client.ui;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hellomulti.client.mvp.MainActivityMapper;
import com.hellomulti.client.mvp.VerticalMasterActivityMapper;

@Singleton
public class MainView extends Composite {

  private static MainViewUiBinder uiBinder = GWT
  .create(MainViewUiBinder.class);

  interface MainViewUiBinder extends UiBinder<Widget, MainView> {
  }
  
  @UiField SimplePanel mainDisplayPanel;
  @UiField SimplePanel verticalMasterDisplayPanel;
  
  @Inject
  public MainView(MainActivityMapper mainActivityMapper, 
                  VerticalMasterActivityMapper verticalMasterActivityMapper,
                  EventBus eventBus) {     
    initWidget(uiBinder.createAndBindUi(this));

    ActivityManager mainActivityManager = new ActivityManager(mainActivityMapper, eventBus);
    mainActivityManager.setDisplay(mainDisplayPanel);
    
    ActivityManager verticalMasterActivityManager = new ActivityManager(verticalMasterActivityMapper, eventBus);
    verticalMasterActivityManager.setDisplay(verticalMasterDisplayPanel);

  }


}
