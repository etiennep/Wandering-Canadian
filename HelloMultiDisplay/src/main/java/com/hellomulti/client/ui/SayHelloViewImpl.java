package com.hellomulti.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class SayHelloViewImpl extends Composite implements SayHelloView {

  private static SayHelloViewImplUiBinder uiBinder = GWT
      .create(SayHelloViewImplUiBinder.class);

  interface SayHelloViewImplUiBinder extends UiBinder<Widget, SayHelloViewImpl> {
  }
  
  private Presenter presenter;

  public SayHelloViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public SayHelloViewImpl(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("goodbyeLink")
  void onClick(ClickEvent e) {
    presenter.sayGoodbye();
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
    
  }

}
