package gui;

import Model.Stock;

public class ChooseListener {
	private Stock stock;
	private MainFrame main;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock=stock;
		
		if(main!=null){
			main.ReactionDrawChart(stock);
		}
		
	}

	public void setMain(MainFrame main) {
		this.main = main;
	}
	
	
	

}
