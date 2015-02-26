<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加logo页面</title>
<link rel="stylesheet" type="text/css" href='<s:url value="/styles.css" />'>
</head>
<body>
	<s:include value="/header.jsp" />
	<table>
			<tr>
				<td class="tdHeader">增加LOGO:</td>
			</tr>
			<tr>
				<td style="vertical-align: top;">
					<table>
						<tr>
							<td>
								<s:form action="SurveyAction_doAddLogo" method="post" enctype="multipart/form-data">
								<s:hidden name="sid" />
								<table>
									<tr>
										<td class="tdFormLabel">选择LOGO:</td>
										<td class="tdFormControl">
											<s:file name="logoPicture" cssClass="text" />
											<s:fielderror fieldName="logoPicture"></s:fielderror>
										</td>
									</tr>
									<tr>
										<td class="tdFormLabel"></td>
										<td class="tdFormControl"><s:submit value="%{'确定'}" cssClass="btn" /></td>
									</tr>
								</table>
								</s:form>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>	
</body>
</html>