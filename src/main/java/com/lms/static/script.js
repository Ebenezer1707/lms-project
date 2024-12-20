// Add Form Validation
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('user-form');

    if (form) {
        form.addEventListener('submit', (event) => {
            event.preventDefault(); // Prevent form submission to handle validation manually

            // Reset validation states
            form.classList.remove('was-validated');

            if (form.checkValidity()) {
                // If form is valid, send data to the server
                const user = {
                    name: document.getElementById('name').value,
                    email: document.getElementById('email').value,
                    role: document.getElementById('role').value,
                };

                // Example API POST request for user data
                fetch('/users', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(user),
                })
                    .then((response) => response.json())
                    .then((data) => {
                        alert('User saved successfully!');
                        window.location.href = '/'; // Redirect to the user list page
                    })
                    .catch((error) => console.error('Error:', error));
            } else {
                // If form is invalid, show validation messages
                form.classList.add('was-validated');
            }
        });
    }

    // Highlight the selected row in the User List
    const userList = document.getElementById('user-list');
    if (userList) {
        userList.addEventListener('click', (event) => {
            const rows = document.querySelectorAll('#user-list tr');
            rows.forEach((row) => row.classList.remove('table-active'));

            const clickedRow = event.target.closest('tr');
            if (clickedRow) {
                clickedRow.classList.add('table-active');
            }
        });
    }

    // Add Delete Confirmation
    const deleteButtons = document.querySelectorAll('.btn-danger');
    deleteButtons.forEach((button) => {
        button.addEventListener('click', (event) => {
            const confirmation = confirm('Are you sure you want to delete this user?');
            if (!confirmation) {
                event.preventDefault(); // Prevent deletion if not confirmed
            }
        });
    });
});
// Example fetch request to populate users
fetch('/users')
.then(response => response.json())
.then(users => {
    const userList = document.getElementById('user-list');
    userList.innerHTML = users.map(user => `
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <a href="/edit-user/${user.id}" class="btn btn-warning btn-sm">Edit</a>
                <button class="btn btn-danger btn-sm" onclick="deleteUser(${user.id})">Delete</button>
            </td>
        </tr>
    `).join('');
});

function deleteUser(userId) {
fetch(`/users/${userId}`, { method: 'DELETE' })
    .then(() => location.reload());
}
const form = document.getElementById('user-form');

        form.addEventListener('submit', (event) => {
            event.preventDefault();

            if (!form.checkValidity()) {
                form.classList.add('was-validated');
                return;
            }

            const user = {
                name: document.getElementById('name').value,
                email: document.getElementById('email').value,
                role: document.getElementById('role').value
            };

            // Example POST request to create/update a user
            fetch('/users', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(user)
            })
            .then(response => response.json())
            .then(() => window.location.href = '/');
        });