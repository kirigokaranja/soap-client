package com.soap.soap;

import countries.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UniversityClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    public GetUniversityResponse getUniversityResponse(String name){
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        return (GetUniversityResponse) getWebServiceTemplate()
                                            .marshalSendAndReceive("http://localhost:7000/ws/universities", request);
    }

    public GetAllUniversitiesAtLocationResponse getAllUniversitiesAtLocationResponse(String location){
        GetAllUniversitiesAtLocationRequest request = new GetAllUniversitiesAtLocationRequest();
        request.setLocation(location);

        return (GetAllUniversitiesAtLocationResponse) getWebServiceTemplate()
                                                            .marshalSendAndReceive("http://localhost:7000/ws/universities", request);
    }

    public GetAllUniversitiesResponse getAllUniversitiesResponse(){
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();

        return (GetAllUniversitiesResponse) getWebServiceTemplate()
                                                .marshalSendAndReceive("http://localhost:7000/ws/universities", request);
    }
}
