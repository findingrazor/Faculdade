let btnValidar = document.querySelector("#validar");
btnValidar.addEventListener("click", verificar);

function verificar() {
    let cpf = document.getElementById("cpf").value;
    const num = /^\d+$/;
    let calculo = 0;
    let cpfNum = [];
    let dig1 = 0;
    let dig2 = 0;

    if (cpf.length != 11 || !num.test(cpf)) {
        alert("CPF invalido, por favor digite apenas numeros e 11 digitos");
    } else {
        for (let x = 1; x <= cpf.length - 2; x++) {
            cpfNum[x - 1] = Number(cpf.charAt(x - 1));
            calculo = calculo + (cpfNum[x - 1] * x);
        }
        dig1 = calculo % 11;
        if (dig1 == 10) {
            dig1 = 0;
        }
        calculo = 0;
        for (let x = 0; x <= cpf.length - 2; x++) {
            if(x < 9){
                cpfNum[x] = Number(cpf.charAt(x));
            } else {
                cpfNum[x] = dig1;
            }
            calculo = calculo + (cpfNum[x] * x);
        }
        dig2 = calculo % 11;
        if (dig2 == 10) {
            dig2 = 0;
        }
        if (Number(cpf.charAt(9)) != dig1 || Number(cpf.charAt(10)) != dig2) {
            alert("Digito Invalido");
        } else {
            alert("Digito Correto");
        }
    }
}