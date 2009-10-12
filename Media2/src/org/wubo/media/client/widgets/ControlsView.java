package org.wubo.media.client.widgets;

import org.wubo.media.client.ControlImages;
import org.wubo.media.client.Controls;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ControlsView extends Composite implements Controls.Display {
	private final ImageButton play_button = new ImageButton();
	private final ImageButton stop_button = new ImageButton();
	private final ImageButton pause_button = new ImageButton();
	private final ImageButton next_button = new ImageButton();
	private final SongSelectPanel selectPanel = new SongSelectPanel();
	private final Label status_label = new Label();
	
	@Inject
	public ControlsView(ControlImages images) {
		VerticalPanel panel = new VerticalPanel();
		panel.add(status_label);
		
		images.playButtonIcon().applyTo(play_button.getImage());
		images.stopButtonIcon().applyTo(stop_button.getImage());
		images.pauseButtonIcon().applyTo(pause_button.getImage());
		images.nextButtonIcon().applyTo(next_button.getImage());
		
		HorizontalPanel controlPanel = new HorizontalPanel();
		controlPanel.add(play_button);
		controlPanel.add(stop_button);
		controlPanel.add(pause_button);
		controlPanel.add(next_button);
		controlPanel.setStyleName("ControlsView-ButtonBar");
		
		panel.add(controlPanel);
		panel.add(selectPanel);
		initWidget(panel);
		setStyleName("Controls");
	}
	
	@Override
	public HasClickHandlers getNextButtion() {
		return next_button;
	}

	@Override
	public HasClickHandlers getPauseButtion() {
		return pause_button;
	}

	@Override
	public HasClickHandlers getPlayButton() {
		return play_button;
	}

	@Override
	public HasClickHandlers getStopButton() {
		return stop_button;
	}

	@Override
	public HasSelectionHandlers<String> getSelectionProvider() {
		return selectPanel;
	}

	@Override
	public void addSong(String name) {
		selectPanel.addSong(name);
	}

	@Override
	public void songIsPlaying(boolean playing) {
		if(playing) {
			play_button.setVisible(false);
			pause_button.setVisible(true);
			stop_button.setVisible(true);
		} else {
			play_button.setVisible(true);
			pause_button.setVisible(false);
			stop_button.setVisible(false);
		}
	}

	@Override
	public Label getStatusRegion() {
		return status_label;
	}
}
