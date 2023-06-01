package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.client.MailSendClient;
import sample.cafekiosk.spring.domain.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

//    @Spy
    @Mock
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {

        // given
        // stubbing : Spy 사용시 사용 불가 -> 실제 객체에 mocking 하기때문에 테스트 실패
//        Mockito.when(mailSendClient.sendEmail(any(String.class), any(String.class), any(String.class), any(String.class)))
//                .thenReturn(true);
        BDDMockito.given(
                mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
                .willReturn(true);


        // @Spy -> log.info 로그가찍힘
//        doReturn(true)
//                .when(mailSendClient)
//                .sendEmail(
//                        any(String.class),
//                        any(String.class),
//                        any(String.class),
//                        any(String.class)
//                );

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }


}