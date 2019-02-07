package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.Controller;
import Model.Stock;

public class MainFrame extends JFrame{
	
	private ChoosePanel choosepanel;
	private ToolPanel toolpanel;
	private InformationPanel informationpanel;
	private Controller controller;
	private ChooseListener chooselistener;
	private ChartPanel2 chartpanel2;
	private ToolListener toollistener;
	private InformationListener informationlistener;
	MainFrame(){
		setSize(1200,1000);
		Dimension d = new Dimension(1200,800);
		setMinimumSize(d);
		
		chartpanel2=new ChartPanel2();
		choosepanel=new ChoosePanel();
		toolpanel=new ToolPanel();
		toollistener=new ToolListener();
		toollistener.setMain(this);
		toolpanel.setListener(toollistener);
		informationpanel= new InformationPanel();
		informationlistener= new InformationListener();
		informationlistener.setMain(this);
		informationpanel.setListener(informationlistener);
		controller=new Controller();
		chooselistener= new ChooseListener();
		chooselistener.setMain(this);
		choosepanel.setListener(chooselistener);
		Layout();
		Menu();
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

	public void Layout(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		//Erste Reihe///////////
		gc.gridy=0;
		gc.weighty=0.8;
		
		//ToolPanel
		gc.gridx=0;
		gc.weightx=0.2;
		add(toolpanel,gc);
		
		//ChartPanel
		gc.gridx=1;
		gc.weightx=0.6;
		add(chartpanel2,gc);
		
		//ChoosePanel
		gc.gridx=2;
		gc.weightx=0.2;
		add(choosepanel,gc);
		
		//Zweite Reihe//////////
		gc.gridy=1;
		gc.weighty=0.2;
		gc.weightx=1;
		gc.gridwidth=3;
		gc.gridx=0;
		//InformationPanel
		add(informationpanel,gc);
		
		
		
	}	
	
	public void Menu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu datei =new JMenu("Datei");
		
		JMenu chart = new JMenu("Chart");
		JMenu farbe= new JMenu("Farbe");
		JCheckBoxMenuItem rot= new JCheckBoxMenuItem("rot");
		JCheckBoxMenuItem blau= new JCheckBoxMenuItem("blau");
		JCheckBoxMenuItem schwarz= new JCheckBoxMenuItem("schwarz");
		ButtonGroup farbenGruppe = new ButtonGroup();
		farbenGruppe.add(rot);
		farbenGruppe.add(blau);
		farbenGruppe.add(schwarz);
		rot.setSelected(true);
		farbe.add(rot);
		farbe.add(blau);
		farbe.add(schwarz);
		rot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chartpanel2.setColorChart(Color.red);
				
			}
			
		});
		blau.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chartpanel2.setColorChart(Color.blue);
				
			}
			
		});
		schwarz.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chartpanel2.setColorChart(Color.black);
				
			}
			
		});
		
		
		JMenuItem importieren = new JMenuItem("Importieren...");
		JMenuItem beenden =new JMenuItem("Beenden");
		datei.add(importieren);
		datei.add(beenden);
		chart.add(farbe);
		menuBar.add(datei);
		menuBar.add(chart);
		this.setJMenuBar(menuBar);
		
		
		
		
	}
	
	public void getData(){
		List<Stock> db =controller.getData();
		choosepanel.getStocktablemodel().setData(db);
		choosepanel.getStocktablemodel().fireTableDataChanged();
		
		
	}
	public void getNames(){
		List<String> names=controller.getNames();
		List<Stock> database=controller.getData();
		choosepanel.getStocktablemodel().setNames(names,database);
		choosepanel.getStocktablemodel().fireTableDataChanged();
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}
	public void ReactionDrawChart(Stock stock){
		System.out.println("Chart wird gezeichnet...");
		double[] kurs=controller.getStockArray(stock);
		double[] rendite=controller.getReturnArray(stock);
		if(toolpanel.getKurs().isSelected()){
		chartpanel2.setChart(kurs,1);
		}
		if(toolpanel.getRendite().isSelected()){
			chartpanel2.setChart(rendite,2);
			}
	}
	public void ReactionToolListener(){
		if(toolpanel.getKurs().isSelected()){
			choosepanel.setVisible(true);
		}
		if(toolpanel.getRendite().isSelected()){
			choosepanel.setVisible(true);
			}
		if(toolpanel.getKorrelation().isSelected()){
			choosepanel.setVisible(false);
			}
		
		
	}
	public void ReactionToolListenerZoom(int multiplikator){
		
		float mult=(float)multiplikator/600;
		chartpanel2.setZoom(mult);
		
		
	}
	public void ReactionInformationListener(String name){
		String status="Lade "+name+"...\n";
		informationpanel.getStatus().setText(status);
		try {
			controller.LoadStockFromYahooToDatabase(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			informationpanel.getStatus().setText("Fehler beim Laden\n");
		}
		getNames();
		informationpanel.getStatus().setText(status+"Laden abgeschlossen\n");
		
		
	}
	
	
	
}

