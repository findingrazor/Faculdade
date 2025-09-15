let btnGerar = document.querySelector("#gerar");
btnGerar.addEventListener("click", gerar);

function gerar() {
    let nome = document.getElementById("nome").value;
    nome = nome.toUpperCase();
    const num = /\d/;
    let login = "";
    let senha = "";

    if (nome.charAt(0) == " " || nome.includes("  ") || nome.length < 15 || nome.indexOf(" ") === -1 || num.test(nome)) {
        alert("Nome inválido, por favor digite um nome com no mínimo 15 caracteres, um sobrenome, com apenas um espaço entre eles e que contenha apenas letras");
    }

    login = nome.charAt(0);
    for (let x = 0; x < nome.length; x++) {
        if (nome.charAt(x) == " ") {
            login = login + nome.charAt(x + 1);
        }
    }

    for (let x = 0; x < login.length; x++) {
        senha = senha + login.charCodeAt(x).toString().slice(0,1);
    }

    document.getElementById("login").innerHTML = "<label id='login'>Login gerado: " + login + " </label>";
    document.getElementById("senha").innerHTML = "<label id='senha'>Senha gerada: " + senha + " </label>";
}