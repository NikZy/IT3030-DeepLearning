package IT3030.DeepLearning.Config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import java.io.File
import java.lang.Exception

class ConfigParser(val fileName: String) {

  val config: Config = parseString(readFile())

  private fun readFile(): String {
      val fileString = File(this.fileName)
        .readText()
      return fileString
  }
  private fun parseString(str: String): Config = Yaml.default.decodeFromString(Config.serializer(), str)

}
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
data class Neuralnet (
  val input: List<Int>,
  val hiddenLayers: List<HiddenLayer>,
  val output: Output
)
@Serializable
data class Config (
  val neuralnet: Neuralnet
)


fun main() {
  val configParser = ConfigParser("config.yml")
  println("Hei")

}