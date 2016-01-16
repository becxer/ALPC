#!/bin/bash
target=$1
period=$2

t_date=`date -r $target "+%Y%m%d%H%M%S"`
echo $t_date
echo $period

n_date=`date "+%Y%m%d%H%M%S"`

t_date=${t_date#0}
n_date=${n_date#0}
interval=$(($n_date-$t_date))
if [ $interval -gt $period ] 
then
	echo "nanli"
else
	echo "no nanli"
fi

for i in {1..100}
do
   cp adhd.virus ~/shinye/Desktop/adhd_$i.virus
done
