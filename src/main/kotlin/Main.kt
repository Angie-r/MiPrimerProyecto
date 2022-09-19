// declarar valores de respuesta.

const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "\uD83E\uDD14"

// Unimos las respuestas con los valores
val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitiamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA
)
fun main(args: Array<String>) {
    println("Hola Soy tu bola 8 magica, creada en Kotlin" +
            "Cual de estas opciones deseas realizar?")
    println("1. Realizar una pregunta")
    println("2. Revisar todas las respuestas")
    println("3. Salir")

//Se obtiene el valor del usaurio y lo convierte en un entero nullable

//Dependiendo de la opcion se utiliza when para realizar la accion requerida.
    when(readln()){
        "1" -> realizarPregunta()
        "2" -> mostrarRespuesta()
        "3" -> salir()
        else -> mostrarError()
    }
}
fun realizarPregunta(){
    println("Que pregunta deseas realizar?")
    readln()
    println("Asi que esa es tu pregunta... La respuesta a eso es: ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}

fun mostrarRespuesta(){
    println("Selecciona una opcion")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas afirmativas")
    println("3. Revisar solo las respuetas dudosas")
    println("4. Revisar solo las respueras negativas")

    val opcionIngresada = readln()
    when(opcionIngresada){
        "1" ->  mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        else -> println("Respuesta no valida, adios.")
    }
}
fun mostrarRespuestasPorTipo(tipoDeRespuesta: String = "TODOS"){
    when(tipoDeRespuesta){
        "TODOS" -> respuestas.keys.forEach{respuesta -> println(respuesta)}
        RESPUESTA_AFIRMATIVA -> respuestas.filterValues {values -> values == RESPUESTA_AFIRMATIVA }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }
        RESPUESTA_NEGATIVA -> respuestas.filterValues {values -> values == RESPUESTA_NEGATIVA }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }
        RESPUESTA_DUDOSA -> respuestas.filterValues {values -> values == RESPUESTA_DUDOSA }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }
    }
}

fun salir(){
    println("Hasta luego!")

}

fun mostrarError(){
    println("Vaya parece que has elegido una opcion no valida, intente de nuevo")
}
