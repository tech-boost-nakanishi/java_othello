import javax.swing.JFrame;

public class Frame {
	
	JFrame frame;
	
	Menu menuPanel;
	Setting settingPanel;
	Game gamePanel;
	
	public Frame() {
		frame = new JFrame();
		frame.setTitle("オセロゲーム");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		menuPanel = new Menu(this);
		settingPanel = new Setting(this, menuPanel);
		gamePanel = new Game(menuPanel);
		frame.getContentPane().add(menuPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void changePanel(String str) {
		frame.remove(menuPanel);
		frame.remove(settingPanel);
		frame.remove(gamePanel);
		
		if(str.equals("menuPanel")) {
			menuPanel = new Menu(this);
			frame.getContentPane().add(menuPanel);
		}
		else if(str.equals("settingPanel")) {
			settingPanel = new Setting(this, menuPanel);
			frame.getContentPane().add(settingPanel);
		}
		else if(str.equals("gamePanel")) {
			gamePanel = new Game(menuPanel);
			frame.getContentPane().add(gamePanel);
		}
		
		frame.pack();
	}

	public static void main(String[] args) {
		new Frame();
	}

}
