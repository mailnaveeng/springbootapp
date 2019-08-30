package hello;

import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    ExternalService externalService;

    @Autowired
    Map<String, Integer> exceptionCounter;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) throws SocketTimeoutException {
        return externalService.sayHelloGoogle();
    }

    @RequestMapping("/exceptionCounter")
    public Map<String, Integer> exceptionCounter(@RequestParam(value="name", defaultValue="World") String name) {
        return exceptionCounter;
    }
}
