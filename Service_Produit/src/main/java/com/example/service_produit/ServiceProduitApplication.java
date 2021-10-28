package com.example.service_produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class ServiceProduitApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceProduitApplication.class, args);
    }
    @Bean
CommandLineRunner start(ProduitRepository produitRepository){
return args -> {
    produitRepository.save(new Produit(null,"Milka",10,1000));
    produitRepository.save(new Produit(null,"Merendina",2,5000));
    produitRepository.save(new Produit(null,"Aiguebelle chocolat",20,3000));
    produitRepository.save(new Produit(null,"Nutella",100,2000));
    produitRepository.save(new Produit(null,"KitKat",15,6000));
produitRepository.findAll().forEach(p->{
    System.out.println(p.getName());
});
};
}
}
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
class Produit{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double quantity;
}
@RepositoryRestResource
interface ProduitRepository extends JpaRepository<Produit,Long>{

}
