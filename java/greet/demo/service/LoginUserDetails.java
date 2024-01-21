package greet.demo.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import greet.demo.entity.LoginUser;

public class LoginUserDetails implements UserDetails {
	
	private final LoginUser loginUser;
	public LoginUserDetails(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	
	//ユーザー権限
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_"+loginUser.getRole());
	}
	
	public String getUserId() {
		return loginUser.getUserId();
	}

	@Override
	public String getPassword() {
		return loginUser.getPassword();
	}

	@Override
	public String getUsername() {
		return loginUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
