package com.mst.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Singleton {

	public int x = (int)(Math.random()*100);
	
	
	@PostConstruct
	public void init(){
		System.out.println(" Singleton is loaded...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println(" Singleton is going down...");
	}

}
