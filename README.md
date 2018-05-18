# build
```
mvn clean install
```

# workarounds
due to https://github.com/dzikoysk/Pandomium/issues/11 ?
run:
```bash
rm -rf native/
mkdir native
cd native/
tar xJf ../../Pandomium/pandomium-linux/native/linux64-native.tar.xz --strip 1
cd ..
```

Unfortunately embedded chromium will fail to resolv 3 files, which right now
need to be copied or symlinked to the java bin directory (see above ticket).

# run
```
java -jar target/pandomium-example-1.0-SNAPSHOT-jar-with-dependencies.jar 
```

