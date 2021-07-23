package com.prueba.crud.servicesimpl;

import com.prueba.crud.requests.emailBodyRequest;
import com.prueba.crud.services.emailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@Service
public class emailServiceImpl  implements emailService {
	
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private JavaMailSender sender;


    private static final Logger LOGGER = LoggerFactory.getLogger(emailServiceImpl.class);
    @Override
    public Boolean sendEmail(emailBodyRequest emailBody) {
        LOGGER.info("EmailBody: {}", emailBody.toString());
        return sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
    }

    private Boolean sendEmailTool(String textMessage, String email,String subject) {
        Boolean send = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            send = true;
            LOGGER.info("Mail enviado!", email, subject, textMessage, request.getRemoteAddr());
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail: {}", e);
        }
        return send;
    }



}
