<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

</head>
<body>

    <div class="login">
        <h1>приветствую тебя, ${sessionScope.userName}</h1>
    </div>
    <div>
        <h1>Пользователи</h1>
        <c:forEach var="usr" items="${users}">
            <p>${usr.name}</p>
        </c:forEach>
    </div>



</body>

</html>