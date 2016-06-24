from numpy import *

class Logistic :
    def __init__(self, train_mat, train_label) :
        self.train_mat = matrix(train_mat)
        self.train_label = matarix(train_label)
        self.W = matrix([])
        self.W0 = 0
    def fit(self, lr, epoch) :
        for count in range(epoch) :
           # delta_W = (y_prime - y) * X
