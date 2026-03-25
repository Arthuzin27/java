const API_URL = "http://localhost:8081/api";

function login() {
    fetch(API_URL + "/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: document.getElementById("email").value,
            senha: document.getElementById("senha").value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error();
        return res.json();
    })
    .then(data => {
        alert("Login realizado com sucesso!");
        console.log(data);
    })
    .catch(() => {
        document.getElementById("msg").innerText = "Email ou senha inválidos";
    });
}

function registrar() {
    fetch(API_URL + "/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: document.getElementById("nome").value,
            email: document.getElementById("email").value,
            senha: document.getElementById("senha").value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error();
        document.getElementById("msg").style.color = "green";
        document.getElementById("msg").innerText = "Cadastro realizado com sucesso!";
    })
    .catch(() => {
        document.getElementById("msg").innerText = "Erro ao cadastrar";
    });
}

function recuperarSenha() {
    fetch(API_URL + "/auth/forgot-password", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: document.getElementById("email").value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error();
        document.getElementById("msg").style.color = "green";
        document.getElementById("msg").innerText = "Código enviado para o email!";
    })
    .catch(() => {
        document.getElementById("msg").innerText = "Email não encontrado";
    });
}