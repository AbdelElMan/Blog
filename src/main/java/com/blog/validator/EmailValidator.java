package com.blog.validator;

import java.io.Serializable;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class EmailValidator implements ConstraintValidator<EmailValid, Object>, Serializable  {
	private static final long serialVersionUID = 6405973656243632456L;
	private final static String ATOM      = "[a-z0-9_%-]";
	private final static String DOMAIN    = ATOM+"+(\\."+ATOM+"+)+";
	private final static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
	private final static String PATTERN =
            "^" + ATOM + "+(\\." +ATOM+ "+)*@"
            		+"("
                    + DOMAIN
                    + "|"
                    + IP_DOMAIN
                    + ")$";
	
	private final static Pattern EMAIL_PATTERN = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		
		if (obj == null){
			return true;
		}else if(obj instanceof String){
			return EMAIL_PATTERN.matcher((String)obj).matches();
		}

		return false;
	}

	@Override
	public void initialize(EmailValid arg0) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
