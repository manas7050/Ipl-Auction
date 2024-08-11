package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import IPL.dto.Player;

@Component
public class PlayerDao {
	@Autowired
	EntityManager entityManager;
	
	public void playerSignup(Player player) 
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
	}
	public Player playerLogin(String username)
	{
		List<Player> list=entityManager.createQuery("select x from Player x where username=?1").setParameter(1, username).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else {
			return list.get(0);
		}
	}
 
	public void updatePlayer(Player player) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(player);
		entityTransaction.commit();
		
	}
	public List<Player> fetchallplayer() {
		List<Player> players=entityManager.createQuery("select x from Player x").getResultList();
		if(players.isEmpty())
		{
			return null;
		}
		else {
			return players;
		}
		
	}
	public Player find(int id) {
		 Player player=entityManager.find(Player.class,id);
		 if(player == null)
		 {
			 return null;
		 }
		 else {
			return player;
		}
		
	}
	public List<Player> viewAvilablePlayer() {
		List<Player> players=entityManager.createQuery("select x from Player x where status='Available'").getResultList();
		return players;
	}

}
