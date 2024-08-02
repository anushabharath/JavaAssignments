document.addEventListener('DOMContentLoaded', function () {
    // Registration form validation
    const registrationForm = document.getElementById('registrationForm');
    registrationForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const name = document.getElementById('regName').value;
        const email = document.getElementById('regEmail').value;
        const password = document.getElementById('regPassword').value;
        const confirmPassword = document.getElementById('regConfirmPassword').value;

        if (password !== confirmPassword) {
            alert('Passwords do not match');
            return;
        }

        // Further validation can be added here

        alert('Registration successful');
    });

    // Login form validation
    const loginForm = document.getElementById('loginForm');
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const email = document.getElementById('loginEmail').value;
        const password = document.getElementById('loginPassword').value;

        // Further validation can be added here

        alert('Login successful');
    });
});
