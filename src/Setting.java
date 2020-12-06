import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Setting extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int width = 640, height = 360;
	
	public Setting() {
		this.setPreferredSize(new Dimension(width, height));
		
		this.setLayout(null);
		String[] faorsacombostr = {"先攻", "後攻"};
		JComboBox faorsacombo = new JComboBox(faorsacombostr);
		faorsacombo.setBounds(280, 120, 100, 40);
		this.add(faorsacombo);
		
		String[] blackorwhitecombostr = {"黒", "白"};
		JComboBox blackorwhitecombo = new JComboBox(blackorwhitecombostr);
		blackorwhitecombo.setBounds(280, 210, 100, 40);
		this.add(blackorwhitecombo);
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
	}

}
