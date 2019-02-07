package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Stock;

public class StockTableModel extends AbstractTableModel {
	private List<Stock> database;
	private List<String> names;
	
	public void setData(List<Stock> database){
		this.database=database;
	}
	public void setNames(List<String> names,List<Stock> database){
		this.database=database;
		this.names=names;
	}
	public Stock getStock(int row){
		return database.get(row);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(names!=null){
		return names.size();
		}else{
		return 0;
		}
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		if(names!=null){
		return names.get(arg0);
		}else{
			return null;
		}
	}

}
