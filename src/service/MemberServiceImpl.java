package service;

import java.util.ArrayList;

import dao.MemberDaoImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{

	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImpl getInstance() {return instance;}

	MemberDaoImpl dao;
	
	@Override
	public void creatMember(MemberBean member) {
		System.out.println("맴버서비스 조인에 진입");
		System.out.println("===컨트롤러에서넘어온 회원정보===");
		System.out.println("ID :"+member.getId());
		System.out.println("NAME :"+member.getName());
		System.out.println("PASS :"+member.getPass());
		System.out.println("SSN :"+member.getSsn());
		dao.insertMember(member);
	}

	@Override
	public ArrayList<MemberBean> findMembersByList() {
		ArrayList<MemberBean> list =  new ArrayList<>();
		return list;
	}

	@Override
	public ArrayList<MemberBean> findMembersByName(String name) {
		ArrayList<MemberBean> list =  new ArrayList<>();
		return list;
	}

	@Override
	public MemberBean findMemberById(String id) {
		System.out.println("맴버서비스임플 id 찾기 들어옴 ===");
		return dao.selectMemberById(id);
	}

	@Override
	public int countMembers() {
		int count = 0;
		return count;
	}

	@Override
	public boolean existMember(String id, String pass) {
		MemberBean member = dao.selectMemberById(id);
		boolean exist = false;
		if(!(id.equals(member.getId())&&pass.equals(member.getPass()))) {
			exist = true;
		}else{
			exist = false;
		}
		
		return exist;
	}

	@Override
	public void changePass(String id, String pass, String newpass) {
	}

	@Override
	public void removeContent(String id, String pass) {
	}

}
