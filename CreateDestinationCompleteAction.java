package com.internousdev.laravel.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.laravel.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;


public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		String loginFlg = String.valueOf(session.get("login_flg"));
		if (loginFlg.equals("0")) {

			return "loginError";
		}

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		int resultCount = 0;

		String userId = session.get("user_id").toString();
		String familyName = session.get("family_name").toString();
		String firstName = session.get("first_name").toString();
		String familyNameKana = session.get("family_name_kana").toString();
		String firstNameKana = session.get("first_name_kana").toString();
		String email = session.get("email").toString();
		String telNumber = session.get("tel_number").toString();
		String userAddress = session.get("user_address").toString();

		resultCount = destinationInfoDAO.createDestination(userId, familyName, firstName, familyNameKana, firstNameKana, email, telNumber, userAddress);

		if (resultCount == 0) {

			return result;
		}

		session.remove("family_name");
		session.remove("first_name");
		session.remove("family_name_kana");
		session.remove("first_name_kana");
		session.remove("email");
		session.remove("tel_number");
		session.remove("user_address");

		result = SUCCESS;
		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
