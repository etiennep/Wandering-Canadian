package com.hellomulti.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hellomulti.client.activity.SayGoodbyeActivity;
import com.hellomulti.client.activity.SayHelloActivity;
import com.hellomulti.client.place.GoodbyePlace;

public class VerticalMasterActivityMapper implements ActivityMapper {

  Provider<SayHelloActivity> sayHelloActivityProvider;
  Provider<SayGoodbyeActivity> sayGoodbyeActivityProvider;
  
  
  @Inject
  public VerticalMasterActivityMapper(Provider<SayHelloActivity> sayHelloActivityProvider,
      Provider<SayGoodbyeActivity> sayGoodbyeActivityProvider) {
    super();
    this.sayHelloActivityProvider = sayHelloActivityProvider;
    this.sayGoodbyeActivityProvider = sayGoodbyeActivityProvider;
  }



  @Override
  public Activity getActivity(Place place) {
    
    if (place instanceof GoodbyePlace) {
      return sayGoodbyeActivityProvider.get();
    } else {
      return sayHelloActivityProvider.get();
    }
  }

}
