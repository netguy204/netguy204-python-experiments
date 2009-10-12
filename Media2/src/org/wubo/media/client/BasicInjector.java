package org.wubo.media.client;

import org.wubo.media.client.widgets.ControlsView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(BasicModule.class)
public interface BasicInjector extends Ginjector {
	public Controls getControls();
	public ControlsView getControlsView();
	public MusicPlaybackService getMusicPlaybackService();
	public HandlerManager getEventBus();
}
