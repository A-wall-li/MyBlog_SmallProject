package peng.filter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

// @author �����
public class LoginFilter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String s = (String) ServletActionContext.getRequest().getSession().getAttribute("loginInfo");
		if ("true".equals(s)) {
			// ��½���������ڡ����С��Ĳ���
			return arg0.invoke();
		} else {
			// δ��½�����ص�½ҳ��
			return "false";
		}
	}

}
