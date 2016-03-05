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
#echo "---"

$max_value=0
$key_store
for key in ${!cmd_count[@]}
do
      #echo $key
      
      echo "$key : ${cmd_count[$key]}"
      #if ["${cmd_count['$key']} = "$1"]; then
      if [ ${cmd_count[$key]} -gt $max_value ]; then
          max_value=${cmd_count[$key]}
          key_store=$key
      fi

      #cmd_count["$key"]=0
done

echo $max_value
echo "The best keyword is $key_store"
reconv=`echo $key_store | sed 's/_/ /g'`
echo $reconv

