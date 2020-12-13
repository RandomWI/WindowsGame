package businessLogic;

import Abstract.BasicButtonContainer;

import java.awt.Color;
import java.util.Random;
import Abstract.Point;
import GUI_WindowsApp.GWindow;
import GUI_WindowsApp.GWindowButton;

import java.util.Vector;

public class Window implements Point, BasicButtonContainer {

	private int row;
	private int column;

	private Vector<Button> buttonContainer;

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

	// A BasicButtonContainer interfész implementálása.
	@Override
	public void setButtonContainer(int size) {
		buttonContainer = new Vector<>(size);
	}

	@Override
	public void addButton(Button button) {
		buttonContainer.add(button);
	}

	public Button getButton(int index) {
		return buttonContainer.get(index);
	}

	@Override
	public int getContainerSize() {
		return buttonContainer.size();
	}

	/**
	 * @return the buttonContainer
	 */
	public Vector<Button> getButtonContainer() {
		return buttonContainer;
	}

	/**
	 * @param buttonContainer the buttonContainer to set
	 */
	public void setButtonContainer(Vector<Button> buttonContainer) {
		this.buttonContainer = buttonContainer;
	}

	public String randomStateGenerator(String[] AvaibleLists) {
		String result = "";
		int max = AvaibleLists.length - 1;
		int min = 0;
		int range = max - min + 1;
		if (max == 0) {
			result = AvaibleLists[max];
			return result;
		} else {
			int randomNum = (int) (Math.random() * range) + min;
			result = AvaibleLists[randomNum];
		}
		return result;
	}

	public void fillButtons(GWindow item, String[] AvaibleLists) {
		int num;

		// Generalok egy random oldalt, a lehetséges variációk közül
		String returnSide = randomStateGenerator(AvaibleLists);
		buttonPusher(item, returnSide);
	}

	public void windowsHandler(Vector<GWindow> gWindows) {

		int end = (int) Math.sqrt(gWindows.size());
		int ptr = 0;

		for (int i = 0; i < end; i++) {

			for (int j = 0; j < end; j++) {
				System.out.println(ptr);
				
				if(i==0 && j==0) {
					String[] resultS = { "right","down" };
					fillButtons(gWindows.get(ptr), resultS);	
				}
				else if(i==0 && j <end-1) {
					String[] resultS = { "down" };
					fillButtons(gWindows.get(ptr), resultS);		
				}
				
				else if(i==0 && j == end-1) {
					String[] resultS = { "left","down" };
					fillButtons(gWindows.get(ptr), resultS);		
				}
				
				else if(i>0 && j==0) {
					String[] resultS = { "right" };
					fillButtons(gWindows.get(ptr), resultS);	
				}
				else if(i>0 && j==end-1) {
					String[] resultS = { "left" };
					fillButtons(gWindows.get(ptr), resultS);	
				}
				
				else if(i==end-1) {
					String[] resultS = { "up" };
					fillButtons(gWindows.get(ptr), resultS);	
				}
				else if(i>0 && i<end-1) {
					String[] resultS = { "up","left","down","right" };
					fillButtons(gWindows.get(ptr), resultS);	
				}
				ptr++;
			}

		}

	}

	// megvizsgálja az előző Window itemet és vissza adja a lehetséges következő
	// lépéseket
	/*public String[] checkerLastWindow(Boolean rightSideScope, GWindow last) {
		String[] result = null;
		if (rightSideScope) {
			if (last.getButtonTwo().isHidePressed() == true && last.getButtonFour().isHidePressed() == false) {
				result = new String[2];
				result[1] = "up";
			} else if (last.getButtonTwo().isHidePressed() == false && last.getButtonFour().isHidePressed() == true) {
				result = new String[2];
				result[1] = "down";
			} else if (last.getButtonTwo().isHidePressed() == true && last.getButtonFour().isHidePressed() == true) {
				result = new String[3];
				result[1] = "down";
				result[2] = "up";
			}
		}

		else {
			if (last.getButtonThree().isHidePressed() == true && last.getButtonFour().isHidePressed() == false) {
				result = new String[2];
				result[0] = "left";
				result[1] = "up";
			} else if (last.getButtonThree().isHidePressed() == false && last.getButtonFour().isHidePressed() == true) {
				result = new String[2];
				result[0] = "right";
				result[1] = "up";
			} else if (last.getButtonTwo().isHidePressed() == true && last.getButtonFour().isHidePressed() == true) {
				result = new String[3];
				result[0] = "left";
				result[1] = "right";
				result[2] = "up";
			}
		}

		return result;
	}*/

	public void buttonPusher(GWindow item, String avaibleSides) {

		switch (avaibleSides) {
		case "up":
			item.getButtonOne().setHidePressed(true);
			item.getButtonTwo().setHidePressed(true);
			break;
		case "right":
			item.getButtonTwo().setHidePressed(true);
			item.getButtonFour().setHidePressed(true);
			break;
		case "left":
			item.getButtonOne().setHidePressed(true);
			item.getButtonThree().setHidePressed(true);
			break;
		case "down":
			item.getButtonThree().setHidePressed(true);
			item.getButtonFour().setHidePressed(true);
			break;
		}
	}

	public String stateSetter(int num) {
		String returnState = "";
		switch (num) {
		case 0:
			returnState = "up";
			break;
		case 1:
			returnState = "right";
			break;
		case 2:
			returnState = "left";
			break;
		case 3:
			returnState = "down";
			break;
		}
		return returnState;

	}

}
