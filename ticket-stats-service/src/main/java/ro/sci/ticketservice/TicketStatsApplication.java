package ro.sci.ticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketStatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketStatsApplication.class, args);
    }

}
