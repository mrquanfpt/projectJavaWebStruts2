<%-- 
    Document   : search
    Created on : Aug 24, 2018, 10:47:50 PM
    Author     : QuanNTM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Machines for Sales</title>
        <meta charset="utf-8">
        <meta name="keywords" content="Mobile, Samsung, Apple, HTC" />
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/main.css" />
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <s:head/>
    <body>
        <header>
            <div id="header_wrapper">
                <a href="home" id="logo">
                    <i class="fa fa-home"></i>
                    <span>Go Machines</span>
                </a>
                <s:if test="%{#session.USERNAME != null}">
                    <h2 style="left: 50px;">
                        <font color="blue">Welcome, <s:property value="%{#session.USERNAME}"/></font>
                    </h2>
                </s:if>
                <nav id="main_nav">
                    <form action="searchUserByName">
                        <span id="search_box">
                            <s:textfield name="searchValue"/>
                            <s:submit id="button_search" value="Search By Name"/>
                        </span>
                    </form>
                    <a href="search"><i class="fa fa-credit-card"></i>For Sale</a>
                    <a href="feedback.jsp"><i class="fa fa-comment"></i>Contact</a>
                    <s:if test="%{#session.USERNAME != null}">
                        <a href="login.jsp">Logout</a>
                        <a href="viewCart.jsp"><i class="fa fa-shopping-cart"></i>Cart</a>
                    </s:if>
                    <s:else>
                        <a href="login.jsp">Login</a>
                        <a href="register.jsp"><i class="fa fa-registered"></i>Register</a>
                    </s:else>
                </nav>
            </div>
        </header>
        <h1>
            <font color="blue">User Management</font>
        </h1>
        <section id="body_wrapper">
            <div id="left_col">
                <s:if test="%{listUser != null}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Full Name</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listUser" status="counter">
                                <s:form theme="simple" action="updateUser">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <s:property value="username"/>
                                            <s:hidden name="username" value="%{username}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="password" value="%{password}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="fullName" value="%{fullName}"/>
                                        </td>
                                        <td>
                                            <s:url action="deleteUser" id="Delete">
                                                <s:param name="username" value="%{username}"/>
                                                <s:param name="lastSearchValue" value="%{searchValue}"/>
                                            </s:url>
                                            <s:a href="%{Delete}">Delete</s:a>
                                            </td>
                                            <td>
                                            <s:submit value="Update"/>
                                            <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                        </td>
                                    </tr>
                                </s:form>
                            </s:iterator>

                        </tbody>
                    </table>

                </s:if>
            </div>
        </section>
        <footer>
            &copy; 2017 - GO MACHINES
        </footer>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">


        </script>
        <script>
            $(function () {
                $('#logo').click(function () {
                    $('#main_nav').toggle();
                });
            });

        </script>
    </body>
</html>
