package com.example.demo

import javafx.fxml.FXML
import javafx.scene.control.Label
import java.lang.Math.random
import kotlin.math.sin
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class HelloController {

    val matrix1 = arrayListOf(
            arrayListOf(1,5,9,4,2,2),
            arrayListOf(1,2,3,4,8,8),
            arrayListOf(5,2,9,4,3,3),
            arrayListOf(5,2,9,4,3,3)
    )
    val matrix2 = arrayListOf(
            arrayListOf(1,2,6,6),
            arrayListOf(1,2,4,4),
            arrayListOf(8,1,7,7),
            arrayListOf(4,3,6,6),
            arrayListOf(2,5,2,2),
            arrayListOf(2,5,2,2)
    )

    val line = matrix1.size - 1
    val column = matrix2[0].size - 1

    val binaryTree = BinaryTree()

    @FXML
    private lateinit var welcomeText: Label

    @OptIn(ExperimentalTime::class)
    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
        val time = measureTime {
            matrix()
            fazONode()
            runNBody()
        }
        println("\n${time}")
    }

    fun matrix(): Array<IntArray> {
        val product = Array(line + 1) { IntArray(column + 1) }
        var temp = 0

        for (i in 0 .. line) {
            for (y in 0 .. column) {
                for (z in 0 .. column) {
                    temp += matrix1[i][z] * matrix2[z][y]
                }
                product[i][y] = temp
                temp = 0
            }
        }

        println("Termino a matriz")

        return product
    }

    fun fazONode() {
//        var i = 0
//        while(i < 1000){
//            if(binaryTree.insert((sin(random()) - sin(random()) * -100).toInt())) {
//                i++
//            }
//        }
        for (i in 0 until  1000000000) {
            binaryTree.insert((sin(random()) - sin(random()) * -100).toInt())
        }
        binaryTree
        println("Termino o nó")
    }

    fun runNBody() {
        var bodies = NBody()
        bodies.NBodySystem()
        println("${bodies.energy()}")
        for (i in 0 until 50000000) bodies.advance(0.01)
        println("${bodies.energy()}")
    }


}