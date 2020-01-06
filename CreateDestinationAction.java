package com.internousdev.laravel.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;
		String loginFlg = String.valueOf(session.get("login_flg"));

		if (loginFlg.equals("0")) {
			result = "loginError";
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
