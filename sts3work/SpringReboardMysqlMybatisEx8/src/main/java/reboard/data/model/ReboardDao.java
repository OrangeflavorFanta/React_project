package reboard.data.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReboardDao implements ReboardDaoInter {

	@Autowired
	private SqlSession session;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfReboard");
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("MaxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session.update("updateStepOfReboard", map);
	}

	@Override
	public void insertReboard(ReboardDto dto) {
		// TODO Auto-generated method stub
		
		int num=dto.getNum(); //0:���� 1:���
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) { //�� ���� ���
			
			regroup=getMaxNum()+1;  //num�� �ִ� ���� �ٰ�  ������ +1
			restep=0;
			relevel=0;	
		}else { //����� ���
			
			//���� �׷��߿��� ���� ���� restep���� ū �۵��� ��� +1
			updateRestep(regroup, restep);
			
			//���޹��� step�� level�� +1
			restep++;
			relevel++;
		}
		
		//�ٲ� ������ �ٽ� dto�� ��´�
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//insert
		session.insert("insertOfReboard", dto);
		
	}

	@Override
	public List<ReboardDto> getList(int start, int perpage) { //�Ķ���� �� 2�� �̻��̸� map���� �����ش�
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList("getAllPagingOfReboard", map );
	}

	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub
		session.update("updateReadCountOfReboard", num);
	}

	@Override
	public ReboardDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("gatDataOfReboard", num);
	}

	@Override
	public int getCheckPass(int num, int pass) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkEqualPassOfReboard", map);
	}

	@Override
	public void deleteReboard(int num) {
		// TODO Auto-generated method stubs
		
	 session.delete("deleteOfReboard", num);
	 
	}

	@Override
	public void updatereboard(ReboardDto dto) {
		// TODO Auto-generated method stub
		
		session.update("updateOfReboard",dto);
		
	}
	
	

}
