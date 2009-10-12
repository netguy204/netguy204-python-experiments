package org.wubo.media.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface StopSongHandler extends EventHandler {
	public void onStopSong(StopSongAction action);
}
