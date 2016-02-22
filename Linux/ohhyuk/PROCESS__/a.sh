#!/bin/bash
# top -o cpu -n 1
while : ; do
    clear
    ps -axr | head -n 5
    sleep 1
done
