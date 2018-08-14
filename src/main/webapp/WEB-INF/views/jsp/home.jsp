<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />
<head>
     <title>SimpleSpringLogin</title>
</head>
<body>
    <div></div>
    <div class="row">
      <h2> Hello, ${user.getName()} and you've logged in successfully '</h2>
       <a href="/login.jsp">log out</a>
    </div>

</body>
</html>