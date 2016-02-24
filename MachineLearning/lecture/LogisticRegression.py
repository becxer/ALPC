from numpy import *
import random

class LogisticRegression:
    
    def __init__(self, mat_data, label_data):
        self.mat_data = mat_data
        self.label_data = label_data
        self.mat_w = array([ random.random() * 0.0000001 \
                for i in range(len(mat_data[0]))])
        self.mat_w0 = random.random() * 0.0000001

    def sigmoid(self, k):
        return 1.0 / (1.0 + math.exp(-k))

    def fit(self, epoch, lr):
        for ep in range(epoch):
            yp = (self.mat_w * self.mat_data).sum(axis=1)
            sig_yp = map(self.sigmoid, yp)
            gd = self.label_data - sig_yp
            dw = (gd * self.mat_data.T).sum(axis=1)
            dw0 = gd.sum(axis=0)
            self.mat_w = self.mat_w + dw * lr
            self.mat_w0 = self.mat_w0 + dw0 * lr

    def predict(self, input_array):
        return round(self.sigmoid((self.mat_w * input_array)\
                .sum(axis=0)))


train_mat = array([\
        [0.12, 0.25],\
        [3.24, 4.33],\
        [0.14, 0.45],\
        [7.30, 4.23],\
    ])

train_label = array([1,0,1,0])

LR = LogisticRegression(train_mat, train_label)
LR.fit(epoch = 10000, lr = 0.001)
print LR.predict(array([0.03,0.13]))

