all:JaBank

JaBank: compiler
	
compiler: 
	javac src/*.java

clean:
	rm src/*.class