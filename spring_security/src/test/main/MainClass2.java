package test.main;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass2 {
	public static void main(String[] args) {
		//가입할대 입력한 비밀번호
		String pwd ="1234";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//DB에 저장된 암호화된 비밀번호 가정
		String hash1=encoder.encode(pwd);
		
		//로그인 할때 입력한 비밀번호라고 가정
		String inutPwd="1234";
		
		//스프링프레임웍에서 제공하는 클래스 checkpw(순수문자열, 암호화된 문자열) 를 통해 boolean타입으로 리턴해서 비교한다.
		boolean isValid = BCrypt.checkpw(inutPwd, hash1);
		
		System.out.println("isValid:"+isValid);
		
		String inputPwd2="2345";
		
		//로그인 할때 잘못 입력한 비밀번호라고 가정
		boolean isValid2 = BCrypt.checkpw(inputPwd2, hash1);
		
		System.out.println("isValid2:"+isValid2);
				
	}
}
