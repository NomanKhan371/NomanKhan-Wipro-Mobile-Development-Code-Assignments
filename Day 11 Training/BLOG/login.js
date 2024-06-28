function validateLogin(event) {
    event.preventDefault(); // Prevent the form from submitting

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const email = document.getElementById('email').value;
    const messageElement = document.getElementById('message');

    // Hard-coded credentials
    const hardcodedUsername = 'admin';
    const hardcodedPassword = '123';
    const hardcodedEmail = 'nomankhan@gmail.com';

    if (username === hardcodedUsername && password === hardcodedPassword && email === hardcodedEmail) {
        messageElement.style.color = 'green';
        messageElement.textContent = 'Login successful!';
        setTimeout(() => {
            window.location.href = 'home.html'; // Redirect to another file
        }, 1000);
    } else {
        messageElement.style.color = 'red';
        messageElement.textContent = 'Invalid login. Please try again.';
    }
}
