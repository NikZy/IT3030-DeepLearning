package IT3030.DeepLearning.NeuralnetWork

import IT3030.DeepLearning.Config.WeightRegularizationEnum
import IT3030.DeepLearning.IActivationFunction
import IT3030.DeepLearning.Tanh
import org.jetbrains.numkt.core.*

class NeuralNetworkLayer(
    val inputSize: Int,
    val outputSize: Int,
    val activationFunction: IActivationFunction = Tanh(),
    val weightRegularizationEnum: WeightRegularizationEnum = WeightRegularizationEnum.glorot,
) {

    val neurounLayer: List<Neuron> = (1..outputSize).map {
        Neuron(
            inputSize = inputSize,
            startWeightValue = 1.0,
            bias = 0.0,
            activationFunction = activationFunction
        )
    }
    fun forward(
        X: List<Double>,
    ): List<Double> = this.neurounLayer.map { neuron ->
        neuron.input(X)
    }
}

class NeuralNetwork {
    constructor(layers: NeuralNetworkLayer) {
    }
    fun forwardPass() {
        TODO()
    }
    fun backwardPass() {
        TODO()
    }
}
