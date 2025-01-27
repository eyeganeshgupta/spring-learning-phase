<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Data</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
<div class="bg-white shadow-lg rounded-lg p-8 max-w-md w-full text-left animate-slideUp">
    <!-- Dynamic Date -->
    <p class="text-gray-500 text-sm text-center mb-4">Current Date: ${currentDate}</p>

    <h2 class="text-xl text-center font-bold mb-4">Submitted User Details</h2>
    <!-- Display Name -->
    <p class="text-gray-700"><strong>Name:</strong> ${user.name}</p>
    <!-- Display Email -->
    <p class="text-gray-700"><strong>Email:</strong> ${user.email}</p>

    <!-- Back Button -->
    <a href="/"
       class="mt-6 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg transition duration-200 animate-bounceSlow">
        Back to Form
    </a>
</div>
</body>
</html>
