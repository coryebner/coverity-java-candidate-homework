# coverity-java-candidate-homework

How to build

The following applies if you are running the program with Windows command line.
In the directory containing pom.xml type
mvn package

To run the program
In the target/ directory containing calculator-0.0.1-SNAPSHOT.jar type:
java –jar calculator-0.0.1-SNAPSHOT.jar <expression to calculate> <verbosity>
Example:
java -jar calculator-0.0.1-SNAPSHOT.jar add(2,2)
or
java -jar calculator-0.0.1-SNAPSHOT.jar mult(2,2) –INFO
or
java -jar calculator-0.0.1-SNAPSHOT.jar mult(2,2) –DEBUG
or
java -jar calculator-0.0.1-SNAPSHOT.jar mult(2,2) -ERROR
