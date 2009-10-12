package org.wubo.media.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface PlaySongHandler extends EventHandler {

	public void onPlaySong(PlaySongAction action);
	
}
