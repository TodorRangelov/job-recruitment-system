package com.melon.openposition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<OpenPosition, Long> {

    OpenPosition findByTitle(String title);
}
