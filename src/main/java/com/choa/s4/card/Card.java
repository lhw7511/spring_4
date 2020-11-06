package com.choa.s4.card;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@After("execution(* com.choa.s4.transfer.Taxi.take*(..))")
	public void cardCheck() {
		System.out.println("카드찍기");
		System.out.println("삑---------------------------");
	}
	@Around("execution(* com.choa.s4.transfer.*.take*(..))")
	public Object transferCard(ProceedingJoinPoint join) {
	      System.out.println("승차 전 카드 찍기");
	      
	      Object obj = null;
	      
	      try {
	    	  Object [] ar =join.getArgs();
	    	  
	         obj = join.proceed();
	      } catch (Throwable e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      System.out.println("하차시 카드 찍기");
	      
	      return obj;
	   }
}