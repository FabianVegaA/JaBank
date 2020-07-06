all:JaBank

JaBank: compiler
	

compiler: 
	javac src/*.java

move:
	mv src/*.class bin/

clean:
	rm bin/*.class src/*.class