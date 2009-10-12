package org.wubo.media.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SongIsPlayingEvent extends GwtEvent<SongIsPlayingHandler> {
	private static Type<SongIsPlayingHandler> type = new Type<SongIsPlayingHandler>();
	private boolean playing;
	private String song;
	
	public SongIsPlayingEvent(boolean isPlaying, String song) {
		this.playing = isPlaying;
		this.song = song;
	}
	
	@Override
	protected void dispatch(SongIsPlayingHandler handler) {
		handler.songIsPlaying(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SongIsPlayingHandler> getAssociatedType() {
		return type;
	}

	public static Type<SongIsPlayingHandler> getType() {
		return type;
	}
	
	public boolean isPlaying() {
		return playing;
	}
	
	public String getSong() {
		return song;
	}
}
