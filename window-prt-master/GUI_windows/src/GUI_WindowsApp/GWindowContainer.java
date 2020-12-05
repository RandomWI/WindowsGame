package GUI_WindowsApp;

import java.util.ArrayList;

public class GWindowContainer {

	int size;
	ArrayList<GWindow> gwindowList;

	public GWindowContainer() {gwindowList = new ArrayList<>();}

	private void setGwindowList(ArrayList<GWindow> gwindowList) {
		this.gwindowList = gwindowList;
	}


	void addGWindow(GWindow tmpB) {
		gwindowList.add(tmpB);
		size++;
	}

	public void clear(){
		gwindowList.clear();
	}

	    
		/**
		 * @return the gwindowList
		 */
		public ArrayList<GWindow> getGwindowList() {
			return gwindowList;
		}
		
		public int getSize() {
			return size;
		}

		/**
		 * @param gwindowList the gwindowList to set
		 */
		
		/**
		 * @param size the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}

		/**
		 * @return the size
		 */

}
