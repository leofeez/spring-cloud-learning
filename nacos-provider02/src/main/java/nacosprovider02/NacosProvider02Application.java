package nacosprovider02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author leofee
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider02Application.class);
    }
}
