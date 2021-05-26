package IT3030.DeepLearning.Config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

//class ConfigParser

@Serializable
data class Test(val test: String)

fun main() {
  val test = Test("Hei")

val jaja= Yaml.default.encodeToString(Test.serializer(), test)
  println(jaja)
}