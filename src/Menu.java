import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Menu extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	private Ellipse2D startEllipse, settingEllipse, quitEllipse;
	private String hoveredEllipse = "";
	
	public Menu() {
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		startEllipse = new Ellipse2D.Double(width / 2 - 90, 110, 180, 60);
		settingEllipse = new Ellipse2D.Double(width / 2 - 90, 190, 180, 60);
		quitEllipse = new Ellipse2D.Double(width / 2 - 90, 270, 180, 60);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, width, height);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("arial", Font.BOLD, 30));
		g2d.drawString("メインメニュー", width / 2 - g2d.getFontMetrics().stringWidth("メインメニュー") / 2, 60);
		
		g2d.setColor(Color.BLACK);
		g2d.fill(startEllipse);
		g2d.fill(settingEllipse);
		g2d.fill(quitEllipse);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("arial", Font.BOLD, 26));
		g2d.drawString("ゲーム開始", (int)startEllipse.getX() + 25, (int)startEllipse.getY() + 40);
		g2d.drawString("設定画面", (int)settingEllipse.getX() + 40, (int)settingEllipse.getY() + 40);
		g2d.drawString("ゲーム終了", (int)quitEllipse.getX() + 25, (int)quitEllipse.getY() + 40);
		if(hoveredEllipse.equals("startEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("ゲーム開始", (int)startEllipse.getX() + 25, (int)startEllipse.getY() + 40);
		}
		else if(hoveredEllipse.equals("settingEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("設定画面", (int)settingEllipse.getX() + 40, (int)settingEllipse.getY() + 40);
		}
		else if(hoveredEllipse.equals("quitEllipse")) {
			g2d.setColor(Color.RED);
			g2d.drawString("ゲーム終了", (int)quitEllipse.getX() + 25, (int)quitEllipse.getY() + 40);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle mouseRect = new Rectangle(e.getX(), e.getY(), 1, 1);
		if(mouseRect.intersects(startEllipse.getX(), startEllipse.getY(), startEllipse.getWidth(), startEllipse.getHeight())) {
			hoveredEllipse = "startEllipse";
		}
		else if(mouseRect.intersects(settingEllipse.getX(), settingEllipse.getY(), settingEllipse.getWidth(), settingEllipse.getHeight())) {
			hoveredEllipse = "settingEllipse";
		}
		else if(mouseRect.intersects(quitEllipse.getX(), quitEllipse.getY(), quitEllipse.getWidth(), quitEllipse.getHeight())) {
			hoveredEllipse = "quitEllipse";
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
