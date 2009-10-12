package org.wubo.media.client.events;

import com.google.gwt.event.shared.GwtEvent;

public abstract class PlaySongAction extends GwtEvent<PlaySongHandler> implements Action {

	private static Type<PlaySongHandler> type = new Type<PlaySongHandler>();
	
	public abstract String getSong();
	
	@Override
	protected void dispatch(PlaySongHandler handler) {
		handler.onPlaySong(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PlaySongHandler> getAssociatedType() {
		return type;
	}

	public static Type<PlaySongHandler> getType() {
		return type;
	}
}
