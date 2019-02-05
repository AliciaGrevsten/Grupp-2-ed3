package ProjektG2;

import java.io.File;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Start {

    private static InfDB db;

    public static void main(String[] args) {

        File databas = new File("TESTG2.FDB");

        try {
            db = new InfDB(databas.getAbsolutePath());
            

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggaIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoggaIn(db).setVisible(true);
            }
        });

    }
}
