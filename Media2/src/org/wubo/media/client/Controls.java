package org.wubo.media.client;

import org.wubo.media.client.events.SongAvailableHandler;
import org.wubo.media.client.events.SongIsPlayingHandler;
import org.wubo.media.client.events.PlaySongAction;
import org.wubo.media.client.events.SongAvailableEvent;
import org.wubo.media.client.events.SongIsPlayingEvent;
import org.wubo.media.client.events.StopSongAction;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class Controls implements ClickHandler, SongAvailableHandler, SongIsPlayingHandler, SelectionHandler<String> {
	public interface Display {
		HasClickHandlers getPlayButton();
		HasClickHandlers getStopButton();
		HasClickHandlers getPauseButtion();
		HasClickHandlers getNextButtion();
		Label getStatusRegion();
		
		HasSelectionHandlers<String> getSelectionProvider();
		
		void songIsPlaying(boolean playing);

		void addSong(String name);
	}
	
	private Controls.Display view = null;
	private HandlerManager event_bus = null;
	private String selection = null;
	
	enum PlayState {
		PLAYING,
		PAUSED,
		STOPPED
	};
	
	@Inject
	public Controls(Controls.Display theView, HandlerManager eventBus) {
		view = theView;

		view.getStatusRegion().setText("Nothing much has happened yet");
		view.getPlayButton().addClickHandler(this);
		view.getPauseButtion().addClickHandler(this);
		view.getStopButton().addClickHandler(this);
		view.getNextButtion().addClickHandler(this);
		view.getSelectionProvider().addSelectionHandler(this);
		view.songIsPlaying(false);
		
		this.event_bus = eventBus;
		event_bus.addHandler(SongAvailableEvent.getType(), this);
		event_bus.addHandler(SongIsPlayingEvent.getType(), this);
	}
	
	public void onClick(ClickEvent event) {
		if(event.getSource() == view.getPlayButton()) {
			if(selection != null) {
				setMessage("Requesting that a song be played. Handlers: " + event_bus.getHandlerCount(PlaySongAction.getType()));
				
				event_bus.fireEvent(new PlaySongAction() {
					@Override
					public void onFailure(Throwable exception) {
						setMessage("Playing failed");
					}

					@Override
					public void onSuccess() {
						setMessage("Playing succeeded");
					}

					@Override
					public String getSong() {
						return selection;
					}
				});
			}
			
		} else if(event.getSource() == view.getStopButton()) {
			setMessage("Requesting that a song be stopped");
			
			event_bus.fireEvent(new StopSongAction() {
				@Override
				public void onFailure(Throwable exception) {
					setMessage("Stopping failed");
				}

				@Override
				public void onSuccess() {
					setMessage("Stopping succeeded");
				}
			});
			
		} else if(event.getSource() == view.getPauseButtion() ) {
			setMessage("Requesting that a song be paused");
			
			event_bus.fireEvent(new StopSongAction() {
				@Override
				public void onFailure(Throwable exception) {
					setMessage("Pausing failed");
				}

				@Override
				public void onSuccess() {
					setMessage("Pausing succeeded");
				}
			});
			
		} else if(event.getSource() == view.getNextButtion()) {
		}
	}

	private void setMessage(String text) {
		view.getStatusRegion().setText(text);
	}

	@Override
	public void onSongAvailable(SongAvailableEvent event) {
		view.addSong(event.getSongName());
	}

	@Override
	public void songIsPlaying(SongIsPlayingEvent event) {
		view.songIsPlaying(event.isPlaying());
	}

	@Override
	public void onSelection(SelectionEvent<String> event) {
		selection = event.getSelectedItem();
	}
}
