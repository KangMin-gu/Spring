package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 어노테이션을 붙이고 component scan 을 이용해서 bean 으로 등록 
@Aspect //aspect로 만든다.
@Component //빈에 등록한다.
public class PrintLogAspect {
	
	@Around("execution(public void insert())")//public void insert()이 작업을 이메소드 주변에 하겠다!
	public Object PrintLog(ProceedingJoinPoint joinPoint) 
			throws Throwable{
		//메소드 실행 이전에들어감
		System.out.println("비즈니스 로직을 수행하기 직전입니다.");
		
		//로직 수행 public void insert() 메소드 실행
		Object obj = joinPoint.proceed();
		
		//메소드 실행 이후에 들어감
		System.out.println("비즈니스 로직을 수행했습니다.");
		
		return obj;
	}
	
	//메소드를 하나 더 만들어서 select 메소드에 적용해 보세요.
	@Around("execution(public void select())")
	public Object PrintLog1(ProceedingJoinPoint joinPoint1) throws Throwable{
		System.out.println("비즈니스로직을 수행하기 직전입니다.");
		Object obj2 = joinPoint1.proceed();
		System.out.println("비즈니스 로직을 수행했습니다.");
		return obj2;
		
	}
}
