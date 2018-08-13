<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>
    <div></div>

    <div class="row">
      <h2> Hello : ${user.getName()}</h2>
       <a href="/login.jsp">log out</a>
    </div>

</body>
</html>