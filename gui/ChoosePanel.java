package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import Model.Stock;

public class ChoosePanel extends JPanel {
	private JTable stocktable;
	private StockTableModel stocktablemodel;
	private JButton btn;
	private ChooseListener listener;
	ChoosePanel(){
		stocktablemodel=new StockTableModel();
		stocktable =new JTable(stocktablemodel);
		
		btn=new JButton("Chart");
		
		
		
		btn.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				if(stocktable.getSelectedRow()!=-1){
				int row = stocktable.getSelectedRow();
				Stock stock=stocktablemodel.getStock(row);
				listener.setStock(stock);
				
				
				}
			}
			
			
		});
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension d = new Dimension(240,500);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		Layout();
		
		
		
		
	}
	public void Layout(){
		
		this.setLayout(new BorderLayout());
		add(stocktable,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		
		
	}
	public StockTableModel getStocktablemodel() {
		return stocktablemodel;
	}
	public JTable getStocktable() {
		return stocktable;
	}
	public void setListener(ChooseListener listener) {
		this.listener = listener;
	}
	
	

}
