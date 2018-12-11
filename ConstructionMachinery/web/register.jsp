<%-- 
    Document   : register
    Created on : Aug 24, 2018, 10:53:30 PM
    Author     : QuanNTM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <meta charset="utf-8">
        <meta name="keywords" content="Mobile, Samsung, Apple, HTC" />
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/register.css" />
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <s:head/>
    <body>
        <header>
            <div id="header_wrapper">
                <a href="home" id="logo">
                    <i class="fa fa-home"></i>
                    <span>Go Search</span>
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
            <div id="register">
                <s:form action="register">
                    <h1><font color="blue">Register</font></h1>
                    <p>Please fill in this form to create an account.</p>
                    <!--<hr>-->
                    <s:textfield name="username" label="Username" placeholder="Enter Username"/>
                    <s:textfield name="fullName" label="Full Name" placeholder="Enter Full Name"/>
                    <s:password name="password" label="Password" placeholder="Enter Password"/>
                    <s:password name="confirm" label="Confirm" placeholder="Repeat Password"/>

                    <!--                        <label for="email"><b>Username</b></label>
                                            <input type="text" placeholder="Enter Username" name="username" required>
                    
                                            <label for="psw-repeat"><b>Full Name</b></label>
                                            <input type="text" placeholder="Full Name" name="fullName" required>
                    
                                            <label for="psw"><b>Password</b></label>
                                            <input type="password" placeholder="Enter Password" name="password" required>
                    
                                            <label for="psw-repeat"><b>Repeat Password</b></label>
                                            <input type="password" placeholder="Repeat Password" name="confirm" required>-->

                    <!--<hr>-->


                    <s:submit value="Register"/>
                    <!--<button type="submit" class="registerbtn">Register</button>-->

                    <s:if test="%{exception.message.indexOf('duplicate') > - 1}">
                        <h3>
                            <font color="red"><s:property value="username"/> is existed!</font>
                        </h3>
                    </s:if>

                </s:form>
                <p>Already have an account?<a href="login.jsp">Login</a></p>
            </div>



        </section>
        <footer>
            &copy; 2017 - GO MACHINES
        </footer>
    </body>
</html>
