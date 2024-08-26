package com.mst;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mst.beans.Prototype;
import com.mst.beans.Singleton;
import com.mst.beans.SingletonLazy;
import com.mst.config.Config;

public class Runner {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		System.out.println("*************************");
		
		Prototype p1 = ctx.getBean("proto", Prototype.class);
		Prototype p2 = ctx.getBean("proto", Prototype.class);
		
		System.out.println("Proto 1,randnum="+p1.x);
		System.out.println("Proto 2,randnum="+p2.x);
		
		
		Singleton s1 = ctx.getBean(Singleton.class);
		Singleton s2 = ctx.getBean(Singleton.class);
		System.out.println("----------------------");
		
		System.out.println("Single 1,randnum="+s1.x);
		System.out.println("Single 2,randnum="+s2.x);
		
		
		SingletonLazy sl1 = ctx.getBean(SingletonLazy.class);
		}

}
