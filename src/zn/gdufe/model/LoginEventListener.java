package zn.gdufe.model;

import java.util.EventListener;

/**
 * 抽象观察者LoginEventListener(登录事件监听器)
 * 应用:观察者模式
 * @author zn
 *
 */
public interface LoginEventListener{
	public int validateLogin(LoginEvent event);	//	声明响应方法
}
