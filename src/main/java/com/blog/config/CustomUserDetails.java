package com.blog.config;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 7047944966940820377L;
	private User user;
	private com.blog.entity.User loggedUser;

    public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

	public void setUser(User user) {
		this.user = user;
	}

	public com.blog.entity.User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(com.blog.entity.User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
}