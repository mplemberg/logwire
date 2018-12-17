package com.weddingwire.logwire.api;



import com.weddingwire.logwire.api.interfaces.IDatabaseSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {
    @Autowired
    private IDatabaseSeeder databaseSeeder;

    @Override
    public void run(ApplicationArguments args) {
        databaseSeeder.runIfEmpty();
    }


}
