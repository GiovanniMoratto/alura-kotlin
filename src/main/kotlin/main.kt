/**
 *@Author giovanni.moratto
 */

fun main() {
    println("Bem vindo ao Bytebank")

    val contaGiovanni = Conta(titular = "Giovanni", numero = 1000)
    contaGiovanni.deposita(200.0)

    val conta2 = Conta(numero = 1001, titular = "2")
    conta2.deposita(300.0)

    println(conta2.titular)
    println(conta2.numero)
    println(conta2.saldo)

    println(contaGiovanni.titular)
    println(contaGiovanni.numero)
    println(contaGiovanni.saldo)

    println("depositando na conta do Giovanni")
    contaGiovanni.deposita(50.0)
    println(contaGiovanni.saldo)

    println("depositando na conta 2")
    conta2.deposita(70.0)
    println(conta2.saldo)

    println("sacando na conta do Giovanni")
    contaGiovanni.saca(250.0)
    println(contaGiovanni.saldo)

    println("sacando na conta 2")
    conta2.saca(100.0)
    println(conta2.saldo)

    println("saque em excesso na conta do Giovanni")
    contaGiovanni.saca(100.0)
    println(contaGiovanni.saldo)

    println("saque em excesso na conta 2")
    conta2.saca(500.0)
    println(conta2.saldo)

    println("Transferência da conta 2 para o Giovanni")

    if (conta2.transfere(destino = contaGiovanni, valor = 300.0)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println(contaGiovanni.saldo)
    println(conta2.saldo)
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    contaJoao.titular = "João"
    var contaMaria = Conta("Maria", 1003)
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Giovanni $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Giovanni $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}