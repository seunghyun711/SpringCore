package hello.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

//        ac.getBean("beanB", BeanB.class);
        assertThrows(
                NoSuchBeanDefinitionException.class, () ->
                        ac.getBean("beanB", BeanB.class)
        );
    }

    //
    @Configuration
    @ComponentScan(
            // includeFilters에 MyIncludeComponent 애너테이션을 추가해 BeanA가 스프링 빈에 등록된다.
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            // excludeFilters에 MyExcludeComponent 애너테이션을 추개해 BeanB가 스프링 빈에 등록되지 않는다.
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig {
    }

}
