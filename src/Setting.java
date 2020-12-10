import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Setting extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	private Ellipse2D menuEllipse, changeEllipse;
	private String hoveredEllipse = "";
	private Frame frame;
	private Menu menu;
	private boolean isChanged = false;
	private String faorsa, blackorwhite;
	private static JComboBox<Object> faorsacombo, blackorwhitecombo;
	
	public Setting(Frame frame, Menu menu) {
		this.frame = frame;
		this.menu = menu;
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setLayout(null);
		
		String[] faorsacombostr = {"先攻", "後攻"};
		faorsacombo = new JComboBox<Object>(faorsacombostr);
		faorsacombo.setBounds(280, 120, 100, 40);
		this.add(faorsacombo);
		
		String[] blackorwhitecombostr = {"黒", "白"};
		blackorwhitecombo = new JComboBox<Object>(blackorwhitecombostr);
		blackorwhitecombo.setBounds(280, 210, 100, 40);
		this.add(blackorwhitecombo);
		
		menuEllipse = new Ellipse2D.Double(280, 280, 120, 50);
		changeEllipse = new Ellipse2D.Double(420, 280, 120, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, width, height);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("arial", Font.BOLD, 30));
		g2d.drawString("設定画面", width / 2 - g2d.getFontMetrics().stringWidth("設定画面") / 2, 60);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("arial", Font.BOLD, 24));
		g2d.drawString("先攻or後攻", 100, 150);
		g2d.drawString("黒or白", 150, 240);
		
		g2d.setColor(Color.BLACK);
		g2d.fill(menuEllipse);
		g2d.fill(changeEllipse);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("arial", Font.BOLD, 24));
		g2d.drawString("メニュー", (int)menuEllipse.getX() + 15, (int)menuEllipse.getY() + 35);
		g2d.drawString("変更", (int)changeEllipse.getX() + 38, (int)changeEllipse.getY() + 35);
		if(hoveredEllipse.equals("menuEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("メニュー", (int)menuEllipse.getX() + 15, (int)menuEllipse.getY() + 35);
		}
		else if(hoveredEllipse.equals("changeEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("変更", (int)changeEllipse.getX() + 38, (int)changeEllipse.getY() + 35);
		}
	}
	
	public void changeSetting() {
		try {
			File file = new File("res/setting.txt");
			if(!file.exists()) {
				file.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				faorsa = "fa";
				blackorwhite = "black";
				bw.write(faorsa + " " + blackorwhite);
				bw.close();
			}
			else {
				if(isChanged) {
					file.delete();
					file.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					int num = faorsacombo.getSelectedIndex();
					if(num == 0) faorsa = "fa";
					else if(num == 1) faorsa = "sa";
					num = blackorwhitecombo.getSelectedIndex();
					if(num == 0) blackorwhite = "black";
					else if(num == 1) blackorwhite = "white";
					bw.write(faorsa + " " + blackorwhite);
					bw.close();
				}
				else {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String data = br.readLine();
					String[] datasplit = data.split(" ");
					faorsa = datasplit[0];
					blackorwhite = datasplit[1];
					br.close();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		isChanged = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(menu.MouseOnOval(mx, my, menuEllipse)) {
			hoveredEllipse = "menuEllipse";
		}
		else if(menu.MouseOnOval(mx, my, changeEllipse)) {
			hoveredEllipse = "changeEllipse";
		}
		else {
			hoveredEllipse = "";
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(menu.MouseOnOval(mx, my, menuEllipse)) {
			frame.changePanel("menuPanel");
		}
		else if(menu.MouseOnOval(mx, my, changeEllipse)) {
			isChanged = true;
			changeSetting();
			frame.changePanel("menuPanel");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
