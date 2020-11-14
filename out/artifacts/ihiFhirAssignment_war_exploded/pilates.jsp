<%--
  Created by IntelliJ IDEA.
  User: jenchurillo
  Date: 11/7/20
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h1{
            padding-top: 10px;
            text-align: center;
        }
        p{
            padding-top: 5px;
            font-size: 15px;
            margin-left: 350px;
            margin-right: 350px;
        }
        h3{
            padding-top: 150px;
            font-size: 10px;
            margin-left: 100px;
        }
        h4{
            padding-top: 5px;
            padding-bottom: 10px;
            margin-left: 10px;
        }
        iframe{
            display: block;
            margin: 0 auto;
        }


    </style>
    <title>Pilates</title>
</head>
<body>
<h1>Pilates</h1>
<p>Pilates is a low-impact activity that stabilizes the joints and strengthens the muscles around them.</p>
<p>The video below demonstrates a pilates routine created for individuals experiencing Rheumatoid Arthritis.</p>

<iframe height="350" width="600"
        src="https://www.youtube.com/embed/yjzsJxzQKkA">

</iframe>



<h3>Data Source: Arthritis Foundation. (n.d.-a). Best Exercises for Rheumatoid Arthritis | Arthritis Foundation. Retrieved November 11, 2020, from https://www.arthritis.org/health-wellness/healthy-living/physical-activity/other-activities/best-exercises-for-rheumatoid-arthritis</h3>
<h4><button type="button" onclick="location.href='/ihiFhirAssignment_war_exploded/rheumatoid'">Back</button></h4>

</body>
</html>
