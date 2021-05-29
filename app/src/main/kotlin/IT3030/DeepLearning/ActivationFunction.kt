package IT3030.DeepLearning

import IT3030.DeepLearning.Config.ActivationFunctionEnum
import kotlin.math.exp

interface IActivationFunction {
  fun activate(input: Double): Double
}
sealed class ActivationFunction {
  companion object {
    operator fun invoke(f: ActivationFunctionEnum): IActivationFunction {
      when(f) {
        ActivationFunctionEnum.tanh -> return Tanh()
        ActivationFunctionEnum.linear -> TODO()
        ActivationFunctionEnum.softmax -> TODO()
      }
    }

  }
}

class Tanh(): IActivationFunction {
  override fun activate(x: Double): Double = (exp(x) - exp(-x)) /
    (exp(x) + exp(-x))
}
fun main() {
  val d = ActivationFunction(ActivationFunctionEnum.tanh)
}