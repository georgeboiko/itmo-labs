javac -d bin -sourcepath src src/Main.java
echo -e "Manifest-Version: 1.0\nMain-Class: Main" > MANIFEST.MF
jar -cfm main.jar MANIFEST.MF -C bin .
rm MANIFEST.MF
rm -rf bin