package Controller;

public class ControllerUtils {
	public static double[] giveReturn(double[]kurs){
		int l=kurs.length;
		double[] kurs1=new double[l-1];
		double[] kurs2=new double[l-1];
		double[] rendite =new double[l-1];
		for(int i=0;i<(l-1);i++){
			kurs1[i]=kurs[i];
			kurs2[i]=kurs[i+1];
			rendite[i]=(kurs2[i]-kurs1[i])/kurs1[i];
		}
		return rendite;
		
	}


}
