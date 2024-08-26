package com.mst.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("proto")
@Scope("prototype")
public class Prototype {
	
	public int x=(int)(Math.random()*100);
	
	/*
	 * @PostConstruct public void init(){
	 * System.out.println(" Prototype is loaded..."); }
	 * 
	 * @PreDestroy public void destroy(){
	 * System.out.println(" Prototype is going down..."); }
	 */
}
