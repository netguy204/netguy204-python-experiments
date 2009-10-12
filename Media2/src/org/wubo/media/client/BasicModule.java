package org.wubo.media.client;

import org.wubo.media.client.widgets.ControlsView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;

public class BasicModule extends AbstractGinModule {

	@Override
	public void configure() {
		bind(Controls.Display.class).to(ControlsView.class);
		bind(HandlerManager.class).toProvider(HandlerManagerProvider.class);
		bind(MusicPlaybackService.class).asEagerSingleton();
		bind(Controls.class).asEagerSingleton();
	}
}
