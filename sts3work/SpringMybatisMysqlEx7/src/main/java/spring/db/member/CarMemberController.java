package spring.db.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarMemberController {
	
	//sql (mapper) -> dao -> controller

	@Autowired
	CarMemberDao dao;
	
	@GetMapping("/member/list")
	public String list(Model model) {
		
		//��ü ����
		int totalCount=dao.getTotalCount();
		
		//��� ��������
		List<CarMemberDto> list=dao.getAllDatas();
		
		//Model�� ����� request�� ����
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
		
	}
	
	
	//�� ��� �Է� ������ ����
	@GetMapping("/member/writeform")
	public String memform() {
		
		return "carmember/writeform";
	}
	
	//insert
	@PostMapping("/member/write")
	public String insert(@ModelAttribute CarMemberDto dto) {
		
		dao.insertMymem(dto);
		return "redirect:list";
		
	}
	
	//���� ������ ����
	@GetMapping("/member/updateform")
	public String update (String num, Model model) {
		
		//dto��������
		CarMemberDto dto=dao.getData(num);
		
		//����
		model.addAttribute("dto", dto);
		
		return "carmember/updateform";
	}
	
	//update
	@PostMapping("/member/update")
	public String update(@ModelAttribute CarMemberDto dto) {
		
		dao.updateMyMem(dto);
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
