package zn.gdufe.model;

/**
 * 可借阅状态
 * @author zn
 *
 */
public class CanBorrowState extends AbstractState {
	
	public CanBorrowState() {

	}
	
	public CanBorrowState(AbstractState state) {
		this.studentInfo = state.studentInfo;
		this.stateName = "Can borrow!";
	}
	
	public CanBorrowState(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
		this.stateName = "Can borrow!";
	}
	
	@Override
	public void checkState(int newBookNum) {
		if(newBookNum >= 2)studentInfo.setState(new CanNotBorrowState(this));
	}
	
	public String toString(){
		return "可借阅状态";
	}
}
