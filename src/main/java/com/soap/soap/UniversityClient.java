package com.soap.soap;

import countries.wsdl.GetAllUniversitiesAtLocationRequest;
import countries.wsdl.GetAllUniversitiesAtLocationResponse;
import countries.wsdl.GetUniversityRequest;
import countries.wsdl.GetUniversityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UniversityClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    public GetUniversityResponse getUniversityResponse(String name){
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                                            .marshalSendAndReceive("http://localhost:7000/ws/universities", request,
                                                    new SoapActionCallback(
                                                            "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"
                                                    ));
        return response;
    }

    public GetAllUniversitiesAtLocationResponse getAllUniversitiesAtLocationResponse(String location){
        GetAllUniversitiesAtLocationRequest request = new GetAllUniversitiesAtLocationRequest();
        request.setLocation(location);

        GetAllUniversitiesAtLocationResponse response = (GetAllUniversitiesAtLocationResponse) getWebServiceTemplate()
                                                            .marshalSendAndReceive("http://localhost:7000/ws/universities", request);
        return response;
    }
}
