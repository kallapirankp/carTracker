package com.kallapiran;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Application.class, JpaConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
