<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/createDestination.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>宛先情報入力画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">

		<div id="top">
			<h1>宛先情報入力画面</h1>
		</div>

		<s:if test = "familyNameErrorList.size() > 0">
			<div class="error">
			<s:iterator value="familyNameErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test= "firstNameErrorList.size() > 0">
			<div class="error">
				<s:iterator value="firstNameErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test = "familyNameKanaErrorList.size() > 0">
			<div class="error">
				<s:iterator value="familyNameKanaErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test = "firstNameKanaErrorList.size() > 0">
			<div class="error">
				<s:iterator value="firstNameKanaErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test = "addressErrorList.size() > 0">
			<div class="error">
				<s:iterator value="addressErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test = "telNumErrorList.size()>0">
			<div class="error">
				<s:iterator value="telNumErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test = "emailErrorList.size() > 0">
			<div class="error">
				<s:iterator value="emailErrorList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>


		<div id="contents">
		<s:form action="CreateDestinationConfirmAction">
			<table>
				<tr>
					<th>姓</th>
					<td><s:textfield name="familyName" value="%{session.family_name}" placeholder="姓" size="50"/></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:textfield name="firstName" value="%{session.first_name}" placeholder="名" size="50"/></td>
				</tr>
				<tr>
					<th>姓ひらがな</th>
					<td><s:textfield name="familyNameKana" value="%{session.family_name_kana}" placeholder="姓ふりがな" size="50"/></td>
				</tr>
				<tr>
					<th>名ひらがな</th>
					<td><s:textfield name="firstNameKana" value="%{session.first_name_kana}" placeholder="名ふりがな" size="50"/></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><s:textfield name="userAddress" value="%{session.user_address}" placeholder="住所" size="50"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:textfield name="telNumber" value="%{session.tel_number}" placeholder="電話番号" size="50"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:textfield name="email" value="%{session.email}" placeholder="メールアドレス" size="50"/></td>
				</tr>
			</table>
			<s:submit value="確認" class="submit"/>
		</s:form>
		</div>

	</div>
</body>
</html>