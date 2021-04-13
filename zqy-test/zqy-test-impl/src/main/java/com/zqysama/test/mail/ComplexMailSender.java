package com.zqysama.test.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * 复杂邮件（带附件的邮件）发送器
 *
 * @author yyc
 */
public class ComplexMailSender {

    private static final Log log = LogFactory.getLog(ComplexMailSender.class);

    public boolean sendHtmlMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress(), mailInfo.getFromName());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] to = InternetAddress.parse(mailInfo.getToAddresseseAsStr());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipients(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(MimeUtility.encodeText(new String(mailInfo.getSubject().getBytes(), "gbk"), "gbk", "B"));
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 报文正文(html)
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=gbk");
            mainPart.addBodyPart(html);
            // 附件
            BodyPart file;
            FileDataSource fds;
            ArrayList<String> attachFileNames = mailInfo.getAttachFileNames();
            // BASE64Encoder enc = new BASE64Encoder();
            // 用以解决附件中文名乱码问题
            for (String attachFileName : attachFileNames) {
                fds = new FileDataSource(attachFileName);
                file = new MimeBodyPart();
                file.setDataHandler(new DataHandler(fds));
                // file.setFileName("=?GBK?B?" +
                // enc.encode(fds.getName().getBytes()) + "?=");
                file.setFileName(MimeUtility.encodeText(new String(fds.getName().getBytes(), "gbk"), "gbk", "B"));
                mainPart.addBodyPart(file);
            }
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            log.error("[ComplexMailSender] MessagingException:" + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception e) {
            log.error("[ComplexMailSender] Exception e:" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
