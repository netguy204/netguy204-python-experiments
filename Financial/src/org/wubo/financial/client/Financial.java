package org.wubo.financial.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Financial implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		LabeledTextBox box1 = new LabeledTextBox("Box 1");
		LabeledTextBox box2 = new LabeledTextBox("Box 2");
		
		VerticalPanel mainPanel = new VerticalPanel();
		
		HorizontalPanel inputs = new HorizontalPanel();
		inputs.add(box1);
		inputs.add(box2);
		mainPanel.add(inputs);
		
		TabBar bar = new TabBar();
		bar.addTab("Foo");
		bar.addTab("Bar");
		bar.addTab("Gangsta");
		mainPanel.add(bar);
		
		final LedgerTable table = new LedgerTable();
		for(int ii = 0; ii < 10; ++ii) {
			table.setText(ii, 0, "Thing " + ii);
		}
		table.setWidth("500px");
		
		Button button = new Button("Insert Row");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				table.newRow();
				table.setText(0, 0, "Empty");
			}
		});
		mainPanel.add(button);
		mainPanel.add(table);
		
		RootPanel.get("container").add(mainPanel);
		
		box1.setFocus(true);
		box1.getTextBox().setTabIndex(0);
		box2.getTextBox().setTabIndex(1);
	}
}
