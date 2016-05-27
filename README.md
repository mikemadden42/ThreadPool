# ThreadPool
Simple Java thread pool

## Manual build instructions
```bash
echo 'Main-Class: ThreadPool' > Manifest.txt
javac -g:none *.java
jar cvfm ThreadPool.jar Manifest.txt *.class
java -jar ThreadPool.jar
```
## Automatic build instructions
```bash
ant
java -jar ThreadPool.jar
```
