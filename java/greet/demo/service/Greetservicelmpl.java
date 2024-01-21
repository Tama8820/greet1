package greet.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import greet.demo.entity.GreetMessage;
import greet.demo.form.GreetForm;
import greet.demo.repository.GreetRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

//挨拶実装
public class Greetservicelmpl implements GreetService {

	private final GreetRepository greetRepository;//greetRepository DI対象
	
	//新たな言語挨拶を登録する
	@Override
	public String saveGreetMessage(GreetForm greetForm) {
		
		//言語登録チェック
		List<String> languages = getLanguages();
		for (String language : languages) {
			if (language.equals(greetForm.getLanguage())) {

				return "指定された言語は登録済みです";
			}
		}

		//形式の変換
		GreetMessage greetMessage = new GreetMessage();
		greetMessage.setLanguage(greetForm.getLanguage());
		greetMessage.setMorning(greetForm.getMorning());
		greetMessage.setNoon(greetForm.getNoon());
		greetMessage.setEvening(greetForm.getEvening());
		greetMessage.setNight(greetForm.getNight());
		greetMessage.setRemarks(greetForm.getRemarks());

		//挨拶の登録
		try {
			greetRepository.save(greetMessage);
		} catch (Exception e) {
			System.out.println("データベース書き込み時にエラーが発生しました" + e.toString());
			return "データベース書き込み時にエラーが発生しました";
		}
		return "OK";
	}

	@SuppressWarnings("null")
	@Override
	public List<String> getLanguages() {
		List<GreetMessage> greetMessages = greetRepository.findAll();
		List<String> languages = new ArrayList<String>();
		greetMessages.forEach(message -> languages.add(message.getLanguage()));
		return languages;
	}
//	
	
	//指定された言語の、指定された時間帯の挨拶を返す
	@Override
	public String sayMessage(String language,String timeframe) {
		GreetMessage message = greetRepository.findByLanguage(language);
		
		switch(timeframe) {
		case "morning":
			return message.getMorning();
		case "noon":
			return message.getNoon();
		case "evening":
			return message.getEvening();
		case "night":
			return message.getNight();
		default:
			return "登録されていません";
			
		}
	}


}
