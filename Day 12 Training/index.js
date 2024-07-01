// User object
const user = {
    name: 'Noman Khan',
    email: 'noman@example.com',
    age: 23
};

// Function to change the user's name
function changeName(newName) {
    user.name = newName;
}

// Function to update the user's email
function updateEmail(newEmail) {
    user.email = newEmail;
}

// Function to calculate the user's birth year
function calculateBirthYear() {
    const currentYear = new Date().getFullYear();
    return currentYear - user.age;
}

// Example usage
console.log('Original user:', user);

changeName('pathan');
console.log('After name change:', user);

updateEmail('pathan@example.com');
console.log('After email update:', user);

const birthYear = calculateBirthYear();
console.log('User\'s birth year:', birthYear);