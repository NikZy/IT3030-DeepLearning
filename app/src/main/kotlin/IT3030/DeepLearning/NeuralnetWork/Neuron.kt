package IT3030.DeepLearning.NeuralnetWork

import IT3030.DeepLearning.IActivationFunction
import org.jetbrains.numkt.array

class Neuron(
    val inputSize: Int,
    val startWeightValue: Double = 1.0,
    val weights: List<Double> = List(inputSize, { startWeightValue }),
    val bias: Double = 0.0,
    val activationFunction: IActivationFunction
) {
    fun input(input: List<Double>): Double {
        require(input.size == inputSize) { "Input size is wrong length" }

        val sumOfWeightedInputsPlusBias = input.mapIndexed { index, x ->
            x * this.weights[index]
        }.sum()
            .plus(this.bias)

        return this.activationFunction.activate(sumOfWeightedInputsPlusBias)
    }
}

fun main() {
    val Xs = array(arrayOf(1, 2, 3))
    println(Xs)
}
