package nacos_config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leofee
 */
@RefreshScope
@RestController
public class NacosConfigController {

    @Autowired
    public Environment environment;

    @Value("${config.info}")
    private String configInfo;


    @RequestMapping("/config/{key}")
    public String getConfigByKey(@PathVariable String key) {
        return environment.getProperty(key);
    }

    @RequestMapping("/config/info")
    public String getConfig() {
        return configInfo;
    }
}
