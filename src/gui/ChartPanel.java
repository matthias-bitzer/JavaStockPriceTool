package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Stock;

public class ChartPanel extends JPanel {
	private Stock stock;
	private double[] kurse;
	private double[] kurse2;
	private int l;
	private double max1;
	private double min1;
	private Color colorChart;
	ChartPanel(){
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.white);
		Dimension d1 = new Dimension(720,500);
		Dimension d2 = new Dimension(1200,500);
		this.setMinimumSize(d1);
		this.setPreferredSize(d2);
		colorChart=Color.red;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int height=this.getHeight();
		int width=this.getWidth();
		double scalex=(double)width/((double)l-1);
		double scaley=((double)height/(max1))/2;
		chartPaint(g,scalex,scaley, width, height);
		paintCoordinates(g,scalex,scaley, width, height);
		
	}

	public void setStock(Stock stock) {
		this.stock = stock;
		convertToArray(stock);
		repaint();
	}
	public void convertToArray(Stock stock){
		int l1= stock.getKurse().size();
		this.l=l1;
		double max=stock.getKurse().get(0).getKurse();
		double min=max;
		kurse=new double[l1];
		kurse2=new double[l1];
		for(int i=0; i<stock.getKurse().size();i++){
			kurse[i]=stock.getKurse().get(i).getKurse();
			kurse2[i]=-1*kurse[i];
			if(max<kurse[i]){
				max=kurse[i];
			}
			if(min>kurse[i]){
				min=kurse[i];
			}
			
		}
		this.max1=max;
		this.min1=min;
		
	}
	public void chartPaint(Graphics g,double scalex,double scaley, int width,int height){
		Graphics2D g2=(Graphics2D) g;
		
		
		GeneralPath chart =new GeneralPath();
		
		if(stock!=null){
			chart.moveTo(0, kurse2[0]);
			for(int i=1; i<kurse2.length;i++){
				chart.lineTo(i,kurse2[i]);
				}
		
		AffineTransform transform= new AffineTransform();
		transform.translate(0, height/2);
		transform.scale(scalex, scaley);
		transform.translate(0, -1*kurse2[0]);
		Shape chart2=transform.createTransformedShape(chart);
		g2.setColor(colorChart);
		
		g2.draw(chart2);
		}
		
			
			
		}
	public void paintCoordinates(Graphics g,double scalex, double scaley, int width,int height){
		if(stock!=null){
		//int l=height/(int)scaley;
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(0.3f));
		AffineTransform transform= new AffineTransform();
		transform.translate(0, height/2);
		transform.scale(scalex, scaley);
		transform.translate(0, -1*kurse2[0]);
		
		double amountx=(double)width/scalex;
		double amounty=(double)height/scaley;
		for(int i=-40;i<=40;i++){
			int koordinate=(int)((max1*2/30)*i*(-1)*2);
			
		GeneralPath xachse=new GeneralPath();
		xachse.moveTo(0, i*30/scaley);
		xachse.lineTo(width/scalex, i*30/scaley);
		
	
		//g2.drawString(koordinate+"", 0,  ykoordinatetext);
		Shape xachse2=transform.createTransformedShape(xachse);
		int kooredinatetext=xachse2.getBounds().y;
		g2.drawString(koordinate+"", 0, kooredinatetext);
		g2.draw(xachse2);
		}
	
		
		}
		
		
		
	}

	public void setColorChart(Color colorChart) {
		this.colorChart = colorChart;
		repaint();
	}
	
		
		
	}
	
	


