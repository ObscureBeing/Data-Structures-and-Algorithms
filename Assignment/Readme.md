# Program: cryptoGraph.java

The project is about analyzing cryptocurrency trading data. Various data structures and Algorithms have been used which are mentioned in the report as well.

* The functionality of the program begins with loading the crypto data either from JSON files or loading the serialized data. 
* Furthermore, assets and trades can be enquired. Menu options give range of options such as finding a particular asset and trade, displaying details regarding it and giving an overview of assets and trades. 
* The data can be saved as serialized data and potential direct and indirect trade paths between two assets.

Files: -

-   cryptoGraph.java
-   json-20200518.jar
-   ParseJSON.java
-   DSAGraph.java
-   DSAGraphVertex.java
-   DSAGraphEdge.java
-   DSALinkedList.java
-   DSAStack.java
-   DSAQueue.java
-   TradeInformation.java
-   UnitTestDSAGrap.java
-   UnitTestDSALinkedList.java
-   UnitTestDSAStack.java
-   UnitTestDSAQueue.java
-   UnitTestTradeInformation.java
-   README.txt
-   CoverSheet.pdf
-   ProjectReport.pdf

Instructions: - To run the program, use the fiollowing commands.

* Compiling- To compile the program, use the command:
                Javac -cp .:json-20200518.jar *.java
* Run- To run the program use the following command for different modes.
        Java -cp .:json-20200518.jar cryptoGraph
        Java -cp .:json-20200518.jar cryptoGraph -i
        Java -cp .:json-20200518.jar cryptoGraph -r <asset_file> <trade_file>
