<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录页面</title>
	<link rel="stylesheet" type="text/css" href='<s:url value="/styles.css" />'>
</head>
<body>
	<s:include value="/header.jsp" />
	<s:if test="#session['user'] != null">
			<div class="divNavigatorOuterFrame">
				<div class="divNavigatorInnerFrame" style="text-align: right;">
					欢迎你,<s:property value="#session['user'].nickName" />&nbsp;&nbsp;
				</div>
				<%-- 
				<div class="divNavigatorInnerFrame" style="text-align: right;">
					<s:a action="SignInAction_logOut.do" namespace="/">登出</s:a>
				</div>
				--%> 
			</div>
			<div class="divWhiteLine"></div>
	</s:if>
	<s:form action="SignInAction_signIn" namespace="/" method="post">
		<table>
			<tr>
				<td colspan="2" class="tdWhiteLine"></td>
			</tr>
			<tr>
				<td class="tdHeader" colspan="2">用户登录</td>
			</tr>
			<tr>
				<td class="tdFormLabel">邮 　&nbsp; 箱:</td>
				<td class="tdFormControl">
					<s:textfield name="email" cssClass="text" />
					<font class="fonterror"><br><s:actionerror></s:actionerror></font>
				</td>
			</tr>
			<tr>
				<td class="tdFormLabel">密 　&nbsp; 码:</td>
				<td class="tdFormControl">
					<s:password name="password" cssClass="text" />
				</td>
			</tr>
			<tr>
				<td class="tdFormLabel"></td>
				<td class="tdFormControl"><s:submit cssClass="btn" value="登录"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>