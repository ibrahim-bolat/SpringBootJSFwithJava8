package org.example.config;

import com.sun.faces.config.FacesInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class JsfInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        //bu ayar set edilmezse convertDateTime br gün önce tarih alıyor.
        context.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", Boolean.TRUE.toString());

        //faces servleti başlatıyor
        ServletContainerInitializer facesInitializer = new FacesInitializer();
        facesInitializer.onStartup(null, context);
    }
}

