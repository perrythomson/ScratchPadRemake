package toolbox;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by perrythomson on 8/17/16.
 */
public class SendMail {
    static private Properties mailServerProperties;
    static private Session getMailSession;
    static private MimeMessage generateMailMessage;
    static private String emailAddressTo = "<----- Your GMAIL ADDRESS ----->";
    static private String emailAddressFrom = "<----- Your GMAIL ADDRESS ----->";
    static private String emailSubject = "Sending Email in Java";
    static private String emailBody = "Test email using JavaMail. " + "<br><br> Best, <br>Future Software Engineer";

    public static void main(String args[]) throws AddressException, MessagingException {
        generateAndSendEmail();
        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully to "+emailAddressTo+". Check your email..");
    }

    public static void generateAndSendEmail() throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.setFrom(new InternetAddress(emailAddressFrom));
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddressTo));
        generateMailMessage.setSubject(emailSubject);
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "<----- Your GMAIL ADDRESS ----->", "<----- Your GMAIL PASSWORD ----->");
//        transport.connect("smtp.gmail.com", "<----- Your GMAIL ADDRESS ----->", "<----- Your GMAIL PASSWORD ----->");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

}
