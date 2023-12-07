<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>b8.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>이곳은 btom폴더의 b8.jsp 입니다.</h2>
  <hr/>
  <p>
  	<a href="${ctp}/" class="btn btn-success">홈으로</a> |
  	<a href="${ctp}/ctom/c1Service" class="btn btn-primary">c1호출</a> |
  	<a href="${ctp}/ctom/c1Service2" class="btn btn-primary">c1호출2</a> |
  </p>
</div>
<p><br/></p>
</body>
</html>