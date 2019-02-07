package Model;

import java.util.LinkedList;
import java.util.List;

public class Stock {
	private List<kurs> kursStock;
	private String name;
	
	public Stock(String name){
		kursStock=new LinkedList<kurs>();
		this.name=name;
		
	}
	public Stock(double[] kurse,String name){
		this.name=name;
		kursStock=new LinkedList<kurs>();
		int l =kurse.length;
		
		for(int i =0; i<l;i++){
			addKurs(kurse[i],i+1);
			
		}
	}
	
	public void addKurs(double kursx, int index){
		kursStock.add(new kurs(kursx,index));
		
	}
	public List<kurs> getKurse(){
		return kursStock;
	}
	public String getName() {
		return name;
	}
	
	
	

}
