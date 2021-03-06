/**
 * Java Program SongListener
 * Program contains 1 Methods; to listen to the actions from the Project3 Panel and respond depending on what the action is.  
 * Program is designed to create a song listener for SongPanel.
 * 
 * @ Bryson Bonham
 */
import java.io.*;
import java.awt.event.*;


public class SongListener implements ActionListener
{  
    boolean isClicked = false;
    
    private SongPanel panel;
    public SongListener( SongPanel p )
    {
        panel = p;
    }
/*
 * Method defines the actions performed based upon the listener.
 */      
    public void actionPerformed( ActionEvent e )
    {     
        Object source = e.getSource();        
                
        if ( source == panel.songList )
        {
            int o = panel.songList.getSelectedIndex(); 
            panel.codeField.setText(SongPanel.codeList.get(o));
            panel.descriptionField.setText(SongPanel.descriptionList.get(o));
            panel.artistField.setText(SongPanel.artistList.get(o));
            panel.albumField.setText(SongPanel.albumList.get(o));
            panel.priceField.setText(String.valueOf(SongPanel.priceList.get(o)));            
        }
        
       if ( source == panel.addButton )
        {
            SongPanel.counters++;            
            panel.codeField.setEditable(true);
            panel.descriptionField.setEditable(true);
            panel.artistField.setEditable(true);
            panel.albumField.setEditable(true);
            panel.priceField.setEditable(true);
            panel.acceptButton.setEnabled(true);
            panel.cancelButton.setEnabled(true);
            panel.editButton.setEnabled(false);
            panel.deleteButton.setEnabled(false); 
            panel.addButton.setEnabled(false);
            isClicked = true;
       }
       
        if ( source == panel.editButton )
        {
            panel.codeField.setEditable(false);
            panel.descriptionField.setEditable(true);
            panel.artistField.setEditable(true);
            panel.albumField.setEditable(true);
            panel.priceField.setEditable(true);
            panel.acceptButton.setEnabled(true);
            panel.cancelButton.setEnabled(true);
            panel.editButton.setEnabled(false);
            panel.deleteButton.setEnabled(false); 
            panel.addButton.setEnabled(false); 
        } 
        if ( source == panel.deleteButton )
        {
            int o = panel.songList.getSelectedIndex(); 
            SongPanel.codeList.remove(o);
            SongPanel.descriptionList.remove(o);
            SongPanel.artistList.remove(o);
            SongPanel.albumList.remove(o);
            SongPanel.priceList.remove(o);
            panel.songList.removeItemAt(o);
            SongPanel.counters--;
            
            if ( o == 0 )
            {
              panel.songList.setSelectedIndex(o+1);
            }
            
            else if ( o != 0 )
            {
              panel.songList.setSelectedIndex(o-1);
            }
        }
            
        if ( source == panel.acceptButton && isClicked == true )
        {
            panel.songList.addItem(panel.descriptionField.getText());  
            int o = SongPanel.counters;          
            panel.acceptButton.setEnabled(false);
            panel.cancelButton.setEnabled(false);
            panel.editButton.setEnabled(true);
            panel.deleteButton.setEnabled(true);  
            panel.addButton.setEnabled(true); 
            panel.codeField.setEditable(false);
            panel.descriptionField.setEditable(false);
            panel.artistField.setEditable(false);
            panel.albumField.setEditable(false);
            panel.priceField.setEditable(false);               
            SongPanel.codeList.add(o, panel.codeField.getText());
            SongPanel.descriptionList.add(o, panel.descriptionField.getText());            
            SongPanel.artistList.add(o, panel.artistField.getText());
            SongPanel.albumList.add(o, panel.albumField.getText());
            SongPanel.priceList.add(o, Double.parseDouble(panel.priceField.getText())); 
            System.out.println(o);
            isClicked = false;            
        }
            
        else if ( source == panel.acceptButton && isClicked == false )
        {
            int o = panel.songList.getSelectedIndex(); 
            if ( o == 0 )
            {
                SongPanel.codeList.add(o, panel.codeField.getText());            
                SongPanel.descriptionList.add(o, panel.descriptionField.getText());               
                SongPanel.artistList.add(o, panel.artistField.getText());
                SongPanel.albumList.add(o, panel.albumField.getText());
                SongPanel.priceList.add(o, Double.parseDouble(panel.priceField.getText()));   
                SongPanel.codeList.remove(o+1);  
                SongPanel.descriptionList.remove(o+1);   
                SongPanel.artistList.remove(o+1);
                SongPanel.albumList.remove(o+1);  
                SongPanel.priceList.remove(o+1);             
                panel.songList.insertItemAt(panel.descriptionField.getText(), o+1);
                panel.songList.removeItemAt(o);
                panel.songList.setSelectedIndex(o+1);
                panel.songList.setSelectedIndex(o);             
            }
            
            else if (o != 0 )
            {
                SongPanel.codeList.add(o, panel.codeField.getText());            
                SongPanel.descriptionList.add(o, panel.descriptionField.getText());               
                SongPanel.artistList.add(o, panel.artistField.getText());
                SongPanel.albumList.add(o, panel.albumField.getText());
                SongPanel.priceList.add(o, Double.parseDouble(panel.priceField.getText()));               
                panel.songList.insertItemAt(panel.descriptionField.getText(), o+1);
                panel.songList.removeItemAt(o);
                panel.songList.setSelectedIndex(o-1);
                panel.songList.setSelectedIndex(o);  
            }
            
            panel.codeField.setEditable(false);
            panel.descriptionField.setEditable(false);
            panel.artistField.setEditable(false);
            panel.albumField.setEditable(false);
            panel.priceField.setEditable(false);             
            panel.acceptButton.setEnabled(false);
            panel.cancelButton.setEnabled(false);
            panel.editButton.setEnabled(true);
            panel.deleteButton.setEnabled(true);  
            panel.addButton.setEnabled(true); 
        }  
            
        if ( source == panel.cancelButton && isClicked == true )
        {
            SongPanel.counters--;
            panel.acceptButton.setEnabled(false);
            panel.cancelButton.setEnabled(false);  
            panel.editButton.setEnabled(true);
            panel.deleteButton.setEnabled(true);  
            panel.addButton.setEnabled(true);
            panel.codeField.setEditable(false);
            panel.descriptionField.setEditable(false);
            panel.artistField.setEditable(false);
            panel.albumField.setEditable(false);
            panel.priceField.setEditable(false);              
        }
            
        if ( source == panel.cancelButton && isClicked == false )
        {
            panel.acceptButton.setEnabled(false);
            panel.cancelButton.setEnabled(false);  
            panel.editButton.setEnabled(true);
            panel.deleteButton.setEnabled(true);  
            panel.addButton.setEnabled(true);  
            panel.codeField.setEditable(false);
            panel.descriptionField.setEditable(false);
            panel.artistField.setEditable(false);
            panel.albumField.setEditable(false);
            panel.priceField.setEditable(false);              
        }
    
    String Cods = new String();
    String Desc = new String();
    String Arts = new String();
    String Albs = new String();
    String Prc = new String(); 
    Cods = panel.codeField.getText();
    Desc = panel.descriptionField.getText();
    Arts = panel.artistField.getText();
    Albs = panel.albumField.getText();
    Prc = panel.priceField.getText();
        
        if (Cods.equals("") || Desc.equals("") || Arts.equals("") || Albs.equals("") || Prc.equals("") )
        {
          System.out.println("Please do not leave the field blank.");
        }
        
        if ( source == panel.exitButton )
        { 
            try
            {
                PrintWriter outputFile = new PrintWriter(SongDatabase.File);      
                for (int i = 0; i < panel.songList.getItemCount(); i++)
                {
                    outputFile.write(SongPanel.codeList.get(i));
                    outputFile.write("\r\n");
                    outputFile.write(panel.songList.getItemAt(i));
                    outputFile.write("\r\n");
                    outputFile.write(SongPanel.descriptionList.get(i));
                    outputFile.write("\r\n");
                    outputFile.write(SongPanel.artistList.get(i));
                    outputFile.write("\r\n");
                    outputFile.write(SongPanel.albumList.get(i));
                    outputFile.write("\r\n");
                    outputFile.write(String.valueOf(SongPanel.priceList.get(i)));
                    outputFile.write("\r\n");          
                } 
            outputFile.close();
            }
            catch (IOException except)
            {
                System.out.println("I/O Exception: " + except.getMessage());
                return;
            }     
        System.exit(0);
        }
    }
}