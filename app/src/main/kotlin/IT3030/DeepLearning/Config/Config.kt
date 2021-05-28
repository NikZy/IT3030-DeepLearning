package IT3030.DeepLearning.Config

import kotlinx.serialization.Serializable

@Serializable
data class Output(
    val size: List<Int>,
    val activation_function: ActivationFunctionEnum,
    val weight_regularization: WeightRegularizationEnum,

)

@Serializable
data class HiddenLayer(
    val size: List<Int>,
    val activation_function: ActivationFunctionEnum,
    val weight_regularization: WeightRegularizationEnum,
)

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
