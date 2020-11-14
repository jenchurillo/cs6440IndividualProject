<%--
  Created by IntelliJ IDEA.
  User: jenchurillo
  Date: 11/6/20
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h1{text-align: center;
        }
        h2{text-align: center;
            text-decoration: underline;
        }
        p{
            font-size: 15px;
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
            text-align:center;

        }
        button[type=button] {
            width: 25%;
            background-color: lightskyblue;
            color: white;
            padding: 14px 20px;
            margin: 0px 0;
            width: 50%;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

    </style>
    <title>Rheumatoid Arthritis Care Plan</title>
</head>
<body>

<h1>Patient Detailed Care Plan</h1>

<div>

    <h2>Ice Therapy</h2>
    <p>Apply an ice or cold pack for no more than 20 minutes at a time.</p>
    <p>Repeat this process throughout the day—up to 8 or 10 times in a 24-hour period</p>

</div>

<div>

    <h2>Healthy Diet</h2>
    <p>Making health food choices can help reduce inflamation from rheumatoid Arthritis</p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/food'">View Recommended Foods</button></p>

</div>

<div>

    <h2>Physical Exercise</h2>
    <p>It is recommended to get 30 minutes of physical activity each day. You may choose from the following exercises:</p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/stretching'">Stretching</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/walking'">Walking</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/swimming'">Swimming</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/cycling'">Cycling</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/flowing'">Flowing Movements</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/pilates'">Pilates</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/strength'">Strength Training</button></p>

</div>

</body>
</html>
