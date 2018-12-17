/**
 * Java Program SongPanel
 * Program contains 2 Methods, 6 LinkedLists and several buttons.
 * Program is designed to create a Panel to allow the creation of a song database.
 * 
 * @ Bryson Bonham
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class SongPanel extends JPanel
{
    public JLabel songLabel, codeLabel, descriptionLabel, artistLabel, albumLabel, priceLabel;
    public JTextField codeField, descriptionField, artistField, albumField, priceField;
    public JButton addButton, editButton, deleteButton, acceptButton, cancelButton, exitButton;
    public JComboBox<String> songList;
    public static String[] readFile = readFiles(); 
    public static int counters = ((readFile.length/6)-1);

    public static LinkedList<String> songListTitles  = new LinkedList<String>();
    {
        for (int l = 1; l < readFile.length; l=l+6)
        {
            songListTitles.add( readFile[l] );
        }
    }
    public static LinkedList<String> codeList  = new LinkedList<String>();
    {
        for (int l = 0; l < readFile.length; l=l+6)
        {
            codeList.add( readFile[l] );
        }
    }
    public static LinkedList<String> descriptionList  = new LinkedList<String>();
    {
        for (int l = 2; l < readFile.length; l=l+6)
        {
            descriptionList.add( readFile[l] );
        }
    }
    public static LinkedList<String> artistList  = new LinkedList<String>();
    {
        for (int l = 3; l < readFile.length; l=l+6)
        {
            artistList.add( readFile[l] );
        }
    }
    public static LinkedList<String> albumList  = new LinkedList<String>();
    {
        for (int l = 4; l < readFile.length; l=l+6)
        {
            albumList.add( readFile[l] );
        }
    }
    public static LinkedList<Double> priceList  = new LinkedList<Double>();
    {
        for (int l = 5; l < readFile.length; l=l+6)
        {       
            priceList.add( Double.parseDouble(readFile[l]) );
        }
    }
/*
 * Method defines the SongPanel, adding the buttons and setting up the listener.
 */       
    public SongPanel()
    {
        ActionListener listener = new SongListener(this);
        
        String[] readFile = readFiles();        
        String[] songTitles = new String[readFile.length/6];
 
        for (int q = 0; q < readFile.length/6; q++)  
        {
            songTitles[q] = songListTitles.get(q);
        }        
        
        JComboBox<String> combos = new JComboBox<String>();   
        songList = new JComboBox<String>(songTitles);
        combos.add( songList );
        
        JPanel buttons = new JPanel();
        addButton = new JButton("   Add   " );
        editButton = new JButton("   Edit   " );
        deleteButton = new JButton("  Delete  " );
        acceptButton = new JButton("  Accept  " );
        cancelButton = new JButton("  Cancel  " );
        exitButton = new JButton("   Exit   " );
        buttons.add( addButton );
        buttons.add( editButton );
        buttons.add( deleteButton );
        buttons.add( acceptButton );
        buttons.add( cancelButton );
        buttons.add( exitButton );
        acceptButton.setEnabled(false);
        cancelButton.setEnabled(false);
                
        JPanel songSelect = new JPanel();
        songLabel = new JLabel( "Select Song: " );
        songSelect.add( songLabel );
       
        JPanel itemCode = new JPanel();
        codeLabel = new JLabel( "  Item Code:     " );
        codeField = new JTextField( 30 );
        codeField.setEditable( false );
        itemCode.add( codeLabel );
        itemCode.add( codeField );           

        JPanel description = new JPanel();
        descriptionLabel = new JLabel( "  Description:   " );
        descriptionField = new JTextField( 30 );
        descriptionField.setEditable( false );
        description.add( descriptionLabel );
        description.add( descriptionField );     
        
        JPanel artist = new JPanel();
        artistLabel = new JLabel( "  Artist:        " );
        artistField = new JTextField( 30 );
        artistField.setEditable( false );
        artist.add( artistLabel );
        artist.add( artistField );              

        JPanel album = new JPanel();
        albumLabel = new JLabel( "  Album:         " );
        albumField = new JTextField( 30 );
        albumField.setEditable( false );
        album.add( albumLabel );
        album.add( albumField );    

        JPanel price = new JPanel();
        priceLabel = new JLabel( "  Price:         " );
        priceField = new JTextField( 30 );
        priceField.setEditable( false );
        price.add( priceLabel );
        price.add( priceField );    
        
        codeField.setText(readFile[0]);
        descriptionField.setText(readFile[2]);
        artistField.setText(readFile[3]); 
        albumField.setText(readFile[4]);
        priceField.setText(readFile[5]);  
        
        addButton.addActionListener(listener);
        editButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        acceptButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        exitButton.addActionListener(listener);
               
        codeField.addActionListener(listener);
        descriptionField.addActionListener(listener);
        artistField.addActionListener(listener);
        albumField.addActionListener(listener);
        priceField.addActionListener(listener);            
              
        songList.addActionListener(listener);
             
        this.setLayout( new FlowLayout() );
        songSelect.setLayout( new FlowLayout( FlowLayout.LEFT, 50, 12) );        
        songList.setLayout( new FlowLayout( FlowLayout.LEFT) );

        this.add( songSelect );
        this.add( songList );

        itemCode.setLayout( new FlowLayout ( FlowLayout.LEFT, 50, 5 ) );      
        this.add( itemCode ); 
        description.setLayout( new FlowLayout ( FlowLayout.LEFT, 50, 5 ) );      
        this.add( description );         
        artist.setLayout( new FlowLayout ( FlowLayout.LEFT, 50, 5 ) );  
        this.add( artist );
        album.setLayout( new FlowLayout ( FlowLayout.LEFT, 50, 5 ) );  
        this.add( album );        
        price.setLayout( new FlowLayout ( FlowLayout.LEFT, 50, 5 ) );  
        this.add( price );       
        this.add( buttons );          
    }
/*
 * Method reads the file and returns an array of the items from the file, if file is not found a file is created with name from SongDatabase and filled with two blank items.
 */          
    public static String[] readFiles()
    {
        try
        {
            File f = new File(SongDatabase.File);
            Scanner s = new Scanner(f);
            int l = 0;
            while (s.hasNextLine())
            {
                l++;
                s.nextLine();
            }
            String[] arr = new String[l];
            Scanner s1 = new Scanner(f);
            
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = s1.nextLine(); 
            }
            return arr;
        }
        catch(Exception e)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("File not found, would you like to create a new file?");
            System.out.println("1 for yes, 2 for no");
            int l = Integer.parseInt(scan.nextLine());
            
            if (l == 2)
            {  
                System.exit(0);
            }
            
            else if (l != 2) 
            
            try
            {
                PrintWriter outputFile = new PrintWriter(SongDatabase.File);
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("Blank ");
                outputFile.write("\r\n");            
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("Blank ");
                outputFile.write("\r\n"); 
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("1.00");
                outputFile.write("\r\n");  
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("Blank ");
                outputFile.write("\r\n");            
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("Blank ");
                outputFile.write("\r\n"); 
                outputFile.write("Blank ");
                outputFile.write("\r\n");
                outputFile.write("1.00");
                outputFile.write("\r\n");              
                outputFile.close();
                File f2 = new File(SongDatabase.File);
                Scanner s2 = new Scanner(f2);            
                int q = 0;
                
                while (s2.hasNextLine())
                {
                    q++;
                    s2.nextLine();
                }
                String[] arr2 = new String[q];
                Scanner s22 = new Scanner(f2);
            
                for (int i = 0; i < arr2.length; i++)
                {
                    arr2[i] = s22.nextLine(); 
                }
                return arr2;
            }
            
            catch (Exception m)
            {
                return null;
            }
        return null;
        }
    }
}