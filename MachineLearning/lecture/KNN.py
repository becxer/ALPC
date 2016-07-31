
import numpy as np

class KNN:
    def __init__(self, x, y, k):
        self.x = np.array(x)
        self.y = y
        self.k = k

    def predict(self, in_x):
        in_x = np.array(in_x)
        pass



sample_data = [\
        [1.0, 1.1],
        [1.0, 1.0],
        [0.0, 0.1],
        [0.0, 0.0],
        [0.1, 0.1]
    ]
    
sample_label = ['A', 'A', 'B', 'B', 'B']

knn = KNN(sample_data, sample_label, k=3)

r1 = knn.predict([0.9, 0.9])
print r1

r2 = knn.predict([0.1, 0.4])
print r2

