import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Setting extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	
	public Setting() {
		this.setPreferredSize(new Dimension(width, height));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, width, height);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("arial", Font.BOLD, 30));
		g2d.drawString("設定画面", width / 2 - g2d.getFontMetrics().stringWidth("設定画面") / 2, 60);
	}

}
