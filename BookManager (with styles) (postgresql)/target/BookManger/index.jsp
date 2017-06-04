<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
  <meta http-equiv='Content-Type' content='text/html; charset=utf8'>
  <link rel="stylesheet" href="style.css" type="text/css" />
  <title>Service of reception orders<br>Сервис приёма заказов</title>
  <style type="text/css">
  body{
  margin: 0px;
  width: 100%;
  height: 100%;
  text-align: left;
  font-family: Verdana, Helvetica, Arial, sans-serif;
  background-attachment: fixed ;
  }

  #header{
  width:100%;
  height:150px;
  margin: 0 auto;
  font-style: oblique;
  text-shadow: white 0 0 10px;
  }
  a{
  text-decoration: none;
  }
  #marq{
  margin-left:300px;
  }


  table {
  outline:solid #000;
  }
  td {
  padding: 10px;
  border: 1px solid #000;
  }

  #zaglavie{
  position:absolute;
  top: 0px;
  left: 150px;
  height: 75px;
  width: 1150px;
  text-align: center;
  font-size: 50px;
  font-weight: bold;
  font-style: italic;
  margin: 8px;
  font-style: oblique;
  color: black;
  }
  #content{
  position:absolute;
  margin-left: 300px;
  margin-top: 55px;
  background:rgba(255,215,000,0.8);
  border-top-style:groove;
  border-top-color:red ;
  padding: 20px;
  border: 1px solid #000000;
  width:  780px;
  height: 100%;
  border-radius: 35px;
  }
  #footer{
  background-color:rgb(255, 215, 000) ;
  position: absolute;
  top:1067px;
  bottom: 0;
  width: 100%;
  margin-top: -17px;
  height: 80px;
  border-radius: 50px;
  }

  ul {
  display: block;
  margin: 0;
  padding: 0;
  list-style: none;

  }
  ul:after {
  display: block;
  content: ' ';
  clear: both;
  float: none;
  }
  ul.menu > li {
  float: left;
  position: relative;
  }
  ul.menu > li > a {
  display: block;
  padding: 30px;
  color: black;
  font-weight: bold;
  background-color: rgb(255, 215, 000);
  text-decoration: none;
  }
  ul.menu > li > a:hover {
  background-color: gold;
  }
  ul.submenu {
  display: none;
  position: absolute;
  width: 160px;
  top:77px;
  left: 0;
  background-color: white;
  text-align:center;
  }
  ul.submenu > li {
  display: block;
  }
  ul.submenu > li > a {
  display: block;
  padding: 10px;
  color: black;
  background-color: gold;
  text-decoration: none;
  font-weight: bold;
  }
  ul.submenu > li > a:hover {
  text-decoration: underline;
  }
  ul.menu > li:hover > ul.submenu {
  display: block;
  }

  table.table{
  border: 3px rgb(27, 27, 27) solid;
  width: 534px;
  height: 210px;
  border-spacing: 2px;
  }
  table.table th{
  border: 3px rgb(27, 27, 27) solid;
  background-color: rgba(0, 146, 243, 0.4);
  height: 30px;
  }
  table.table td{
  border: 1px rgb(27, 27, 27) solid;
  height: 40px;
  }
  table.table tfoot td{
  border: 1px rgb(27, 27, 27) solid;
  height: 30px;
  }
  </style>



</head>
<body background="img/fon3.jpg" >
<div id="header">
  <img src="img/chaplin.jpg" width="150" height="150" usemap="#Map"
       style="float:left; margin-top: 10px; margin-left:10px;"/>
  <map name="Map">
    <area shape="circle" coords="76,76,71" href="index.jsp">
  </map>

  <div align="center" id="zaglavie">Service of reception orders "Chaplin"</div>
  <ul class="menu" style="padding:76px; padding-left:300px;">
    <li><a href="<c:url value="/clients"/>" >Clients list</a></li>
    </li>

    <li><a  href="<c:url value="/orderr"/>"> Order list</a></li>

    <li><a href="<c:url value="/orderr_products"/>" >Order + product list</a>
    </li>
    <li><a href="<c:url value="/product"/>" >Product list</a>
    </li>
    <li>
      <a href="inform.jsp" target="_blank">Basket</a>
    </li>
  </ul>
</div>
<div id="marq">
  <font size="5" color="black" face="COMIC SANS MS" >
    <marquee  width="820"  height="30"  vspace="5"   bgcolor=gold>
      <strong>WELCOME!!! WELCOME!!! WELCOME!!!</strong>
    </marquee>
  </font>
</div>

<div id="content"  >
  <h1><font size="10" align="center" face="COMIC SANS MS"><strong>Курсовой проект студента 3 курса,<br> 5 группы<br> Фатуева Андрея</strong></font></h1>

</div>
</body>



</html>