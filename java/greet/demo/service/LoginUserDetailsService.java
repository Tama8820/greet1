package greet.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import greet.demo.entity.LoginUser;
import greet.demo.repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginUserDetailsService implements UserDetailsService {
	private final LoginUserRepository loginUserRepository;
	
	//ログインIDで認証するが、Securityからのメソッドは
	//ByUsernameとなっている
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		LoginUser loginUser = loginUserRepository.findByUserId(userId);
		if(loginUser == null) {
			throw new UsernameNotFoundException("Not found user");
			
		}
		return new LoginUserDetails(loginUser);
	}

}
