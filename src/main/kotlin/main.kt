/**
 *@Author giovanni.moratto
 */

fun main() {
    println("Bem vindo ao Bytebank")
    val contaGiovanni = Conta()
    contaGiovanni.titular = "Giovanni"
    contaGiovanni.numero = 1000
    contaGiovanni.saldo = 200.0

    val conta2 = Conta()
    conta2.titular = "Fran"
    conta2.numero = 1001
    conta2.saldo = 300.0

    println(conta2.titular)
    println(conta2.numero)
    println(conta2.saldo)

    println(contaGiovanni.titular)
    println(contaGiovanni.numero)
    println(contaGiovanni.saldo)

    println("depositando na conta do Giovanni")
    deposita(contaGiovanni, 50.0)
    println(contaGiovanni.saldo)

    println("depositando na conta 2")
    deposita(conta2, 70.0)
    println(conta2.saldo)
}

fun deposita(conta: Conta, valor: Double) {
    conta.saldo += valor
}

class Conta {
    var titular = ""
    var numero = 0
    var saldo = 0.0
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta()
    contaJoao.titular = "João"
    var contaMaria = Conta()
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