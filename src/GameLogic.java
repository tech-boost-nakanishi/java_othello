import java.util.Random;

public class GameLogic {
	
	public static boolean CanPutStone(int x, int y, String player, String mode) {
		int count = 0;
		int index = 0;
		int dx, dy;
		int[][] flipstones;
		String opponent = null;
		if(player.equals(States.USER.toString())) opponent = States.COMPUTER.toString();
		else if(player.equals(States.COMPUTER.toString())) opponent = States.USER.toString();
		else States.BLANK.toString();
		
		//上方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][2];
		while(true) {
			dy--;
			if(Game.board[dx][dy].equals(States.BLANK.toString()) ||
			   Game.board[dx][dy].equals(null)) {
				break;
			}
			else {
				if(Game.board[dx][dy].equals(player)) {
					count += flipstones.length;
					if(mode.equals(States.CHANGE.toString())) {
						flipStones(flipstones, player);
					}
				}
				else if(Game.board[dx][dy].equals(opponent)) {
					flipstones[index][0] = dx;
					flipstones[index][1] = dy;
					index++;
				}
			}
		}
		
		if(mode.equals(States.CHECK.toString())) {
			if(count == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		
		if(mode.equals(States.CHANGE.toString())) {
			Game.board[x][y] = player;
		}
		return false;
	}
	
	public static void ComputerLogic() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int[][] blank = new int[64][2];
		int index = 0;
		for(int x = 0; x < Game.board.length; x++) {
			for(int y = 0; y < Game.board[x].length; y++) {
				if(Game.board[x][y].equals(States.BLANK.toString())) {
					if(CanPutStone(x, y, States.COMPUTER.toString(), States.CHECK.toString())) {
						blank[index][0] = x;
						blank[index][1] = y;
						index++;
					}
				}
			}
		}
		
		if(blank.length == 0) {
			if(Game.isSkipped) {
				//両方置けないのでゲーム終了
				Game.playerState = States.BLANK.toString();
			}
			else {
				Game.isSkipped = true;
			}
		}
		else {
			Game.isSkipped = false;
			Random rand = new Random();
			int r = rand.nextInt(blank.length);
			Game.board[blank[r][0]][blank[r][1]] = States.COMPUTER.toString();
			Game.playerState = States.USER.toString();
		}
	}
	
	public static void flipStones(int[][] array, String player) {
		if(array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				Game.board[array[i][0]][array[i][1]] = player;
			}
		}
	}

}
