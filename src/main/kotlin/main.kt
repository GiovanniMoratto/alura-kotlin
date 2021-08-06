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
}

class Conta {
    var titular = ""
    var numero = 0
    var saldo = 0.0
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