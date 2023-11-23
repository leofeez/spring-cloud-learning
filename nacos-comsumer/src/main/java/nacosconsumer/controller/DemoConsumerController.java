package nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leofee
 */
@RestController
public class DemoConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-provider-service}")
    private String serviceUrl;

    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForObject(serviceUrl + "/nacos_provider/provider", String.class);
    }
}
