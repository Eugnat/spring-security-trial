package webdemo;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import webdemo.config.DataSourceConfiguration;
import webdemo.config.SecurityConfiguration;
import webdemo.config.SpringDataConfiguration;
import webdemo.config.WebMvcConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Order(1)
public class WebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DataSourceConfiguration.class, SecurityConfiguration.class, SpringDataConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }



    @Override
    public void onStartup(final ServletContext servletContext)
            throws ServletException {

        super.onStartup(servletContext);

    }

}
