# TODOS
- Create a config parser
	* Need to be able to spesify the network in the config
		Example:
		inout: (20,30) # 20x20 image which is not flattened
		size: (20,20) act: tanh wr: glorot # wr = weight regulization
		size(8,8) act: tanh wr:glorot
		size 5 act: tanh wr:glorot br: (0,1)
		type: softmax

