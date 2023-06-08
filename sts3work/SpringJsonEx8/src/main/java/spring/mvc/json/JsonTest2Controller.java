package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//json�����̹Ƿ� �Ϲ� �޼��� �ȵ�
public class JsonTest2Controller {

	@GetMapping("/list2")
	public List<PhotoDto > list2()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("������ġ", "1.jpg"));
		list.add(new PhotoDto("��ġ", "2.jpg"));
		list.add(new PhotoDto("��ġ�쵿", "3.jpg"));
		list.add(new PhotoDto("��Ʃ", "4.jpg"));
		list.add(new PhotoDto("������", "5.jpg"));
		
		return list;
		
	}
	
	
	@GetMapping("/list3")
	public Map<String, Object> list3(@RequestParam String name){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("������ġ", "1.png"));
		list.add(new PhotoDto("��ġ����", "2.png"));
		list.add(new PhotoDto("�׶���", "5.png"));
		list.add(new PhotoDto("�������", "11.png"));
		list.add(new PhotoDto("�������", "9.png"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(PhotoDto dto:list)
		{
			if(name.equals(dto.getName())) {
				map.put("name", dto.getName());
				map.put("photo",dto.getPhoto());
			}
		}
		
		return map;
	}
	
	
}
