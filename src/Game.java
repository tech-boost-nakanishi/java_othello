import java.awt.BasicStroke;
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
	private Frame frame;
	private String hoveredEllipse = "";
	public static String[][] board = new String[8][8];
	public static String playerState, playerWinner;
	public static boolean isSkipped = false;
	public static boolean isFinished = false;
	
	public Game(Frame frame, Menu menu) {
		this.frame = frame;
		this.menu = menu;
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		menuEllipse = new Ellipse2D.Double(30, 670, 120, 50);
		againEllipse = new Ellipse2D.Double(170, 670, 120, 50);
		settingEllipse = new Ellipse2D.Double(300, 670, 120, 50);
		
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				board[x][y] = States.BLANK.toString();
			}
		}
		
		if(Setting.blackorwhite.equals("black")) {
			board[3][3] = States.COMPUTER.toString();
			board[4][3] = States.USER.toString();
			board[3][4] = States.USER.toString();
			board[4][4] = States.COMPUTER.toString();
		}
		else if(Setting.blackorwhite.equals("white")) {
			board[3][3] = States.USER.toString();
			board[4][3] = States.COMPUTER.toString();
			board[3][4] = States.COMPUTER.toString();
			board[4][4] = States.USER.toString();
		}
		
		playerWinner = States.BLANK.toString();
		
		if(Setting.faorsa.equals("fa")) {
			playerState = States.USER.toString();
		}
		else if(Setting.faorsa.equals("sa")) {
			playerState = States.COMPUTER.toString();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(new Color(0, 128, 0));
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
		
		//境界線
		g2d.setColor(Color.BLACK);
		BasicStroke BStroke = new BasicStroke(2.0f);
        g2d.setStroke(BStroke);
		g2d.drawLine(80, 0, 80, width);
		g2d.drawLine(160, 0, 160, width);
		g2d.drawLine(240, 0, 240, width);
		g2d.drawLine(320, 0, 320, width);
		g2d.drawLine(400, 0, 400, width);
		g2d.drawLine(480, 0, 480, width);
		g2d.drawLine(560, 0, 560, width);
		g2d.drawLine(0, 80, width, 80);
		g2d.drawLine(0, 160, width, 160);
		g2d.drawLine(0, 240, width, 240);
		g2d.drawLine(0, 320, width, 320);
		g2d.drawLine(0, 400, width, 400);
		g2d.drawLine(0, 480, width, 480);
		g2d.drawLine(0, 560, width, 560);
		
		int usercount = 0;
		int computercount = 0;
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				if(board[x][y].equals(States.USER.toString())) {
					usercount++;
					if(Setting.blackorwhite.equals("black")) {
						drawBlackCircle(g, x, y);
					}
					else if(Setting.blackorwhite.equals("white")) {
						drawWhiteCircle(g, x, y);
					}
				}
				else if(board[x][y].equals(States.COMPUTER.toString())) {
					computercount++;
					if(Setting.blackorwhite.equals("black")) {
						drawWhiteCircle(g, x, y);
					}
					else if(Setting.blackorwhite.equals("white")) {
						drawBlackCircle(g, x, y);
					}
				}
			}
		}
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("arial", Font.BOLD, 16));
		g2d.drawString("あなた: " + usercount + "  コンピュータ: " + computercount, 430, 690);
		String str = "";
		if(playerState.equals(States.USER.toString())) {
			str = "あなたの番です。";
		}
		else if(playerState.equals(States.COMPUTER.toString())) {
			str = "コンピュータの番です。";
		}
		else {
			str = "";
		}
		g2d.drawString(str, 430, 720);
		
		if(isFinished()) {
			drawResult(g, usercount, computercount);
		}
	}
	
	public static boolean isFinished() {
		return isFinished;
	}

	public static void setFinished(boolean isFinished) {
		Game.isFinished = isFinished;
	}

	public void drawBlackCircle(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		int xPos = x * (width / 8);
		int yPos = y * (width / 8);
		int diff = 3;
		
		g2d.setColor(Color.BLACK);
		g2d.fillOval(xPos + diff, yPos + diff, width / 8 - diff * 2, width / 8 - diff * 2);
	}
	
	public void drawWhiteCircle(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		
		int xPos = x * (width / 8);
		int yPos = y * (width / 8);
		int diff = 3;
		
		g2d.setColor(Color.WHITE);
		g2d.fillOval(xPos + diff, yPos + diff, width / 8 - diff * 2, width / 8 - diff * 2);
	}
	
	public void drawResult(Graphics g, int uc, int cc) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(new Color(0, 0, 0, 200));
		g2d.fillRect(0, 0, width, width);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("arial", Font.BOLD, 26));
		String str;
		if(uc > cc) str = "あなたの勝ちです。";
		else if(uc < cc) str = "あなたの負けです。";
		else str = "引き分けです。";
		g2d.drawString(str, width / 2 - g2d.getFontMetrics().stringWidth(str) / 2, width / 2 + g2d.getFontMetrics().getAscent());
	}
	
	public int getX(int mx) {
		return (int) mx / (width / 8);
	}
	
	public int getY(int my) {
		return (int) my / (width / 8);
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
		int mx = e.getX();
		int my = e.getY();
		if(menu.MouseOnOval(mx, my, menuEllipse)) {
			frame.changePanel("menuPanel");
		}
		else if(menu.MouseOnOval(mx, my, againEllipse)) {
			frame.changePanel("gamePanel");
		}
		else if(menu.MouseOnOval(mx, my, settingEllipse)) {
			frame.changePanel("settingPanel");
		}
		
		if(GameLogic.CanPutStone(States.USER.toString())) {
			if(mx >= 0 && mx <= width && my >= 0 && my <= width) {
				if(playerState.equals(States.USER.toString())) {
					if(GameLogic.PutStone(getX(mx), getY(my), States.USER.toString(), States.CHECK.toString()) > 0) {
						isSkipped = false;
						GameLogic.PutStone(getX(mx), getY(my), States.USER.toString(), States.CHANGE.toString());
						playerState = States.COMPUTER.toString();
						GameLogic.ComputerLogic();
					}
				}
			}
		}
		else {
			if(isSkipped) {
				//両方置けないのでゲーム終了
				setFinished(true);
				playerState = States.BLANK.toString();
			}
			else {
				isSkipped = true;
			}
		}
		repaint();
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
