#!/bin/bash -i

#result=`awk '{print $2}' history.txt`
#result=`awk '{for (i=2; i<NF; i++) printf $i " "; print $NF}' history.txt`
#source $1

while read line
do
    #echo $line
    result=`echo $line | awk '{for (i=2; i<NF; i++) printf $i " "; print $NF}'`

    echo $result
done < $1

