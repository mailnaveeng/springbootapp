package hello.impl;

import hello.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;

@Service
public class ExternalServiceImpl implements ExternalService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String sayHelloGoogle() throws SocketTimeoutException {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        if(true) {
            throw new SocketTimeoutException("A Socket Timeout");
        }
        return restTemplate.exchange("http://google.com", HttpMethod.GET, entity, String.class).getBody();
    }


}
