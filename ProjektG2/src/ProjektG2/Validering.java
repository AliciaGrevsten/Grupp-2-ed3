/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektG2;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;

/**
 *
 * @author edith
 */
public class Validering{

    //LAGRAR INFDB I VARIABEL HOGWARTS
    private static File db = new File("/DB/TESTG2.FDB");
    private static InfDB idb;

    public Validering(InfDB idb) {
        this.idb = idb;
    }

    //KOLLAR OM EN RUTA ÄR TOM
    public static boolean textFaltHarVarde(JTextField rutaAttKolla) {
        boolean resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inmatningsrutan är tom.");
            resultat = false;
        }
        return resultat;
    }   

    //ÄNDRAR SÅ ATT NAMNEN SOM SKRIVS IN SKRIVS MED FÖRSTA BOKSTAVEN STOR OCH RESTEN SMÅ
    public static String formateraNamn(String namnAttKolla) {
        String output = namnAttKolla.substring(0, 1).toUpperCase() + namnAttKolla.substring(1).toLowerCase();
        return output;
    }

    //KOLLAR SÅ ATT DET SOM SKRIVS IN ÄR EN STRING
    public static boolean vardeArString(JTextField rutaAttKolla) {
        boolean arString = false;

        if (rutaAttKolla.getText().matches("[a-zA-Z]+")) {
            arString = true;
        } else {
            JOptionPane.showMessageDialog(null, "Du får bara använda bokstäver.");
        }
        return arString;
    } 
    
    //KOLLAR SÅ ATT DET SOM SKRIVS IN ÄR EN SIFFRA ELLER FLERA SIFFROR
    public static boolean vardeArSiffra(JTextField rutaAttKolla) {
        boolean arSiffra = false;

        if (rutaAttKolla.getText().matches("[0-9]+")) {
            arSiffra = true;
        } else {
            JOptionPane.showMessageDialog(null, "Du får bara använda siffror.");
        }
        return arSiffra;
    } 
    
}
