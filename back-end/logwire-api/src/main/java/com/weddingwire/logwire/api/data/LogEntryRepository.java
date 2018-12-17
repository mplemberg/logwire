package com.weddingwire.logwire.api.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface LogEntryRepository extends JpaRepository<LogEntry, String> {
    Page<LogEntry> findByRawTextIgnoreCaseContainingAndRequestDateTimeBetweenOrderByRequestDateTimeDesc(String rawText, Date from, Date to, Pageable pageable);
    Page<LogEntry> findByRequestDateTimeBetweenOrderByRequestDateTimeDesc(Date from, Date to, Pageable pageable);
    Page<LogEntry> findAllByOrderByRequestDateTimeDesc(Pageable pageable);
}
