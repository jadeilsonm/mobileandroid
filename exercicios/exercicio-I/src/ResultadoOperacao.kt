sealed class ResultadoOperacao {
    data class Sucesso(val valor: Int) : ResultadoOperacao()
    data class Falha(val mensagem: String) : ResultadoOperacao()
    object Pendente : ResultadoOperacao()
}

fun imprimirResultado(resultado: ResultadoOperacao) {
    when (resultado) {
        is ResultadoOperacao.Sucesso -> println("Operação concluída com sucesso! Valor: ${resultado.valor}")
        is ResultadoOperacao.Falha -> println("Atenção: A operação falhou. Motivo: ${resultado.mensagem}")
        ResultadoOperacao.Pendente -> println("Aguardando a conclusão da operação...")
    }
}
