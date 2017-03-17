package peng.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import peng.entity.Message;
import peng.service.MessageService;

// @author �����
public class MessageAction extends ActionSupport {

	private MessageService messageService;
	private int page;// ҳ���ύ����������
	private int p;// ���ص�ҳ�������
	private int maxPage;
	private List<Message> listInfo;

	public int getMaxPage() {
		return maxPage;
	}

	public List<Message> getListInfo() {
		return listInfo;
	}

	public int getP() {
		return p;
	}

	public void setPage(int page) {
		this.maxPage = messageService.getMaxPage();
		if (page < 0) {
			this.page = 0;
		} else if (page > (this.maxPage - 1)) {
			this.page = this.maxPage - 1;
		} else {
			this.page = page;
		}
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	// http://127.0.0.1:8080/MyBlog/message.action?page=0
	public String execute() throws Exception {
		if (this.maxPage == 0) {
			this.maxPage = messageService.getMaxPage();
		}
		this.listInfo = messageService.getPageMessage(this.page);
		this.p = this.page;
		return SUCCESS;
	}

	/*--------------------���´���ʵ��������Թ���--------------------*/
	private String name;
	private String textarea;
	private String msg;// �����Ƿ���ӳɹ�����Ϣ

	public String getMsg() {
		return msg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	/**
	 * �������
	 * 
	 * @return
	 * @author �����
	 */
	public String addMessage() {
		this.msg = messageService.addMessage(this.name, this.textarea);
		this.listInfo = messageService.getPageMessage(0);
		this.p = 0;
		if (this.maxPage == 0) {
			this.maxPage = messageService.getMaxPage();
		}
		return SUCCESS;
	}

	/*--------------------���´���ʵ������ɾ������--------------------*/

	private int delId;

	public void setDelId(int delId) {
		this.delId = delId;
	}

	/**
	 * ������ת�����Ա༭ҳ��
	 * 
	 * @return
	 * @author �����
	 */
	public String messageSet() {
		if (this.maxPage == 0) {
			this.maxPage = messageService.getMaxPage();
		}
		this.listInfo = messageService.getPageMessage(this.page);
		this.p = this.page;
		return SUCCESS;
	}

	/**
	 * ɾ��һ������
	 * 
	 * @return
	 * @author �����
	 */
	public String messageDele() {
		messageService.messageDele(delId);
		return SUCCESS;
	}
}
