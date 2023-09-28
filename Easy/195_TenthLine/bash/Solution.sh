#!/bin/bash

# temp=0
# while read line
# do
#     ((temp=temp+1))
#     if [[ $temp -eq 10 ]]
#     then
#         echo $line
#     fi
# done < file.txt

# awk 'NR==10' file.txt

sed -n '10p' file.txt