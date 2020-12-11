import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 750;
	private Ellipse2D menuEllipse, againEllipse, settingEllipse;
	private Menu menu;
	private String hoveredEllipse = "";
	
	public Game(Menu menu) {
		this.menu = menu;
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		menuEllipse = new Ellipse2D.Double(30, 670, 120, 50);
		againEllipse = new Ellipse2D.Double(170, 670, 120, 50);
		settingEllipse = new Ellipse2D.Double(300, 670, 120, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, width, width);
		
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, width, width, height - width);
		
		g2d.setColor(Color.BLACK);
		g2d.fill(menuEllipse);
		g2d.fill(againEllipse);
		g2d.fill(settingEllipse);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("arial", Font.BOLD, 24));
		g2d.drawString("メニュー", (int)menuEllipse.getX() + 15, (int)menuEllipse.getY() + 35);
		g2d.drawString("最初から", (int)againEllipse.getX() + 15, (int)againEllipse.getY() + 35);
		g2d.drawString("設定画面", (int)settingEllipse.getX() + 15, (int)settingEllipse.getY() + 35);
		if(hoveredEllipse.equals("menuEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("メニュー", (int)menuEllipse.getX() + 15, (int)menuEllipse.getY() + 35);
		}
		else if(hoveredEllipse.equals("againEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("最初から", (int)againEllipse.getX() + 15, (int)againEllipse.getY() + 35);
		}
		else if(hoveredEllipse.equals("settingEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("設定画面", (int)settingEllipse.getX() + 15, (int)settingEllipse.getY() + 35);
		}
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
		else if(menu.MouseOnOval(mx, my, againEllipse)) {
			hoveredEllipse = "againEllipse";
		}
		else if(menu.MouseOnOval(mx, my, settingEllipse)) {
			hoveredEllipse = "settingEllipse";
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
