package com.zqysama.test.mail;

import com.zqysama.common.util.FileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Properties;


/**
 * 发送邮件需要使用的基本信息
 *
 * @author 周泉宇
 */
public class MailSenderInfo {

    private static final Log log = LogFactory.getLog(MailSenderInfo.class);

    // 发送邮件的服务器的IP和端口
    private String mailServerHost;
    private String mailServerPort = "25";
    // 邮件发送者的地址
    private String fromAddress;
    private String fromName = "tauro";
    // 邮件接收者的地址s
    private ArrayList<String> toAddresses = new ArrayList<String>();
    // 登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    // 是否需要身份验证
    private boolean validate = false;
    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;
    // 邮件附件的文件名
    private ArrayList<String> attachFileNames = new ArrayList<String>();

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        // p.put("mail.debug", "true");
        return p;
    }

    /**
     * 添加一个收件人/地址
     *
     * @param toAddress
     * @return
     */
    public boolean addToAddress(String toAddress) {
        toAddresses.add(toAddress);
        return true;
    }

    /**
     * 添加一个附件
     *
     * @param attachFileName 文件全路径
     */
    public boolean addAttachFile(String attachFileName) {
        if (!FileUtil.checkFileExist(attachFileName)) {
            log.error(attachFileName + "文件不存在");
            return false;
        }
        attachFileNames.add(attachFileName);
        return true;
    }

    /**
     * 获取收件人地址：xxx,xxx,...,xxx
     *
     * @return
     */
    public String getToAddresseseAsStr() {
        if (toAddresses.size() == 0) {
            return "";
        }
        StringBuffer toAddresseseAsStr = new StringBuffer();
        for (String toAddresse : toAddresses) {
            toAddresseseAsStr.append("," + toAddresse);
        }
        return toAddresseseAsStr.toString().substring(1);
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public ArrayList<String> getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(ArrayList<String> fileNames) {
        this.attachFileNames = fileNames;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String textContent) {
        this.content = textContent;
    }

    public ArrayList<String> getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(ArrayList<String> toAddresses) {
        this.toAddresses = toAddresses;
    }
}
