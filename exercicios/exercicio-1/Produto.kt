data class Produto(val nome: String, var preco: Double, val categoria: String) {
    fun aplicarDesconto(percent: Double) {
        if (percent > 0 && percent <= 100) {
            this.preco -= this.preco * (percent / 100.0)
        } else {
            println("Percentual de desconto inválido. Deve estar entre 0 e 100.")
        }
    }
}

fun main() {
    val meuProduto = Produto("Smartphone", 1500.0, "Eletrônicos")
    println("Preço original: ${meuProduto.preco}")
    
    meuProduto.aplicarDesconto(10.0)
    println("Preço com desconto: ${meuProduto.preco}")
}