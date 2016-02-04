# FORMAT

# BEGIN:VEVENT
# DTSTART:yearmonthday
# DTEND:yearmonthday
# SUMMARY:event_name
# END:VEVENT

# 읽어서 스트링 형태로 저장
str=`cat $1`
# 라인별로 자르기
count=0
startDate="DTSTART:"
endDate="DTEND:"
summary="SUMMARY:"
for elem in $str; do
    if [ $count -lt 3 ]; then
        startDate=$startDate$elem
    elif [ $count -lt 6 ]; then
        endDate=$endDate$elem
    else
        summary=$summary$elem
        echo "BEGIN:VEVENT" >> $2
        echo $startDate >> $2
        echo $endDate >> $2
        echo $summary >> $2
        echo "END:VEVENT" >> $2
        count=-1
        startDate="DTSTART:"
        endDate="DTEND:"
        summary="SUMMARY:"
    fi
    ((count++))
done

#for f in gwajae.ics
#do
#    echo $startDate >> "$f"
#    echo $endDate >> "$f"
#done
