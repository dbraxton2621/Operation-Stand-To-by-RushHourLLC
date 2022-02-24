#!/usr/bin/env sh

javac -d classes -classpath "lib/*" src/com/RushHour/*.java src/com/RushHour/client/*.java


jar --create --file standTo-1.0.jar -C classes .