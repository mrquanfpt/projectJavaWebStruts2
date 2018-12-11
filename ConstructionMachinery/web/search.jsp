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
                    <form action="searchByNameFull">
                        <span id="search_box">
                            <s:textfield name="searchValue"/>
                            <s:submit id="button_search" value="Search By Name"/>
                        </span>
                    </form>
                    <form action="searchInRangeFull">
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
                <h2><font color="blue">Machines for sale</font></h2>
            </div>
        </header>
        <section id="body_wrapper">
            <div id="left_col">
                <s:if test="%{#session.ROLE.equals('AD')}">
                    <h2><a href="userManagement">User Management</a></h2>
                </s:if>
                <s:if test="%{#session.USERNAME == null}">
                    <h3>Please <a href="login.jsp">login</a> to buy machine</h3></br>
                    <a href="register.jsp">Click here if you don't have an account!</a>

                </s:if>
                <s:if test="%{listAll != null}">
                    <table border="1" id="table_full">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description picture</th>
                                <th>Entry name</th>
                                <th>Entry description</th>
                                <th>Published date</th>
                                <th>Price</th>
                                    <s:if test="%{#session.ROLE.equals('AD')}">
                                    <th>Delete</th>
                                    <th>Update</th>
                                    </s:if>
                                    <s:if test="%{#session.ROLE.equals('US')}">
                                    <th>Add To Cart</th>
                                    </s:if>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listAll" status="counter">

                                <s:form action="update" theme="simple">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <img src="<s:property value="picture"/>" />
                                        </td>
                                        <td>
                                            <s:textfield name="nameMachines" value="%{nameMachines}"/>
                                        </td>
                                        <td>
                                            <s:textarea name="description" value="%{description}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="published" value="%{published}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="price" value="%{price}"/>
                                        </td>
                                        <s:if test="%{#session.ROLE.equals('AD')}">
                                            <td>
                                                <s:url action="delete" id="Delete">
                                                    <s:param name="idMachines" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{Delete}">Delete</s:a>
                                                </td>
                                                <td>
                                                <s:hidden name="idMachines" value="%{idMachines}"/>
                                                <s:submit value="Update"/>
                                            </td>
                                        </s:if>
                                        <s:if test="%{#session.ROLE.equals('US')}">
                                            <td>
                                                <s:url action="addToCart" id="ADD">
                                                    <s:param name="item" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{ADD}">Add To Cart</s:a>
                                                </td>
                                        </s:if>
                                    </s:form>
                                </s:iterator>

                        </tbody>
                    </table>
                </s:if>

                <s:if test="%{listByName != null}">
                    <table border="1" id="table_full">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description picture</th>
                                <th>Entry name</th>
                                <th>Entry description</th>
                                <th>Published date</th>
                                <th>Price</th>
                                    <s:if test="%{#session.ROLE.equals('AD')}">
                                    <th>Delete</th>
                                    <th>Update</th>
                                    </s:if>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listByName" status="counter">
                                <s:form action="update" theme="simple">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <img src="<s:property value="picture"/>" />
                                        </td>
                                        <td>
                                            <s:textfield name="nameMachines" value="%{nameMachines}"/>
                                        </td>
                                        <td>
                                            <s:textarea name="description" value="%{description}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="published" value="%{published}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="price" value="%{price}"/>
                                        </td>
                                        <s:if test="%{#session.ROLE.equals('AD')}">
                                            <td>
                                                <s:url action="delete" id="Delete">
                                                    <s:param name="idMachines" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{Delete}">Delete</s:a>
                                                </td>
                                                <td>
                                                <s:hidden name="idMachines" value="%{idMachines}"/>
                                                <s:submit value="Update"/>
                                            </td>
                                        </s:if>
                                        <s:if test="%{#session.ROLE.equals('US')}">
                                            <td>
                                                <s:url action="addToCart" id="ADD">
                                                    <s:param name="item" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{ADD}">Add To Cart</s:a>
                                                </td>
                                        </s:if>
                                    </tr>

                                </s:form>
                            </s:iterator>

                        </tbody>
                    </table>
                </s:if>
                <s:if test="%{listInRange != null}">
                    <table border="1" id="table_full">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description picture</th>
                                <th>Entry name</th>
                                <th>Entry description</th>
                                <th>Published date</th>
                                <th>Price</th>
                                    <s:if test="%{#session.ROLE.equals('AD')}">
                                    <th>Delete</th>
                                    <th>Update</th>
                                    </s:if>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listInRange" status="counter">
                                <s:form action="update" theme="simple">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <img src="<s:property value="picture"/>" />
                                        </td>
                                        <td>
                                            <s:textfield name="nameMachines" value="%{nameMachines}"/>
                                        </td>
                                        <td>
                                            <s:textarea name="description" value="%{description}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="published" value="%{published}"/>
                                        </td>
                                        <td>
                                            <s:textfield name="price" value="%{price}"/>
                                        </td>
                                        <s:if test="%{#session.ROLE.equals('AD')}">
                                            <td>
                                                <s:url action="delete" id="Delete">
                                                    <s:param name="idMachines" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{Delete}">Delete</s:a>
                                                </td>
                                                <td>
                                                <s:hidden name="idMachines" value="%{idMachines}"/>
                                                <s:submit value="Update"/>
                                            </td>
                                        </s:if>
                                        <s:if test="%{#session.ROLE.equals('US')}">
                                            <td>
                                                <s:url action="addToCart" id="ADD">
                                                    <s:param name="item" value="%{idMachines}"/>
                                                </s:url>
                                                <s:a href="%{ADD}">Add To Cart</s:a>
                                                </td>
                                        </s:if>
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
