package com.hostcoIntern.archivarius.service.config;

import com.hostcoIntern.archivarius.service.RegUserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class RegUserConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("hello.wsdl");
        return marshaller;
    }

    @Bean
    public RegUserClient RegUserClient(Jaxb2Marshaller marshaller) {
        RegUserClient client = new RegUserClient();
        client.setDefaultUri("https://cas-test.hostco.ru/RegUserService/services/RegUserService?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
