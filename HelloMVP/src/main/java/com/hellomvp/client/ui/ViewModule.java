package com.hellomvp.client.ui;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class ViewModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(GoodbyeView.class).to(GoodbyeViewImpl.class).in(Singleton.class);
    bind(HelloView.class).to(HelloViewImpl.class).in(Singleton.class);
  }

}
