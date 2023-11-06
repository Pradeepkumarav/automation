package mail;
import javax.mail.BodyPart;
import javax.mail.Session; 
import javax.mail.Transport;

import java.io.IOException;
import java.util.Properties; import javax.activation.DataHandler; import javax.mail.Message; import javax.mail.MessagingException; import javax.mail.Multipart; import javax.mail.PasswordAuthentication; import javax.activation.DataSource; import javax.activation.FileDataSource;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.bouncycastle.crypto.examples.DESExample;

import java.io.*;  


public class EmailReport{

	
public static String[] ToAdresses = { "pradeep7725@gmail.com"
             };

public void main ()
            throws IOException, AddressException, MessagingException {

    Properties sysmProp = System.getProperties();
    sysmProp.put("mail.smtp.starttls.enable", "true");
    sysmProp.put("mail.smtp.host", "smtp.gmail.com");
    sysmProp.put("mail.smtp.user", "pradeep7725@gmail.com");
    sysmProp.put("mail.smtp.password","hrdgfegixwsmsfyl");
    sysmProp.put("mail.smtp.port", "587");
    sysmProp.put("mail.smtp.auth", "true");

    /*Create session object*/
    Session session = Session.getInstance(sysmProp, null);


    	  
    
    /*Create MimeMessage object and add recipients */
    MimeMessage message = new MimeMessage(session);

    /* Setting the string value type as address */
            InternetAddress[] recipients = new InternetAddress[ToAdresses.length];

    for (int i = 0; i < ToAdresses.length; i++) {
            recipients[i] = new InternetAddress(ToAdresses[i]);
        }

    /* Adding the recipients to the message object. */
    for (int j = 0; j < ToAdresses.length; j++) {
            message.addRecipient(Message.RecipientType.TO, recipients[j]);
        }

     message.setSubject("Test report for mercury tours");
     BodyPart messageBodyPart = new MimeBodyPart(); 
     messageBodyPart.setText("Hii pradeep, I have executed regression suite please find report");

    /* Adding the attachment to the mail. */
    File file = new File(System.getProperty("user.dir") +"\\mercurytoursReport.html" );
    BodyPart messageBodyPart_2 = new MimeBodyPart();
    DataSource source = new FileDataSource(file.getAbsolutePath());
    messageBodyPart_2.setDataHandler(new DataHandler(source));
    messageBodyPart_2.setFileName("mercurytoursReport.html");

    /* Clubbing the subject of mail. */
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    multipart.addBodyPart(messageBodyPart_2);
    message.setContent(multipart);

    /* Triggers mail. */
    Transport.send(message,"pradeep7725@gmail.com","hrdgfegixwsmsfyl");

  }
}
