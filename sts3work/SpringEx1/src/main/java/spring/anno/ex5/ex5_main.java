package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ex5_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//������̼� ������ ������ּ���..
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext.xml");
		
		MysqlContoller cont=(MysqlContoller)app.getBean("mysqlcont");
		
		cont.insert("��ȯ��");
		cont.delete("2");
		cont.selete("���Ѱ�");
		
	}

}
