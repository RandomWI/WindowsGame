package GUI_WindowsApp;

import Abstract.Point;
import Abstract.Pressable;
import businessLogic.Table;

import javax.swing.*;
import java.awt.*;

public class GWindowButton extends JButton implements Point, Pressable {

	private int row;
	private int column;

	private boolean pressed = false;
	private boolean hidePressed = false;

	public GWindowButton(int buttonSize) {
		super();

		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(buttonSize, buttonSize));
	}

	// A Pressable interfész implementálása.
	@Override
	public boolean isPressed() {
		return pressed;
	}

	@Override
	public void setPressed(boolean press) {
		if (Table.gameFinished == false) {

			this.pressed = press;

			if (press)
				setBackground(Color.YELLOW);
			else
				setBackground(Color.WHITE);
		}
	}

	@Override
	public void buttonPress() {
		if (Table.gameFinished == false) {

		this.pressed = !pressed;
		}
	}

	// A Point interfész implementálása.
	@Override
	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	public void setCoordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean isHidePressed() {
		return hidePressed;
	}

	public void setHidePressed(boolean hidePressed) {
		this.hidePressed = hidePressed;

	}

}
