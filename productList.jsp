<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./css/productList.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>商品一覧画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">

		<div id="top">
			<h1>商品一覧画面</h1>
		</div>

		<!-- エラーメッセージがあった場合はエラーを表示 -->

		<s:if test="searchWordCheckList.size() != 0">
			<div class="error">
				<s:iterator value="searchWordCheckList">
					<div><s:property /></div>
				</s:iterator>
			</div>
		</s:if>

		<div id="contents">

			<!-- 検索結果及び全商品一覧 -->
			<s:elseif
				test="productInfoDTOList.size() != 0 && searchWordCheckList.size() == 0 && productInfoDTOList != null">
				<s:iterator value="productInfoDTOList">
					<table>
						<!-- 商品写真 -->
						<tr>
							<td class="image"><a
								href='<s:url action= "ProductDetailsAction">
						<s:param name="productId" value="%{productId}"/>
						</s:url>'><img
									src='<s:property value="imagineFilePath"/><s:property value="imagineFileName"/>'
									width="40" height="60" /></a></td>
						</tr>
						<!-- 商品名 -->
						<tr>
							<td><s:property value="productName" /></td>
						</tr>
						<!-- 商品名ひらがな -->
						<tr>
							<td><s:property value="productNameKana" /></td>
						</tr>
						<!-- 値段 -->
						<tr>
							<td><s:property value="price" />円</td>
						</tr>
					</table>
				</s:iterator>
			</s:elseif>

			<!-- 検索結果なしメッセージ -->
			<s:else>
				<div class="info">
					<s:property value="searchResultNull" />
				</div>
			</s:else>
		</div>
	</div>
</body>
</html>
