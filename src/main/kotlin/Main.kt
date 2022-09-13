import java.util.*

fun main(args: Array<String>) {
    var nombre : String? = null
    nombre?.let {
        valor -> println("El nombre no es nulo, es $valor")
    }
    nombre = "Angela"
    nombre?.let {
        valor  -> println("El nombre no es nulo, es $valor")
    }
}