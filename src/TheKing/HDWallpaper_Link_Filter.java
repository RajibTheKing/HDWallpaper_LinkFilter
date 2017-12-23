/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheKing;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author rajib
 */
public class HDWallpaper_Link_Filter extends JFrame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        HDWallpaper_Link_Filter hdWallper_filter = new HDWallpaper_Link_Filter();
        hdWallper_filter.AskUserFordata();
        
        
        
    }
    
    
    private void AskUserFordata() 
    {
       
        Vector<String> str = new Vector<String>();
        Vector<String> filtered = new Vector<String>();
        HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.requestFocus();
        textArea.requestFocusInWindow();
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JOptionPane.showMessageDialog(this, scrollPane,"Paste Info", JOptionPane.PLAIN_MESSAGE);
        String info = textArea.getText();
        if(info.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "User input is not found");
        }
        else
        {
            String linkList[] = info.split("\n");
            for(String value: linkList)
            {
                str.add(value);
                
            }   
            Collections.sort(str);
            
            for(String s: str)
            {
                System.out.println("Sorted --->>> : " + s);
                String commonName = getCommonName(s);
                
                if(mp.get(commonName) == null)
                {
                    mp.put(commonName, new Boolean(true));
                    filtered.add(s);
                }
                else
                {
                    filtered.removeElement(filtered.elementAt(filtered.size() - 1));
                    filtered.add(s);
                }
                
            }
            
            for(String s: filtered)
            {
                if(s.endsWith("wide.jpg"))
                {
                    //Skip
                }
                else
                {
                    System.out.println(s);
                }
            }
            
            
               
        }
    }
    
    private String getCommonName(String str)
    {
        int startIndex = -1;
        int endIndex = -1;
        for(int i=str.length()-1;i>=0; i--)
        {
            if(str.charAt(i) == '/')
            {
                startIndex = i;
            }
        }
        
        if(startIndex == -1)
        {
            return "";
        }
        
        for(int i = str.length()-1; i>=startIndex; i--)
        {
            if(str.charAt(i) == '-')
            {
                endIndex = i;
            }
        }
        
        if(endIndex == -1)
        {
            return "";
        }
        
        String commonName = "";
        for(int i=startIndex+1; i<endIndex; i++)
        {
            commonName+= str.charAt(i);
        }
        
        return commonName;
        
        
    }
    private Resolution getResolution(String str)
    {
        //not completed
        return new Resolution(0, 0);
        
    }
    
    
    
}

class Resolution
{
    public int x, y;
    
    public Resolution(int a, int b) 
    {
        this.x = a;
        this.y = b;
    }
    
}
