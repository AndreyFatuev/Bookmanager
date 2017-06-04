<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Orderr+Products </title>

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

        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }
        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
        .tg .tg-4eph {
            background-color: #f9f9f9
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

        <li><a href="<c:url value="/orderr"/>" >Order list</a></li>

        <li><a href="<c:url value="/orderr_products"/>" >Order + product list</a>
        </li>
        <li><a href="<c:url value="/product"/>" >Product list</a>
        </li>
        <li>
            <a href="inform.jsp" target="_blank">Basket</a>
        </li>
    </ul>
</div>
<div id="content">

<h1> <center>Order + Product List</center></h1>

<c:if test="${!empty listBooks}">
    <table align="center" class="tg">
        <tr>
            <th width="80">id_orderr_product</th>
            <th width="120">id_orderr</th>
            <th width="120">articul</th>
            <th width="120">amount</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="orderr_product">
        <tr>
            <td>${orderr_product.id_orderr_product}</td>

            <td>${orderr_product.id_orderr}</td>
            <td>${orderr_product.articul}</td>
            <td>${orderr_product.amount}</td>
            <td><a href="<c:url value='/edit_orderr_products/${orderr_product.id_orderr_product}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove_orderr_products/${orderr_product.id_orderr_product}'/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<h1><center>Add a order_product</center></h1>

<c:url var="addAction" value="/orderr_products/add"/>

<form:form action="${addAction}" commandName="book">
    <table align="center">
        <c:if test="${!empty book.id_orderr}">
            <tr>
                <td>
                    <form:label path="id_orderr_product">
                        <spring:message text="id_orderr_product"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id_orderr_product" size="8" />
                    <form:hidden path="id_orderr_product"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="id_orderr">
                    <spring:message text="id_orderr"/>
                </form:label>
            </td>
            <td>
                <form:input path="id_orderr"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="articul">
                    <spring:message text="articul"/>
                </form:label>
            </td>
            <td>
                <form:input path="articul"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center" >
                <c:if test="${!empty book.id_orderr}">
                    <input type="submit"
                           value="<spring:message text="Edit orderr_product"/>"/>
                </c:if>
                <c:if test="${empty book.id_orderr}">
                    <input type="submit"
                           value="<spring:message text="Add orderr_product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
