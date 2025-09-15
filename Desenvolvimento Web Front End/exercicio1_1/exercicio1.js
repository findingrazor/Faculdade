let vencedor;

let btnchecar = document.querySelector("#checar");
btnchecar.addEventListener("click", jogo);

let btnlimpar = document.querySelector("#limpar");
btnlimpar.addEventListener("click", limpar);

function jogo(){
    let jogador1 = document.getElementById("jogada1").value;
    let jogador2 = document.getElementById("jogada2").value;
    jogada1 = jogador1.toLowerCase();
    jogada2 = jogador2.toLowerCase();

    if(jogada1 == 'papel'){
        if(jogada2 == 'papel'){
            vencedor = "Empate";
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 == 'tesoura'){
            vencedor = "Jogador 2!"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 == 'pedra'){
            vencedor = "Jogador 1!"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else {
            alert("Jogada inválida para o jogador 2, escolha pedra, papel ou tesoura!");
        }
    } else if(jogada1 == 'tesoura'){
        if(jogada2 == 'papel'){
            vencedor = "Jogador 1!";
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 =='tesoura'){
            vencedor = "Empate"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 == 'pedra'){
            vencedor = "Jogador 2!"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else {
            alert("Jogada inválida para o jogador 2, escolha pedra, papel ou tesoura!");
        }
    } else if(jogada1 == 'pedra'){
        if(jogada2 == 'papel'){
            vencedor = "Jogador 2!";
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 == 'tesoura'){
            vencedor = "Jogador 1!"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else if(jogada2 == 'pedra'){
            vencedor = "Empate"
            document.getElementById("resultado").innerHTML = "<p>Vencedor: "+ vencedor +"</p>";
        } else {
            alert("Jogada inválida para o jogador 2, escolha pedra, papel ou tesoura!");
        }
    } else{
        alert("Jogada inválida para o jogador 1, escolha pedra, papel ou tesoura!");
    }    
}

function limpar(){
    document.getElementById("jogada1").value = "";
    document.getElementById("jogada2").value = "";
    document.getElementById("resultado").innerHTML = "<p>Vencedor:</p>";

}