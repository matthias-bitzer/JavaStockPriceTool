package Model;

import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<Stock> portfolio;
	public Database(){
		portfolio=new LinkedList<Stock>();
		
	}
	public void addStock(Stock stock){
		portfolio.add(stock);
	}
	public void addStock(double[] kurse, String name){
		Stock stock1= new Stock(kurse,name);
		portfolio.add(stock1);
	}
	public List<Stock> getPortfolio() {
		return portfolio;
	}
	
	
	
	
}
