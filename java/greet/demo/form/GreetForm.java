package greet.demo.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GreetForm {
	
	@NotNull
	@Size(min=1,max=20,message="言語は1文字以上20文字以下で指定してください")
	private String language;
	
	@NotNull
	@Size(min=1,max=64,message="朝の挨拶は1文字以上64文字以下で指定してください")
	private String morning;
	
	@NotNull
	@Size(min=1,max=64,message="朝の挨拶は1文字以上64文字以下で指定してください")
	private String noon;
	
	@NotNull
	@Size(min=1,max=64,message="朝の挨拶は1文字以上64文字以下で指定してください")
	private String evening;
	
	@NotNull
	@Size(min=1,max=64,message="朝の挨拶は1文字以上64文字以下で指定してください")
	private String night;
	
	@NotNull
	@Size(min=1,max=256,message="備考は256文字以下で指定してください")
	private String remarks;
	
	

}
