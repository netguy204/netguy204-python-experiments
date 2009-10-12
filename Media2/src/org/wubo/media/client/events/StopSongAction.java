package org.wubo.media.client.events;

import com.google.gwt.event.shared.GwtEvent;

public abstract class StopSongAction extends GwtEvent<StopSongHandler> implements Action {

	private static Type<StopSongHandler> type = new Type<StopSongHandler>();
	
	@Override
	protected void dispatch(StopSongHandler handler) {
		handler.onStopSong(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<StopSongHandler> getAssociatedType() {
		return type;
	}

	public static Type<StopSongHandler> getType() {
		return type;
	}
}
