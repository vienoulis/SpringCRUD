<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Update</h1>
<form method="post" action="/update">
    <table>
        <tr>
            <input type="hidden" name="userId" value="${userUpdated.id}">
            <td>Name:</td>
            <td><input type="text" value="${userUpdated.name}" name="nameToUpdate"></td>
        </tr>
        <tr>/
            <td>Age:</td>
            <td><input type="number" value="${userUpdated.age}" name="ageToUpdate"></td>
        </tr>
    </table>
    <p>
        <input type="submit" name="doUpdate" value="Update">
    </p>
</form>

</body>
</html>
