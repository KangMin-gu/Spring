package test.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 	-Aspectj Expression
 * 
 * 	1. execution(public * *(..)) => 접근 지정자가 public 인 메소드가 point cut
 * 	2. execution(* test.service.*.*(..)) 
 * 		=> test.service 패키지의 모든 메소드 point cut
 * 	3. execution(public void insert*(..))
 * 		=> 접근 지정자는 public 리턴 type 은 void 이고 메소드명이 
 * 		insert 로 시작하는 모든 메소드가 point cut
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 메소드가 
 * 		point cut
 * 	5. execution(* delete*(*,*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 메소드가 
 *      point cut
 */

@Aspect
@Component
public class WritingAspect { //스프링빈컨테이너에서 관리되는 객체의 메소드중에서 아래의 aspect를 실행하겠다.
	
	//write로 시작되는 모든 메소드에 적용 .. 인자가 전달되든 안되는 모두
	@Before("execution(public void write*(..))") //public void write*(java.lang.String)->Stringtype 문자열을 인자로받는
	public void preparePen(){
		System.out.println("펜을 준비해서 뚜겅을 열어요");
	}
	
	@After("execution(public void write*(..))")
	public void endPen(){
		
		System.out.println("펜의 뚜겅을 닫고 정리를 해요");
	}
	
	/*
	 *  ProcedingJoinPoint 객체는 @Around 에서만 지원된다.
	 */
	
	//ToTeacher로 끝나는 메소드
	@Around("execution(public void *ToTeacher(*))") //인자가 1개 
	public void aroundPen(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//Around는 aop가 적용되는 그 지점 객체 ProceedingJoinPoint joinPoint 특별한객체하나가 전달됨
		//before 와 after가 적용되는 경계선이 있어야하는데 그 경계선은 joinPoint.proceed(); 이다. 이게 없으면 핵심로직이 실행 안된다.
		//상황에 따라 핵심로직을 실행 안할꺼면 호출안하면된다. 
	
		System.out.println("Pen 준비"); //Before
		
		//Aop 가 적용된 메소드에 전달된 인자 배열 얻어오기
		Object[] args = joinPoint.getArgs(); //알아두기
		//for 문으로 인자들이 담긴 배열에서 값을 하나씩 빼서 
		for(Object tmp:args){
			//만일 객체가 String type 이라면 (우리가코딩했으니 알고 있다 타입은.)
			if(tmp instanceof String){ //타입으로 반복문돌면서 꺼내와서 tmp타입이 string이면 true 아니면 false를 반환한다.
				String name=(String)tmp; //원래타입으로 casting하여 
				System.out.println("메소드에 전달된 name:"+name); //사용한다.
			}
		}
		
		joinPoint.proceed(); //핵심 로진 수행  //알아두기
		
		System.out.println("Pen 마무리"); //After
	}
	
	@Around("execution(public java.util.Map *ToMother())")
	public Object aroundMother(ProceedingJoinPoint joinPoint) throws Throwable{
		//AOP가 적용된 메소드에서 리턴해주는 값 얻어오기 
		Object obj = joinPoint.proceed();//object type
		//리턴된 객체가 Map type 이라면
		if(obj instanceof Map){
			//object에서 원래타입으로 casting 해서
			Map<String, Object> map =(Map)obj;
			//Map 에 저장된 데이터 읽어와 보기 
			String msg = (String)map.get("msg");
			System.out.println("msg:"+msg);
			//Map에 저장된 데이터 수정하기 -> 조작할수도있다.
			map.put("msg", "안녕 엄마~");
		}
		return obj;
	}
}
