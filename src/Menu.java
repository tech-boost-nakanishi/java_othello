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

public class Menu extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	private Ellipse2D startEllipse, settingEllipse, quitEllipse;
	private String hoveredEllipse = "";
	private Frame frame;
	
	public Menu(Frame frame) {
		this.frame = frame;
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
	
	public boolean MouseOnOval(int mx, int my, Ellipse2D ell) {
		int a = (int) ell.getWidth() / 2;
		int b = (int) ell.getHeight() / 2;
		int c = (int) Math.sqrt(a*a - b*b);
		int centerX = (int) ell.getX() + a;
		int centerY = (int) ell.getY() + b;
		int fx1 = centerX - c;
		int fx2 = centerX + c;
		int kijun = (int) Math.sqrt(c*c + b*b) * 2;
		int aa = Math.abs(mx - fx1);
		int bb = Math.abs(my - centerY);
		int cc = (int) Math.sqrt(aa*aa + bb*bb);
		aa = Math.abs(mx - fx2);
		cc += (int) Math.sqrt(aa*aa + bb*bb);
		if(kijun >= cc) {
			return true;
		}
		return false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(MouseOnOval(mx, my, startEllipse)) {
			hoveredEllipse = "startEllipse";
		}
		else if(MouseOnOval(mx, my, settingEllipse)) {
			hoveredEllipse = "settingEllipse";
		}
		else if(MouseOnOval(mx, my, quitEllipse)) {
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
		int mx = e.getX();
		int my = e.getY();
		if(MouseOnOval(mx, my, startEllipse)) {
			frame.changePanel("gamePanel");
		}
		else if(MouseOnOval(mx, my, settingEllipse)) {
			frame.changePanel("settingPanel");
		}
		else if(MouseOnOval(mx, my, quitEllipse)) {
			System.exit(1);
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
