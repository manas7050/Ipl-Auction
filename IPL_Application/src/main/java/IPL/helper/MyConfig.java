package IPL.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "IPL")
public class MyConfig {
	@Bean //it will be helpfull to create reference varibale of interface and mainly  it is used to return the reference  varibale of reference type
	public EntityManager getEMF() {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 
		 return entityManager;

	}

}
