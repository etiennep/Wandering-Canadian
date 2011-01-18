package com.hellomulti.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.hellomulti.client.activity.ActivityModule;
import com.hellomulti.client.mvp.MvpModule;
import com.hellomulti.client.ui.ViewModule;


public class HelloGinModule extends AbstractGinModule {

  /* (non-Javadoc)
   * @see com.google.gwt.inject.client.AbstractGinModule#configure()
   */
  @Override
  protected void configure() {
    
    // install the Gin module used to setup the GWT MVP framework classes.
    install(new MvpModule());
    install(new ViewModule());
    install(new ActivityModule());
  }

  
}
