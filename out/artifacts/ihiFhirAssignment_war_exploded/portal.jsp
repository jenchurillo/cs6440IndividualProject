<%--
  Created by IntelliJ IDEA.
  User: jenchurillo
  Date: 10/10/20
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h1{text-align: center;
            font-size: 25px;
        }
        h2{text-align: center;
            font-size: 25px;
            text-decoration: underline;
        }
        p{
            font-size: 15px;

        }
        div{

            font-size: 20px;
            padding: 50px;
            width: 40%;
            margin: auto;
            background-color: darkgrey;
            text-align: center;
        }
        button[type=button] {
            width: 25%;
            background-color: lightskyblue;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 15px;
        }
    </style>
    <title>Portal</title>
</head>
<body>
    <h1>Welcome to your Portal ${patientName}!<h1>
        <div>
            <h2>Patient Information</h2>
            <p>Name: ${patientName}</p>
            <P>Date of Birth: ${patientDateOfBirth}</P>
            <p>Gender: ${patientGender}</p>
            <p>Address: ${patientAddress}</p>
            <p>Phone #: ${patientPhone}</p>
            <p>Condition: ${patientCondition}</p>

            <h2>Plan of Care</h2>
            <p>${patientCarePlan}</p>
        </div>



            <button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/${urlString}'">View my Detailed Care Plan </button>



            <button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/progress'">View my Progress </button>


</body>
</html>
