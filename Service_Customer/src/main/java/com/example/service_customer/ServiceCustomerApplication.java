package com.example.service_customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class ServiceCustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceCustomerApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"MOUNIA","mounia@gmail.com"));
            customerRepository.save(new Customer(null,"KACEMI","kacemi@gmail.com"));
            customerRepository.save(new Customer(null,"YASMINE","yasmine@gmail.com"));
            customerRepository.save(new Customer(null,"LAMIA","lamia@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.getName());
            });
        };
    }
}

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@ToString
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

}

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long> {

}