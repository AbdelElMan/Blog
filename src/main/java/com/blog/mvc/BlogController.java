package com.blog.mvc;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import com.blog.config.CustomUserDetails;
import com.blog.entity.Comment;
import com.blog.entity.Entry;
import com.blog.entity.Tag;
import com.blog.entity.User;
import com.blog.exception.BlogException;
import com.blog.propertyEditor.TagPropertyEditor;
import com.blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController  {

	protected static Logger log = Logger.getLogger(BlogController.class);
	
	@Autowired private BlogService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Tag.class, new TagPropertyEditor());   
	}
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getResisterPage(Model model) {
    	
		model.addAttribute("user", new User());
		return "register";
	}
    

    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) throws BlogException{
    	
    	if (!result.hasErrors()){
        	service.addUser(user);
    		return "redirect:/login";
    	}

		return "register";
	}
	
    @RequestMapping(value = "/entries", method = RequestMethod.GET)
	public String getEntries(Model model) {

		model.addAttribute("entry", new Entry());
		model.addAttribute("entries", service.getAllEntries());
		return "entries";
	}
    
    @RequestMapping(value = "/entries", method = RequestMethod.POST)
	public String addEntry( @ModelAttribute("logedUser") CustomUserDetails logedUser, @ModelAttribute("entry") @Valid Entry entry, 
			BindingResult result, Model model) throws BlogException {
    	
    	if (!result.hasErrors()){
        	service.addEntry(entry, logedUser.getLoggedUser());
    		return "redirect:/entries";
    	}

		model.addAttribute("entries", service.getAllEntries());
		return "entries";
	}


    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
	public String getEntry(Model model, @PathVariable("id") Long id) throws BlogException{
    	
    	Entry entry = service.getEntry(id);
    	
    	model.addAttribute("comment", new Comment());
		model.addAttribute("entry", entry);
		return "entry";
	}
    
    @RequestMapping(value = "/entries/{id}", method = RequestMethod.POST)
	public String addComment( @ModelAttribute("logedUser") CustomUserDetails logedUser, @PathVariable("id") Long id, 
			@ModelAttribute("comment") @Valid Comment comment, 
			BindingResult result, Model model) throws BlogException {
    	
    	if (!result.hasErrors()){
    		
    		Entry entry = service.getEntry(id);
        	service.addComment(comment, logedUser.getLoggedUser(), entry);
    		return "redirect://entries/"+id;
    	}

    	model.addAttribute("entry", service.getEntry(id));
		return "entry";
	}
    
}