#!/bin/bash
cd /home/pi/deploy/HelloPi
pkill java
DISPLAY=:0 XAUTHORITY=/home/pi/.Xauthority java -XX:+UseZGC -Xmx1G -jar IP12-Prototype-1.0-shaded.jar
exit 0
