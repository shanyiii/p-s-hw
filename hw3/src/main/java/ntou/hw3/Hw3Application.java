package ntou.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.context.event.ContextStartedEvent;

import java.util.ArrayList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Hw3Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Hw3Application.class, args);
        applicationContext.start();
    }

    @Component
    static class ContextStarted implements ApplicationListener<ContextStartedEvent>{
        @Autowired
        private SightsRepository repo;
        @Autowired
        private SightsService service;

        @Override
        public void onApplicationEvent(ContextStartedEvent e){
            KeelungSightsCrawler crawler = new KeelungSightsCrawler();
            ArrayList<Sight> sights = crawler.getStarted();
            for(Sight s : sights){
                repo.insert(s);
                //System.out.println(s);
            }
        }
    }
}
