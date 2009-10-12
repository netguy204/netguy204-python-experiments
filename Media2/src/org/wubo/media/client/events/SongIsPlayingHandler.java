package org.wubo.media.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface SongIsPlayingHandler extends EventHandler {
	public void songIsPlaying(SongIsPlayingEvent event);
}
