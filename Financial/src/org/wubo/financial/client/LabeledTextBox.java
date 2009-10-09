package org.wubo.financial.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LabeledTextBox extends Composite {
	private final Label label = new Label();
	private final TextBox text_box = new TextBox();
	
	enum LabeledTextBoxLayout {
		VERTICAL,
		HORIZONTAL
	};
	
	public LabeledTextBox(String labelStr) {
		buildWidget(labelStr, LabeledTextBoxLayout.VERTICAL);
	}
	
	public LabeledTextBox(String labelStr, LabeledTextBoxLayout layout)
	{
		buildWidget(labelStr, layout);
	}
	
	public TextBox getTextBox()
	{
		return text_box;
	}
	
	public void setCaption(String caption)
	{
		label.setText(caption);
	}
	
	public String getCaption()
	{
		return label.getText();
	}
	
	public void setFocus(boolean focus)
	{
		text_box.setFocus(focus);
	}
	
	private Widget buildWidget(String labelStr, LabeledTextBoxLayout layout)
	{
		Panel panel;
		
		if(layout == LabeledTextBoxLayout.VERTICAL) {
			panel = new VerticalPanel();
		} else {
			panel = new HorizontalPanel();
		}
		
		label.setText(labelStr);
		panel.add(label);
		panel.add(text_box);
		initWidget(panel);
		
		label.setStyleName("LabeledTextBox-label");
		text_box.setStyleName("LabeledTextBox-text_box");
		setStyleName("LabeledTextBox");
		
		return panel;
	}
}
