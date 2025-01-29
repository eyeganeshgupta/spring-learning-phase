<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laptop Details</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateX(-50px);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        .slide-in {
            animation: slideIn 1s ease-out;
        }

        .glow-button {
            box-shadow: 0px 0px 10px rgba(59, 130, 246, 0.5);
            transition: box-shadow 0.3s ease;
        }

        .glow-button:hover {
            box-shadow: 0px 0px 20px rgba(59, 130, 246, 0.8);
        }
    </style>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<div class="max-w-lg w-full bg-white shadow-lg rounded-lg p-6 slide-in">
    <h1 class="text-xl font-bold text-center text-blue-600 mb-6">Laptop Details</h1>

    <!-- Laptop Info -->
    <p><strong>ID:</strong> ${laptop.id}</p>
    <p><strong>Name:</strong> ${laptop.name}</p>
    <p><strong>Processor:</strong> ${laptop.processor}</p>
    <p><strong>RAM:</strong> ${laptop.ram}</p>
    <p><strong>Storage:</strong> ${laptop.storage}</p>
    <p><strong>Graphics Card:</strong> ${laptop.graphicsCard}</p>

    <div class="mt-6 text-center">
        <a href="/laptops/"
           class="bg-blue-500 text-white py-2 px-4 rounded glow-button transition duration-300">
            Back to List
        </a>
    </div>
</div>

</body>
</html>
