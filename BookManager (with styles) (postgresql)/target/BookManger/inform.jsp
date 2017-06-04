<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table" %>
<%@ page import="static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.andrey.shop.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information of client</title>
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
            color: gold;
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
        .tg tc{
            font-weight: normal;
            padding: 10px 5px;
             ;
        }
        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body background="img/fon3.jpg" >

<%

    try {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/shhop";
        String username = "postgres";
        String password = "anddrreeyy112";


//String myDataField = null;
//String myQuery = "SELECT * FROM client";
        //ResultSet myResultSet = null;
        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;

        Class.forName(driver).newInstance();
        myConnection = DriverManager.getConnection(url,username,password);
        String selectTableSQL = "select Client.client_name, Client.client_city, Orderr_Product.articul, Orderr_Product.amount, Product.product_name, Product.price, Orderr_Product.amount*Product.price As summa  from Client,Orderr,Orderr_Product,Product where Client.id_client = Orderr.id_client and Orderr_Product.articul = Product.articul and Orderr.id_orderr = Orderr_Product.id_orderr;";

        myPreparedStatement = myConnection.prepareStatement(selectTableSQL);

        ResultSet rs1 = myPreparedStatement.executeQuery();
        PrintWriter out2 = response.getWriter();
        out2.println("<html>");
        out2.println("<table align=\"center\" class=\"tg\">\n" +
                "  <tr>\n" +
                "    <th width=\"80\">CLIENT NAME</th>\n" +
                "    <th width=\"120\">CLIENT CITY</th>\n" +
                "    <th width=\"120\">ARTICUL</th>\n" +
                "    <th width=\"120\">AMOUNT</th>\n" +
                "    <th width=\"120\">PRODUCT NAME</th>\n" +
                "    <th width=\"120\">PRICE</th>\n" +
                "    <th width=\"120\">SUMMA</th>\n");
        out2.println("</html>");

        while(rs1.next()){
            String client_name  = rs1.getString(1);
            String client_city = rs1.getString(2);
            Integer articul = rs1.getInt(3);
            Integer amount = rs1.getInt(4);
            String product_name = rs1.getString(5);
            Integer price  = rs1.getInt(6);
            Integer summa = rs1.getInt(7);

            PrintWriter out1 = response.getWriter();

            out1.println("<html>");
            out1.println();
            out1.println("<table class=\"tg\" align=\"center\">" +
                    "  <tr>" +
                    "    <th height=\"10\" width=\"80\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "    <th height=\"10\" width=\"120\"></th>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td><tc>");
            out1.println(client_name);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(client_city);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(articul);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(amount);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(product_name);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(price);
            out1.println("</td></tc>");
            out1.println("<td><tc>");

            out1.println(summa);
            out1.println("</td></tc>");
            out1.println("</table>");

            out1.println("</html>");

        }
        rs1.close();
    }
    catch(Exception e){
        out.print(e);
    }

%>

</body>
</html>