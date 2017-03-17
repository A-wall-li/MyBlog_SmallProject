package peng.action;

import com.opensymphony.xwork2.ActionSupport;
import peng.entity.UserInfo;
import peng.service.AboutMeService;

// @author �����
public class AboutMeAction extends ActionSupport {

	private AboutMeService aboutMeService;
	private UserInfo my;

	public UserInfo getMy() {
		return my;
	}

	public void setAboutMeService(AboutMeService aboutMeService) {
		this.aboutMeService = aboutMeService;
	}

	@Override
	// http://127.0.0.1:8080/MyBlog/aboutMe.action
	public String execute() throws Exception {
		this.my = aboutMeService.getMyInfo();
		return SUCCESS;
	}

	/*------------------���´���ʵ�ָ�����Ϣ�޸Ĺ���------------------*/
	private String realName;
	private String sex;
	private String birth;
	private String email;
	private String tell;
	private String qq123;
	private String selfIntroduction;

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public void setQq123(String qq123) {
		this.qq123 = qq123;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public String aboutMeUpdate() {
		this.my = aboutMeService.getMyInfo();
		if (this.realName == null) {// û���ύҪ�޸ĵ����ݣ���һ�η���
			return "success1";
		} else {
			my.setRealName(realName);
			my.setSex(sex);
			my.setBirth(birth);
			my.setEmail(email);
			my.setTell(tell);
			my.setqQNum(qq123);
			my.setSelfIntroduction(selfIntroduction);
			aboutMeService.aboutMeUpdate(my);
			this.realName = null;
			return "success2";
		}
	}

}
