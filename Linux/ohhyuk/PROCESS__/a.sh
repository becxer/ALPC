#!/bin/bash

total=0
kakao=0

echo "program is running..."

while : ; do
    total=$(($total+1))
    result=`ps aux | sort -rk 3,3 | head -n 2 | grep "htop"`
    #result=`top -n 1 -l 1 -o cpu | grep "KakaoTalk"`
    if [ ! -z "$result" ]; then
        kakao=$(($kakao+1))
    fi

        echo "kakao >> $(($kakao/60)) min / hour ($(($kakao*100/$total))%)"
    #if [ $total -eq 3600 ]; then
    #    break
    #fi

    sleep 1
done
echo "program is ended..."
