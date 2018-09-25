package gui;

public class TestStock {

	public static double[] GenerateStock(int l,int start1){
		double[] kurse = new double[l];
		double kurs=start1*Math.random();
		kurse[0]=kurs;
		for(int i=1; i<l;i++){
			double zufall1=Math.random();
			double zufall2=Math.random();
			double rendite=0;
			if(zufall1>0.5){
			rendite=0.1*zufall2;
			}else{
				rendite=-0.1*zufall2;
			}
			kurs=kurs*(1+rendite+0.001);
			kurse[i]=kurs;
			
		}
		return kurse;
		
		
		
	}
	
	
}
