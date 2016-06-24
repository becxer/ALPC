

def count_res(str_in):
    res = {}
    for word in str_in.split():
        res[word] = res.get(word, 0) + 1
    return res
   
    pass


if __name__ == '__main__':

    str = "abc cat dog dog cat"
    res = count_res(str)
    print res
    assert res['abc'] == 1
    assert res['cat'] == 2


