package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService st1 = ac.getBean(StatefulService.class);
        StatefulService st2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원 주문(stateful)
        st1.order("userA" ,10000);

        // ThreadA : A사용자가 10000원 주문(stateless)
        int userAPrice = st1.order("userA",10000);

        // ThreadB : B사용자가 20000원 주문(stateful)
        st2.order("userB" ,20000);

        // ThreadB : B사용자가 10000원 주문(stateless)
        int userBPrice = st2.order("userB", 20000);

        // ThreadA : A사용자가 주문 금액 조회 -> 중간에 B가 20000원으로 지정하여 20000이 결과로 나온다.
   //     int price = st1.getPrice();
        System.out.println("price = " + userAPrice);

 //       assertThat(st1.getPrice()).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }


}