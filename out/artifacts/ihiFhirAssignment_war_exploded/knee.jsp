<%--
  Created by IntelliJ IDEA.
  User: jenchurillo
  Date: 11/4/20
  Time: 11:22 AM
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
    <title>Patient Detailed Care Plan</title>

</head>
<body>
<h1>Patient Detailed Care Plan</h1>

<div>
    <h2>Ice Therapy</h2>
    <p>Apply an ice or cold pack for no more than 20 minutes at a time.</p>
    <p>Repeat this process throughout the day—up to 8 or 10 times in a 24-hour period</p>
</div>

<div>

    <h2>Choose 5 of the following exercises to perform 2X a day</h2>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/hamstringStretch'">Hamstring Stretch</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/calfStretch'">Calf Stretch</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/straightLegRaise'">Straight Leg Raise</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/quadSet'">Quad Set</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/seatedHipMarch'">Seated Hip March</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/pillowSqueeze'">Pillow Squeeze</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/heelRaise'">Heel Raise</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/sideLegRaise'">Side Leg Raise</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/sitToStand'">Sit to Stand</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/oneLegBalance'">One Leg Balance</button></p>

</div>





</body>
</html>
