package com.hellomulti.client.ui;

import com.google.gwt.inject.client.AbstractGinModule;

public class ViewModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(MainView.class);
    bind(GoodbyeView.class).to(GoodbyeViewImpl.class);    
    bind(HelloView.class).to(HelloViewImpl.class);
    bind(SayHelloView.class).to(SayHelloViewImpl.class);
    bind(SayGoodbyeView.class).to(SayGoodbyeViewImpl.class);
    
  }

}
