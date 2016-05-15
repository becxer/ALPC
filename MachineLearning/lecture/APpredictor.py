
# NaiveBayes spam,ham   ->  wordvector
# AP_rssi.data -> wordvector
# wordvector -> NaiveBayes -> prediction

import json
from NaiveBayes import *

rssi_dat = open("rssi.dat")
rssi_dat =  rssi_dat.read().split('\n')
rssi_dat.pop()
print len(rssi_dat)

APdict = {}
label_data = []
for row in rssi_dat:
    row = json.loads(row)
    # apList = []
    # areaID = ""
    aplist = row["apList"]
    area_id = row["areaID"]
    print area_id , len(aplist)
    label_data.append(area_id)
    for ap in aplist:
        APdict[ap["bssid"]] = APdict.get(ap["bssid"], 0) + 1

print APdict
print APdict.keys() # vector column

count = 0
train_mat = []
train_label = []
test_mat = []
test_label = []

def ap2vector(ap_list):
    vt = [0 for i in range(len(APdict.keys()))]
    for idx, ap_word in enumerate(APdict.keys()):
        for ap in ap_list:
            if ap_word == ap["bssid"] :
                vt[idx] = 1
                break
    return vt

for row in rssi_dat:
    row = json.loads(row)
    count += 1
    ap_list = row["apList"]
    area_id = row["areaID"]
    vt = ap2vector(ap_list)
    if count % 5 == 0 :
        test_mat.append(vt)
        test_label.append(area_id)
    else:
        train_mat.append(vt)
        train_label.append(area_id)

print len(train_mat)
print len(train_label)
print len(test_mat)
print len(test_label)

nb = NaiveBayes(train_mat, train_label)
nb.fit()
correct = 0.0
for idx, row in enumerate(test_mat):
    predicted_label = nb.predict(row)
    print "origin : ", test_label[idx] , " predicted : ", predicted_label
    if test_label[idx] == predicted_label:
        correct += 1.0
print "Prediction : ", correct * 100 / len(test_mat)

