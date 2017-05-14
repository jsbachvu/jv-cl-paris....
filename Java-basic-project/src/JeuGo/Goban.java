package JeuGo;

public class Goban {
	private int playerFlag;
	private int map[][];
	private int timeRule;
	private Step steps[];
	private int hoshi[][];
	private Player players;

	public final static int NONE = 0;
	public final static int ABSOLUTE_RULE = 1;
	public final static int BYO_YONI_RULE = 2;

	public final static int BLACK_PLAYER = 1;
	public final static int WHITE_PLAYER = 2;

	public final static int SIZE_TYPE_9x9 = 0;
	public final static int SIZE_TYPE_13x13 = 1;
	public final static int SIZE_TYPE_19x19 = 2;

	public Goban(int sizeType, int timeRule, Player players) {
		switch (sizeType) {
		case SIZE_TYPE_9x9:
			map = new int[9][9];
			hoshi = new int[5][2];

			hoshi[0][0] = 2;
			hoshi[0][1] = 2;

			hoshi[1][0] = 6;
			hoshi[1][1] = 2;
			//

			break;
		case SIZE_TYPE_13x13:
			map = new int[13][13];
			hoshi = new int[5][2];
			//
			break;
		case SIZE_TYPE_19x19:
			map = new int[19][19];
			hoshi = new int[9][2];

			//
			break;
		}
		this.playerFlag = BLACK_PLAYER;
		this.timeRule = timeRule;
		this.players = players;
	}

	public int getPlayerFlag() {
		return playerFlag;
	}

	public void setPlayerFlag(int playerFlag) {
		this.playerFlag = playerFlag;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getTimeRule() {
		return timeRule;
	}

	public void setTimeRule(int timeRule) {
		this.timeRule = timeRule;
	}

	public Step[] getSteps() {
		return steps;
	}

	public void setSteps(Step[] steps) {
		this.steps = steps;
	}

	public Player getPlayers() {
		return players;
	}

	public void setPlayers(Player players) {
		this.players = players;
	}

	public int[][] getHoshi() {
		return hoshi;
	}

	public void setHoshi(int[][] hoshi) {
		this.hoshi = hoshi;
	}
	
	

}
