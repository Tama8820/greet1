package greet.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import greet.demo.entity.GreetMessage;

public interface GreetRepository extends JpaRepository<GreetMessage,Integer> {
	
	//指定言語の挨拶を読みだす
	public GreetMessage findByLanguage(String language);
	public List<GreetMessage>findAll();
	
	//登録されてる言語の種類の報告(?)
	@Query("SELECT g.language FROM GreetMessage g")
	List<String> findLanguages();

	//指定した言語登録確認
	public boolean existsByLanguage(String language);
}
