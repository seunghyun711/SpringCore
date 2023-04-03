package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // AppConfig클래스는 수동으로 등록한 빈이기 때문에 자동으로 또 등록하면 안된다. 따라서 @Configuration이 붙은 것들을 제외한다.
        // 기존 코드 남기려고 이렇게 했다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes= Configuration.class)
) // @Component이 붙은 클래스를 찾아 자동으로 스프링 빈으로 등록해준다.
public class AutoAppConfig {

}
