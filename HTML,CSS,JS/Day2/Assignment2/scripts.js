// User object
let user = {
    name: "ram",
    email: "ram.222@gmail.com",
    age: 26
};
// Function to change the user's name
function changeName() {
    let newName = document.getElementById('newName').value;
    if (newName) {
        user.name = newName;
        document.getElementById('userName').textContent = user.name;
        console.log(`Name changed to: ${user.name}`);
    } else {
        alert('Please enter a new name.');
    }
}

// Function to update the user's email
function updateEmail() {
    let newEmail = document.getElementById('newEmail').value;
    if (validateEmail(newEmail)) {
        user.email = newEmail;
        document.getElementById('userEmail').textContent = user.email;
        document.getElementById('emailError').textContent = '';
        console.log(`Email updated to: ${user.email}`);
    } else {
        document.getElementById('emailError').textContent = 'Please enter a valid email address.';
    }
}

// Function to update the user's age
function updateAge() {
    let newAge = document.getElementById('newAge').value;
    if (newAge) {
        user.age = parseInt(newAge);
        document.getElementById('userAge').textContent = user.age;
        console.log(`Age updated to: ${user.age}`);
    } else {
        alert('Please enter a new age.');
    }
}

// Function to validate the email address
function validateEmail(email) {
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    return emailPattern.test(email);
}

// Function to calculate the user's birth year
function calculateBirthYear() {
    let currentYear = new Date().getFullYear();
    let birthYear = currentYear - user.age;
    console.log(`User's birth year is: ${birthYear}`);
    return birthYear;
}

// Function to display the user's birth year
function displayBirthYear() {
    let birthYear = calculateBirthYear();
    document.getElementById('userBirthYear').textContent = birthYear;
}