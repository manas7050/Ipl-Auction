package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.Query;

import IPL.dto.Management;

@Component
public class Management_Dao {
	@Autowired
	EntityManager entityManager;
	
	public void Management_save(Management management) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(management);
		entityTransaction.commit();
		
	}
	public Management management_login(String name) {
		List<Management> list=entityManager.createQuery("select x from Management x where name=?1 ").setParameter(1,name).getResultList();
		
		if(list.isEmpty())
		{
			return null;
		}
		else {
			return list.get(0);
		}
	}

}
