data class Products(val nome: String, var preco: Double, val categoria: String) {
    fun aplicarDesconto(percent: Double) {
        if (percent > 0 && percent <= 100) {
            this.preco -= this.preco * (percent / 100.0)
        } else {
            println("Percentual de desconto inválido. Deve estar entre 0 e 100.")
        }
    }
}
