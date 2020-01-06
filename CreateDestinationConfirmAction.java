package com.internousdev.laravel.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.laravel.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {

	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	private Map<String, Object> session;
	private List<String> familyNameErrorList = new ArrayList<String>();
	private List<String> firstNameErrorList = new ArrayList<String>();
	private List<String> familyNameKanaErrorList = new ArrayList<String>();
	private List<String> firstNameKanaErrorList = new ArrayList<String>();
	private List<String> addressErrorList = new ArrayList<String>();
	private List<String> telNumErrorList = new ArrayList<String>();
	private List<String> emailErrorList = new ArrayList<String>();


	public String execute() throws SQLException {

		String tempUserAddress = "";
		String result = SUCCESS;

		if (StringUtils.isBlank(userAddress)) {
			tempUserAddress = "@@@";

		}else {
			tempUserAddress = userAddress;

		}

		session.put("family_name", familyName);
		session.put("first_name", firstName);
		session.put("family_name_kana", familyNameKana);
		session.put("first_name_kana", firstNameKana);
		session.put("email", email);
		session.put("tel_number", telNumber);
		session.put("user_address", userAddress);

		String loginFlg = String.valueOf(session.get("login_flg"));

		if (loginFlg.equals("0")) {

			result ="loginError";
			return result;
		}

		InputChecker inputChecker = new InputChecker();
		familyNameErrorList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, true, false);
		firstNameErrorList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, true, false);
		familyNameKanaErrorList = inputChecker.doCheck("姓ひらがな", familyNameKana, 1, 16, false, false, true, false, false, false);
		firstNameKanaErrorList = inputChecker.doCheck("名ひらがな", firstNameKana, 1, 16, false, false, true, false, false, false);
		addressErrorList = inputChecker.doCheck("住所", tempUserAddress, 10, 50, true, true, true, true, true, true);
		telNumErrorList = inputChecker.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false);
		emailErrorList  = inputChecker.doCheckForEmail("メールアドレス", email , 10, 32);

		if (familyNameErrorList.size() > 0 || firstNameErrorList.size() > 0
				|| familyNameKanaErrorList.size() > 0 || firstNameKanaErrorList.size() > 0
				|| addressErrorList.size() > 0 || telNumErrorList.size() > 0
				|| emailErrorList.size() > 0 ){

			result = ERROR;
			return result;
		}

		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public List<String> getFamilyNameErrorList() {
		return familyNameErrorList;
	}

	public void setFamilyNameErrorList(List<String> familyNameErrorList) {
		this.familyNameErrorList = familyNameErrorList;
	}

	public List<String> getFirstNameErrorList() {
		return firstNameErrorList;
	}

	public void setFirstNameErrorList(List<String> firstNameErrorList) {
		this.firstNameErrorList = firstNameErrorList;
	}

	public List<String> getFamilyNameKanaErrorList() {
		return familyNameKanaErrorList;
	}

	public List<String> getFirstNameKanaErrorList() {
		return firstNameKanaErrorList;
	}

	public void setFirstNameKanaErrorList(List<String> firstNameKanaErrorList) {
		this.firstNameKanaErrorList = firstNameKanaErrorList;
	}

	public void setFamilyNameKanaErrorList(List<String> familyNameKanaErrorList) {
		this.familyNameKanaErrorList = familyNameKanaErrorList;
	}

	public List<String> getAddressErrorList() {
		return addressErrorList;
	}

	public void setAddressErrorList(List<String> addressErrorList) {
		this.addressErrorList = addressErrorList;
	}

	public  List<String> getTelNumErrorList() {
		return telNumErrorList;
	}

	public void setTelNumErrorList (List<String> telNumErrorList) {
		this.telNumErrorList = telNumErrorList;
	}

	public List<String> getEmailErrorList() {
		return emailErrorList;
	}

	public void setEmailErrorList(List<String> emailErrorList) {
		this.emailErrorList = emailErrorList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}