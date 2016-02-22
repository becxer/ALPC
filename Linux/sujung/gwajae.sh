#!/bin/bash -i

#result=`awk '{print $2}' history.txt`
#result=`awk '{for (i=2; i<NF; i++) printf $i " "; print $NF}' history.txt`
#hist=`history`

declare -Ax cmd_count
history | while read line
do
    #echo $line
    cmd_one=`echo $line | awk '{for (i=2; i<NF; i++) printf $i " "; printf $NF}'`
    
    #array_result=($result)
    #echo "${array_result[0]}"
    #echo $cmd_one
    
    cmd_count["aaa"]=1
    break

done
echo ${cmd_count["aaa"]}

#declare하면 전역변수인가요? ㄴㄴ 어레이로 선언하는거에요

echo ${!cmd_count[@]}

for i in ${!cmd_count[@]};
do
      echo 'cmd  : $i'
      echo 'count : ${cmd_count[$i]}'
done
