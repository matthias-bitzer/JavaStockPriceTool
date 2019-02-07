package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ToolPanel extends JPanel {
	JCheckBox kurs;
	JCheckBox rendite;
	JCheckBox korrelation;
	ToolListener listener;
	JSlider zoomslider;
	ToolPanel(){
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension d = new Dimension(240,500);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		kurs=new JCheckBox("Kurs");
		rendite=new JCheckBox("Rendite");
		korrelation=new JCheckBox("Korrelation");
		zoomslider=new JSlider(JSlider.VERTICAL,200,1000,600);
		zoomslider.setPreferredSize(new Dimension(40,490));
		zoomslider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				int multiplikator=((JSlider) arg0.getSource()).getValue();
				listener.setChartPanel(multiplikator);
				
			}
			
		});
		
		ButtonGroup checkBoxGruppe =new ButtonGroup();
		checkBoxGruppe.add(kurs);
		checkBoxGruppe.add(rendite);
		checkBoxGruppe.add(korrelation);
		
		
		Layout();
		
		
	}
	public void Layout(){
		setLayout(new GridBagLayout());
		GridBagConstraints gc =new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(kurs,gc);
		gc.gridy=1;
		add(rendite,gc);
		gc.gridy=2;
		gc.weighty=0;
		add(korrelation,gc);
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.gridx=1;
		gc.gridy=0;
		gc.weighty=1;
		gc.gridheight=3;
		add(zoomslider,gc);
		
		
		
		
	}
	public JCheckBox getKurs() {
		return kurs;
	}
	public JCheckBox getRendite() {
		return rendite;
	}
	public JCheckBox getKorrelation() {
		return korrelation;
	}
	public void setListener(ToolListener listener) {
		this.listener = listener;
		korrelation.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ToolPanel.this.listener.setChoosePanel();
				
			}
			
		});
		kurs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ToolPanel.this.listener.setChoosePanel();
				
			}
			
		});
		rendite.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ToolPanel.this.listener.setChoosePanel();
				
			}
			
		});
	}
	
	

}
