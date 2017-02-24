package zn.gdufe.dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Dao工厂类
 * 应用:单例模式,工厂模式
 * @author zn
 *
 */
public class DaoFactory {
	private static UserDao userDao = null;
	private static BookDao bookDao = null;
	private static BookTypeDao bookTypeDao = null;
	private static StudentInfoDao studentInfoDao = null;
	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory(){
		try {
			Properties prop = new Properties();
			//InputStream inStream = new FileInputStream(new File("src/daoconfig.properties"));
			InputStream inStream = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
			prop.load(inStream);
			
			String userDaoClass = prop.getProperty("userDaoClass");
			Class clazz1 = Class.forName(userDaoClass);
			userDao = (UserDao)clazz1.newInstance();
			
			String bookDaoClass = prop.getProperty("bookDaoClass");
			Class clazz2 = Class.forName(bookDaoClass);
			bookDao = (BookDao)clazz2.newInstance();
			
			String bookTypeDaoClass = prop.getProperty("bookTypeDaoClass");
			Class clazz3 = Class.forName(bookTypeDaoClass);
			bookTypeDao = (BookTypeDao)clazz3.newInstance();
			
			String studentInfoDaoClass = prop.getProperty("studentInfoDaoClass");
			Class clazz4 = Class.forName(studentInfoDaoClass);
			studentInfoDao = (StudentInfoDao)clazz4.newInstance();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	public static UserDao getUserDao(){
		return userDao;
	}
	public static BookDao getBookDao(){
		return bookDao;
	}
	public static BookTypeDao getBookTypeDao(){
		return bookTypeDao;
	}
	public static StudentInfoDao getStudentInfoDao(){
		return studentInfoDao;
	}
}
