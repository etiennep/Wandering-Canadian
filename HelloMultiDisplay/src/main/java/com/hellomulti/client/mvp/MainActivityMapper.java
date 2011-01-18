package com.hellomulti.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hellomulti.client.activity.GoodbyeActivity;
import com.hellomulti.client.activity.HelloActivity;
import com.hellomulti.client.place.GoodbyePlace;
import com.hellomulti.client.place.HelloPlace;

public class MainActivityMapper implements ActivityMapper {

  Provider<HelloActivity> helloActivityProvider;
  Provider<GoodbyeActivity> goodbyeActivityProvider;
  
  
  @Inject
  public MainActivityMapper(Provider<HelloActivity> helloActivityProvider,
      Provider<GoodbyeActivity> goodbyeActivityProvider) {
    super();
    this.helloActivityProvider = helloActivityProvider;
    this.goodbyeActivityProvider = goodbyeActivityProvider;
  }



  @Override
  public Activity getActivity(Place place) {
    
    if (place instanceof GoodbyePlace) {
      return goodbyeActivityProvider.get().withPlace((GoodbyePlace)place);
    } else {
      return helloActivityProvider.get().withPlace((HelloPlace)place);
    }
  }

}
