package zn.gdufe.model;

public class StudentInfo {
	private int id;			//编号
	private String username;//学号(用户名)
	private String nickname;//姓名
	private int bookNum;	//当前借阅书本数量
	private String major;	//专业
	
	private AbstractState state;
	
	
	public AbstractState getState() {
		return state;
	}
	public void setState(AbstractState state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
