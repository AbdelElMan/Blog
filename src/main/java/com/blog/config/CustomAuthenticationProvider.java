package com.blog.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blog.service.CustomUserDetailService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired CustomUserDetailService userService;
	@Autowired BCryptPasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (password.isEmpty())
			throw new BadCredentialsException("El password no esta vacio");

		if (username.isEmpty())
			throw new BadCredentialsException("El usuario no puede estar vacio");

		UserDetails user = userService.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado.");
		}

		if (!user.isEnabled()) {
			throw new DisabledException("Usuario Deshabilitado");
		}

		if (!encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Usuario o password incorrectos");
		}

		if (!user.isAccountNonLocked()) {
			throw new LockedException("User account is locked");
		}

		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}