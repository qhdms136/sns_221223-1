<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="h-100 header bg-info d-flex justify-content-between">
	<%-- logo --%>
	<div class="logo d-flex align-items-center">
		<h1 class="text-white ml-3">Marondalgram</h1>
	</div>
	
	<%-- 로그인 정보 --%>
	<div class="login-info d-flex align-items-end mb-3 mr-5">
		<%-- 로그인 정보 있을 때만 노출 --%>
		<c:if test="${not empty userName}">
			<span class="text-white">${userName}님 안녕하세요</span>
			<a href="/user/sign_out" class="ml-2 text-white font-weight-bold">로그아웃</a>
		</c:if>
		<%-- 비로그인 시 로그인 노출 --%>
		<c:if test="${empty userName}">
			<a href="/user/sign_in_view" class="text-white font-weight-bold">로그인</a>
		</c:if>
	</div>
</div>