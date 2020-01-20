#!/bin/sh

javac modulo.java
javac astronave.java
echo "Compilazione terminata!"
java astronave > ../out/output.txt
cat ../out/output.txt |less
