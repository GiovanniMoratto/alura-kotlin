/**
 *@Author giovanni.moratto
 */

fun main() {
    println("Bem vindo ao Bytebank")
    val contaGiovanni = Conta()
    contaGiovanni.titular = "Giovanni"
    contaGiovanni.numero = 1000
    contaGiovanni.setSaldo(-200.0)

    val conta2 = Conta()
    conta2.titular = "2"
    conta2.numero = 1001
    conta2.setSaldo(300.0)

    println(conta2.titular)
    println(conta2.numero)
    println(conta2.getSaldo())

    println(contaGiovanni.titular)
    println(contaGiovanni.numero)
    println(contaGiovanni.getSaldo())

}

class Conta {
    var titular = ""
    var numero = 0
    private var saldo = 0.0

    fun deposita(valor: Double) {
        this.saldo += valor
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

    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    }
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