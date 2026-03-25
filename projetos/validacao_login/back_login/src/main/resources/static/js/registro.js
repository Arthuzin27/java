function registrar() {
    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value.trim();
    const msg = document.getElementById("msg");

    msg.innerText = "";

    if (!nome || !email || !senha) {
        msg.style.color = "red";
        msg.innerText = "Preencha todos os campos";
        return;
    }

    fetch("/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nome, email, senha })
    })
    .then(async res => {
        if (!res.ok) {
            throw new Error(await res.text());
        }

        msg.style.color = "green";
        msg.innerText = "Cadastro realizado com sucesso!";

        setTimeout(() => {
            window.location.href = "login.html";
        }, 1500);
    })
    .catch(err => {
        msg.style.color = "red";
        msg.innerText = err.message || "Erro ao cadastrar";
    });
}

document.getElementById("btnRegistrar")?.addEventListener("click", registrar);