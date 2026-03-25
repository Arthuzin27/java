function resetarSenha() {
    const codigo = document.getElementById("codigo").value.trim();
    const novaSenha = document.getElementById("novaSenha").value.trim();
    const msg = document.getElementById("mensagem");

    const email = localStorage.getItem("emailParaRedefinir");

    msg.innerText = "";

    if (!codigo || !novaSenha) {
        msg.style.color = "red";
        msg.innerText = "Preencha todos os campos";
        return;
    }

    if (!email) {
        msg.style.color = "red";
        msg.innerText = "Sessão expirada. Volte e solicite novamente.";
        return;
    }

    fetch("/auth/resetar-password", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            email: email,
            codigo: codigo,
            novaSenha: novaSenha
        })
    })
    .then(async res => {
        const texto = await res.text();

        if (!res.ok) {
            throw new Error(texto);
        }

        msg.style.color = "green";
        msg.innerText = "Senha redefinida com sucesso!";

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

document.getElementById("btnResetar")?.addEventListener("click", resetarSenha);