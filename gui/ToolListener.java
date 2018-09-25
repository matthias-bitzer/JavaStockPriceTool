package gui;

public class ToolListener {
	private MainFrame main;
	
	public void setMain(MainFrame main){
		this.main=main;
		
	}
	public void setChoosePanel(){
		main.ReactionToolListener();
	}
	public void setChartPanel(int multiplikator){
		main.ReactionToolListenerZoom(multiplikator);
	}
}
