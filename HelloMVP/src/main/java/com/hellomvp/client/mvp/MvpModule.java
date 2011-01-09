/*
 **  $HeadURL$
 **  $Id$
 **  $Date$
 **
 **  Copyright (c) 2010 Pegasus Solutions, Inc.
 **          All Rights Reserved
 **
 **  This software is the confidential and proprietary information of
 **  Pegasus Solutions, Inc.
 **
 **/
package com.hellomvp.client.mvp;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hellomvp.client.place.HelloPlace;

/**
 *
 *
 * @author $Author$
 * @version $Revision$
 */
public class MvpModule extends AbstractGinModule {

  /* (non-Javadoc)
   * @see com.google.gwt.inject.client.AbstractGinModule#configure()
   */
  @Override
  protected void configure() {
    
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    // PlaceHistoryMapper instantiate new places based on the browser URL. You
    // only need one of those for the entire app.
    bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);
    /// ActivityMapper maps the place to a new activity instance.
    // You should have one activity mapper for each display area.
    bind(AppActivityMapper.class).in(Singleton.class);

  }

  /**
   * Creates a new PlaceHistoryHandler.  This object is responsible handling navigation based on the browser URL.
   * You only need one of those for the entire app.
   * 
   * @param placeController the place controller.
   * @param historyMapper This is used to map the URL to a Place object and vice versa.
   * @param eventBus the event bus.
   * @return
   */
  @Provides 
  @Singleton
  public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
                                               PlaceHistoryMapper historyMapper, 
                                               EventBus eventBus) {
    PlaceHistoryHandler historyHandler =  new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new HelloPlace("World!"));
    return historyHandler;
  }

  /**
   * Creates a new PlaceController. The place controller is used by the PlaceHistoryHandler and activities
   * to tell the app to navigate to a different place. You only need one for the
   * entire app. However, it is essential for it to get instantiated in order
   * for the application navigation to work.
   * 
   * @param eventBus the event bus.
   * @return
   */
  @Provides
  @Singleton
  public PlaceController getPlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }

  

  
}
