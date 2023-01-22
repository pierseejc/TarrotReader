#!/bin/bash

echo 'Please Enter IP address for Target'

read ipAddy

echo "Select Scan options Silent, Medium, Noisy"

read options

if [$options = "Silent" ] || [$options = "s"]; then
scanspeed = "T1"
fi


if [$options = "Medium" ] || [$options = "m"]; then
scanspeed = "T3"
fi


if [$options = "Noisy" ] || [$options = "n"]; then
scanspeed = "T5"
fi

echo  "Options Loaded"if [options]
echo   "Scanning..."
sleep 1

Results= nmap -A $ipAddy $scanspeed -p-

echo $Results
