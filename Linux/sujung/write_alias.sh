#!/bin/sh

best='ls -al'

#목표 bashrc 에 쓰기
#1.사용자한테 입력받기
#2.입력받은거랑 + 명령어랑 bashrc에 저장


echo 가장 많이 입력한명령어는 $best 입니다. 등록을 원하십니까?
read Is_yes
if [ "$Is_yes" = "y" ]; then
    echo 어떤 단축명령어를 등록하겠습니까?
    read cmd
    echo $cmd
    result="alias $cmd='$best'"
    echo $result
    #alias egrep='egrep --color=auto'
    
    echo $result >> bashrc
fi

