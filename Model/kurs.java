package Model;

import java.util.Date;

public class kurs {
	private double kurse;
	//private Date date;
	private int index;
	kurs(double kurse, int index){
		this.kurse=kurse;
		//this.date=date;
		this.index=index;
		
		
	}
	public double getKurse() {
		return kurse;
	}
	public int getIndex() {
		return index;
	}
	

}
