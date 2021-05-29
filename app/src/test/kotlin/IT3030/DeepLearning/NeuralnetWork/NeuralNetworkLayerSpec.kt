import IT3030.DeepLearning.NeuralnetWork.NeuralNetworkLayer
import IT3030.DeepLearning.Tanh
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class NeuralNetworkLayerSpec : Spek({

    describe("NeuralNetworkLayer") {
        // Arrange
        val neuralNetworkLayer = NeuralNetworkLayer(
            inputSize = 4,
            outputSize = 2,
            activationFunction = Tanh(),
        )

        describe("forward()") {
            val input = listOf(1.0, 2.0, 3.0, 4.0)
            val output = neuralNetworkLayer.forward(input)
            it("Gives expected length as output") {
                // Assert
                assertEquals(2, output.size)
            }
            it("Calculates correct calues") {
                assertEquals(listOf(0.9999999958776926, 0.9999999958776926), output)
            }
        }
    }
})
