package hello;

import java.net.SocketTimeoutException;

public interface ExternalService {

    String sayHelloGoogle() throws SocketTimeoutException;
}
