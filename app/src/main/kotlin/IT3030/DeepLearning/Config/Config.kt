package IT3030.DeepLearning.Config

import kotlinx.serialization.Serializable

interface NeuralLayer {
    val size: List<Int>
    val activation_function: ActivationFunctionEnum
    val weight_regularization: WeightRegularizationEnum
}
@Serializable
data class Output(
    override val size: List<Int>,
    override val activation_function: ActivationFunctionEnum,
    override val weight_regularization: WeightRegularizationEnum,

) : NeuralLayer

@Serializable
data class HiddenLayer(
    override val size: List<Int>,
    override val activation_function: ActivationFunctionEnum,
    override val weight_regularization: WeightRegularizationEnum,
) : NeuralLayer

@Serializable
data class Neuralnet(
    val input: List<Int>,
    val hiddenLayers: List<HiddenLayer>,
    val output: Output
)

@Serializable
data class Config(
    val neuralnet: Neuralnet
)
