package service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.hostco.reguser.types.*;

@Service
public class RegUserClient extends WebServiceGatewaySupport {

    private final String regUserToken = "D468E929-A94E-4F16-A7D2-DB414EC53071";

    public GetUserResponseType getUser(String snils){
        GetRolesRequestType request = new GetRolesRequestType();
        request.setToken(regUserToken);
        request.setSNILS(snils);
        return (GetUserResponseType) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback("https://cas-test.hostco.ru/RegUserService/services/RegUserService?wsdl"));
    }

}
