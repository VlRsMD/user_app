<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>CRUD Servlet</title>
</head>
<body>
<h1>Enter details to save in database</h1>
<form action="report" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form>
<br />
<a href="display">view users</a>
</body>
</html>
