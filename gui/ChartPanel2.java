package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Stock;

public class ChartPanel2 extends JPanel {
	private Color colorChart;
	
	
	private double[] werte;
	private double[] nwerte;
	private int l;
	private double max;
	private double min;
	private int ymouse;
	private boolean first;
	private int artWert;
	private int mouseclicked;
	private int mousereleased;
	private int xstart;
	private float zoom;
	private float zoom1;
	
	
	ChartPanel2(){
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.white);
		Dimension d1 = new Dimension(720,500);
		Dimension d2 = new Dimension(1200,500);
		this.setMinimumSize(d1);
		this.setPreferredSize(d2);
		colorChart=Color.red;
		final int height=this.getHeight();
		first=true;
		ymouse=0;
		mouseclicked=0;
		mousereleased=0;
		xstart=0;
		zoom=1;
		zoom1=1;
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				
				ymouse=arg0.getY();
				
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseclicked=arg0.getY();
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				mousereleased=arg0.getY();
				xstart=-mouseclicked+mousereleased+xstart;
				
				
			}
			
		});
		
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
	
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//paintEverything(g);
		paintEverything2(g);
		
		
		
	
	}



	public void setChart(double[] werte1,int artWert){
		first=true;
		ymouse=0;
		mouseclicked=0;
		mousereleased=0;
		xstart=0;
		
		this.artWert=artWert;
		if(artWert==1){
			zoom=1;
			zoom1=1;
		}
		if(artWert==2){
			zoom=1000;
			zoom1=1000;
		}
		getWerte(werte1);
		
		repaint();
	}
	
	public void getWerte(double[] werte1){
		int l1=werte1.length;
		 werte=new double[l1];
		 nwerte=new double[l1];
		 
		double maxx=werte1[0];
		double minn=werte1[0];
		for(int i=0; i<l1;i++){
			
			werte[i]=werte1[i];
			nwerte[i]=(-1)*werte1[i];
			if(maxx<werte[i]){
				maxx=werte[i]*zoom;
			}
			if(minn>werte[i]){
				minn=werte[i]*zoom;
			}
			
			
			
		}
		this.min=minn;
		this.max=maxx;
		this.l=l1;
		
		
	}
	
	
	public void chartPaint(Graphics g,double scalex,double scaley, int width,int height,AffineTransform transform){
		Graphics2D g2=(Graphics2D) g;
		
		
		GeneralPath chart =new GeneralPath();
		
		if(werte!=null){
			chart.moveTo(0, nwerte[0]);
			for(int i=1; i<nwerte.length;i++){
				chart.lineTo(i,nwerte[i]);
				}
		
		
		Shape chart2=transform.createTransformedShape(chart);
		g2.setColor(colorChart);
		
		g2.draw(chart2);
		}
		
			
			
		}
	
	public void chartPaint2(Graphics g,AffineTransform transform){
		Graphics2D g2=(Graphics2D) g;
		
		
		GeneralPath chart =new GeneralPath();
		
		if(werte!=null){
			chart.moveTo(0, nwerte[0]*zoom);
			for(int i=1; i<nwerte.length;i++){
				chart.lineTo(i,nwerte[i]*zoom);
				}
		
		
		Shape chart2=transform.createTransformedShape(chart);
		g2.setColor(colorChart);
		
		g2.draw(chart2);
		}
		
			
			
		}
	public void paintCoordinates(Graphics g,double scalex, double scaley, int width,int height,AffineTransform transform, int zoom){
		if(werte!=null){
		//int l=height/(int)scaley;
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(0.3f));
		
		
		double amountx=(double)width/scalex;
		double amounty=(double)height/scaley;
		for(int i=-40;i<=40;i++){
			float koordinate=(float)((max*2/30)*i*(-1)*zoom);
			
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
	
	public void paintCoordinates2(Graphics g,AffineTransform transform){
		int abstand=40;
		int ymin=(int) (min-1000);
		int ymax=(int) (max+1000);
		int height=this.getHeight();
		int width=this.getWidth();
		//int l=height/(int)scaley;
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(0.3f));
		
		
		for(int i=-ymax; i<=-ymin;i=i+abstand){
		float koordinate=(float)(-i)/(float)zoom;
		
		GeneralPath xachse=new GeneralPath();
		xachse.moveTo(0,i);
		xachse.lineTo(width, i);
		
	
		//g2.drawString(koordinate+"", 0,  ykoordinatetext);
		Shape xachse2=transform.createTransformedShape(xachse);
		int kooredinatetext=xachse2.getBounds().y;
		g2.drawString(koordinate+"", 0, kooredinatetext);
		g2.draw(xachse2);
		}
	
		
		
		
		
		
	}
	
	
	public void paintEverything(Graphics g){
		int height=this.getHeight();
		int width=this.getWidth();
		if(first){
			ymouse=height/2;
			first=false;
		}else{
		
		}
		//System.out.println(werte[0]);
		double scalex=(double)width/((double)l-1);
		int zoom=1;
		double scaley=((double)height/(max))/zoom;
		//double scaley=((double)height/(max-min));
		//double scaley=((double)height/(max));
		if(werte!=null){
		AffineTransform transform= new AffineTransform();
		//transform.translate(0, height/2);
		transform.translate(0, ymouse);
		if(artWert==1){
			transform.scale(scalex, scaley);
			}
		if(artWert==2){
		transform.scale(scalex, scaley/2);
		}
		transform.translate(0, -1*nwerte[0]);
		chartPaint(g,scalex,scaley, width, height,transform);
		paintCoordinates(g,scalex,scaley, width, height,transform,zoom);
		}
		
	}
	
	
	
	public void paintEverything2(Graphics g){
		int height=this.getHeight();
		int width=this.getWidth();
		if(werte!=null){
		int y=height/2;
		
		
		AffineTransform transform= new AffineTransform();
		//transform.translate(0, -1*nwerte[0]+height-y);
		
		transform.translate(0,-1*nwerte[0]);
		transform.translate(0,height/2);
		transform.translate(0,xstart);
		//transform.translate(0,mouseclicked);
		transform.translate(0,ymouse-mouseclicked);
		transform.scale(2, 1);
		
		chartPaint2(g,transform);
		paintCoordinates2(g,transform);
		
		}
		
	}
	
	
	public void setColorChart(Color colorChart) {
		this.colorChart = colorChart;
		ymouse=0;
		mouseclicked=0;
		mousereleased=0;
		xstart=0;
		repaint();
	}
	
	public void setZoom(float multiplikator){
		this.zoom=this.zoom1*multiplikator;
		ymouse=0;
		mouseclicked=0;
		mousereleased=0;
		if(werte!=null){
		xstart=(int) (((zoom-1)*(-1)*nwerte[0]));
		}else{
			xstart=0;
		}
		repaint();
	}
	
}
