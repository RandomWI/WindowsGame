package GUI_WindowsApp;

import javax.swing.*;

import Server.SelectNames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileChannel;
import java.util.Vector;

import XML.XMLWriter;
import businessLogic.Converter;
import businessLogic.Table;

/**
 * A ButtonBar tartalmazza a pálya mentéséhez és visszatöltéséhez szükséges kezelőket.
 */
public class ButtonBar extends JPanel {

	protected JButton buttonLoading;
    protected JButton buttonSave;
    String fileName = "";

    private GameFrame frame;
    private Table table ;

    private JFileChooser jfc = new JFileChooser("D:");
    JComboBox JCNameList;
    private JLabel labelSize;
    private JTextField textSize;
    SelectNames doNameList =  new SelectNames();
    String actualFile = "";

    
    public ButtonBar(GameFrame frame, Table table){
        super(new GridBagLayout());

        this.frame = frame;
        this.table = table;

        setButtonBar();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAction();

                fileName = textSize.getText();

                //System.out.println(PlayGround.getTable());
                //PlayGround.getTable().write(PlayGround.getTable(),fileName);
                if(fileName != null) {
                fileName = fileName + ".xml";
                table.save(table, fileName);
                String[] nameList = doNameList.select();
                JCNameList = new JComboBox(nameList);
                int size = nameList.length;
                JCNameList.setSelectedIndex(size-1);
                }
                else {System.out.println("Kérem adjon meg egy fájl nevet!");}
            }
        });

        buttonLoading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
              try {
				table.load(actualFile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                LoadingToPlayGround();
                frame.ReLoading();
            }
        });
        
        JCNameList.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
            	JComboBox cb = (JComboBox)e.getSource();
                actualFile = (String)cb.getSelectedItem();
            }
        });
    }
    
    public void setButtonBar(){
    	buttonSave = new JButton("Mentés");
        buttonLoading = new JButton("Betöltés");
        labelSize = new JLabel("Adja meg a fájl nevét (max 10 karakter): ");
        textSize = new JTextField(10);
        String[] nameList = doNameList.select();

      //Create the combo box, select item at index 4.
      //Indices start at 0, so 4 specifies the pig.
        if(nameList.length > 0) {
      JCNameList = new JComboBox(nameList);
      int size = nameList.length;
      JCNameList.setSelectedIndex(size-1);
        }

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelSize, constraints);

        constraints.gridx = 1;
        add(textSize, constraints);
        
        constraints.gridx = 2;
        add(buttonSave, constraints);

        constraints.gridx = 3;
        add(buttonLoading, constraints);
        
        constraints.gridx = 4;
        add(JCNameList, constraints);
    }

    private void SaveAction(){
        table.clear(); // Mentés előtt törli a table tartalmát.

        for(GWindow gw : PlayGround.getGWindowsContainer()){
            table.addWindow(Converter.convertToWindow(gw));
        }
    }


    
    
    private void LoadingToPlayGround(){
        PlayGround.getGWindowsContainer().clear(); //Törli a már benne lévő tartalmat mielőtt rátöltené.

        GWindow gw;

        for(int i = 0; i < table.size(); i++){
            gw = Converter.convertToGWindow(table.getWindow(i), table.size());
            PlayGround.getGWindowsContainer().add(gw);
        }
    }


}
