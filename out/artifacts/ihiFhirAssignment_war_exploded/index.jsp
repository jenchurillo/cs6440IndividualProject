<%--
  Created by IntelliJ IDEA.
  User: jenchurillo
  Date: 10/8/20
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <style>
        h1{text-align: center;
        }
        p{
            font-size: 20px;
        }
        form{
            font-size: 20px;
        }
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            width: 50%;
            margin:0 auto;
        }
        input[type=submit] {
            width: 25%;
            background-color: lightskyblue;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=text], select {
            width: 90%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=password], select {
            width: 90%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
    </style>
    <title>My Patient Portal</title>
</head>
<body>



    <h1>Welcome to your Care Plan Portal<h1>

<div>
    <p>Log into Care Plan Portal</p>
        <form action="/ihiFhirAssignment_war_exploded/carePlan" method="post">
            username: <input type="text" name="username" width="30" placeholder="Username"/>
            password: <input type="password" name="password" width="30" placeholder="Password"/>
            <input type="submit" value="Log In"/>

    </form>
</div>

        <p style="color:red;">${errorMessage}</p>







</body>
</html>
