package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dto.Management;
import IPL.dto.Player;
import IPL.dto.Team;

@Controller
@Component
public class controller 
{
	@Autowired//fresh object of the management dto class
	Management management;
	
	@Autowired
	Team team;
	
	@Autowired
	Player player;
	
	@PostMapping("signup")
	@ResponseBody
	public ModelAndView signupp(@RequestParam String role)//request param it will work as (req.getParameter()). it will used to to receive the parameter from frontend
	{	
		ModelAndView modelAndView=new ModelAndView ();
		if(role.equals("Management")) {
			 modelAndView.addObject("management", management);
			 modelAndView.setViewName("Management_SignUp.jsp");
		 }
		else if (role.equals("Team")) 
		{
			modelAndView.addObject("team" , team);
			modelAndView.setViewName("Team_SignUp.jsp");
			
		}
		else
		{
			modelAndView.addObject("player", player);
			modelAndView.setViewName("playerSignUp.jsp");
		}
		return modelAndView;
	}

}
