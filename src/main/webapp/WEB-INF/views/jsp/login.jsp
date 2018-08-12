<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>
    <div></div>

    <div class="row">
        <form id="login", method="get", action="/go">
            <div class="small-3 columns">
                <input type="text"  name="username" >
            </div>

            <div class="small-3 columns">
                <input type="password"  name="password" >
            </div>

            <div class="small-5 columns end">
                <button id="button-id" type="submit">Search Teams</button>
            </div>




        </form>
        <h3>
            ${error}
        </h3>
    </div>

</body>
</html>