package lt.homework.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import jakarta.xml.bind.helpers.DefaultValidationEventHandler;

@EnableWs
@Configuration
public class SoapConfig {

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

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
            lt.homework.demo.model.requests.CreateRequest.class,
            lt.homework.demo.model.requests.DeleteRequest.class,
            lt.homework.demo.model.requests.UpdateRequest.class,
            lt.homework.demo.model.requests.ReadRequest.class,
            lt.homework.demo.model.responses.ResultResponse.class,
            lt.homework.demo.model.CustomerDetails.class,
            lt.homework.demo.model.Address.class,
            lt.homework.demo.model.ServiceDetails.class
        );
        marshaller.setSchemas(new ClassPathResource("xsd/service.xsd")); 
        marshaller.setValidationEventHandler(new DefaultValidationEventHandler());
        return marshaller;
    }
}