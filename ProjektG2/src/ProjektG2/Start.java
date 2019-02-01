/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektG2;

import java.io.File;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Start {
    
    private static File db = new File("/DB/TESTG2.FDB");
    private static InfDB idb;
    
    public static void main(String [] args)
    {       
        try
        {
            
        idb = new InfDB (db.getAbsolutePath());
        System.out.println(db.getAbsolutePath());
        
        new TestG2(idb).setVisible(true);
        
        }
        catch(InfException e){
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Error "+ e);
        }
    }
    
    public static InfDB getDatabase()
    {
    return idb;
}}
