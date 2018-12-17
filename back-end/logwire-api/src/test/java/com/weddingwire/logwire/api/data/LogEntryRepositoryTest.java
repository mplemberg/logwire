package com.weddingwire.logwire.api.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//TODO: Should swap with an in-memory datastore. Don't actually want to mess with the stored data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LogEntryRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LogEntryRepository logEntryRepository;

    private SimpleDateFormat requestDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss Z");
    @Before
    public void setUp() throws Exception {
        List<LogEntry> logEntryList = new ArrayList<>();
        LogEntry logEntry1 = new LogEntry();
        logEntry1.setId("1");
        logEntry1.setRequestDateTime(requestDateTimeFormat.parse("2014-03-30 16:14:35 -0400"));
        entityManager.persist(logEntry1);

        LogEntry logEntry2 = new LogEntry();
        logEntry2.setId("2");
        logEntry2.setRequestDateTime(requestDateTimeFormat.parse("2014-03-30 16:14:40 -0400"));
        entityManager.persist(logEntry2);

        LogEntry logEntry3 = new LogEntry();
        logEntry3.setId("3");
        logEntry3.setRequestDateTime(requestDateTimeFormat.parse("2014-03-30 16:14:45 -0400"));
        entityManager.persist(logEntry3);
        entityManager.flush();
    }

    @Test
    public void OneLogEntryIsFoundWhenDateRangeIsProvided() throws ParseException {
        //Given
        Date from = requestDateTimeFormat.parse("2014-03-30 16:14:36 -0400");
        Date to = requestDateTimeFormat.parse("2014-03-30 16:14:44 -0400");

        //When
        Page<LogEntry> found = logEntryRepository.findByRequestDateTimeBetweenOrderByRequestDateTimeDesc(from, to, PageRequest.of(0,100));
        LogEntry logEntry = found.getContent().get(0);

        //Then
        assertThat(logEntry.getId()).isEqualTo("2");
    }
}
