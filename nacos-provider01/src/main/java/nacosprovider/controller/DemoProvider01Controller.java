package nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author leofee
 */
@RestController
public class DemoProvider01Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/provider")
    public String provider() {
        return "Hello! Provider port is :" + port;
    }

    @GetMapping(value = "/query")
    public String query() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello! Provider port is :" + port;
    }
}
