#!/bin/bash -i

declare -Ax cmd_count
history > yame.txt
while read line
do
    cmd_one=`echo $line | awk '{for (i=2; i<NF; i++) print $i " "; print $NF}'`
    conv=`echo $cmd_one | sed 's/ /_/g'`
    e=$((${cmd_count["$conv"]}+1))
    cmd_count["$conv"]=$e
done < yame.txt
echo "---"

for key in ${!cmd_count[@]}
do
      echo "$key : ${cmd_count[$key]}"
      cmd_count["$key"]=0
done

