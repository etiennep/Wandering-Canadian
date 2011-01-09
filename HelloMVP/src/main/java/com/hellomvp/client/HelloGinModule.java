package com.hellomvp.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.hellomvp.client.activity.ActivityModule;
import com.hellomvp.client.mvp.MvpModule;
import com.hellomvp.client.ui.MainView;
import com.hellomvp.client.ui.ViewModule;


public class HelloGinModule extends AbstractGinModule {

  /* (non-Javadoc)
   * @see com.google.gwt.inject.client.AbstractGinModule#configure()
   */
  @Override
  protected void configure() {
    // declare a binding for the display area. You may need to use annotations
    // to identify the various display areas to match them to the right activity
    // manager.
    bind(MainView.class);
    
    // install the Gin module used to setup the GWT MVP framework classes.
    install(new MvpModule());
    install(new ViewModule());
    install(new ActivityModule());
  }

  
}
