package org.example.config;

import com.sun.faces.config.FacesInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JSFConfiguration {

    @Bean
    public ServletContextInitializer initializer(FacesInitializer facesInitializer) {
        return servletContext -> {
            //bu ayar set edilmezse convertDateTime br gün önce tarih alıyor.
            servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", Boolean.TRUE.toString());

            //faces servleti başlatıyor
            facesInitializer.onStartup(null, servletContext);
        };
    }
    @Bean
    public FacesInitializer facesInitializer() {
        return new FacesInitializer();
    }
}