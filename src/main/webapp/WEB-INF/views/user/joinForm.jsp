<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="from-group">
            <label for="username">User Name</label>
            <input type="username" class="form-control" placeholder="Enter username" id="username"
                    aria-describedby="resultUsername"/>
            <p id="resultUsername">
                Must be length is more than 4
            </p>
        </div>
        <div class="from-group">
            <label for="password">Password</label>
            <input type="Password" class="form-control" placeholder="Enter password" id="password"
                    aria-describedby="resultPassword"/>
            <p id="resultPassword">
                Must be 8-20 characters long.
            </p>
        </div>
        <div class="from-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email"
                    aria-describedby="resultEmail"/>
            <p id="resultEmail">
                Must be (your email id)@(your email domain)
            </p>
        </div>

    </form>
    <button id="btn-save" class="btn btn-primary">Sign-up</button>

</div>
<script src="/js/user.js" type="text/javascript"></script>
<%@ include file="../layout/footer.jsp" %>