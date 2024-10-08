antlrjar = antlr-4.13.2-complete.jar

###### FOR LINUX AND MAC -- uncomment the following line if you do not use Windows:
# classpath = '$(antlrjar):.'

###### FOR WINDOWS -- comment the following line if you do not use Windows:
classpath = '$(antlrjar);.'

antlr4 = java -cp $(classpath) org.antlr.v4.Tool
grun = java -cp $(classpath) org.antlr.v4.gui.TestRig
SRCFILES = main.java
GENERATED = ccListener.java ccBaseListener.java ccParser.java ccLexer.java ccVisitor.java ccBaseVisitor.java

all:	
	make run

ccLexer.java:	cc.g4
	$(antlr4) -visitor cc.g4

ccLexer.class:	ccLexer.java
	javac -cp $(classpath) $(GENERATED)

main.class: ccLexer.class main.java
	javac -cp $(classpath) $(GENERATED) main.java

run: main.class
	java -cp $(classpath) main 04-von-Neumann.hw

grun:	ccLexer.class 04-von-Neumann.hw
	$(grun) cc start -gui -tokens 04-von-Neumann.hw

clean:
	rm -f $(GENERATED) *.class