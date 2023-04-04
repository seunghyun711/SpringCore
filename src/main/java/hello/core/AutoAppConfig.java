package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /*
        권장하는 방법 : 패키지 위치를 지정하지 않고 설정 정보 클래스의 위치를 프로젝트 최상위에 둔다.
         */
//        basePackages = "hello.core.member", // member 부터 컴포넌트 스캔의 대상이 된다.
//        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색 시작 위치로 지정
        // 디폴트 값은 hello.core가 붙은 모든 파일이 컴포넌트 스캔 대상이 된다.
        // AppConfig클래스는 수동으로 등록한 빈이기 때문에 자동으로 또 등록하면 안된다. 따라서 @Configuration이 붙은 것들을 제외한다.
        // 기존 코드 남기려고 이렇게 했다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes= Configuration.class)
) // @Component이 붙은 클래스를 찾아 자동으로 스프링 빈으로 등록해준다.
public class AutoAppConfig {

}
