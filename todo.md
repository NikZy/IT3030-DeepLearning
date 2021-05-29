# TODOS
- Create a config parser
	* Need to be able to spesify the network in the config
		Example:
		inout: (20,30) # 20x20 image which is not flattened
		size: (20,20) act: tanh wr: glorot # wr = weight regulization
		size(8,8) act: tanh wr:glorot
		size 5 act: tanh wr:glorot br: (0,1)
		type: softmax


- Create NeuralNetwork
	* forwardPass()
		for each layer L, multiply outputs from upstream with weight
		then add in biases
		apply output function to these sums()

		Apply softmax functions to values entering output layer. Softmax has no incoming weigths

		Compare targets to the output values via the lossFunction()

		Cache any information (such as the outputs of each layer) needed for the baackward stage
	* backwardPass()
	* layers: NeuralNetworkLayer
	* lossFunction

- Create NeuralNetworkLayer
	* Dimensions
	* neurons
	* forwardPass()
	* backwardPass()

- Create Neuron
	* Weight
	* Bias: constant
	* activationFunction(sum(inputs * weights) + bias)

- Create ActivationFunction
	* Derivative()
