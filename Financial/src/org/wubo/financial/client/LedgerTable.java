package org.wubo.financial.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

public class LedgerTable extends Composite implements ClickHandler {
	
	private final FlexTable table = new FlexTable();
	private ScrollPanel scroll_panel = null;
	public LedgerTable()
	{
		table.addClickHandler(this);
		table.setStyleName("LedgerTable");
		initWidget(table);
	}

	public FlexTable getTable() {
		return table;
	}
	
	public void newRow() {
		table.insertRow(0);
		int num_rows = table.getRowCount();
		for(int ii = 0; ii < num_rows; ++ii) {
			table.getRowFormatter().setStyleName(ii, getRowStyle(ii));
		}
	}
	
	public void setText(int row, int col, String text)
	{
		table.setText(row, col, text);
		
		table.getRowFormatter().setStyleName(row, getRowStyle(row));
	}
	
	private String getRowStyle(int row)
	{
		String style = null;
		if(row % 2 == 0) {
			style = "LedgerTable-EvenRow";
		} else {
			style = "LedgerTable-OddRow";
		}
		return style;
	}
	
	public void onClick(ClickEvent event) {
		final Cell cell = table.getCellForEvent(event);
		final int row = cell.getRowIndex();
		final int column = cell.getCellIndex();
		
		Widget old_widget = table.getWidget(row, column);
		if(old_widget instanceof TextBox) {
			return;
		}
		
		String value = table.getText(row, column);
		
		final TextBox text = new TextBox();
		
		text.setText(value);
		text.setWidth("100%");
		text.setStyleName("LedgerTable-TextBox");
		table.setWidget(row, column, text);
		text.setFocus(true);
		
		text.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					TextBox box = (TextBox)event.getSource();
					String new_value = box.getText();
					
					MyCell cell = findWidget(box);
					if(cell != null) {
						table.clearCell(cell.getRow(), cell.getCell());
						table.setText(cell.getRow(), cell.getCell(), new_value);
					}
				}
			}
		});
	}
	
	class MyCell {
		private int row;
		private int cell;
		
		public MyCell(int row, int cell) {
			this.row = row;
			this.cell = cell;
		}

		public int getRow() {
			return row;
		}

		public int getCell() {
			return cell;
		}
	}
	private MyCell findWidget(Widget widget) {
		int num_rows = table.getRowCount();
		for(int ii = 0 ; ii < num_rows ; ++ii) {
			int num_cols = table.getCellCount(ii);
			for(int jj = 0 ; jj < num_cols ; ++jj) {
				if(table.getWidget(ii, jj) == widget) {
					return new MyCell(ii, jj);
				}
			}
		}
		
		return null;
	}
}
