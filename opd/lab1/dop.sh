#!/bin/bash

#echo $0
n=$1
path=$2
d=()
for ((i = 1; i*i <= n; ++i))
do
	if ((n%i==0)) 
	then
		d+=($i)
		if ((n/i != i))
		then 
			d+=($((n/i)))
		fi
	fi
done

#exec 1023>&1

if [ -z $path ]
then
	printf '%d\n' ${d[@]} | sort -n #>&1023
else
	ls $path 1>/dev/null 2>/dev/null
	if [ $? != 0 ]
	then
		mkdir -p $path
	fi
	printf '%d\n' ${d[@]} | sort -n >$path/ans.txt
fi

#exec 1023>&-

#sleep 5m
