<%-- 
    Document   : error
    Created on : Aug 28, 2018, 5:56:13 PM
    Author     : QuanNTM
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>
            <font color="red">
                <s:property value="%{#request.ERROR}"/>
            </font>
        </h1>
            <a href="home">Click here to return a Home Page</a>
    </body>
</html>
