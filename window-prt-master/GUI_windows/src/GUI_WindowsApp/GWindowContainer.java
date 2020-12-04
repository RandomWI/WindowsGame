package GUI_WindowsApp;

import java.util.ArrayList;

public class GWindowContainer {
	

	private void setGwindowList(ArrayList<GWindow> gwindowList) {
		this.gwindowList = gwindowList;
	}

	ArrayList<GWindow> gwindowList;
	   public GWindowContainer() {gwindowList = new ArrayList<>();}

	    void addGWindow(GWindow tmpB) {
	        gwindowList.add(tmpB);
	    }

	    
		/**
		 * @return the gwindowList
		 */
		public ArrayList<GWindow> getGwindowList() {
			return gwindowList;
		}

		/**
		 * @param gwindowList the gwindowList to set
		 */
}
