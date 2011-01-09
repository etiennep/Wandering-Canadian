package com.hellomvp.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.ui.GoodbyeView;

public class GoodbyeActivity extends AbstractActivity {
	// Name that will be appended to "Good-bye, "
	private String name;

	private GoodbyeView view;
	
	@Inject
	public GoodbyeActivity(GoodbyeView view) {
		this.view=view;
	}

	public GoodbyeActivity withPlace(GoodbyePlace place) {
    this.name = place.getGoodbyeName();
    return this;
  }
	
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {		
		view.setName(name);
		containerWidget.setWidget(view.asWidget());
	}
}