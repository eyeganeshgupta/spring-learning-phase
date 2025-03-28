<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <!-- MDBootstrap Animation CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css">
    <!-- Custom Styles -->
    <style>
        body {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: white;
            font-family: 'Arial', sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }
        .greeting-card {
            text-align: center;
            padding: 2rem;
            border-radius: 15px;
            background-color: rgba(255, 255, 255, 0.1);
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
        }
        .welcome-message {
            font-size: 2.5rem;
        }
        .date {
            font-size: 1.2rem;
        }
        .btn-custom {
            margin-top: 1rem;
        }
    </style>
</head>
<body>
<%
    // Get the current date and time
    Date currentDate = new Date();
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("EEEE, dd MMMM yyyy");
    String formattedDate = formatter.format(currentDate);
%>
<div class="greeting-card">
    <h1 class="welcome-message animate__animated animate__fadeInDown">Hello! Welcome to Our Website</h1>
    <p class="date">Today is <%= formattedDate %></p>
    <p class="animate__animated animate__fadeInUp">We’re thrilled to have you here. Enjoy your experience!</p>
    <button class="btn btn-primary btn-lg btn-custom animate__animated animate__pulse animate__infinite">Get Started</button>
</div>
<!-- Bootstrap JS and MDBootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>