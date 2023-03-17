cd .\src
javac -cp gson-2.10.1.jar;. -source 1.8 -target 1.8 Main.java Vertex.java Edge.java Graph.java GraphADT.java
java -cp gson-2.10.1.jar;. Main

