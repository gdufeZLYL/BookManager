package zn.gdufe.model;

/**
 * 具体观察类LoginValidator
 * 应用:观察者模式
 * @author zn
 *
 */
public class LoginValidator implements LoginEventListener {

	@Override
	public int validateLogin(LoginEvent event) {
		if(event.getIden().equals("admin"))return 1;
		return 2;
	}

}
