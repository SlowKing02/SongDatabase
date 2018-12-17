/**
 * Java Program SongDatabase
 * Program contains 3 Methods, to create the frame and fill with the panel and request the user to input a file location.
 * Program is designed to create a frame and execute the SongPanel.
 * 
 * @ Bryson Bonham
 */

import javax.swing.*;
import java.util.Scanner;
public class SongDatabase extends JFrame

{
/*
 * Method defines the panel and sets the size.
 */  
    public SongDatabase()
    {
        setTitle( "SongDatabase" );
        setSize( 550, 300 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JPanel panel = new SongPanel();
        this.add( panel );
    }
    public static String File = fileName();     
/*
 * Method exectutes the program through the database.
 */
    public static void main( String [] args )
    {        
        JFrame frame = new SongDatabase();
        frame.setVisible( true );
    }
/*
 * Method requests file location from user and returns it as a string.
 */    
    public static String fileName() 
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the location (Including file type e.g. .txt) of the file:");
        String File = new String();
        File = scan.next(); 
        return File;
    }
}
       