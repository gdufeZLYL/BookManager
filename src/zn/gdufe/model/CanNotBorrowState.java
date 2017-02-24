package zn.gdufe.model;

/**
 * 不可借阅状态
 * @author zn
 *
 */
public class CanNotBorrowState extends AbstractState {
	public CanNotBorrowState() {

	}
	
	public CanNotBorrowState(AbstractState state) {
		this.studentInfo = state.studentInfo;
		this.stateName = "Can borrow!";
	}
	
	public CanNotBorrowState(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
		this.stateName = "Can borrow!";
	}
	
	@Override
	public void checkState(int newBookNum) {
		if(newBookNum < 2)studentInfo.setState(new CanBorrowState(this));
	}
	
	public String toString() {
		return "不可借阅";
	}
}
