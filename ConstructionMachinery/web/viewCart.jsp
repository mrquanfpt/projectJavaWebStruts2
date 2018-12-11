<%-- 
    Document   : viewCart
    Created on : Aug 24, 2018, 10:50:25 PM
    Author     : QuanNTM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
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
                <nav id="main_nav">
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
            </div>
        </header>
        <section id="body_wrapper">
            <h1><font color="blue">Your Cart:</font></h1>
            <div id="left_col">
                <s:if test="%{#session.CART != null}">
                    <table border="1" id="table_full">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Description picture</th>
                                <th>Entry name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Action</th>
                                <td>Checkout</td>
                            </tr>
                        </thead>
                        <tbody>
                            <s:form action="removeItem" theme="simple">
                                <s:iterator value="%{#session.CART.items}" status="counter">
                                    <tr>
                                        <td>
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <img src="<s:property value="key.picture"/>" />
                                        </td>
                                        <td>
                                            <s:property value="key.nameMachines"/>
                                        </td>
                                        <td>
                                            <s:property value="value"/>
                                        </td>
                                        <td>
                                            <s:property value="key.price"/>
                                        </td>
                                        <td>
                                            <s:checkbox name="selectedItem" fieldValue="%{key.idMachines}"/>
                                        </td>
                                        <td>
                                            <s:url action="checkOut" id="checkout">
                                            <s:param name="idMachines" value="%{key.idMachines}"/>
                                            <s:param name="username" value="%{#session.USERNAME}"/>
                                            <s:param name="quantity" value="%{value}"/>
                                            <s:param name="price" value="%{key.price}"/>
                                            </s:url>
                                            <h3><s:a href="%{checkout}">CheckOut here!</s:a></h3>
                                        </td>
                                        
                                    </tr>
                                </s:iterator>
                                <tr>
                                    <td colspan="5">
                                        <h2><s:a href="search">Click here to add more!</s:a></h2>
                                        </td>
                                        <td>
                                        <s:submit value="Remove Selected Items"/>
                                    </td>


                                </tr>
                            </s:form>
                        </tbody>

                    </table>

                    
                </s:if>


                <s:if test="%{#session.CART == null}">
                    <h2>Your cart is empty!</h2>
                    <a href="search">Click here to buy!</a>
                </s:if>

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
