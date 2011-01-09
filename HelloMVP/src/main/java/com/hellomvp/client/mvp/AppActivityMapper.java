package com.hellomvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;

public class AppActivityMapper implements ActivityMapper {

  Provider<HelloActivity> helloActivityProvider;
  Provider<GoodbyeActivity> goodbyeActivityProvider;
  
	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
  @Inject
	public AppActivityMapper(final Provider<HelloActivity> helloActivityProvider,
                           final Provider<GoodbyeActivity> goodbyeActivityProvider) {
    super();
    this.helloActivityProvider = helloActivityProvider;
    this.goodbyeActivityProvider = goodbyeActivityProvider;
  }

  /**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof HelloPlace)
			return helloActivityProvider.get().withPlace((HelloPlace)place);
		else if (place instanceof GoodbyePlace)
		  return goodbyeActivityProvider.get().withPlace((GoodbyePlace)place);

		return null;
	}

}
