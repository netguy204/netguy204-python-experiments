package org.wubo.media.client;

import org.wubo.media.client.events.SongAvailableEvent;
import org.wubo.media.client.widgets.ControlsView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Media2 implements EntryPoint {

	private HandlerManager event_bus;
	private final BasicInjector injector = GWT.create(BasicInjector.class)
	;
	String selectedSong = null;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel mainPanel = new VerticalPanel();
		
		ControlsView controlsView = injector.getControlsView();

		event_bus = injector.getEventBus();
		
		mainPanel.add(controlsView);
		
		addTableData();
		
		RootPanel.get("container").add(mainPanel);
	}
	
	private void addTableData() {
		for(int ii = 0; ii < 10; ++ii) {
			event_bus.fireEvent(new SongAvailableEvent("The awesome Song #" + ii));
		}
	}
}
