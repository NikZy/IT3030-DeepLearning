import IT3030.DeepLearning.ActivationFunction
import IT3030.DeepLearning.Config.ActivationFunctionEnum
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.math.exp
import kotlin.test.assertEquals


class ActivationFunctionSpec : Spek({

    describe("ActivationFunction") {
        describe("ActivationFunction Tanh") {
            // Arrange
            val function = ActivationFunction(ActivationFunctionEnum.tanh)

            // Act
            val result = function.activate(5.0)
            //Assert
            assertEquals((exp(5.0) - exp(-5.0)) / (exp(5.0) + exp(-5.0)), result)
        }

    }

})