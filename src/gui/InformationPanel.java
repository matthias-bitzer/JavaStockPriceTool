package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InformationPanel extends JPanel {
	private JTextField aktienEingabe;
	private JButton laden;
	private JLabel label;
	private InformationListener listener;
	private JTextArea status;
	InformationPanel(){
		aktienEingabe= new JTextField(10);
		laden=new JButton("laden");
		label= new JLabel("Name/KŸrzel");
		status=new JTextArea();
		status.setBackground(this.getBackground());
		this.setBorder(BorderFactory.createEtchedBorder());
		Dimension d = new Dimension(1200,200);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		Layout();
		
	}
	public void Layout(){
		setLayout(new GridBagLayout());
		GridBagConstraints gc= new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=0;
		gc.weighty=0;
		gc.anchor=GridBagConstraints.PAGE_START;
		gc.insets=new Insets(3,1,0,0);
		add(label,gc);
		gc.insets=new Insets(0,0,0,0);
		gc.gridx=1;
		add(aktienEingabe,gc);
		gc.gridx=2;
		gc.weightx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(laden,gc);
		gc.anchor=GridBagConstraints.SOUTHWEST;
		gc.weightx=0;
		gc.gridx=0;
		gc.gridy=1;
		gc.weighty=1;
		gc.gridwidth=2;
		add(status,gc);
	
		
		
	}
	public void setListener(InformationListener listener){
		this.listener=listener;
		laden.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name=aktienEingabe.getText();
				if(name!=null){
					
					InformationPanel.this.listener.ladeAktie(name);
					
				}
				
			}
			
		});
		
	}
	public JTextArea getStatus() {
		return status;
	}

	
}
