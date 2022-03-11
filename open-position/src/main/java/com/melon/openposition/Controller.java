package com.melon.openposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Environment environment;
    @Autowired
    private Service service;

    @GetMapping("/open-position/title/{title}")
    public OpenPosition getOpenPosition(@PathVariable String title) {

//        OpenPosition openPosition = new OpenPosition();
//        openPosition.setTitle("senior java");
//        openPosition.setStatus("active");
//        openPosition.setLanguage("java");
//        this.service.addOpenPosition(openPosition);

        OpenPosition openPosition = this.service.getOpenPosition(title);
        String port = this.environment.getProperty("local.server.port");
        openPosition.setEnvironment(port);

        return openPosition;
    }
}
