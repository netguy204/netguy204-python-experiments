package org.wubo.media.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface SongAvailableHandler extends EventHandler {
	public void onSongAvailable(SongAvailableEvent event);
}
