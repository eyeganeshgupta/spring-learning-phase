<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laptop List</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .fade-in {
            animation: fadeIn 1s ease-in-out;
        }

        tr:hover {
            background-color: #f3f4f6;
            transition: background-color 0.3s ease;
        }
    </style>
</head>
<body class="bg-gray-100 min-h-screen flex flex-col items-center justify-center">

<div class="max-w-3xl w-full bg-white shadow-lg rounded-lg p-6 fade-in">
    <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Available Laptops</h1>
    <table class="w-full border-collapse border border-gray-300">
        <thead>
        <tr class="bg-gray-200">
            <th class="border border-gray-300 px-4 py-2">ID</th>
            <th class="border border-gray-300 px-4 py-2">Name</th>
            <th class="border border-gray-300 px-4 py-2">Processor</th>
            <th class="border border-gray-300 px-4 py-2">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="laptop" items="${laptops}">
            <tr class="hover:bg-gray-100">
                <td class="border border-gray-300 px-4 py-2">${laptop.id}</td>
                <td class="border border-gray-300 px-4 py-2">${laptop.name}</td>
                <td class="border border-gray-300 px-4 py-2">${laptop.processor}</td>
                <td class="border border-gray-300 px-4 py-2 text-center">
                    <a href="/laptops/${laptop.id}"
                       class="text-blue-500 hover:underline hover:text-blue-700 transition duration-300">
                        View Details
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
