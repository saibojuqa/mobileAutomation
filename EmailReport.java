package com.peoplematter.modulesList.modules.pages;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Created by sai.boju on 3/23/17.
 */
public class EmailReport {

    /* Sending email reports */

    public static void sendingMail(String sMailPath,String aAttachmentName,int aPass,int aFail,int aTotal) throws Exception

    {

        String[] to={"saibojuqa@gmail.com"};

        String[] cc={};
        String[] bcc={};

        //This is for google
        sendMail("saibojuqa@gmail.com",
                "Masters@1",
                "smtp.gmail.com",
                "465",
                "true",
                "true",
                true,
                "javax.net.ssl.SSLSocketFactory",
                "false",
                to,
                cc,
                bcc,
                "Automation test Reports.\n\n",
                "Please find the automation reports in below attached html file for smoke testcases.\n\n" +
                        "Total Test Cases Executed-"+ aTotal + "\n\nNo of Testcases Pass-"+aPass +"\n\nNo of Testcases Fail-"+aFail +"\n\n",
                sMailPath,
                aAttachmentName
        );
    }

    public  static boolean sendMail(final String userName,
                                    final String passWord,
                                    String host,
                                    String port,
                                    String starttls,
                                    String auth,
                                    boolean debug,
                                    String socketFactoryClass,
                                    String fallback,
                                    String[] to,
                                    String[] cc,
                                    String[] bcc,
                                    String subject,
                                    String text,
                                    String attachmentPath,
                                    String attachmentName){

        Properties props = new Properties();
        //Properties props=System.getProperties();
        props.put("mail.smtp.user", userName);
        props.put("mail.smtp.host", host);
        if(!"".equals(port))
            props.put("mail.smtp.port", port);
        if(!"".equals(starttls))
            props.put("mail.smtp.starttls.enable",starttls);
        props.put("mail.smtp.auth", auth);
        // props.put("mail.smtps.auth", "true");
        if(debug){
            props.put("mail.smtp.debug", "true");
        }else{
            props.put("mail.smtp.debug", "false");
        }
        if(!"".equals(port))
            props.put("mail.smtp.socketFactory.port", port);
        if(!"".equals(socketFactoryClass))
            props.put("mail.smtp.socketFactory.class",socketFactoryClass);
        if(!"".equals(fallback))
            props.put("mail.smtp.socketFactory.fallback", fallback);
        try
        {
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, passWord);
                }
            });
            session.setDebug(debug);
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(subject);
            //attachment start
            // create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(text);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source =
                    new FileDataSource(attachmentPath);
            messageBodyPart.setDataHandler(
                    new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
            multipart.addBodyPart(messageBodyPart);

            // attachment ends
            // Put parts in message
            msg.setContent(multipart);
            //
            msg.setFrom(new InternetAddress("saibojuqa@gmail.com"));
            for(int i=0;i<to.length;i++){
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
            }
            for(int i=0;i<cc.length;i++){
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
            }
            for(int i=0;i<bcc.length;i++){
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
            }
            msg.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userName, passWord);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return true;
        }
        catch (Exception mex)
        {
            mex.printStackTrace();
            return false;
        }
    }
}
