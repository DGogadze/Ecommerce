package ge.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfig {
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String enable;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(host);
        javaMailSender.setPassword(password);
        javaMailSender.setUsername(username);
        javaMailSender.setPort(port);

        Properties properties = javaMailSender.getJavaMailProperties();

        properties.setProperty("mail.smtp.auth", auth);
        properties.setProperty("mail.smtp.starttls.enable", enable);
        properties.setProperty("mail.transport.protocol",protocol);

        return javaMailSender;
    }
}