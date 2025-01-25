<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculation Result</title>

    <script src="https://cdn.tailwindcss.com"></script>

    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        primary: '#4F46E5', // Indigo
                        accent: '#FACC15', // Yellow
                    },
                },
            },
        };
    </script>

    <style>
        .animate-fade-in {
            animation: fadeIn 1.5s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>
</head>
<body class="bg-gradient-to-br from-primary to-blue-500 h-screen flex items-center justify-center text-white">

<div class="w-full max-w-md p-6 bg-white bg-opacity-10 rounded-lg shadow-lg text-center animate-fade-in">
    <h1 class="text-3xl font-bold mb-4">Calculation Result</h1>

    <p class="text-lg mb-4">
        You entered:
        <span class="font-semibold text-accent">${number1}</span> and
        <span class="font-semibold text-accent">${number2}</span>.
    </p>

    <p class="text-lg mb-6">
        The sum is:
        <span class="font-bold text-green-400">${sum}</span>
    </p>

    <a href="/"
       class="py-3 px-4 bg-accent text-gray-900 font-semibold rounded-lg shadow hover:bg-yellow-400 transition duration-300">
        Go Back
    </a>
</div>

</body>
</html>
