package com.hellomvp.client.activity;

import com.google.gwt.inject.client.AbstractGinModule;

public class ActivityModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(HelloActivity.class);
    bind(GoodbyeActivity.class);


  }

}
