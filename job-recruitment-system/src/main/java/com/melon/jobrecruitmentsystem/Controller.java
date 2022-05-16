package com.melon.jobrecruitmentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class Controller {

    @Autowired
    private OpenPositionProxy proxy;

    @GetMapping("job-recruitment-system/openPosition/{title}")
    public ResponseEntity<Object> getOpenPosition(@PathVariable String title) {

        HashMap<String, String> urlVariable = new HashMap<>();
        urlVariable.put("title", title);

        ResponseEntity<Object> responseEntity = new RestTemplate().getForEntity(
                        "http://localhost:8000/open-position/title/{title}",
                        Object.class,
                        urlVariable);

        return responseEntity;
    }

    @GetMapping("job-recruitment-system/openPosition/get/{title}")
    public ResponseEntity<Object> getOpenPositionFeign(@PathVariable String title) {

        ResponseEntity<Object> responseEntity = proxy.getOpenPosition(title);

        return responseEntity;
    }
}
