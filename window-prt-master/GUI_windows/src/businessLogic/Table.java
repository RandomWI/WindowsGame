package businessLogic;

import java.awt.Color;
import java.io.StringWriter;
import java.util.Vector;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import GUI_WindowsApp.GWindow;
import XML.CreateTableClassFromXml;
import XML.StringParseToXML;
import XML.XMLParseToString;
import XML.XMLWriter;
import Server.Insert;
import Server.SelectState;

public class Table {
	int szamok = 0;
	static int pressCounter;
	public static boolean gameFinished = false;
	private int index;
	private Vector<Window> windows;
	int counter = 0;
	XMLWriter writer = new XMLWriter();
	XMLParseToString reader = new XMLParseToString();
	StringParseToXML parser = new StringParseToXML();
	CreateTableClassFromXml returner = new CreateTableClassFromXml();
	Insert sender = new Insert();
	SelectState requesting = new SelectState();

	public Table() {
		windows = new Vector<>();
	}

	public void addWindow(Window window) {
		windows.add(window);
		counter++;
	}

	public Window getWindow(int index) {
		return windows.get(index);
	}

	public void clear() {
		windows.clear();
	}

	public int size() {
		return windows.size();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void morePush(Boolean item) {
		if (item)
			szamok++;
		else {
			szamok--;
		}
		System.out.println(szamok);
		if (szamok == windows.size() * 2) {
			System.out.println("The num: " + szamok);
		}
	}

	public void save(Table container, String filename) {
		if(gameFinished==false) {
		writer.Write(container, filename);
		String actualState = reader.XmlToString(filename);
		sender.stateToDB(filename, actualState);
		}
		else {
		showMessageDialog(null, "A játék véget ért, válasszon új pályát!");
		}
	}

	public void load(String filename) throws Exception {
		String returnState = requesting.select(filename);
		System.out.println(returnState);
		Document doc = parser.loadXMLFromString(returnState);
		Table test = returner.TableCreator(doc);
		System.out.println(test.getPressCounter());
		this.windows = test.windows;
		
		System.out.println(Table.pressCounter);
	}

	public static void pressIn() {
	Table.pressCounter ++;
	System.out.println(Table.pressCounter);
		
	}

 public static void pressOut() {
	 Table.pressCounter --;
		System.out.println(Table.pressCounter);
	}

	public void endGame(Vector<GWindow> gWindows) {

		int size = gWindows.size() * 2;
		System.out.println(getPressCounter());
		if (getPressCounter() == size) {
			gameFinished = true;
			int target = 0;
			for (GWindow Window : gWindows) {

					if (Window.getButtonOne().isPressed() == true && Window.getButtonOne().isHidePressed() == true) {
						target++;
						Window.getButtonOne().setBackground(Color.GREEN);
					} else if (Window.getButtonOne().isPressed() == true
							&& Window.getButtonOne().isHidePressed() == false) {
						Window.getButtonOne().setBackground(Color.YELLOW);
					} else if (Window.getButtonOne().isPressed() == false
							&& Window.getButtonOne().isHidePressed() == true) {
						Window.getButtonOne().setBackground(Color.RED);
					}
					
					if (Window.getButtonTwo().isPressed() == true && Window.getButtonTwo().isHidePressed() == true) {
						target++;
						Window.getButtonTwo().setBackground(Color.GREEN);
					} else if (Window.getButtonTwo().isPressed() == true
							&& Window.getButtonTwo().isHidePressed() == false) {
						Window.getButtonTwo().setBackground(Color.YELLOW);
					} else if (Window.getButtonTwo().isPressed() == false
							&& Window.getButtonTwo().isHidePressed() == true) {
						Window.getButtonTwo().setBackground(Color.RED);
					}
					if (Window.getButtonThree().isPressed() == true && Window.getButtonThree().isHidePressed() == true) {
						target++;
						Window.getButtonThree().setBackground(Color.GREEN);
					} else if (Window.getButtonThree().isPressed() == true
							&& Window.getButtonThree().isHidePressed() == false) {
						Window.getButtonThree().setBackground(Color.YELLOW);
					} else if (Window.getButtonThree().isPressed() == false
							&& Window.getButtonThree().isHidePressed() == true) {
						Window.getButtonThree().setBackground(Color.RED);
					}
					
					if (Window.getButtonFour().isPressed() == true && Window.getButtonFour().isHidePressed() == true) {
						target++;
						Window.getButtonFour().setBackground(Color.GREEN);
					} else if (Window.getButtonFour().isPressed() == true
							&& Window.getButtonFour().isHidePressed() == false) {
						Window.getButtonFour().setBackground(Color.YELLOW);
					} else if (Window.getButtonFour().isPressed() == false
							&& Window.getButtonFour().isHidePressed() == true) {
						Window.getButtonFour().setBackground(Color.RED);
					}
			}
			showMessageDialog(null, target+"db találat, gratulálok!");

		}
	}

	public static void setPressCounter(int parseInt) {
		Table.pressCounter = parseInt;	
	}

	public int getPressCounter() {
		return this.pressCounter;
	}

	

	
}
