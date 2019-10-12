#!/bin/bash

cd /home/vladis/IdeaProjects/Lab1

javac -sourcepath src -d bin -classpath /home/vladis/IdeaProjects/Lab1/commons-codec-1.8.jar src/com/Matveev/hash/Main.java src/com/Matveev/hash/CountHash.java src/com/Matveev/hash/InteractiveMode.java src/com/Matveev/hash/SimpleMode.java

mkdir lib
cd lib
jar -xvf /home/vladis/IdeaProjects/Lab1/commons-codec-1.8.jar org/
cd ..
cp -r bin/* lib/
jar -cef com.Matveev.hash/Main main.jar -C lib .
rm -r lib
