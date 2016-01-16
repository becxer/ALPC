#!/bin/bash

# TODO: 
# 0. write to manage_list new file location
# 0_1. run script on bash is loaded
# 1. manage_list read
# 2. check date
# 3. select backup / remove
# 4. move files
# 5. remove or manage files
for elem in $(ls); do
  echo $elem
  elemD=`date -r $elem "+%Y%m%d"`
  nowD=`date "+%Y%m%d"`
  if [ $elemD -eq $nowD ]; then
	echo "ok";
  fi
done
