package zn.gdufe.dao;

import java.sql.Connection;

import zn.gdufe.model.StudentInfo;


public interface StudentInfoDao {
	/**
	 * 查找指定学号的学生信息
	 * @param con
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public StudentInfo getStudentInfo(Connection con, String username) throws Exception;
	
	/**
	 * 更新学生信息
	 * @param con
	 * @param studentInfo
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, StudentInfo studentInfo) throws Exception;
}
