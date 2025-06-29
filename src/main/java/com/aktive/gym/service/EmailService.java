package com.aktive.gym.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Async
    public void sendMail(String to, String subject, Map<String, Object> params, String fileNameWithoutExtension) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        Context context = new Context();
        context.setVariables(params);

        String htmlContent = templateEngine.process(fileNameWithoutExtension, context);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        ClassPathResource bigLogo = new ClassPathResource("images/bigLogo.png");
        ClassPathResource smallLogo = new ClassPathResource("images/smallLogo.png");

        helper.addInline("bigLogo", bigLogo);
        helper.addInline("smallLogo", smallLogo);

        helper.setFrom("AktiveGym1@gmail.com");
        mailSender.send(message);
    }

}
