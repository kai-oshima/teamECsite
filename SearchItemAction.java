package com.internousdev.laravel.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.laravel.dao.MCategoryDAO;
import com.internousdev.laravel.dao.ProductInfoDAO;
import com.internousdev.laravel.dto.MCategoryDTO;
import com.internousdev.laravel.dto.ProductInfoDTO;
import com.internousdev.laravel.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	//ヘッダーから入力されたカテゴリーIDと検索ワード
	private int categoryId;
	private String searchWord;
	private String searchResultNull = "";

	private String searchWordTrim;
	private Map<String, Object> session;
	private List<String> searchWordCheckList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private ProductInfoDTO dto = new ProductInfoDTO();

	public String execute() throws SQLException {

		String result = SUCCESS;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();

		//カテゴリー全てと商品一覧のカテゴリーパラメーターを統一
		if (categoryId == 1 || categoryId == 0) {
			categoryId = 0;
		}

		//検索ワードがある場合
		if (!StringUtils.isBlank(searchWord)) {

			//検索ワードに前後の空欄があった場合、削除。
			//また全角スペース2個スペースを半角に変換
			searchWord = searchWord.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();

			//inputCheckerを行い結果をListに入れる
			InputChecker inputCheckerDAO = new InputChecker();

			searchWordCheckList = inputCheckerDAO.doCheck("検索ワード", searchWord, 0, 50, true, true, true, true, true, true);

			//エラーメッセージがlistに入っていた場合は結果をstruts.xmlに返す。
			if(searchWordCheckList.size() != 0) {
				return result;
			}

			productInfoDTOList = productInfoDAO.getSearchItemCategory(searchWord.split(" "),searchWord.split(" "),categoryId);

		} else {

			//検索ワードが入力されていない場合、かつ検索されていないもしくはカテゴリーのみ選択されている場合
			productInfoDTOList = productInfoDAO.getSearchProduct(categoryId);
		}

		//検索結果がない場合は検索結果なしメッセージをセットする
		if (productInfoDTOList.size() == 0) {

			setSearchResultNull("検索結果がありません。");
		}

		//カテゴリー保持をチェック
		//カテゴリーが保持されていない場合は保持をする(jspのプルダウンに入れる）
		if (!session.containsKey("mCategoryDTOList")) {
			List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
			MCategoryDAO mCategoryDAO = new MCategoryDAO();

			//カテゴリー保持を行う
			mCategoryDTOList = mCategoryDAO.getCategory();
			session.put("mCategoryDTOList",mCategoryDTOList);
		}

		//必要ないセッション情報を削除
		session.remove("family_name");
		session.remove("first_name");
		session.remove("family_name_kana");
		session.remove("first_name_kana");
		session.remove("email");
		session.remove("tel_number");
		session.remove("user_address");

		return result;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchWordTrim() {
		return searchWordTrim;
	}

	public void setSearchWordTrim(String searchWordTrim) {
		this.searchWordTrim = searchWordTrim;
	}

	public String getSearchResultNull() {
		return searchResultNull;
	}

	public void setSearchResultNull(String searchResultNull) {
		this.searchResultNull = searchResultNull;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getSearchWordCheckList() {
		return searchWordCheckList;
	}

	public void setSearchWordCheckList(List<String> searchWordCheckList) {
		this.searchWordCheckList = searchWordCheckList;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public ProductInfoDTO getDto() {
		return dto;
	}

	public void setDto(ProductInfoDTO dto) {
		this.dto = dto;
	}
}
