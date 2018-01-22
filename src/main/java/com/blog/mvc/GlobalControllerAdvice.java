package com.blog.mvc;

import java.security.Principal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blog.config.CustomUserDetails;

@ControllerAdvice
public class GlobalControllerAdvice extends RuntimeException  {

	private static final long serialVersionUID = 4163769255473934613L;
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	
    @ModelAttribute("logedUser")
    public CustomUserDetails getLogedUser2(Model model, Principal principal) {
    	
    	if (principal != null){
    		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    	}
      return null;
    }
    
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
	        throw e;

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", e);
	    mav.addObject("timestamp",new Date());
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
	}


}