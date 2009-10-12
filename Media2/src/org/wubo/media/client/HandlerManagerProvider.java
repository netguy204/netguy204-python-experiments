package org.wubo.media.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class HandlerManagerProvider implements Provider<HandlerManager> {
	HandlerManager instance = new HandlerManager(null);
	
	@Override
	public HandlerManager get() {
		return instance;
	}

}
