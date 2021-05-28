import IT3030.DeepLearning.Config.ConfigParser
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ConfigParserSpec : Spek({


  val configYml = """
    neuralnet:
      input: 
        - 20
        - 30
      
      hiddenLayers:
        - size:
            - 20
            - 20
          activation_funtion: tanh
      
        
        
  
  """.trimIndent()

    describe("#${ConfigParser::readFile.name}") {
      assertTrue { true }

      describe("It can parse yaml correctly") {
        // Arrange
        val configSimple = """
              neuralnet:
                test: yes!
            """.trimIndent()
        @Serializable
        data class Neuralnet(val test: String)

        @Serializable
        data class SimpleConfig (val neuralnet: Neuralnet)

        @Serializable
        data class Test(
          val neuralnet: Neuralnet,
        )

        // Act
        val parsed = Yaml.default.decodeFromString(SimpleConfig.serializer(), configSimple)
        println(parsed)

        val expected = SimpleConfig(Neuralnet("yes!"))
        // Assert
        assertEquals(expected, parsed)
        assertEquals(expected.neuralnet.test, "yes!")
      }
      

    }

})