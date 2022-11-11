# Java Reflection Project
A java project about Java Reflection API

## The aim of the project
In this project a Java program has been developed, which utilizes Reflection techniques, to answer the following questions.
What are the top-N types of program that have the most:
1a. Declared fields
1b. Total (declared and inherited) fields
2a. Declared methods
2b. Total (declared and inherited) methods
3. Sub-types
4. Super-types 

## Requirements
Requires the invoker to provide 3 arguments:
- the path to a .txt input file, containing the names of the types, that will have one type name per line
- the path to a .txt output file, that the program will create and write the requested data
- the top-N results

## Notes
It is assumed that the program (per invocation) consists of the types contained in the input and the types contained in the "standard" Java 11 library. The user running the program is responsible to configure the classpath in such a way that the types provided in the input file can be dynamically identified by the programm (at runtime), via the Reflection API.

After compiling all .java files, run the command:
java -cp <classpath> Main <input-file> <output9file> <top-N>

The <classpath> must be a .jar file or a folder containing .class files.# advancedProgrammingReflection
