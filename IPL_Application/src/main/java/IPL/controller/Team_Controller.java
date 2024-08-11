package IPL.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dao.TeamDao;
import IPL.dto.Player;
import IPL.dto.Team;

//@Controller
@RestController //it will do the work of @controller and @respocebody also
public class Team_Controller {
	@Autowired
	TeamDao teamDao;
	@Autowired
	PlayerDao playerDao;
	
	@RequestMapping("teamSignup")
//	@ResponseBody
	public ModelAndView team_signup(@ModelAttribute Team team)
	{
		teamDao.teamSave(team);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","Team account got Created");
		modelAndView.setViewName("LoginArea.jsp");
		return modelAndView;
	}
	@PostMapping("teamLogin")
//	@ResponseBody
	public ModelAndView team_login(@RequestParam String username, @RequestParam String password, HttpSession httpSession)
	{
		 Team team=teamDao.team_login(username);
		 ModelAndView modelAndView=new ModelAndView();
		 
		 if(team == null)
		 {
			 modelAndView.addObject("msg","Invalid Password");
			 modelAndView.setViewName("LoginArea.jsp");
		 }
		 else
		 {
			 if(team.getPassword().equals(password))
			 {
				 if(team.isStatus() == true)
				 {
					 httpSession.setAttribute("team", team);//if i want the information of the team in future then i can get the in information
					 modelAndView.addObject("msg", "Login Successful");
					 modelAndView.addObject("img",team.getImagelink());
					 modelAndView.setViewName("team_home.jsp");
				 }
				 else {
					 modelAndView.addObject("msg","wait for the management approval");
					 modelAndView.setViewName("LoginArea.jsp");
				 }
			 }
			 else {
				modelAndView.addObject("msg","invalid password");
				modelAndView.setViewName("LoginArea.jsp");
			}
		 }
		 return modelAndView;

	}
	@RequestMapping("viewallteam")
//	@ResponseBody
	 public ModelAndView viewallteams()
	 {
		List<Team> teams=teamDao.view_All_Team();
		ModelAndView modelAndView=new ModelAndView();
		
		if(teams.isEmpty())
		{
			modelAndView.addObject("msg","There are no team present inside the database ");
			modelAndView.setViewName("ManagementHome.jsp");
		}
		else {
			modelAndView.addObject("teams",teams);
			modelAndView.setViewName("ViewAllTeams.jsp");
		}
		return modelAndView;
	 }
	
	@RequestMapping("changestatus")
	public ModelAndView changestatus(@RequestParam int id) {
		Team team=teamDao.changeStatus(id);
		ModelAndView modelAndView=new ModelAndView();
		if(team.isStatus()== true)
		{
			team.setStatus(false);
		}
		else {
			team.setStatus(true);
			
		}
		teamDao.update(team);
		List<Team> teams=teamDao.view_All_Team();
		modelAndView.addObject("teams",teams);
		modelAndView.addObject("msg","team status got update");
		modelAndView.setViewName("ViewAllTeams.jsp");
		return modelAndView;
	}
	
	@PostMapping("addamount")
	public ModelAndView addAmount(@RequestParam double wallet, @RequestParam int tid)
	{
		Team team=teamDao.addAmount(tid);
		team.setWallet(team.getWallet() + wallet);
		
		teamDao.update(team);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", "Amount has been added fro team "+ team.getName()+"account");
		modelAndView.setViewName("team_home.jsp");
		
		return modelAndView;
		
	}
	@RequestMapping("buyplayer")
	public ModelAndView buyPlayer(@RequestParam int id,HttpSession httpSession)
	{
		
		Team team=(Team) httpSession.getAttribute("team");
		Player player=playerDao.find(id);
		ModelAndView modelAndView=new ModelAndView();
		
		if(team.getWallet()< player.getBaseprice())
		{
			modelAndView.addObject("msg","Insufficient balance");
			modelAndView.setViewName("Buy_Players.jsp");
		}
		else 
		{
			team.setWallet(team.getWallet()-player.getBaseprice()); 
			player.setStatus("Sold");
			player.setTeam(team);//inside player reference variable i have taken team information
			
			playerDao.updatePlayer(player);
			List<Player> players1=team.getPlayers();
			
			if(players1 == null)
			{
				List<Player> players2=new ArrayList<Player>();
				players2.add(player);
				team.setPlayers(players2);
				
				teamDao.update(team);
			}
			else 
			{
			List<Player> players3=team.getPlayers();//IT IS FRESH COPY POR EMPTY LIST
			players3.add(player);//hence one user information is comming and sitting
			team.setPlayers(players3);
//			playerDao.updatePlayer(player);
			teamDao.update(team);
			
			
			modelAndView.addObject("msg","player has been sold out for team"+" "+team.getName());
			modelAndView.setViewName("team_home.jsp");
			}
			
			
			
		}
		return modelAndView;
	}
	@RequestMapping("viewteam")
	public ModelAndView viewTeam(HttpSession httpSession)
	{
		Team team=(Team)httpSession.getAttribute("team");
		List<Player> players=team.getPlayers();
		ModelAndView modelAndView=new ModelAndView();
		if(players.isEmpty())
		{
			modelAndView.addObject("msg","No Players has been soldout for team"+""+team.getName());
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("View_my_team.jsp");
		}
		else {
			modelAndView.addObject("players",players);
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("View_my_team.jsp");
		}
		return modelAndView;
	}
	@RequestMapping("viewteambyname")
	public ModelAndView viewTeamByName()
	{
		List<Team> teams=teamDao.view_All_Team();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("teams",teams);
		modelAndView.setViewName("viewteambyname.jsp");
		
		return modelAndView;
		
	}
	@PostMapping("fetchUsingTeamName")
	public ModelAndView name(@RequestParam String name)
	{
		Team team=teamDao.fetchAllTeamUsingName(name);
		List<Player> players=team.getPlayers(); //information will come  virat+uvi+cahal
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("players",players);
		modelAndView.setViewName("View_my_team.jsp");
		
		return modelAndView;
	}
	

}
