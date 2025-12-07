document.getElementById("registerForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phoneNumber = document.getElementById("phone").value;

    const response = await fetch("http://localhost:8080/api/registration", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
        name: name,
        email: email,
        phoneNumber: phoneNumber
       })
     });


    const data = await response.json();
    const msgEl = document.getElementById("message");

    if (response.status === 201) {
        msgEl.innerText = "Kayıt başarılı! → " + data.message;
        msgEl.style.color = "green";
        loadLastUsers(); 
    } else {
        msgEl.innerText = "Geçersiz numara: " + data.message;
        msgEl.style.color = "red";
    }
});
async function loadLastUsers() {
    const response = await fetch("http://localhost:8080/api/last-three");
    const users = await response.json();

    const tbody = document.getElementById("lastUsersTable").querySelector("tbody");
    tbody.innerHTML = "";

    users.forEach(user => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${new Date(user.date).toLocaleString()}</td>
        `;
        tbody.appendChild(tr);
    });
}

document.addEventListener("DOMContentLoaded", loadLastUsers);

