package org.wubo.media.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

public class SongSelectPanel extends Composite implements ClickHandler, HasSelectionHandlers<String> {
	
	private final FlexTable table = new FlexTable();
	private int selected_row = 0;
	
	public SongSelectPanel() {
		table.setText(0, 0, "Song Name");
		table.addClickHandler(this);
		initWidget(table);
		setStyleName("MusicView");
	}
	
	public void addSong(String name) {
		int ii = table.getRowCount();
		final SongRow row = new SongRow(name);
		table.setWidget(ii, 0, row);
		table.getRowFormatter().setStyleName(ii, "MusicView-Unselected");
	}

	public void onClick(ClickEvent event) {
		Cell cell = table.getCellForEvent(event);
		
		if(cell.getRowIndex() != 0) {
			if(selected_row != 0) {
				table.getRowFormatter().setStyleName(selected_row, "MusicView-Unselected");
			}
			
			table.getRowFormatter().setStyleName(cell.getRowIndex(), "MusicView-Selected");
			selected_row = cell.getRowIndex();
			SongRow row = (SongRow)table.getWidget(selected_row, 0);
			SelectionEvent.fire(this, row.getText());
		}
	}

	@Override
	public HandlerRegistration addSelectionHandler(SelectionHandler<String> handler) {
		return addHandler(handler, SelectionEvent.getType());
	}
}
