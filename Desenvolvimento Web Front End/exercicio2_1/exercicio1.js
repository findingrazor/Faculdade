let btnInserir = document.querySelector("#inserir");
btnInserir.addEventListener("click", inserir);

let btnExibir = document.querySelector("#exibir");
btnExibir.addEventListener("click", exibir);

let empArray = [];

function inserir() {
    let nome = document.getElementById("emp").value;
    let pecas = document.getElementById("pecas").value;
    if (nome.length == 0 || pecas.length == 0) {
        alert("Campos vazios, por favor preencha todos os campos!");
    } else if (parseInt(pecas) < 0) {
        alert("Número de peças inválido, a quantidade deve ser maior que zero!");
    } else {
        let emp = {
            func: nome,
            salario: calculoSalario(parseInt(pecas))
        };
        empArray.push(emp);
        document.getElementById("emp").value = "";
        document.getElementById("pecas").value = "";
    }
}

function calculoSalario(pecas) {
    let salario = 0;
    if (pecas > 400) {
        salario = pecas * 2.50;
    } else if (pecas > 200 && pecas <= 400) {
        salario = pecas * 2.30;
    } else if (pecas > 0 && pecas <= 200) {
        salario = pecas * 2;
    }
    return salario;
}

function exibir() {
    let soma = 0;
    let head = document.createElement("h4");
    head.innerHTML = "Nome &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Salário"; 
    document.body.append(head);
    
    for (let x = 0; x < empArray.length; x++) {
        let linha = document.createElement("li");
        linha.innerHTML = empArray[x].func + "&nbsp;&nbsp;&nbsp;" + empArray[x].salario.toFixed(2);
        document.body.append(linha);
        soma += empArray[x].salario;
    }

    let media = soma / empArray.length;

    let somaSal = document.createElement("h4");
    somaSal.innerHTML = "Total de Salários: " + soma.toFixed(2);
    document.body.append(somaSal);

    let mediaSal = document.createElement("h4");
    mediaSal.innerHTML = "Média de Salários: " + media.toFixed(2);
    document.body.append(mediaSal);
}

