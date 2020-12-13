import java.util.Random;

public class GameLogic {
	
	public static boolean CanPutStone(int x, int y, String player, String mode) {
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
			Random rand = new Random();
			int r = rand.nextInt(blank.length);
			Game.board[blank[r][0]][blank[r][1]] = States.COMPUTER.toString();
			Game.playerState = States.USER.toString();
		}
	}

}
