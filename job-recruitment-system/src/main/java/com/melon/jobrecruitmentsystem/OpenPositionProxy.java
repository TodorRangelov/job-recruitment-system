package com.melon.jobrecruitmentsystem;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "open-position")
public interface OpenPositionProxy {

    @GetMapping("/open-position/title/{title}")
    public ResponseEntity<Object> getOpenPosition(@PathVariable String title);
}
