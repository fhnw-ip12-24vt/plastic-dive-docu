#!/bin/bash
cd /home/pi/deploy/IP12-Prototype
pkill java
DISPLAY=:0 XAUTHORITY=/home/pi/.Xauthority java -XX:+UseZGC -Xmx1G -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -jar IP12-Prototype-1.0-shaded.jar
exit 0
