package ru.igorlo

import ru.igorlo.Generation.GenerationApplication
import ru.igorlo.Visualisation.GraphVisualiser
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Input a command: ")
        val text = scanner.next()
        when (text.toLowerCase()) {
            "generate" -> GenerationApplication.main()
            "graph" -> GraphVisualiser.main()
            "exit" -> exitProcess(0)
            "echo" -> println(scanner.next())
            "hello" -> println("well... Hello")
        }
    }
}