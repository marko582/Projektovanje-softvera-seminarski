/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import domen.Instruktor;
import java.sql.SQLException;



import javax.mail.*;
import ui.GlavnaAdmin;
import ui.Login;
/**
 *
 * @author Windows HD
 */
public class ProjektovanjeSoftvera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, SQLException {
        FlatMacLightLaf.setup();
        new Login().setVisible(true);


//    email.EmailSender.posaljiEmail("markomijailovic03@gmail.com","markojekralj");

//tls mesto ne radi

//      String from = "mijailovicm30@gmail.com";
//      String appPass ="vylf egur qvmz tnuk";
//      
//      String to = "markomijailovic03@gmail.com";
//      
//      String host = "smtp.gmail.com";
//
//      Properties properties = new Properties();
//      properties.put("mail.smtp.host", host);
//      properties.put("mail.smtp.port", "587");
//      properties.put("mail.smtp.auth", "true");
//      properties.put("mail.smtp.starttls.enable", "true");
//      Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, appPass);
//            }
//      });
//
//      try {
//        MimeMessage message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(from));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//        message.setSubject("This is the email subject");
//        message.setText("This is the email body");
//
//        Transport.send(message);
//        
//        System.out.println("Email sent successfully!");
//        
//      } catch (MessagingException mex) {
//        mex.printStackTrace();
//      }


//ssl radi

//    String from = "mijailovicm30@gmail.com";
//    String appPassword ="vylf egur qvmz tnuk";
//      
//    String to = "markomijailovic03@gmail.com";
//
//    String host = "smtp.gmail.com";
//    Properties properties = new Properties();
//    properties.put("mail.smtp.host", host);
//    properties.put("mail.smtp.port", "465");
//    properties.put("mail.smtp.auth", "true");
//    properties.put("mail.smtp.socketFactory.port", "465");
//    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    properties.put("mail.smtp.socketFactory.fallback", "false");
//
//    Session session = Session.getInstance(properties, new Authenticator() {
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(from, appPassword);
//        }
//    });
//
//    try {
//        MimeMessage message = new MimeMessage(session);
//
//        message.setFrom(new InternetAddress(from));
//        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//        message.setSubject("This is the SSL email subject");
//        message.setText("This email was sent using SSL with JavaMail!");
//
//        Transport.send(message);
//        System.out.println("Email sent successfully using SSL!");
//    } catch (MessagingException e) {
//        e.printStackTrace();
//    }


        
    }
    
}
