package io.spring.app;

import io.spring.beans.Country;
import io.spring.beans.State;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseBeans {
    public static void main(String[] args) {
        // 👉 Create the Spring container
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();

        // 👉 Register the Country and State bean with the container
        container.register(io.spring.beans.Country.class);
        container.register(io.spring.beans.State.class);

        // 👉 Refresh the container to apply the configuration
        container.refresh();

        // 👉 Retrieve the Country bean from the container
        // NOTE: Once we refresh the container then only country and state bean will be created.
        Country country = (Country) container.getBean("country");
        State state = (State) container.getBean("state");

        // 👉 Use the Country and State bean
        country.displayDetails();
        state.displayDetails();
    }
}
