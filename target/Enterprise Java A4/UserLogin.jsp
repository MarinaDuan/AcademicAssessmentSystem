<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 2022/4/10
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please select the according role to log in</title>
</head>
<body>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
        Dropdown
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><button class="dropdown-item" type="button">HOD</button></li>
            <li><button class="dropdown-item" type="button">Instructor</button></li>
            <li><button class="dropdown-item" type="button">Student</button></li>
        </ul>
    </div>
    <div class="dropdown-menu">
        <form class="px-4 py-3">
            <div class="mb-3">
                <label for="exampleDropdownFormEmail1" class="form-label">UserID</label>
                <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="User ID">
            </div>
            <div class="mb-3">
                <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
            </div>
            <div class="mb-3">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="dropdownCheck">
                    <label class="form-check-label" for="dropdownCheck">
                        Remember me
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#">New around here? Sign up</a>
        <a class="dropdown-item" href="#">Forgot password?</a>
    </div>
</body>
</html>
