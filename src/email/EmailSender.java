/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Windows HD
 */
public class EmailSender {
    public static void posaljiEmail(String email,String generisanaLozinka){
    
    String from = "mijailovicm30@gmail.com";
    String appPassword ="vylf egur qvmz tnuk";

    String host = "smtp.gmail.com";
    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.socketFactory.fallback", "false");

    Session session = Session.getInstance(properties, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, appPassword);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Uspesna registracija");
        message.setText("Ovo je vasa trenutna sifra: "+generisanaLozinka+"\n Imate rok od 3 dana da je promenite.");

        Transport.send(message);
        System.out.println("Email uspesno poslat!");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
    }
}
