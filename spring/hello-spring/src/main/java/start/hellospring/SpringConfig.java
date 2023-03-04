package start.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.hellospring.repository.JdbcTemplateMemberRepository;
import start.hellospring.repository.JpaMemberRepository;
import start.hellospring.repository.MemberRepository;
import start.hellospring.repository.MemoryMemberRepository;
import start.hellospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//}

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }



    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
