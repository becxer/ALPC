
def count_word(str_in):
    res = {}
    for word in str_in.split():
        res[word] = res.get(word,0) + 1
    return res

def count_file(filename):
    fo = open(filename)
    read_str = fo.read().strip()
    return count_word(read_str)

#------------------------------------------------------
if __name__ == "__main__": # python jinwon_wordcount.py
    test_str = "abc car cat dog cat dog dog"
    res = count_word(test_str)
    assert res["dog"] == 3
    assert res["cat"] == 2
    assert res["car"] == 1
    read_str = ""
    fo = open("test.txt")
    read_str = fo.read().strip()
    assert read_str == "abcde"
#------------------------------------------------------

# python jinwon.py input.txt <-- argument!

import sys
argument = sys.argv[1]
print "argument", argument
assert len(sys.argv) >= 2

print count_file(argument)
