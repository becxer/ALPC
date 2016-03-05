i=1
while : ;
do
    sleep 1
    echo "$i" > db.txt
    i=$(($i+1))
done
