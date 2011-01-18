package com.hellomulti.client.mvp;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hellomulti.client.place.AppPlaceHistoryMapper;
import com.hellomulti.client.place.HelloPlace;

public class MvpModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    // PlaceHistoryMapper instantiate new places based on the browser URL. You
    // only need one of those for the entire app.
    bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);

    bind(MainActivityMapper.class);
    bind(VerticalMasterActivityMapper.class);
    
  }

  /**
   * Creates a new PlaceHistoryHandler.  This object is responsible handling navigation based on the browser URL.
   * You only need one of those for the entire app.
   * 
   * @param placeController the place controller.
   * @param historyMapper This is used to map the URL to a Place object and vice versa.
   * @param eventBus the event bus.
   * @return   */
  @Provides 
  @Singleton  
  public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
      PlaceHistoryMapper historyMapper, EventBus eventBus) {
    PlaceHistoryHandler historyHandler =  new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new HelloPlace("User!"));

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
