package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class SpringBootJSFwithJava8 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJSFwithJava8.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistraiton() {
        FacesServlet facesServlet = new FacesServlet();
        ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean(facesServlet, "*.xhtml" );
        return registration;
    }
}
