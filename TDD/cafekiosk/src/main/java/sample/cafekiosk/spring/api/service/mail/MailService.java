package sample.cafekiosk.spring.api.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.client.MailSendClient;
import sample.cafekiosk.spring.domain.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.mail.MailSendHistoryRepository;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;

    public boolean sendMail(String formEmail, String toEmail, String subject, String content) {
        boolean result = mailSendClient.sendEmail(formEmail, toEmail, subject, content);

        if(result){
            mailSendHistoryRepository.save(MailSendHistory.builder()
                            .fromEmail(formEmail)
                            .toEmail(toEmail)
                            .subject(subject)
                            .content(content)
                    .build());

            mailSendClient.a();
            mailSendClient.b();
            mailSendClient.c();
            return true;
        }
        return false;
    }
}
