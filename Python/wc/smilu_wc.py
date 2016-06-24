import sys
res = {}
for word in open(sys.argv[1], 'r').read().split() :
    res[word] = res.get(word, 0) + 1
for key in res.keys() :
    print '%s : %s' % (key, res[key])
