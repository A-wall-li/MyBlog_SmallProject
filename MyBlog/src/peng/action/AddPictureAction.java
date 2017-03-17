package peng.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import peng.service.AddPictureService;

// @author �����
public class AddPictureAction extends ActionSupport {

	private AddPictureService addPictureService;
	private File imgFile;// Struts2�Ὣ�ϴ��ɹ����ļ�����ֵ��������
	private String imgFileFileName;// ͨ�������Կɻ�ȡ���ϴ��ļ�������
	private String msg = "ͼƬ�ϴ�ʧ�ܣ�";

	public String getMsg() {
		return msg;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public void setAddPictureService(AddPictureService addPictureService) {
		this.addPictureService = addPictureService;
	}

	@Override
	public String execute() {// throws Exception
		if (imgFile == null || imgFileFileName == null) {
			msg = "û��ѡ���ļ���";
			return SUCCESS;
		}
		// �ж��ļ���ʽ
		boolean b = ".jpg".equals(imgFileFileName.substring(imgFileFileName.length() - 4));
		if (b) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(imgFile);
				int i = addPictureService.getPictureName();
				fos = new FileOutputStream("D:/�����/EclipseWorkspace/MyBlog/WebContent/images1/" + i + ".jpg");
				int data = 0;// ����һ�����桢��ȡ�ļ����ֽڵ���ʱ����
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}
				addPictureService.setPictureName(i);
				msg = "ͼƬ�ϴ��ɹ���";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			msg = "�ݲ�֧�ִ��ļ���ʽ";
		}
		return SUCCESS;
	}

	/**
	 * ������ת���ϴ�ҳ��ķ���
	 * 
	 * @return
	 * @author �����
	 */
	public String gotoPage() {
		msg = "";
		return SUCCESS;
	}
	// http://127.0.0.1:8080/MyBlog/addPicturePage.action
}
