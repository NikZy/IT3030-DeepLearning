import IT3030.DeepLearning.NeuralnetWork.Neuron
import IT3030.DeepLearning.Tanh
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.lang.IllegalArgumentException
import kotlin.math.exp
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NeuronSpec : Spek({

    describe("Neuron") {
        describe("input()") {
            // Arrange
            val neuron = Neuron(
                inputSize = 4,
                activationFunction = Tanh(),
                startWeightValue = 1.0,
                bias = 0.0
            )
            it("Calculated tanh function correctly") {
                val input = listOf(1.0, 2.0, 3.0, 4.0)
                // Act
                val output = neuron.input(input)
                val sum = input.sum()
                val expected = (exp(sum) - exp(-sum)) / (exp(sum) + exp(-sum))

                // Assert
                assertEquals(expected, output)
            }
            it("Throws exeption when given input of wrong size") {
                assertFailsWith<IllegalArgumentException> {
                    neuron.input(listOf(1.0))
                }
            }
        }
    }
})
