package com.melon.openposition;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public void addOpenPosition(OpenPosition openPosition) {
        this.repository.save(openPosition);
    }

    public OpenPosition getOpenPosition(String title) {

        OpenPosition byTitle = this.repository.findByTitle(title);
        return byTitle;
    }
}
