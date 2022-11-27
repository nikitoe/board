<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <button class="btn btn-secondary" onclick="history.back()">Back</button>
    <c:if test="${boards.user.id == principal.user.id}">
        <a href="/board/${boards.id}/updateForm" class="btn btn-warning">Modify</a>
        <button onclick="index.deleteById(${boards.id})" class="btn btn-danger">Delete</button>
    </c:if>
    <br><br>
    <div>
        Post ID : <span id="id"><i>${boards.id}</i></span>
        Post Writer : <span><i>${boards.user.username}</i></span>
    </div>
    <div class="form-group">
        <h3>${boards.title}</h3>
    </div>
    <div class="form-group">
        <span class="label label-info">${boards.category}</span>
    </div>
    <hr>
    <div class="form-group">
        <div>${boards.content}</div>
    </div>

</div>
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>