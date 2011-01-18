package com.hellomulti.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface SayGoodbyeView extends IsWidget {

  public void setPresenter(Presenter presenter);
  
  
  public interface Presenter {
    public void sayHello();
  }
  
}
