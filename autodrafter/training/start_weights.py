import numpy
from numpy import exp
from numpy import array
from numpy import random as rn
from numpy import dot

class NN():
    def __init__(self):
        total = 0
        with open("saved_data/Ai_Layers.txt", "r") as inp:
            for line in inp:
                try: total += int(line)
                except ValueError: 
                    if line != ' ': print('{} is not a number!'.format(line))
        plusminus = (total/25612800)
        self.synaptic_weights = rn.random((12, 2)) -plusminus

    def __sigmoid(self, x):
        return 1/ (1 + exp(-x))

    def __sigmoid_derivative(self, x):
        return x * (1 -x)

    def train(self, training_set_inputs, training_set_outputs, number_of_training_iterations):
        for iteration in range(number_of_training_iterations):
            output = self.think(training_set_inputs)
            error = training_set_outputs - output
            adjustment = dot(training_set_inputs.T, error * self.__sigmoid_derivative(output))
            self.synaptic_weights += adjustment

    def think(self, inputs):
        return self.__sigmoid(dot(inputs, self.synaptic_weights))


def send():
    nn = NN()
    training_set_inputs = array([[0,1,0,0,1,1,0,0,1,1,0,1],[1,0,1,1,0,0,0,0,1,1,0,1]])#[1,1],[1,1],[1,0],[1,1],[0,1],[1,0],[1,1],[1,0],[1,1]])
    training_set_outputs = array([[3+4+4+3+4+3+4+3+4+3+4+3]]).T

    nn.train(training_set_inputs, training_set_outputs, 4096)
    num = -1
    send = []
    for i in nn.synaptic_weights:
        total = [-1]
        num +=1
        total.append(num)
        total.pop(0)
        a = ['%.8f'%x for x in i]
        b = [float(i) for i in a]
        c = b+total
        send.append(c)
    return(send)
