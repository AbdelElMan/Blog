package com.blog.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.blog.config.CustomUserDetails;
import com.blog.dao.UserDao;
import com.blog.enums.Roles;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {    
		  
		CustomUserDetails userDetails = null;
		
		if (username == null || username.trim().isEmpty()) throw new UsernameNotFoundException("Usuario no encontrado.");
		
		com.blog.entity.User loggedUser = userDao.findByUsername(username);

		if (loggedUser == null) throw new UsernameNotFoundException("Usuario no encontrado.");

		User user = this.buildUserFromUserEntity(loggedUser);

		userDetails = new CustomUserDetails(user, user.getAuthorities());

		userDetails.setLoggedUser(loggedUser);

		return userDetails;   

    }   

	private User buildUserFromUserEntity(com.blog.entity.User loggedUser) {
    	  
    	String username = loggedUser.getUsername();
	  	String password = loggedUser.getPassword();
	  	boolean enabled = true;
	  	boolean accountNonExpired = true;
	  	boolean credentialsNonExpired = true;
	  	boolean accountNonLocked = false;
      	
      	List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>(Arrays.asList(this.getAuthoriy(loggedUser)));

      	return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

    }
    
	public SimpleGrantedAuthority getAuthoriy(com.blog.entity.User loggedUser) {
		
		String rol = Roles.getEnum(loggedUser.getRol()).getName();
		
		return new SimpleGrantedAuthority(rol);
	}
 
    
}