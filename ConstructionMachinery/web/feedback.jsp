<%-- 
    Document   : feedback
    Created on : Aug 24, 2018, 10:54:51 PM
    Author     : QuanNTM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <meta charset="utf-8">
        <meta name="keywords" content="Mobile, Samsung, Apple, HTC" />
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="css/feedback.css" />
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
            <div class="container">
                <h1><font color="blue">Contact here</font></h1>
                <form action="insertFeedback">

                    <label for="fname">First Name</label>
                    <input type="text" id="fname" name="firstName" placeholder="Your name.." required>

                    <label for="lname">Last Name</label>
                    <input type="text" id="lname" name="lastName" placeholder="Your last name.." required>

                    <label for="city">City</label>
                    <select id="city" name="city">
                        <option>Ho Chi Minh</option>
                        <option>Da Lat</option>
                        <option>Da Nang</option>
                        <option>Ha Noi</option>
                        <option>Vung Tau</option>
                        <option>Can Tho</option>
                        <option>Vinh</option>
                        <option>Ca Mau</option>
                        <option>Buon Me Thuot</option>
                        <option>Other</option>
                    </select>

                    <label for="subject">Subject</label>
                    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px" required></textarea>

                    <input type="submit" value="Submit">

                </form>
            </div>
        </section>
        <footer>
            &copy; 2017 - GO MACHINES
        </footer>
    </body>
</html>
