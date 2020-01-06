<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/createDestination.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>宛先情報入力確認画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">

		<div id="top">
			<h1>宛先情報入力確認画面</h1>
		</div>


		<div id="contents">
		<s:form action="CreateDestinationCompleteAction">
			<table>
				<tr>
					<th>姓</th>
					<td><s:property value="%{session.family_name}"/></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:property value="%{session.first_name}"/></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><s:property value="%{session.family_name_kana}"/></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><s:property value="%{session.first_name_kana}"/></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><s:property value="%{session.user_address}"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:property value="%{session.tel_number}"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="%{session.email}"/></td>
				</tr>
			</table>
			<s:submit value="登録" class="submit"/>
		</s:form>

		<s:form action= "CreateDestinationAction">
			<s:submit value="戻る" class="submit"/>
		</s:form>
		</div>
	</div>
</body>
</html>