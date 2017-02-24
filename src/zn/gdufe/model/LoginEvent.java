package zn.gdufe.model;

import java.util.EventObject;

/**
 * 事件类LoginEvent
 * 应用:观察者模式
 * @author zn
 *
 */
public class LoginEvent {
	private String iden;
	
	public LoginEvent(String iden) {
		super();
		this.iden = iden;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}
	
}
