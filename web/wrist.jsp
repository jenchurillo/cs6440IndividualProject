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
    <title>Patient Detailed Care Plan</title>
</head>
<body>
<h1>Patient Detailed Care Plan</h1>
<div>

    <h2>Rest</h2>
    <p>Avoid any activities that may cause pain, but do try to use the injured wrist as much as tolerable.</p>

</div>

<div>

    <h2>Physical Activity - Target Light Exercise</h2>
    <p>Choose 4 of the following 7 exercises and perform 2X each day</p>
    <p>Ease off the exercises if you start to have pain.</p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/flexion'">Wrist Flexion and Extension</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/flips'">Hand Flips</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/deviation'">Wrist Radial and Ulnar Deviation</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/extensor'">Wrist Extensor Stretch</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/flexor'">Wrist Flexor Stretch</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/intrinsicFlexion'">Intrinsic Flexion</button></p>
    <p><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/extension'">MP Extension</button></p>


</div>

</body>
</html>
