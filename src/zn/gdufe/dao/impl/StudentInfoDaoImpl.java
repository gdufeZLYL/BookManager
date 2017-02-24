package zn.gdufe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.dao.StudentInfoDao;
import zn.gdufe.model.StudentInfo;
import zn.gdufe.model.User;

public class StudentInfoDaoImpl implements StudentInfoDao {

	@Override
	public StudentInfo getStudentInfo(Connection con, String username)
			throws Exception {
		StudentInfo studentInfo = null;
		String sql = "select * from t_studentInfo where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			studentInfo = new StudentInfo();
			studentInfo.setId(rs.getInt("id"));
			studentInfo.setUsername(rs.getString("username"));
			studentInfo.setNickname(rs.getString("nickname"));
			studentInfo.setBookNum(rs.getInt("bookNum"));
			studentInfo.setMajor(rs.getString("major"));
		}
		return studentInfo;
	}

	@Override
	public int update(Connection con, StudentInfo studentInfo) throws Exception {
		String sql = "update t_studentInfo set username=?,nickname=?,bookNum=?,major=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, studentInfo.getUsername());
		ps.setString(2, studentInfo.getNickname());
		ps.setInt(3, studentInfo.getBookNum());
		ps.setString(4, studentInfo.getMajor());
		ps.setInt(5, studentInfo.getId());
		return ps.executeUpdate();
	}
	
	

}
