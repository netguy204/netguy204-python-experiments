package org.wubo.media.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SongAvailableEvent extends GwtEvent<SongAvailableHandler> {

	private String song_name = null;
	private static Type<SongAvailableHandler> type = new Type<SongAvailableHandler>();
	
	public SongAvailableEvent(String songName) {
		song_name = songName;
	}
	
	@Override
	protected void dispatch(SongAvailableHandler handler) {
		handler.onSongAvailable(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SongAvailableHandler> getAssociatedType() {
		return type;
	}
	
	public String getSongName() {
		return song_name;
	}
	
	public static Type<SongAvailableHandler> getType() {
		return type;
	}
}
