function redefinirSenha() {
    const codigo = document.getElementById("codigo").value.trim();
    const novaSenha = document.getElementById("senha").value.trim();
    const confirmarSenha = document.getElementById("confirmarSenha").value.trim();
    const msg = document.getElementById("msg");

    const email = localStorage.getItem("emailParaRedefinir");

    msg.innerText = "";

    if (!email) {
        msg.style.color = "red";
        msg.innerText = "Sessão expirada. Solicite novamente.";
        return;
    }

    if (!codigo || !novaSenha || !confirmarSenha) {
        msg.style.color = "red";
        msg.innerText = "Preencha todos os campos";
        return;
    }

    if (novaSenha !== confirmarSenha) {
        msg.style.color = "red";
        msg.innerText = "As senhas não conferem";
        return;
    }

    fetch("/auth/reset-password", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, codigo, novaSenha })
    })
    .then(async res => {
        if (!res.ok) {
            throw new Error(await res.text());
        }

        msg.style.color = "green";
        msg.innerText = "Senha alterada com sucesso!";

        localStorage.removeItem("emailParaRedefinir");

        setTimeout(() => {
            window.location.href = "login.html";
        }, 1500);
    })
    .catch(err => {
        msg.style.color = "red";
        msg.innerText = err.message || "Erro ao redefinir senha";
    });
}

document.getElementById("btnResetar")?.addEventListener("click", redefinirSenha);