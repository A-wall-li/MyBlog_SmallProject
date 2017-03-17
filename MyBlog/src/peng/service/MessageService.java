package peng.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import peng.dao.MessageDao;
import peng.entity.Message;

// @author �����
@Transactional
public class MessageService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * �õ���������
	 * 
	 * @param page
	 * @return
	 * @author �����
	 */
	public List<Message> getPageMessage(int page) {
		return messageDao.getPageMessage(page);
	}

	/**
	 * �õ�������ҳ��
	 * 
	 * @return
	 * @author �����
	 */
	public int getMaxPage() {
		int i = messageDao.getCountMessage();
		return i % 3 == 0 ? i / 3 : i / 3 + 1;
	}

	/**
	 * ���һ������
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 * @author �����
	 */
	public String addMessage(String s1, String s2) {
		if ("".equals(s1) || "".equals(s2)) {
			return "����Ϊ�գ�";
		}
		if (messageDao.addMessage(s1, s2)) {
			return "���Գɹ���";
		} else {
			return "����ʧ�ܣ�";
		}
	}

	public void messageDele(int id) {
		messageDao.messageDele(id);
	}
}
