package reanswer.data.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reboard.data.model.ReboardDao;
import reboard.data.model.ReboardDaoInter;
import reboard.data.model.ReboardDto;

@RestController
public class AnswerRestController {
	
	
	@Autowired
	ReanswerDao adao;
	
	@Autowired
	ReboardDaoInter dao; 
	
	@GetMapping("/board/adelete")//ajax mapping�ּ�, ajax��  url�� ��ġ
	public HashMap<String, Integer> answerDelete(@RequestParam int idx,
			@RequestParam String pass){//��Ƽ���� 0,1�� ���޵Ǿ�� �ϱ� ������ integer���°���
		
		int check=adao.getCheckPass(idx, pass);
		
		if(check==1) {//����� ���� ��� ��� ����
			adao.deleteAnswer(idx);
		}
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("check", check);
		
		return map;
		
	}
	
	
	/*
	 * //ajax������ ���� ��� ����
	 * 
	 * @GetMapping("/rest/list") public List<ReboardDto> ajaxlist(){
	 * List<ReboardDto> list=dao.getAlldatas();
	 * 
	 * for(ReboardDto dto:list) { if(!dto.getPhoto().equals("no")) { String []
	 * photos=dto.getPhoto().split(","); dto.setPhoto(photo[0]);//������ ù��° �������� �ֱ�
	 * 
	 * } }
	 * 
	 * return list; }
	 */
	
	
	
	
	
		
	
}
