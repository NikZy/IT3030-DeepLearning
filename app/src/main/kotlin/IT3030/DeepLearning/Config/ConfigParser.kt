package IT3030.DeepLearning.Config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import java.io.File
import java.lang.Exception

class ConfigParser(val fileName: String) {

  fun readFile() {
    try {

    } catch (e: Exception) {
      // TODO: Logger: Swap with logger
      println(e)
    }
    val fileString = File(this.fileName)
      .readText()
    println(fileString)

    val config = Yaml.default.decodeFromString(Config.serializer(),fileString)
  }

}
@Serializable
data class HiddenLayer(
  val size: List<Int>,
  // TODO: Swap with Enums
  val activation_function: ActivationFunctionEnum
)
@Serializable
data class Neuralnet (
  val input: List<Int>,
  val hiddenLayers: List<HiddenLayer>,
)
@Serializable
data class Config (
  val neuralnet: Neuralnet
)


fun main() {
  val configParser = ConfigParser("config.yml")
  configParser.readFile()
}