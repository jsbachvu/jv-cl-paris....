package Control;

import java.util.ArrayList;

import Model.Player;
import Model.Step;
import View.GobanView;
import View.Menu;

public class Control {

	public final static int NONE_RULE = 0;
	public final static int ABSOLUTE_RULE = 1;
	public final static int BYO_YONI_RULE = 2;

	public final static int BLACK_PLAYER = 0;
	public final static int WHITE_PLAYER = 1;
	public final static int NONE_PLAYER = -1;

	public final static int SIZE_TYPE_9x9 = 0;
	public final static int SIZE_TYPE_13x13 = 1;
	public final static int SIZE_TYPE_19x19 = 2;

	private Menu menuView;
	private GobanView gobanView;

	private boolean stepFlag = false;
	private int[][] map;
	private ArrayList<Step> steps;
	private int hoshi[][] = new int[5][2];

	public Control() {
		menuView = new Menu(this);
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	public int[][] getHoshi() {
		return hoshi;
	}

	public void setHoshi(int[][] hoshi) {
		this.hoshi = hoshi;
	}

	public Menu getMenuView() {
		return menuView;
	}

	public void setMenuView(Menu menuView) {
		this.menuView = menuView;
	}

	public GobanView getGobanView() {
		return gobanView;
	}

	public void setGobanView(GobanView gobanView) {
		this.gobanView = gobanView;
	}

	public boolean getStepFlag() {
		return stepFlag;
	}

	public void setStepFlag(boolean stepFlag) {
		this.stepFlag = stepFlag;
	}

	public void invertStepFlag() {
		this.stepFlag = !stepFlag;
	}

	public void start() {
		menuView.setVisible(true);
	}

	public void playGame(Player blackPlayer, Player whitePlayer, int timeRule, int size, Step[] handicapSteps) {
		menuView.setVisible(false);
		switch (size) {
		case Control.SIZE_TYPE_13x13:
			map = new int[13][13];

			// TODO: set Hoshi positions
			break;
		case Control.SIZE_TYPE_19x19:
			map = new int[19][19];
			// TODO: set Hoshi positions
			break;
		case Control.SIZE_TYPE_9x9:
			map = new int[9][9];
			// TODO: set Hoshi positions
			hoshi[0][0] = 2;
			hoshi[0][1] = 2;

			hoshi[1][0] = 6;
			hoshi[1][1] = 2;

			// the 3 remain ....
			break;
		}

		gobanView = new GobanView(blackPlayer, whitePlayer, timeRule, size, handicapSteps, this);
		gobanView.setVisible(true);
	}
}
