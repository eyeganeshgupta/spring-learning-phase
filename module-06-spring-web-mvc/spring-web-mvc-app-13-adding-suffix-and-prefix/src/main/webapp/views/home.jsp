<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Form</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
<div class="bg-white shadow-lg rounded-lg p-8 max-w-md w-full animate-fadeIn">
    <!-- Dynamic Date -->
    <p class="text-gray-500 text-sm text-center mb-4">Current Date: ${currentDate}</p>

    <h2 class="text-2xl font-bold text-center mb-6 animate-slideUp">Enter User Details</h2>
    <form action="/submitForm" method="POST" class="space-y-4">
        <!-- Name Input -->
        <div>
            <label for="name" class="block text-gray-700 font-medium mb-1">Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your full name" required
                   class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition duration-200 animate-fadeIn">
        </div>
        <!-- Email Input -->
        <div>
            <label for="email" class="block text-gray-700 font-medium mb-1">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email address" required
                   class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition duration-200 animate-fadeIn">
        </div>
        <!-- Submit Button -->
        <button type="submit"
                class="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg animate-bounceSlow transition duration-200">
            Submit
        </button>
    </form>
</div>
</body>
</html>
