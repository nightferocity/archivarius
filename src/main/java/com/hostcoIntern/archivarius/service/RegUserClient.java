package com.hostcoIntern.archivarius.service;


import lombok.extern.slf4j.Slf4j;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import ru.hostco.reguser.types.*;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import java.util.List;

@Slf4j
public class RegUserClient extends WebServiceGatewaySupport  {

    public GetUserResponseType getUser(String snils) throws SOAPException {
        String uri = "https://cas-test.hostco.ru/RegUserService/services/RegUserService?wsdl";
        String action = "localhost:8080/user";
        GetUserRequestType request = new GetUserRequestType();
        request.setToken("D468E929-A94E-4F16-A7D2-DB414EC53071");
        request.setSNILS(snils);

        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory();
        WebServiceTemplate wsTemplate = getWebServiceTemplate();
        wsTemplate.setMessageFactory(saajSoapMessageFactory);

        SoapActionCallback requestCallback = new SoapActionCallback(action) {
            public void doWithMessage(WebServiceMessage message) {
                SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                SoapHeader soapHeader = soapMessage.getSoapHeader();

                QName wsaToQName = new QName("http://www.w3.org/2005/08/addressing", "To", "wsa");
                SoapHeaderElement wsaTo =  soapHeader.addHeaderElement(wsaToQName);
                wsaTo.setText(uri);

                QName wsaActionQName = new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa");
                SoapHeaderElement wsaAction =  soapHeader.addHeaderElement(wsaActionQName);
                wsaAction.setText("action");
            }
        };


        log.info("Requesting");

        return (GetUserResponseType) wsTemplate.marshalSendAndReceive(uri, request, requestCallback);
    }

//    public List<Patient> GetPatient(String lastName, String snils){
//        return null;
//    }
}
