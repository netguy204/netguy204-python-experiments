package org.wubo.media.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

public class ImageButton extends Composite implements HasClickHandlers, ClickHandler, MouseOverHandler, MouseOutHandler {

	Image image = new Image();
	SimplePanel panel = new SimplePanel();
	
	public ImageButton() {
		panel.setStyleName("ImageButton-Normal");
		panel.add(image);
		image.addMouseOverHandler(this);
		image.addMouseOutHandler(this);
		image.addClickHandler(this);
		
		initWidget(panel);
	}

	public Image getImage() {
		return image;
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public void onMouseOver(MouseOverEvent event) {
		panel.setStyleName("ImageButton-Hover");
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		panel.setStyleName("ImageButton-Normal");
	}

	@Override
	public void onClick(ClickEvent event) {
		// redispatch as if it came from us
		fireEvent(new ClickEvent() {
			public Object getSource() {
				return ImageButton.this;
			}
		});
	}
}
