package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    private int[] proceedTask (int[] progresses, int[] speeds){
        int [] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int day = 0;
            while(progresses[i] <100){
                progresses[i] += speeds[i];
                day++;
            }
            days[i] = day;
        }
        return days;
    }

    private ArrayList<Integer> deployOrder(int[] days){
        int complate = days[0];
        int count = 0;
        ArrayList<Integer> countBox = new ArrayList();
        for(int day : days){
            if(day <= complate){
                count ++;
            }else{
                countBox.add(count);
                count = 1;
                complate = day;
            }
        }
        countBox.add(count);
        return countBox;
    }

    private int[] arrayListToIntArray(ArrayList<Integer> countBox){
        int size = 0;
        int[] answer = new int[countBox.size()];
        for(Integer temp : countBox){
            answer[size++] = temp.intValue();
        }
        return answer;
    }
}
