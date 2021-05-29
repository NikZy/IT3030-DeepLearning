package IT3030.DeepLearning.NeuralnetWork

import IT3030.DeepLearning.ActivationFunction
import IT3030.DeepLearning.Config.ActivationFunctionEnum
import IT3030.DeepLearning.Config.NeuralLayer
import IT3030.DeepLearning.Config.Output
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
    val hiddenLayers: List<NeuralNetworkLayer>
    val inputLayerSize: Int
    val outputLayer: NeuralNetworkLayer

    constructor(
        inputLayer: List<Int>,
        hiddenLayers: List<NeuralLayer>,
        outputLayer: Output,
    ) {
        this.inputLayerSize = inputLayer.first()
        this.hiddenLayers = hiddenLayers.map { layer ->
            NeuralNetworkLayer(
                inputSize = layer.size.first(),
                outputSize = layer.size.last(),
                activationFunction = ActivationFunction(layer.activation_function),
            )
        }
        this.outputLayer = NeuralNetworkLayer(
            inputSize = this.hiddenLayers.last().outputSize,
            outputSize = outputLayer.size.last(),
            activationFunction = ActivationFunction(ActivationFunctionEnum.none)
        )
    }

    fun forwardPass(X: List<Double>): List<Double> {
        require(X.size == this.inputLayerSize) {"Size of input does not correspond to network size"}

        var tempX: List<Double> = X
        this.hiddenLayers.forEach{ layer ->
            tempX = layer.forward(tempX)
        }
      return this.outputLayer.forward(tempX)
    }
    fun backwardPass() {
        TODO()
    }
}

