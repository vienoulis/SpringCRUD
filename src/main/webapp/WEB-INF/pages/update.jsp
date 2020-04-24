<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Update</h1>
<form method="post" action="/admin/update">
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
        <tr>
            <td>Password:</td>
            <td><input type="text" value="${userUpdated.password}" name="passwordToUpdate"></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <input type="checkbox" name="role_admin_update" value="ROLE_ADMIN"/> Admin
                <input type="checkbox" name="role_user_update" value="ROLE_USER"/> User
            </td>
        </tr>
    </table>
    <p>
        <input type="submit" name="doUpdate" value="Update">
    </p>
</form>

</body>
</html>
