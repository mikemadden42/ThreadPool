#!/bin/bash -x

rm -f *.class *.jar
echo 'Main-Class: ThreadPool' > Manifest.txt
javac -g:none *.java
jar cvfm ThreadPool.jar Manifest.txt *.class
java -jar ThreadPool.jar
