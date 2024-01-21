package greet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greet.demo.entity.LoginUser;

public interface LoginUserRepository extends JpaRepository<LoginUser,Integer> {
	public LoginUser findByUserId(String userId);

}
