package peng.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import peng.entity.Article;
import peng.service.ArticleService;

// @author �����
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private ArticleService articleService;
	private List<Article> list;
	private int id;
	private Article article;

	public Article getArticle() {
		return article;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Article> getList() {
		return list;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public String execute() throws Exception {
		this.list = articleService.getAllArticle();
		return SUCCESS;
	}

	/**
	 * �õ�һƪ����
	 * 
	 * @return
	 * @author �����
	 */
	public String getOneArticle() {
		this.article = articleService.getOneArticle(this.id);
		return "OneArticle";
	}

	/*--------------------���´���ʵ�������޸ĺ�����--------------------*/
	private Integer typeId;
	private Article newArticle = new Article();// ģ�ͷ�װ

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public Article getModel() {
		return newArticle;
	}

	/**
	 * ����༭ҳ��
	 * 
	 * @return
	 * @author �����
	 */
	public String articleUpdatePage() {
		if (typeId > 0) {
			// ����һƪ�����±༭ҳ��
			this.article = articleService.getOneArticle(typeId);
		} else {
			// ���뷢�������µ�ҳ��
			this.article = null;
		}
		return SUCCESS;
	}

	public String articleUpdate() {
		articleService.articleUpdate(this.newArticle);
		return "Update";
	}

	/*--------------------���´���ʵ������ɾ��--------------------*/
	private int delID;

	public void setDelID(int delID) {
		this.delID = delID;
	}

	public String articleDelete() {
		if (delID < 1) {
			return "Delete";
		}
		articleService.articleDelete(delID);
		return "Delete";
	}

}
