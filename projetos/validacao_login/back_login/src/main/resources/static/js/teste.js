function logout() {
    localStorage.removeItem("token"); // remove token
    window.location.href = "login.html"; // volta para login
}