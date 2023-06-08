package spring.anno.ex4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic")//logicContoller �̸����� ��� @Component("name")�� �־ �ȴ�
public class LogicContloller {
	
	//@Autowired
	@Resource(name="myDao")//��Ȯ�� ���� ���̵�� ����_��ȣ���� ���� ��
	DaoInter daoInter;
	
	public LogicContloller(MyDao dao) {
		this.daoInter=dao;
	}
	
	//insert
	public void insert(String str) {
		daoInter.insertData(str);
		
	}
	
	public void delete(String num) {
		daoInter.deleteData(num);
	}

}
