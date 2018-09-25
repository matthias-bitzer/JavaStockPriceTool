package Controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import yahooConnection.ConnectionYahooFinance;

import Model.Database;
import Model.Stock;

public class Controller {
	Database db;
	ConnectionYahooFinance connection;
	public Controller(){
		db=new Database();
		connection=new ConnectionYahooFinance();
	}
	public void setDb(Database db) {
		this.db = db;
	}
	public List<Stock> getData(){
		return db.getPortfolio();
	}
	public void LoadStockFromYahooToDatabase(String stockname) throws IOException{
		
			double[] kurse=connection.loadStock(stockname);
			db.addStock(kurse, stockname);
		
		
	}
	public List<String> getNames(){
		List<String> names= new LinkedList<String>();
		for(int i =0; i<db.getPortfolio().size();i++){
			names.add(db.getPortfolio().get(i).getName());
			
			
		}
		return names;
		
		
		
	}
	public double[]getStockArray(int i){
		Stock stock=db.getPortfolio().get(i);
		double [] kurs= new double[stock.getKurse().size()];
		for(int i1=0;i1<stock.getKurse().size();i1++ ){
			kurs[i1]=stock.getKurse().get(i1).getKurse();
		}
		return kurs;
	}
	public double[]getStockArray(Stock stock){
		//Stock stock=db.getPortfolio().get(i);
		double [] kurs= new double[stock.getKurse().size()];
		for(int i1=0;i1<stock.getKurse().size();i1++ ){
			kurs[i1]=stock.getKurse().get(i1).getKurse();
		}
		return kurs;
	}
	public double[] getReturnArray(Stock stock){
		double[] rendite=ControllerUtils.giveReturn(this.getStockArray(stock));
		return rendite;
		
		
	}
	

}
