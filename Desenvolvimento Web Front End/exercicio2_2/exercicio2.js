let vetCidades = ["BELO HORIZONTE", "SÃO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"];

let btnCalcular = document.querySelector("#calcular");
btnCalcular.addEventListener("click", function() {
    let checkin = Number(document.getElementById("cin").value);
    let checkout = Number(document.getElementById("cout").value);
    let tipoQuarto = Number(document.getElementById("tipo").value);

    calcularConta(checkin, checkout, tipoQuarto);
});

let btnInserir = document.querySelector("#inserir");
btnInserir.addEventListener("click", inserir);

let btnExibir = document.querySelector("#relatorio");
btnExibir.addEventListener("click", exibir);

let arrContas = [];

function inserir() {
    let hospede = document.getElementById("hospede").value;
    let checkin = Number(document.getElementById("cin").value);
    let checkout = Number(document.getElementById("cout").value);
    let tipoQuarto = Number(document.getElementById("tipo").value);
    let cidade = document.getElementById("cidades").value.toUpperCase();
    let existe = true;
    let vlrTotal = 0;

    for (let x = 0; x < arrContas.length; x++) {
        if (cidade == vetCidades[x]) {
            existe = true;
            break;
        } else {
            existe = false;
        }
    }

    if (hospede.length == 0 || isNaN(checkin) || isNaN(checkout) || cidade.length == 0){
        alert("Há campos vazios, por favor preencha todos os campos")
    } else if (checkin > checkout) {
        alert("O dia de check-in deve ser menor que o de check-out");
    } else if (existe == false) {
        alert("A cidade escolhida não faz parte da rede de hotéis por favor escolha: <br> BELO HORIZONTE, SÃO PAULO, RIO DE JANEIRO, SALVADOR ou CURITIBA");
    } else {
        let conta = {
            nome: hospede,
            checkin: checkin,
            checkout: checkout,
            tipo: tipoQuarto,
            cidade,
            vlrTotal: Number(calcularConta(checkin, checkout, tipoQuarto))
        }
        arrContas.push(conta);
        document.getElementById("hospede").value = "";
        document.getElementById("cin").value = "";
        document.getElementById("cout").value = "";
        document.getElementById("tipo").value = "120"; 
        document.getElementById("cidades").value = "";
        //document.getElementById("hospede").focus();
    }
}

function calcularConta(checkin, checkout, tipoQuarto) {
    let vlrTotal = 0;
    vlrTotal = (checkout - checkin) * tipoQuarto;
    document.getElementById("vlrConta").innerHTML = "Valor da Conta: " + Number(vlrTotal) + "";
    return vlrTotal;
}

function exibir() {
    let somaContas = 0;
    let mediaContas = 0;
    document.getElementById("resultado").innerHTML = 'RELATÓRIO DE CONTAS ACIMA DA MÉDIA';
    document.getElementById("lista").innerHTML = 'NOME &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; VALOR DA CONTA';

    for (let x = 0; x < arrContas.length; x++) {
        somaContas += arrContas[x].vlrTotal;
    }

    mediaContas = somaContas / arrContas.length;

    for (let x = 0; x < arrContas.length; x++) {
        if (arrContas[x].vlrTotal >= mediaContas) {
            let linha = document.createElement("li");
            linha.innerHTML = arrContas[x].nome + "&nbsp;&nbsp;&nbsp;" + arrContas[x].vlrTotal.toFixed(2);
            document.body.append(linha);
        }
    }
}
