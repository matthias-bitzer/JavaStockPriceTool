package gui;

public class InformationListener {
private MainFrame main;
	
	public void setMain(MainFrame main){
		this.main=main;
		
	}
	public void ladeAktie(String name){
		main.ReactionInformationListener(name);
		
	}

}
