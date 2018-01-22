package com.blog.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController  {

	protected static Logger log = Logger.getLogger(LoginController.class);
	
    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(Model model) {
    	log.info("Received request to show login page");
        return "login";
    }
 
    
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        log.info("Received request to show denied page");
        //return "denied";
        return "redirect:/login?locked";
    }
 
    @RequestMapping(value = "/logout", method = {RequestMethod.POST,RequestMethod.GET})
    public String logout(Model model) {
    	log.info("Received request to show logout page");
    	return "redirect:/login?logout";
    }
    
    @RequestMapping(value = "/expired", method = RequestMethod.GET)
    public String expired(Model model) {
    	log.info("Received request to show expired page");
    	return "redirect:/login?expired";
    }
    
    @RequestMapping(value = "/locked", method = RequestMethod.GET)
    public String locked(Model model) {
    	log.info("Received request to show expired page");
    	return "redirect:/login?locked";
    }
	
}