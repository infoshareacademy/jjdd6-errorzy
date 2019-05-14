package com.infoshareacademy.jjdd6.errorzy.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Singleton;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Singleton
public class EmailService {

    private static final Logger LOG = LogManager.getLogger(EmailService.class);

    private static final String USERNAME = "errorzy.jjdd6@gmail.com";
    private static final String PASSWORD = "warlubie";

    public void sendMail(String receiver, String topic, String content) {

        LOG.info("Sending email to {} with topic {} and content {}", receiver, topic, content);

        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(receiver));
            message.setSubject(topic);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            LOG.info("Email sent successfully");
        } catch (Exception e) {
            LOG.error("Error while sending email", e);
        }
    }
}
