<%-- 
    Document   : index
    Created on : Aug 24, 2018, 10:24:59 PM
    Author     : QuanNTM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/main.css" />
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <body>
        <header>
            <div id="header_wrapper">
                <a href="home" id="logo">
                    <i class="fa fa-home"></i>
                    <span>Go Machines</span>
                </a>
                <s:if test="%{#session.USERNAME != null}">
                    <h3 style="left: 50px;">
                        <font color="blue">Welcome, <s:property value="%{#session.USERNAME}"/></font>
                    </h3>
                </s:if>
                <nav id="main_nav">
                    <form action="searchByName">
                        <span id="search_box">
                            <s:textfield name="searchValue"/>
                            <s:submit id="button_search" value="Search By Name"/>
                        </span>
                    </form>
                    <form action="searchInRange">
                        <span id="search_box">
                            <s:textfield name="minPrice" placeholder="Min Price" cssStyle="width: 100px;"/>
                            <s:textfield name="maxPrice" placeholder="Max Price" cssStyle="width: 100px;"/>
                            <s:submit id="button_search" value="Search by Price"/>
                        </span>
                    </form>
                    <a href="search"><i class="fa fa-credit-card"></i>For Sale</a>
                    <a href="feedback.jsp"><i class="fa fa-comment"></i>Contact</a>
                    <s:if test="%{#session.USERNAME != null}">
                        <a href="logout">Logout</a>
                        <a href="viewCart.jsp"><i class="fa fa-shopping-cart"></i>Cart</a>
                    </s:if>
                    <s:else>
                        <a href="login.jsp">Login</a>
                        <a href="register.jsp"><i class="fa fa-registered"></i>Register</a>
                    </s:else>
                </nav>
                <h2><font color="blue">Home Page</font></h2>
            </div>
        </header>
        <section id="body_wrapper">
            <div id="left_col">
                <aside id="main_banner">
                    <img src="img/machines_banner.jpg" />
                </aside>
                <div id="main_phone_list">
                    <s:if test="%{listAll != null}">
                        <s:iterator value="%{listAll}">
                            <a href="home" class="phone_box">
                                <img src="<s:property value="picture"/>" />
                                <div class="info">
                                    <h3>
                                        Name: <s:property value="nameMachines"/>
                                    </h3>
                                    <ul>
                                        <li>
                                            ID Machines: <s:property value="idMachines"/>
                                        </li>
                                        <li>
                                            Published date: <s:property value="published"/>
                                        </li>
                                    </ul>
                                </div>
                                <span class="price">
                                    Price of item: <s:property value="price"/>$
                                </span>
                                <span class="discount">Sale 50%</span>
                                <span class="gift"><i class="fa fa-gift"></i>More gift</span>
                            </a>
                        </s:iterator>
                    </s:if>
                    <s:if test="%{!searchValue.isEmpty()}">
                        <s:if test="%{listByName != null}">
                            <s:iterator value="listByName">
                                <a href="home" class="phone_box">
                                    <img src="<s:property value="picture"/>" />
                                    <div class="info">
                                        <h3>
                                            Name: <s:property value="nameMachines"/>
                                        </h3>
                                        <ul>
                                            <li>
                                                ID Machines: <s:property value="idMachines"/>
                                            </li>
                                            <li>
                                                Published date: <s:property value="published"/>
                                            </li>
                                        </ul>
                                    </div>
                                    <span class="price">
                                        Price of item: <s:property value="price"/>$
                                    </span>
                                    <span class="discount">Sale 50%</span>
                                    <span class="gift"><i class="fa fa-gift"></i>More gift</span>
                                </a>
                            </s:iterator>

                        </s:if>
                        <s:else>
                            <h2>No record is matched!</h2>
                        </s:else>
                    </s:if>
                    <s:if test="%{minPrice != 0.0 and maxPrice != 0.0}">
                        <s:if test="%{listInRange != null}">
                            <s:iterator value="listInRange">
                                <a href="home" class="phone_box">
                                    <img src="<s:property value="picture"/>" />
                                    <div class="info">
                                        <h3>
                                            Name: <s:property value="nameMachines"/>
                                        </h3>
                                        <ul>
                                            <li>
                                                ID Machines: <s:property value="idMachines"/>
                                            </li>
                                            <li>
                                                Published date: <s:property value="published"/>
                                            </li>
                                        </ul>
                                    </div>
                                    <span class="price">
                                        Price of item: <s:property value="price"/>$
                                    </span>
                                    <span class="discount">Sale 50%</span>
                                    <span class="gift"><i class="fa fa-gift"></i>More gift</span>
                                </a>
                            </s:iterator>

                        </s:if>
                    </s:if>


                </div>
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
