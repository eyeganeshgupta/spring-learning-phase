<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

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
            margin-bottom: 1rem;
        }
        .date {
            font-size: 1.5rem;
            font-weight: bold;
            color: #ffeb3b; /* Bright yellow for emphasis */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .subtext {
            margin-top: 1rem;
            font-size: 1rem;
        }
    </style>
</head>
<body>

<div class="greeting-card">
    <h1 class="welcome-message">Hello! Welcome to Our Web App</h1>
    <p class="date">Today is <%= request.getAttribute("date") %></p>
    <p class="date">Today is ${date}</p>
    <p class="subtext">We&apos;re thrilled to have you here. Enjoy your experience!</p>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
