package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ex1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("������ �ڹٹ�� ȣ��");
		MessageInter m1= new Message1();
		m1.sayHello("����");
		
		MessageInter m2=new Message2();
		m2.sayHello("����");
		
		System.out.println("������ ������� ��ü ���� �� ȣ��");
		ApplicationContext context=new ClassPathXmlApplicationContext("appcontext1.xml");
		
		MessageInter m3=(Message1)context.getBean("mesBean1");//ȣ���� 1
		m3.sayHello("����Ŭ");
		
		MessageInter m4=context.getBean("mesBean2",	Message2.class);
		m4.sayHello("�޸�");
		
	}

}
