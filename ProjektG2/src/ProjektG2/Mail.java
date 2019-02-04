package ProjektG2;

import java.util.*;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author edith och alicia KOD HÄMTAD FRÅN
 * https://buddhimawijeweera.wordpress.com/2011/02/09/sendreceiveemailsjava/
 */
public class Mail {

    private String anvandarnamn;
    private String losenord;
    private String skickaHost;
    private int skickaPort;
    private String fran;
    private String till;
    private String amne;
    private String text;

    //UPPDATERAR KONTOUPPGIFTER
    public void sattKontoUppgifter(String anvandarnamn, String losenord) {

        //UPPDATERAR FÄLTEN MED INPAR
        this.anvandarnamn = anvandarnamn;
        this.losenord = losenord;

    }

    //SKICKAR UT MAIL TILL ANVÄNDARE FRÅN JAVAGRUPP2@GMAIL.COM
    public void skickaGmail(String fran, String till, String amne, String text) {

        //UPPDATERAR FÄLTEN MED INPAR
        this.fran = fran;
        this.till = till;
        this.amne = amne;
        this.text = text;

        //GMAIL HOST OCH GMAIL PORT 
        this.skickaHost = "smtp.gmail.com";
        this.skickaPort = 465;

        Properties props = new Properties();
        props.put("mail.smtp.host", this.skickaHost);
        props.put("mail.smtp.port", String.valueOf(this.skickaPort));
        props.put("mail.smtp.user", this.anvandarnamn);
        props.put("mail.smtp.password", this.losenord);
        props.put("mail.smtp.auth", "true");
        Session session1 = Session.getDefaultInstance(props);
        Message simpleMessage = new MimeMessage(session1); //MIME stands for Multipurpose Internet Mail Extensions        
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;

        try {
            fromAddress = new InternetAddress(this.fran);
            toAddress = new InternetAddress(this.till);

        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {

            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
            simpleMessage.setSubject(this.amne);
            simpleMessage.setText(this.text);
            Transport transport = session1.getTransport("smtps");
            transport.connect(this.skickaHost, skickaPort, this.anvandarnamn, this.losenord);
            transport.sendMessage(simpleMessage, simpleMessage.getAllRecipients());
            transport.close();

        } catch (MessagingException e) {

            e.printStackTrace();
        }

    }

    //LOGGAR IN PÅ KONTOT FÖR ATT KUNNA SKICKA MAIL
    public static void start(String mailTill, String amne, String valkommen) {

        //AVSÄNDARENS ADRESS
        String mailFran = new String("javagrupp2@gmail.com");

        //INLOGGNINGSUPPGIFTER TILL ANVSÄNDARENS MAIL
        String senderPassword = new String("adminadmin123");
        String senderUserName = new String("javagrupp2");

        //SKAPAR ETT OBJEKT AV EN GMAILCLIENT
        Mail newGmailClient = new Mail();
        //SÄTTER KONTOUPPGIFTER
        newGmailClient.sattKontoUppgifter(senderUserName, senderPassword);
        //SKICKAR GMAIL MED METODEN SKICKAGMAIL:S INFO
        newGmailClient.skickaGmail(mailFran, mailTill, amne, valkommen);

    }

}
