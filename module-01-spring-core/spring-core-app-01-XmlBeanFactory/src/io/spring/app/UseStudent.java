package io.spring.app;

import io.spring.beans.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UseStudent {
    public static void main(String[] args) {
        Resource resourceFile = new ClassPathResource("/io/spring/resources/beanconf.xml");
        BeanFactory container = new XmlBeanFactory(resourceFile);

        // NOTE: BeanFactory performs Lazy initialization
        System.out.println("Container Started");

        // Getting Student Object from Spring Container
        Student studentObj = (Student) container.getBean("studentObj");

        System.out.println("Student name: " + studentObj.getName());
        System.out.println("Student Roll no: " + studentObj.getRollNo());
    }
}
