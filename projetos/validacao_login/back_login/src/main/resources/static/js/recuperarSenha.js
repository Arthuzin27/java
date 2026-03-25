function recuperarSenha() {
    const email = document.getElementById("email").value.trim();
    const msg = document.getElementById("msg");

    msg.innerText = "";

    if (!email) {
        msg.style.color = "red";
        msg.innerText = "Digite seu email";
        return;
    }

    fetch("/auth/forgot-password", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email })
    })
    .then(async res => {
        if (!res.ok) {
            throw new Error(await res.text());
        }

        msg.style.color = "green";
        msg.innerText = "Código enviado para seu email!";

        localStorage.setItem("emailParaRedefinir", email);

        setTimeout(() => {
            window.location.href = "novaSenha.html";
        }, 1000);
    })
    .catch(err => {
        msg.style.color = "red";
        msg.innerText = err.message || "Erro ao enviar código";
    });
}

document.getElementById("btnRecuperar")?.addEventListener("click", recuperarSenha);