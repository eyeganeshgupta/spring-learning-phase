<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome ${name}</title>

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
    <h1 class="text-3xl font-bold mb-4">Hello, <span class="text-accent">${name}</span>!</h1>
    <p class="text-lg mb-6">Today is <span id="currentDate" class="font-semibold text-accent"></span></p>
    <p class="text-base">We&apos;re thrilled to have you here. Enjoy your experience!</p>
</div>

<script>
    const currentDateElement = document.getElementById('currentDate');

    function updateDateTime() {
        const options = {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: 'numeric',
            minute: 'numeric',
            second: 'numeric',
            timeZone: 'Asia/Kolkata',
            timeZoneName: 'short'
        };

        const currentDate = new Date().toLocaleDateString('en-IN', options);
        currentDateElement.textContent = currentDate;
    }

    setInterval(updateDateTime, 1000);

    updateDateTime();
</script>

</body>
</html>
