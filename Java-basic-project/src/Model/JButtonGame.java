package Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonGame extends JButton {
	private int xCoor;
	private int yCoor;
	private boolean isHoshi = false;

	public JButtonGame(int x, int y, boolean isHoshi) {
		super("");
		this.xCoor = x;
		this.yCoor = y;
		if (isHoshi)
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button1.png")));
		else
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button.png")));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setSize(21, 21);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	public boolean isHoshi() {
		return isHoshi;
	}

	public void setHoshi(boolean isHoshi) {
		this.isHoshi = isHoshi;
		if (isHoshi)
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button1.png")));
		else
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button.png")));
	}

	public void backStep(boolean stepFlag) {
		if (isHoshi)
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button1.png")));
		else
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button.png")));
	}

	public void beClicked(boolean stepFlag) {
		if (stepFlag) {
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button3.png")));
		} else {
			this.setIcon(new ImageIcon(JButtonGame.class.getResource("/img/button2.png")));
		}
	}

}
