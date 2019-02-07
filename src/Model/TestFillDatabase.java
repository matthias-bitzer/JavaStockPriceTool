package Model;

import java.util.List;

public class TestFillDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database db=new Database();
		double [] testKurse = {10,12,13.2,11.3,15.4,16};
		double [] testKurse2 = {11,12.2,12.2,12.3,5.4,20};
		Stock testStock=new Stock(testKurse,"Apple");
		Stock testStock2=new Stock(testKurse2,"Microsoft");
		db.addStock(testStock);
		db.addStock(testStock2);
		List<Stock> stocks=db.getPortfolio();
		Stock testStock12=stocks.get(0);
		double a=testStock2.getKurse().get(3).getKurse();
		System.out.println(a);

	}

}
