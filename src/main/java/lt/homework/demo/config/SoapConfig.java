package lt.homework.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@EnableWs
@Configuration
public class SoapConfig {

    // Automatically generates WSDL using the provided XSD schema
    /*@Bean
    public XsdSchema serviceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/service.xsd"));
    }
    
    @Bean(name = "service")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema serviceSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ServiceManagerPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://homework.example.com/");
        wsdl.setSchema(serviceSchema);
        return wsdl;
    }*/

   // Manually providing WSDL from resources
    @Bean(name = "service")
    public SimpleWsdl11Definition simpleWsdl11Definition() {
        return new SimpleWsdl11Definition(new ClassPathResource("wsdl/service.wsdl"));
    }

    // Needed to map the MessageDispatcherServlet to /ws/*
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
}