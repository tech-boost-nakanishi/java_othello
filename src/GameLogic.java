import java.util.Random;

public class GameLogic {
	
	private static int[][] direction = {
			{0,-1},		//上方向
			{0,1},		//下方向
			{1,0},		//右方向
			{-1,0},		//左方向
			{1,-1},		//右斜め上方向
			{1,1},		//右斜め下方向
			{-1,-1},	//左斜め上方向
			{-1,1},		//左斜め下方向
	};
	
	public static int PutStone(int x, int y, String player, String mode) {
		if(mode.equals(States.CHANGE.toString())) {
			Game.board[x][y] = player;
		}
		int count = 0;
		int index = 0;
		int dx, dy;
		int[][] flipstones;
		String opponent = States.BLANK.toString();
		if(player.equals(States.USER.toString())) opponent = States.COMPUTER.toString();
		else if(player.equals(States.COMPUTER.toString())) opponent = States.USER.toString();
		
		for(int i = 0; i < direction.length; i++) {
			dx = x;
			dy = y;
			index = 0;
			flipstones = new int[64][];
			while(true) {
				dx += direction[i][0];
				dy += direction[i][1];
				if(dx < 0 || dy < 0 || dx >= Game.board.length || dy >= Game.board.length) {
					break;
				}
				if(Game.board[dx][dy].equals(States.BLANK.toString())) {
					break;
				}
				else {
					if(Game.board[dx][dy].equals(player)) {
						count += index;
						if(mode.equals(States.CHANGE.toString())) {
							flipStones(flipstones, player);
						}
						break;
					}
					else if(Game.board[dx][dy].equals(opponent)) {
						flipstones[index] = new int[] {dx, dy};
						index++;
					}
				}
			}
		}
		return count;
	}
	
	public static void ComputerLogic() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		int x, y;
		while(true) {
			x = rand.nextInt(Game.board.length);
			y = rand.nextInt(Game.board[0].length);
			if(Game.board[x][y].equals(States.BLANK.toString())) {
				if(PutStone(x, y, States.COMPUTER.toString(), States.CHECK.toString()) > 0) {
					PutStone(x, y, States.COMPUTER.toString(), States.CHANGE.toString());
					break;
				}
			}
		}
	}
	
	public static void flipStones(int[][] array, String player) {
		if(array.length > 0) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] == null) {
					break;
				}
				Game.board[array[i][0]][array[i][1]] = player;
			}
		}
	}
	
	public static boolean CanPutStone(String player) {
		int count = 0;
		for(int x = 0; x < Game.board.length; x++) {
			for(int y = 0; y < Game.board[x].length; y++) {
				if(Game.board[x][y].equals(States.BLANK.toString())) {
					if(PutStone(x, y, player, States.CHECK.toString()) > 0) {
						count++;
					}
				}
			}
		}
		if(count > 0) {
			return true;
		}
		return false;
	}

}
