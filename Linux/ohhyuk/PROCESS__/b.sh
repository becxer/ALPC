#!/bin/bash
total=0
declare -Ax procList

echo "program is running..."
while : ; do
    clear

    while read line
    do
        result=`ps aux | sort -rk 3,3 | head -n 2 | grep "$line"`
        if [ ! -z "$result" ]; then
            total=$(($total+1))
            temp=$((${procList["$line"]}+1))
            procList["$line"]=$temp
        fi
    done < proclist.dat

    for key in ${!procList[@]}
    do
        value=${procList[$key]}
        echo "$key >> $value / $total ($(($value*100/$total))%)"
    done
# (LEGACY SOURCE CODE)
#    result=`ps aux | sort -rk 3,3 | head -n 2 | grep "htop"`
#    #result=`top -n 1 -l 1 -o cpu | grep "KakaoTalk"`
#    if [ ! -z "$result" ]; then
#        kakao=$(($kakao+1))
#    fi
#    #if [ $total -eq 3600 ]; then
#    #    break
#    #fi
    sleep 1
done
echo "program is ended..."
