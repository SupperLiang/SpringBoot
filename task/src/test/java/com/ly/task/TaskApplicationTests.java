package com.ly.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void contextLoads1() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("今晚开会");
        simpleMailMessage.setText("哈哈");
        simpleMailMessage.setTo("liang.yong.max@outlook.com");
        simpleMailMessage.setFrom("863760763@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void contextLoads2() throws MessagingException {
        // 1、创建一个复杂的消息邮件
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        mimeMessageHelper.setSubject("今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>哈哈</b>", true);
        mimeMessageHelper.setTo("liang.yong.max@outlook.com");
        mimeMessageHelper.addAttachment("1.jpg", new File("C:\\Users\\Liang\\Pictures\\Saved Pictures\\head1.png"));
        mimeMessageHelper.setFrom("863760763@qq.com");

        javaMailSender.send(mimeMailMessage);
    }
}
