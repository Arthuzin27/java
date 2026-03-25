function login() {
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value.trim();
    const msg = document.getElementById("msg");

    msg.innerText = "";

    if (!email || !senha) {
        msg.style.color = "red";
        msg.innerText = "Preencha todos os campos";
        return;
    }

    fetch("/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, senha })
    })
    .then(async res => {
        if (!res.ok) {
            throw new Error(await res.text());
        }

        const data = await res.json();
        localStorage.setItem("token", data.token);

        msg.style.color = "green";
        msg.innerText = "Login realizado com sucesso!";

        setTimeout(() => {
            window.location.href = "teste.html";
        }, 1000);
    })
    .catch(err => {
        msg.style.color = "red";
        msg.innerText = err.message || "Erro ao fazer login";
    });
}

document.getElementById("btnLogin")
    ?.addEventListener("click", login);