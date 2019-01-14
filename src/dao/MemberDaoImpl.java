package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.MemberBean;
import factory.DatabaseFactory;
import pool.Constant;

public class MemberDaoImpl implements MemberDao {
	private static MemberDaoImpl instance = new MemberDaoImpl();
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {return instance;}

	private ResultSet rs;

	@Override
	public void insertMember(MemberBean member) {

		try {
			System.out.println("insert Member 진입 !!!");
			DatabaseFactory.createDatabase("oracle").getConnection().createStatement().executeUpdate(
					String.format("INSERT INTO member(id, name, pass, ssn)\n" + "VALUES('%s', '%s', '%s', '%s')",
					member.getId(), member.getName(), member.getPass(), member.getSsn()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<MemberBean> selectMembersByList() {
		ArrayList<MemberBean> list = new ArrayList<>();
		try {
			String sql = "";
			rs = DatabaseFactory.createDatabase("oracle").getConnection().createStatement().executeQuery(sql);
			while (rs.next()) {
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ArrayList<MemberBean> selectMembersByName(String name) {
		ArrayList<MemberBean> list = new ArrayList<>();
		try {
			String sql = "";
			rs = DatabaseFactory.createDatabase("oracle").getConnection().createStatement().executeQuery(sql);
			while (rs.next()) {
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public MemberBean selectMemberById(String id) {
		MemberBean member = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase("oracle").getConnection().createStatement()
					.executeQuery(String.format("SELECT * FROM member\n" + "WHERE id LIKE '%s'", id));
			while (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setSsn(rs.getString("ssn"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public int countMembers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatePass(String id, String pass, String newpass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContent(String id, String pass) {
		// TODO Auto-generated method stub

	}

}
