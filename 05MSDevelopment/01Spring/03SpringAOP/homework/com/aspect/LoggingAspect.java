package aop.com.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class LoggingAspect {

	
	//the logBefore() method will be executed before the execution of addCustomer method.
	@Before("execution(* aop.com.bean.Customer.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("logBefore() is running!");
		System.out.println("Amdocs Spring : " + joinPoint.getSignature().getName());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	
	//the logAfter() method will be executed after the execution of any invoked method
	@After("execution( * aop.com.bean.Customer.* (..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("*********************************************************");
		System.out.println("logAfter() is running!");
		System.out.println(" : " + joinPoint.getSignature().getName());
		System.out.println("*********************************************************");

	}
	
	
	// the logAfterReturning() method will be executed after the execution of Customer, 
	//addCustomerReturnValue() method. In addition, you can intercept the returned value with the returning attribute.
	 @AfterReturning(
		      pointcut = "execution(* aop.com.bean.Customer.addCustomerReturnValue(..))",
		      returning= "result")
		   public void logAfterReturning(JoinPoint joinPoint, Object result) {
		 	System.out.println("----------------------------------------------------");
			System.out.println("logAfterReturning() is running!");
			System.out.println("the  : " + joinPoint.getSignature().getName());
			System.out.println("Method returned value is : " + result);
			System.out.println("----------------------------------------------------");

		   }
	 
	 
	 //the logAfterThrowing() method will be executed if the customer,
	 //addCustomerThrowException() method is throwing an exception.
	 @AfterThrowing(
		      pointcut = "execution(* aop.com.bean.Customer.addCustomerThrowException(..))",
		      throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		 	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("logAfterThrowing() is running!");
			System.out.println("the : " + joinPoint.getSignature().getName());
			System.out.println("Exception : " + error);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

		    }	 
	 
	 @Around("execution(* aop.com.bean.Customer.addCustomerAround(..))")
	   public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		 System.out.println("/////////////////////////////////////////////////////////");
		System.out.println("logAround() is running!");
		System.out.println("Amdocs Around method : " + joinPoint.getSignature().getName());
		System.out.println("Amdocs Around arguments : " + Arrays.toString(joinPoint.getArgs()));
			
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
			
		System.out.println("/////////////////////////////////////////////////////////");
	   }

}
