package org.wubo.media.client;

import org.wubo.media.client.events.PlaySongHandler;
import org.wubo.media.client.events.StopSongHandler;
import org.wubo.media.client.events.PlaySongAction;
import org.wubo.media.client.events.SongIsPlayingEvent;
import org.wubo.media.client.events.StopSongAction;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;

public class MusicPlaybackService implements PlaySongHandler, StopSongHandler {

	HandlerManager event_bus = null;
	
	@Inject
	public MusicPlaybackService(HandlerManager eventBus) {
		this.event_bus = eventBus;
		
		event_bus.addHandler(PlaySongAction.getType(), this);
		event_bus.addHandler(StopSongAction.getType(), this);
	}
	
	@Override
	public void onStopSong(StopSongAction action) {
		// do long running stuff..
		if(Random.nextBoolean()) {
			action.onSuccess();
			Timer timer = new Timer() {
				@Override
				public void run() {
					event_bus.fireEvent(new SongIsPlayingEvent(false, ""));
				}
			};
			timer.schedule(1000);
		} else {
			action.onFailure(new Exception("poo"));
		}
	}

	@Override
	public void onPlaySong(final PlaySongAction action) {
		// do long running stuff..
		if(Random.nextBoolean()) {
			action.onSuccess();
			Timer timer = new Timer() {
				@Override
				public void run() {
					event_bus.fireEvent(new SongIsPlayingEvent(true, action.getSong()));
				}
			};
			timer.schedule(1000);
		} else {
			action.onFailure(new Exception("poo"));
		}
	}
}
