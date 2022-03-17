package com.melon.openposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Environment environment;
    @Autowired
    private Service service;

    @GetMapping("/open-position/title/{title}")
    public OpenPosition getOpenPosition(@PathVariable String title) {

        OpenPosition openPosition = new OpenPosition();
        openPosition.setTitle("java");
        openPosition.setStatus("active");
        openPosition.setLanguage("java");
        this.service.addOpenPosition(openPosition);

        OpenPosition openPosition2 = this.service.getOpenPosition(title);
        String port = this.environment.getProperty("local.server.port");
        openPosition2.setEnvironment(port);

        return openPosition2;
    }

    @GetMapping("/open-position/getall")
    public List<OpenPosition> getAll() {
        List<OpenPosition> response = this.service.getAll();
        return response;
    }

    @PostMapping("/open-position/add")
    public void add(@RequestBody OpenPosition openPosition) {
        this.service.add(openPosition);
    }
}
