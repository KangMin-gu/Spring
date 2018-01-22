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
 * 	1. execution(public * *(..)) => 접근 지정자가 public 인 메소드가 
 * 	   point cut
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
public class WritingAspect {
	//write로 시작되는 모든 메소드에 적용 .. 인자가 전달되든 안되는 모두
	@Before("execution(public void write*(..))")
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
	@Around("execution(public void *ToTeacher(*))")
	public void aroundPen(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Pen 준비"); //Before
		
		//Aop 가 적용된 메소드에 전달된 인자 배열 얻어오기
		Object[] args = joinPoint.getArgs(); //알아두기
		for(Object tmp:args){
			//만일 객체가 String type 이라면 
			if(tmp instanceof String){ //타입으로 반복문돌면서 꺼내와서
				String name=(String)tmp; //casting
				System.out.println("메소드에 전달된 name:"+name);
			}
		}
		
		joinPoint.proceed(); //핵심 로진 수행  //알아두기
		
		System.out.println("Pen 마무리"); //After
	}
	
	@Around("execution(public java.util.Map *ToMother())")
	public Object aroundMother(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object obj = joinPoint.proceed();
		//리턴된 객체가 Map type 이라면
		if(obj instanceof Map){
			//원래타입으로 casting 해서
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
