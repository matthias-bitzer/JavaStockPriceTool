package gui;

import Controller.Controller;
import Model.Database;
import Model.Stock;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Database db=new Database();
		double [] testKurse = TestStock.GenerateStock(1000, 500);
		double [] testKurse2 = TestStock.GenerateStock(1000,500);
		double [] testKurse3 = TestStock.GenerateStock(1000, 500);
		double [] testKurse4 = TestStock.GenerateStock(1000, 500);
		Stock testStock=new Stock(testKurse,"Apple");
		Stock testStock2=new Stock(testKurse2,"Microsoft");
		Stock testStock3=new Stock(testKurse3,"Daimler");
		Stock testStock4=new Stock(testKurse4,"Volkswagen");
		db.addStock(testStock);
		db.addStock(testStock2);
		db.addStock(testStock3);
		db.addStock(testStock4);
		Controller controller= new Controller();
		controller.setDb(db);
		*/
		
		
		MainFrame mainframe= new MainFrame();
		//mainframe.setController(controller);
		//mainframe.getData();
		//mainframe.getNames();
	}

}
