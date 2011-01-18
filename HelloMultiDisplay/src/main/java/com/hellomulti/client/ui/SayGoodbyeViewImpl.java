package com.hellomulti.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class SayGoodbyeViewImpl extends Composite implements SayGoodbyeView {

  private static SayGoodbyeViewImplUiBinder uiBinder = GWT
      .create(SayGoodbyeViewImplUiBinder.class);

  interface SayGoodbyeViewImplUiBinder extends UiBinder<Widget, SayGoodbyeViewImpl> {
  }
  
  private Presenter presenter;

  public SayGoodbyeViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public SayGoodbyeViewImpl(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("helloLink")
  void onClick(ClickEvent e) {
    presenter.sayHello();
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
    
  }

}
