from numpy import *

class NaiveBayes:

    def __init__(self, mat_data, label_data):
        self.word_data = mat_data
        self.num_word = 0

        self.cate_data = label_data
        self.cate_count = {}
        self.cate_count_sum = 0

        self.cate_map = []
        self.num_cate = 0

        self.cate_word_vector = {}
        self.cate_word_vector_sum = {}

    def fit(self):
        self.num_word = len(self.word_data[0])
        for i, cate in enumerate(self.cate_data):
            self.cate_word_vector[cate] = self.cate_word_vector.get(cate, \
                    zeros(self.num_word)) + self.word_data[i]
            self.cate_count[cate] = self.cate_count.get(cate, 0) + 1
            self.cate_count_sum += 1
            
        for cate in self.cate_word_vector:
            self.cate_word_vector_sum[cate] = \
              self.cate_word_vector[cate].sum(axis = 0)

        self.num_cate = len(self.cate_count)
        self.cate_word_vector = array(self.cate_word_vector.values())
        self.cate_word_vector_sum = array(self.cate_word_vector_sum.values())
        self.cate_map = array(self.cate_count.keys())
        self.cate_count = array(self.cate_count.values())


    def predict(self, array_input):
        inprod_cate_word = self.cate_word_vector * \
          tile(array_input, (self.num_cate,1))

        logged_inprod_cate_word = array(map(lambda words : \
            map(lambda wc : log(wc + 1), words), inprod_cate_word ))

        tiled_cate_word_vector_sum = tile(self.cate_word_vector_sum.T,\
                                              (self.num_word,1)).T

        logged_tiled_cate_word_vector_sum = \
          array(\
           map(lambda vt_sums : \
              map(lambda vt_sum : log(vt_sum + self.num_word), vt_sums),\
                   tiled_cate_word_vector_sum))
        logged_cate_prob =  array(map(lambda c : log(c) - log(self.cate_count_sum),\
                                          self.cate_count))
        prob_result = logged_cate_prob + \
          (logged_inprod_cate_word - logged_tiled_cate_word_vector_sum).sum(axis=1)

        best_cate_index = prob_result.argsort()[::-1][0]
        return self.cate_map[best_cate_index]
    
        
        
sample_mails = [\
                  "hello this is virus mail",\
                  "hi this is from friend",\
                  "how about buy this virus",\
                  "facebook friend contact to you",\
                  "I love you baby virus",\
                  "what a nice day how about you"\
                    ]

label_mail = ['spam', 'ham', 'spam', 'ham', 'spam', 'ham']
                 
# vector = (hello, this, is, virus, mail, friend, how, about)    
# sentence 1 = (1,1,1,1,0,0,0,0)
# sentence 2 = (0,1,1,0,1,0,0,0)

def word_vector(voca, sentence):
    ret = []
    for word in voca:
        sentence_words = sentence.split()
        if word in sentence_words:
            ret.append(1)
        else:
            ret.append(0)
    return ret

set_of_word = {}

for mail in sample_mails:
    for word in mail.split():
        set_of_word[word] = set_of_word.get(word, 0) + 1
voca = set_of_word.keys()

vectors = []
for mail in sample_mails:
    vt = word_vector(voca, mail)
    vectors.append(vt)

nb = NaiveBayes(vectors, label_mail)
nb.fit()
print nb.predict(word_vector(voca, "nice a facebook this"))

