let botao = document.querySelector("button");

botao.addEventListener("click", atualizarNome);

function atualizarNome(){
    let nome = prompt("Digite um novo nome");
    if (nome!=null){
        botao.textContent = "Jogador 1: " +nome;
        alert("O NOME SERÁ ALTERADO!");
    }
}