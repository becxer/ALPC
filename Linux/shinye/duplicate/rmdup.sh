
# 남길 파일 한개를 받는다 $1 (했음) 
target=$1

#
# 현재 폴더에서 파일들을 읽어옴 (했음)
files=`find . -name "*" -and -not -name $target -and -not -name "."`

# 읽어온 파일들과 $1 과  용량이 같으면  내용 비교 
#                        용량이 다르면  패스

target_vol=$(du -b $target)
target_text=$(cat $target)

for x in $files; do
    x_text=$(cat $x)
    x_vol=$(du -b $x)
    
    echo "$target_vol"

       if [ "$x_text" == "$target_text" ]; then
        if [ "$x_vol" == "$target_vol" ]; then
#           rm $x
        fi
    else
        echo "not same!"
    fi
done

#target_vol=$(du -b $1)

# if ["$target_vol" == "??"];
# then 
#   for 
#    do
#        echo "delete"
        #rm ..
#    done
#else
#    echo "no delete"
# fi


# 용량을 얻는 방법 du -b 파일명
# 내용을 읽는 방법 cat 파일명
#
# 비교하는 방법은 bash if[ -eq ]
# if [ "$x" == "valid" ]; then
#  echo "x has the value 'valid'"
#  fi

# 내용이 같으면, 같은것은 지운다 rm 



