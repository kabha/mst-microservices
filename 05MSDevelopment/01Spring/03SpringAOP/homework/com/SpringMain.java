package aop.com;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aop.com.model.Customer;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"aop.com"})
public class SpringMain {

	public static void main(String[] args) throws Exception {
		
				// initiate IOC Container
				AnnotationConfigApplicationContext ctx=new 
						AnnotationConfigApplicationContext(SpringMain.class);
				
				//prototype Bean , instance is created per getBean call. 
				Customer customer = (Customer)ctx.getBean("customerBean");
				
				customer.addCustomer();
				
				customer.addCustomerReturnValue();
				
				customer.addCustomerThrowException();
				
				
				customer.addCustomerAround("Hello Dauod");
				
				//Bean life cycle , method predestroy is called just incase that you kill the context 
				ctx.close();
				ctx.registerShutdownHook();
				System.out.println("Spring Context Closed");
	}

}

