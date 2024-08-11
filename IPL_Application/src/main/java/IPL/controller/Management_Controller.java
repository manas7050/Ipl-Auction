package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.Management_Dao;
import IPL.dto.Management;

@Controller

public class Management_Controller {
	@Autowired
	Management_Dao management_Dao;
	@RequestMapping("managementsignup")
	@ResponseBody
	public ModelAndView management_signup(@ModelAttribute Management management)
	{
		management_Dao.Management_save(management);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","management accounnt got created");
		modelAndView.setViewName("LoginArea.jsp");
		
		return modelAndView;
	}
	@PostMapping("managementLogin")
	public ModelAndView management_login(@RequestParam String name, @RequestParam String password)
	{
		ModelAndView modelAndView=new ModelAndView();
		Management management=management_Dao.management_login(name);
		if(management == null)
		{
			modelAndView.addObject("msg","Invalid username");
			modelAndView.setViewName("LoginArea.jsp");
		}
		else {
			if(management.getPassword().equals(password))
			{
				modelAndView.addObject("msg","Login_successful");
				modelAndView.setViewName("ManagementHome.jsp");
			}
			else {
				modelAndView.addObject("msg","Invalid user");
				modelAndView.setViewName("LoginArea.jsp");
				
			}
		}
		return modelAndView;
	}

}
