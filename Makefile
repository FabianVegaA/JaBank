all:JaBank

JaBank: compiler
	java src/ReadFile test_case/cuenta2.jaBank

compiler: 
	javac src/*.java

clean:
	rm src/*.class