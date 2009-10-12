package org.wubo.media.client;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

public interface ControlImages extends ImageBundle {

	@Resource("play.png")
	public AbstractImagePrototype playButtonIcon();
	
	@Resource("stop.png")
	public AbstractImagePrototype stopButtonIcon();
	
	@Resource("next.png")
	public AbstractImagePrototype nextButtonIcon();
	
	@Resource("pause.png")
	public AbstractImagePrototype pauseButtonIcon();
}
