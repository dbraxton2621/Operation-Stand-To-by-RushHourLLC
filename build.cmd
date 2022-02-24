@echo off

javac -d classes -classpath "lib\*" src\com\RushHour\client\*.java src\com\RushHour\*.java

jar --create --file standTo-1.0.jar -C classes .