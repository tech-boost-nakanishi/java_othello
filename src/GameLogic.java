import java.util.Random;

public class GameLogic {
	
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
		
		//上方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dy--;
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
		
		//下方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dy++;
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
		
		//右方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx++;
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
		
		//左方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx--;
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
		
		//左斜め上方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx--;
			dy--;
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
		
		//左斜め下方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx--;
			dy++;
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
		
		//右斜め上方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx++;
			dy--;
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
		
		//右斜め下方向
		dx = x;
		dy = y;
		index = 0;
		flipstones = new int[64][];
		while(true) {
			dx++;
			dy++;
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
		return count;
	}
	
	public static void ComputerLogic() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		if(!CanPutStone(States.COMPUTER.toString())) {
			if(Game.isSkipped) {
				//両方置けないのでゲーム終了
				Game.setFinished(true);
				Game.playerState = States.BLANK.toString();
			}
			else {
				Game.isSkipped = true;
				Game.playerState = States.USER.toString();
			}
			return;
		}
		
		int[][] blank = new int[64][];
		int index = 0;
		for(int x = 0; x < Game.board.length; x++) {
			for(int y = 0; y < Game.board[x].length; y++) {
				if(Game.board[x][y].equals(States.BLANK.toString())) {
					if(PutStone(x, y, States.COMPUTER.toString(), States.CHECK.toString()) > 0) {
						blank[index] = new int[] {x, y};
						index++;
					}
				}
			}
		}
		
		Game.isSkipped = false;
		Random rand = new Random();
		int r;
		while(true) {
			r = rand.nextInt(blank.length);
			if(blank[r] == null) {
				continue;
			}
			else {
				PutStone(blank[r][0], blank[r][1], States.COMPUTER.toString(), States.CHANGE.toString());
				Game.playerState = States.USER.toString();
				break;
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
				if(PutStone(x, y, player, States.CHECK.toString()) > 0) {
					count++;
				}
			}
		}
		if(count > 0) {
			return true;
		}
		return false;
	}

}
