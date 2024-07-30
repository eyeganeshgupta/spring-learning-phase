package io.spring.app;

import io.spring.beans.Math;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseMath {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("/io/spring/resources/config.xml");

        // 👇🏼 Fetching Math Object from the Spring Container
        Math mathObj = container.getBean("mathObj", Math.class);

        System.out.println(mathObj.add(10, 20));
        System.out.println(mathObj.subtract(14, 23));
    }
}
