import IT3030.DeepLearning.Config.*
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ConfigParserSpec : Spek({



    describe("#${ConfigParser::readFile.name}") {
      assertTrue { true }

      describe("It can parse yaml correctly") {
        // Arrange
        val configSimple = """
              neuralnet:
                test: yes!
                list:
                  - a: 1
                    b: 2
                  - a: 3
                    b: 4
            """.trimIndent()

        @Serializable
        data class Test(
          val a: String,
          val b: String
        )
        @Serializable
        data class Neuralnet(
          val test: String,
          val list: List<Test>)

        @Serializable
        data class SimpleConfig (val neuralnet: Neuralnet)


        // Act
        val parsed = Yaml.default.decodeFromString(SimpleConfig.serializer(), configSimple)
        println(parsed)

        val expected = SimpleConfig(
          Neuralnet("yes!", listOf(
            Test("1", "2"),
            Test("3", "4")
          )),
        )
        // Assert
        assertEquals(expected, parsed)
        assertEquals(expected.neuralnet.test, "yes!")
        assertEquals(expected.neuralnet.list.size, 2)
      }
      describe("It can decode advanced Yaml") {
        // Arrange
        val configYml = """
                        neuralnet:
                          input: 
                            - 20
                            - 30
                          
                          hiddenLayers:
                            - size:
                                - 20
                                - 20
                              activation_function: tanh
                        """.trimIndent()
        println(configYml)


        //Act
        val parsed = Yaml.default.decodeFromString(Config.serializer(), configYml)
        println("Size")

        println(parsed.neuralnet.hiddenLayers.size)
        println(parsed)
        val expected = Config(
          Neuralnet(
          input = listOf(20, 30),
          hiddenLayers = listOf(
          HiddenLayer(
              size = listOf(20, 20),
              activation_function = "tanh"
            )
          )
        )
        )
        // Assert
        assertEquals(expected.neuralnet.hiddenLayers[0].activation_function, "tanh")
      }


    }

})