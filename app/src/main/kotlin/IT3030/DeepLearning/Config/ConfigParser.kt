package IT3030.DeepLearning.Config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import java.io.File

class ConfigParser(val fileName: String) {

  fun readFile() {
    // TODO: add try catch
    val fileString = File(this.fileName)
      .readText()
  }

}

@Serializable
data class Test(val test: String)

fun main() {
  val test = Test("Hei")

  val jaja= Yaml.default.encodeToString(Test.serializer(), test)

  println(jaja)
}