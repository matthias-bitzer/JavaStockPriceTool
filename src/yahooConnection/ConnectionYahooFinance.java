package yahooConnection;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

//import yahoofinance.*;
//import yahoofinance.histquotes.HistoricalQuote;
//import yahoofinance.histquotes.Interval;

public class ConnectionYahooFinance {

	public double[] loadStock(String name){
		Random randomizer = new Random();
		double[] kurse= new double[365];
		kurse[0]=100;
		for(int i =1; i<kurse.length;i++){
			double delta = (randomizer.nextDouble()-0.5)*10;
			kurse[i]=kurse[i-1]+delta;
		}
			return kurse;

	}
	/*
	public double[] loadStock(String name) throws IOException{
		
		Stock stock= YahooFinance.get(name);
		Calendar from= Calendar.getInstance();
		from.add(Calendar.YEAR, -1);
		Calendar to= Calendar.getInstance();
		List<HistoricalQuote> stockquote=stock.getHistory(from,to,Interval.DAILY);
		int size=stockquote.size();
		double[] kurse= new double[size];
		for(int i =0; i<size;i++){
			kurse[i]=stockquote.get(i).getClose().doubleValue();
		}
		return kurse;
		
	}
*/
}
