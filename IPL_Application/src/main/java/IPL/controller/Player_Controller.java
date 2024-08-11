package IPL.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dto.Player;

@RestController
public class Player_Controller {
	@Autowired
	PlayerDao playerDao;
	
	@PostMapping("playerSignup")
	public ModelAndView playerSignup(@ModelAttribute Player player)
	{
		player.setStatus("pending");
		playerDao.playerSignup(player);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg",player.getName()+" "+"player account got Created");
		modelAndView.setViewName("LoginArea.jsp");
		return modelAndView;
	}
	@PostMapping("playerlogin")
	public ModelAndView playerLogin(@RequestParam String username,@RequestParam String password,HttpSession httpSession) 
	{
		Player player=playerDao.playerLogin(username);
		ModelAndView modelAndView=new ModelAndView();
		if(player == null)
		{
			modelAndView.addObject("msg","invalid username");
			modelAndView.setViewName("LoginArea.jsp");
		}
		else {
			if(player.getPassword().equals(password))
			{
				httpSession.setAttribute("player", player);//for future use i am setting the information of player by using session tracking concept
				modelAndView.addObject("msg","Login Success");
				modelAndView.setViewName("Player_Home.jsp");
			}
			else 
			{
				modelAndView.addObject("msg","invalid username");
				modelAndView.setViewName("LoginArea.jsp");
			}
		}
		return modelAndView;
	}
	@RequestMapping("editplayerdetail")
	public ModelAndView editPlayerDetail(HttpSession httpSession) 
	{
		Player player=(Player)httpSession.getAttribute("player");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("player",player);
		
		return modelAndView;
		
	}
	@RequestMapping("updateplayer")
	public  ModelAndView updatePlayer(@ModelAttribute Player player) 
	{
		playerDao.updatePlayer(player);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","player data has been update successfully");
		modelAndView.setViewName("Player_Home.jsp");
		
		return modelAndView;
	}
	@RequestMapping("viewallplayer")
	public ModelAndView view_ALL_player_comming_for_auction()
	{
		List<Player> players=playerDao.fetchallplayer();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("players",players);
		modelAndView.setViewName("Viewa_all_Players.jsp");
		return modelAndView;
		
	}
	@RequestMapping("changeplayerstatus")
	public  ModelAndView change_player_status(@RequestParam int id) 
	{
		Player player=playerDao.find(id);
	
		if(player.getStatus().equals("pending"))
		{
			player.setStatus("Available");
		}
		else
		{
			player.setStatus("pending");
		}
		playerDao.updatePlayer(player);
		List<Player> players=playerDao.fetchallplayer();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("players",players);
		modelAndView.addObject("msg","player ststud got updated");
		modelAndView.setViewName("Viewa_all_Players.jsp");
		return modelAndView;
		
	}
	@RequestMapping("viewavilablePlayers")
	public ModelAndView viewAvilablePlayer() {
		 List<Player> players=playerDao.viewAvilablePlayer();
		ModelAndView modelAndView= new ModelAndView();
		if(players.isEmpty())
		{
			modelAndView.addObject("msg","No Players are avilable");
			modelAndView.setViewName("team_home.jsp");
		}
		else {
			modelAndView.addObject("players",players);
			modelAndView.setViewName("Buy_Players.jsp");
			
		}
		return modelAndView;

	}

}
