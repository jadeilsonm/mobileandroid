fun maiorDeTres(a: Int, b: Int, c: Int): Int {
    return maxOf(a, b, c)
}

fun String.inverter(): String {
    return this.reversed()
}

fun String.trocarVogaisPorAsterisco(): String {
    val vogais = "aeiouAEIOU"
    return this.map { if (it in vogais) '*' else it }.joinToString("")
}


fun main() {
    val listaDeNumeros = listOf(10, 5, 8, 25, 12)

    val maiorDaLista = listaDeNumeros.reduce { maiorAtual, proximoElemento ->
        maiorDeTres(maiorAtual, proximoElemento, 0) 
    }
    
    println("O maior número na lista é: $maiorDaLista")

    val stringTest = "Kotlin é divertido!"
    
    println("Original: $stringTest")
    println("Invertida: ${stringTest.inverter()}")
    println("Vogais trocadas: ${stringTest.trocarVogaisPorAsterisco()}")
}
