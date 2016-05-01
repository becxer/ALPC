from numpy import *

def selectJrand(i, m):
    j = i
    while j == i :
        j = int(random.uniform(0, m))
    return j

def clipAlpha(aj, H, L):
    if aj > H:
        aj = H
    if aj < L:
        aj = L
    return aj

def predict(alphas, b, train_mat, train_label, array_input):
    dataMatrix = mat(train_mat)
    labelMatrix = mat(train_label).transpose()
    array_input = mat(array_input)
    fXi = multiply(alphas, labelMatrix).T * \
      (dataMatrix * array_input.T) + b # Wx + b 
    return sign(fXi)

def smoSimple(train_mat, train_label, C, epoch):
    dataMatrix = mat(train_mat)
    labelMatrix = mat(train_label).transpose()
    b = 0
    m, n = shape(dataMatrix)
    alphas = mat(zeros((m,1)))
    iter = 0
    while(iter < epoch):
        alphaPairsChanged = 0
        for i in range(m):
            fXi = multiply(alphas, labelMatrix).T * \
              (dataMatrix * dataMatrix[i,:].T) + b #  ==  W x1 + b
            Ei = fXi - labelMatrix[i] # Error old 1
            if ((labelMatrix[i] * Ei < - 0.001 and (alphas[i] < C )) or\
              (labelMatrix[i] * Ei > 0.001 and (alphas[i] > 0))):
              j = selectJrand(i, m)
              fXj = multiply(alphas, labelMatrix).T * \
                (dataMatrix * dataMatrix[j,:].T) + b # == W x2 + b
              Ej =
    fXj - labelMatrix[j] # Error old 2
              alphaIold = alphas[i].copy()
              alphaJold = alphas[j].copy()
              if ( labelMatrix[i] != labelMatrix[j] ):
                  L = max(0, alphas[j] - alphas[i])
                  H = min(C, C + alphas[j] - alphas[i])
              elif ( labelMatrix[i] == labelMatrix[j]):
                  L = max(0, alphas[j] + alphas[i] - C)
                  H = min(C, alphas[j] + alphas[i])
              if L == H : continue
              eta = 2.0 * dataMatrix[i, :] * dataMatrix[j, :].T - \
                dataMatrix[i, :] * dataMatrix[i, :].T -\
                dataMatrix[j, :] * dataMatrix[j, :].T
              if eta >= 0: continue
              alphas[j] -= labelMatrix[j] * (Ei - Ej) / eta
              alphas[j] = clipAlpha(alphas[j], H, L)
              if ( abs(alphas[j] - alphaJold) < 0.00001 ): continue
              alphas[i] += \
                labelMatrix[j] * labelMatrix[i] * (alphaJold - alphas[j])
              b1 = b - Ei - labelMatrix[i] * (alphas[i] - alphaIold) * \
                dataMatrix[i,:] * dataMatrix[i,:].T - \
                labelMatrix[j] * (alphas[j] - alphaJold) * \
                dataMatrix[i,:] * dataMatrix[j, :].T
              b2 = b - Ej - labelMatrix[i] * (alphas[i] - alphaIold) * \
                dataMatrix[i,:] * dataMatrix[j,:].T - \
                labelMatrix[j] * (alphas[j] - alphaJold) * \
                dataMatrix[j,:] * dataMatrix[j,:].T
              if (0 < alphas[i]) and (C > alphas[i]) : b = b1
              elif (0 < alphas[j]) and (C > alphas[j]) : b = b2
              else : b = (b1 + b2) / 2.0
              alphaPairsChanged += 1
        if(alphaPairsChanged == 0): iter += 1
        else: iter = 0
    return alphas, b
     
train_mat = [\
               [0.12, 0.25],\
               [3.24, 4.33],\
               [0.14, 0.45],\
               [7.30, 4.23],\
            ]
            
train_label = [-1.0 , 1.0, -1.0, 1.0]

alphas, b = smoSimple(train_mat, train_label, C = 0.1, epoch = 40) #  0 < alpha < C

r1 = predict(alphas, b, train_mat, train_label, [0.0, 0.0])
print r1

r2 = predict(alphas, b, train_mat, train_label, [4.0, 4.0])
print r2
