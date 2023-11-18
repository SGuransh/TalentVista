package use_case.HireApplicant;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class AutoMailSend{

    String d_email = "ayush22ar@gmail.com", d_password = "qwpq myrl axrm woeh", d_host = "smtp.gmail.com", d_port = "465", m_to = "sguransh24@gmail.com", m_subject = "Testing", m_text = "Hey, this is the testing email.";

    public AutoMailSend () {}
    public AutoMailSend(String mailto) {
        this.m_to = mailto;
    }

    public void send() {
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);

        try {
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AutoMailSend email = new AutoMailSend();
        email.send();
    }

    public class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}