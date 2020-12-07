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

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Setting extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	private Ellipse2D menuEllipse, changeEllipse;
	private String hoveredEllipse = "";
	private Frame frame;
	
	public Setting(Frame frame) {
		this.frame = frame;
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setLayout(null);
		
		String[] faorsacombostr = {"先攻", "後攻"};
		JComboBox<Object> faorsacombo = new JComboBox<Object>(faorsacombostr);
		faorsacombo.setBounds(280, 120, 100, 40);
		this.add(faorsacombo);
		
		String[] blackorwhitecombostr = {"黒", "白"};
		JComboBox<Object> blackorwhitecombo = new JComboBox<Object>(blackorwhitecombostr);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Rectangle mouseRect = new Rectangle(e.getX(), e.getY(), 1, 1);
		if(mouseRect.intersects(menuEllipse.getX(), menuEllipse.getY(), menuEllipse.getWidth(), menuEllipse.getHeight())) {
			hoveredEllipse = "menuEllipse";
		}
		else if(mouseRect.intersects(changeEllipse.getX(), changeEllipse.getY(), changeEllipse.getWidth(), changeEllipse.getHeight())) {
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
		Rectangle mouseRect = new Rectangle(e.getX(), e.getY(), 1, 1);
		if(mouseRect.intersects(menuEllipse.getX(), menuEllipse.getY(), menuEllipse.getWidth(), menuEllipse.getHeight())) {
			frame.changePanel("menuPanel");
		}
		else if(mouseRect.intersects(changeEllipse.getX(), changeEllipse.getY(), changeEllipse.getWidth(), changeEllipse.getHeight())) {
			
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
