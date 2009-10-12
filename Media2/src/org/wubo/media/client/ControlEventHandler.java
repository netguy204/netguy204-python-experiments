package org.wubo.media.client;

public interface ControlEventHandler {
	void onPlay(Controls controls);
	void onStop(Controls controls);
	void onPause(Controls controls);
	void onNext(Controls controls);
}
