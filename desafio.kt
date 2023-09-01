enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome")
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
        println("${usuario.nome} foi desmatriculado na formação $nome")
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 60)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 90)

    
    val formacao = Formacao("Formação em Desenvolvimento Web", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.map { it.nome }}")

    
    formacao.desmatricular(usuario1)

    
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.map { it.nome }}")
}

