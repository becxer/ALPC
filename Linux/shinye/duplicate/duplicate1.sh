
#!/bin/bash

# 남길 파일 한개를 받는다
# $1 ... $N == 위치 매개변수

target=$1

# 현재 폴더에서 파일들을 읽어옴 "."<요건 뭐지
# 변수 files에 'find~~' 값을 할당
# 변수에 문자열을 입력할 경우 작은 따옴표('') 안에 value값 삽입하면 됨

files=`find . -name '*' -and -not -name $target -and -not -name '.'`
echo $files

# $files => 변수 files에 입력된 값을 호출

# 읽어온 파일들을 하나하나 비교하기. 
# 읽어올 파일들과 $과 용량이 같으면 내용 비교.
#                                        다르면 패스.

#사용량을 얻는 방법 du -b 파일명
target_vol_x=$(du -b $1)
target_vol=`echo $target_vol_x | awk '{print $1}'`

#내용을 읽는 방법 cat 파일명
target_text=$(cat $1)

#echo $target_vol
#echo $target_text


#변수 $files에 저장된 파일들을 하나씩 읽어와 용량과 내용을 비교한다

for x in $files; do
        x_text=$(cat $x)
        x_vol_line=$(du -b $x)
        x_vol=`echo $x_vol_line | awk '{print $1}'`
        
#        echo "==========================================="
#       echo "내용 비교 : $x_text / $target_text"
#        echo "용량 비교 : $x_vol / $target_vol"
        
 #      echo $x_vol
#       echo $target_vol
#       echo "=================="

        if [ "$x_text" = "$target_text" ]; then
               echo "text same"
               if [ "$x_vol" = "$target_vol" ]; then
                    echo "rm $x";
               fi

       else
               echo "not same!"
       fi

done



