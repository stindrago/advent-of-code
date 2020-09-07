#!/bin/sh

cd src
javac modulo.java
javac main.java
javac astronave.java

echo "Compilazione terminata!"
java astronave > ../resources/out.txt
cat ../resources/out.txt
cd ..
