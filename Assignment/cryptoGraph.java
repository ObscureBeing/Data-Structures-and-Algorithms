/************************************************************************************************
* Name: cryptoGraph.java                                                                        *
* Author: Muskan vig                                                                            *
* Date created: 25 October 2020                                                                 *
* Date modified: 28 October 2020                                                                *
* Purpose: Displays the menu and calls required methods for each menu option's functionality.   *
*************************************************************************************************/

import java.util.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.*;

public class cryptoGraph
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int argsNum = args.length;
        String mode;

        //validate the command line arguments.
        switch(argsNum)
        {
            case 0: System.out.println("Welcome!");
                    System.out.println("Please enter \"-i\" as command line argument to run the interactive testing environment.");
                    System.out.println("Please enter \"-r\" <asset_file> <trade_file> for report mode (Automated).\n");
                    break;
            case 1: mode = args[0];
                    
                    //Interactive mode -i as commandline argument.
                    if(mode.equals("-i"))
                    {
                        //Assuming that data always needs to be loaded before 
                        //choosing any other menu option.
                        System.out.println("MENU: (Crypto-currency data).\n");
                        System.out.println("(1) Load data");

                        int option;
                        System.out.println("\t1. Asset data and trade data");
                        System.out.println("\t2. Serialized data");
                        option = sc.nextInt();
                        switch(option)
                        {
                            case 1: String fileAsset, fileTrade;
                                    System.out.println("Please enter the asset file name");
                                    sc.nextLine();
                                    fileAsset = sc.nextLine();
                                    System.out.println("Please enter the trade file name");
                                    fileTrade = sc.nextLine();
                                    DSAGraph graph = new DSAGraph();
                                    graph = ParseJSON.loadData(fileAsset, fileTrade);
                                    menu(graph);
                                    break;

                            case 2: String filename;
                                    System.out.print("Please enter the serialized filename: - ");
                                    sc.nextLine();
                                    filename = sc.nextLine();
                                    DSAGraph serialGraph = new DSAGraph();
                                    System.out.println(filename);
                                    serialGraph = serialGraph.load(filename);
                                    System.out.println("Successfully parsed the serialized data.^_^");
                                    menu(serialGraph);
                                    break;

                            default: System.out.println("Choose valid option.");
                        }//End inner switch 

                   }//End if
                    else
                        System.out.println("Please check your command line argument, enter a valid mode.");   
                    break;
            case 3: mode = args[0];
                
                    //report mode -r <asset_file> <trade_file> as commandline argument (automated).
                    if(mode.equals("-r"))
                    {
                        System.out.println("Report mode on: \n");
                        
                        //to parse assetfile
                        String file1 = args[1];
                        //to parse tradefile
                        String file2 = args[2];

                        DSAGraph g = new DSAGraph();

                        //parse files to loadData()
                        g = ParseJSON.loadData(file1, file2);
    
                        System.out.println("Showing all the assets: \n");
                        g.display();
                        System.out.println("Showing all the trades: \n");
                        g.vertexEdgeList();
                        System.out.println("\nFinding asset \"AUD\" and displaying its details: \n");

                        if(!g.hasVertex("AUD"))
                            System.out.println("No such asset exists!\n");
                        else
                            g.displayVertex("AUD");          

                        System.out.println("\nFinding trade \"SXPAUD\" and displaying its details: \n");
                        if(!g.hasEdge("SXPAUD"))
                            System.out.println("No such trade exits!");
                        else
                            g.displayEdge("SXPAUD");
            //Do the report moe here...............................//
                        System.out.println("\nFiltering out trades including asset \"USDT\"\n");
                            g.filter("USDT");
                    }
                    else
                        System.out.println("Please check your command line argument, enter a valid mode.");
                    break;

            default: System.out.println("Please check your command line arguments.");
        }//End outer switch.
    }//End main.

    /********************************************************
    * Name: menu                                            *
    * Imports: graph(DSAGraph)                              *
    * Export: none                                          *
    * Purpose: Performs chosen option's functionality.      *
    *********************************************************/

    public static void menu(DSAGraph graph)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
              
        do
        {
            System.out.println("\nMENU: Please choose from the following options:- \n");
        
            System.out.println("(2) Find and display asset");
            System.out.println("(3) Find and display trade details \n(4) Find and display potential trade paths");
            System.out.println("(5) Set asset filter \n(6) Asset overview \n(7) Trade overview");
            System.out.println("(8) Save data (serialised) \n(9) Exit");
        
            choice = sc.nextInt();
    
            switch(choice)
            {
               case 2:  String asset;
                        System.out.print("Please enter the asset you want to find and display its details:- ");
                        sc.nextLine();
                        asset = sc.nextLine();
        
                        boolean findAsset = graph.hasVertex(asset);
                        if(!findAsset)
                            System.out.println("No such asset exists!\n");
                        else
                            graph.displayVertex(asset);                       
                        break;

                case 3: String trade;
                        System.out.print("Please enter the trade you want to find and display its details:- ");
                        sc.nextLine();
                        trade = sc.nextLine();
        
                        boolean findTrade = graph.hasEdge(trade);
                        if(!findTrade)
                            System.out.println("No such trade exists!\n");
                        else
                            graph.displayEdge(trade);              
                        break;

                case 4: String base, quote;
                        String combine;
                        System.out.print("Please enter the base asset:- "); 
                        sc.nextLine();
                        base = sc.nextLine();
                        System.out.print("Please enter the quote asset:- "); 
                        quote = sc.nextLine();
                        combine = base + quote;

                        if(graph.hasEdge(combine))
                            System.out.println("\nThere exists a direct path between " + base + " and " + quote);
                        else
                            System.out.println("\nThere is no direct path between " + base + " and " + quote);
            
                        break;

                case 5: System.out.print("Enter the asset you want to filter out: ");
                        sc.nextLine();
                        String filteredAsset;
                        filteredAsset = sc.nextLine();
                        graph.filter(filteredAsset);
                        break;

                case 6: System.out.println("Asset overview from the data is as follows:- \n");
                        int assetNum = graph.getVertexCount();
                        System.out.println("Total number of assets are: - " + assetNum);
                        System.out.println("Displaying all the assets being traded: - \n");
                        graph.display();
                        System.out.println(" ");                        
                        break;

                case 7: System.out.println("Trade overview from the data is as follows: - \n");
                        System.out.println("Trades ongoing where status is \"TRADING\" and not \"BREAK\" are: -\n");
                        System.out.println("Total number of trades are: " + graph.getEdgeCount());
                        System.out.println("All the trades from each asset are: \n");
                        graph.vertexEdgeList();

                        break;

                case 8: String file;
                        System.out.print("Please enter the file name you want to save data (serialized):- ");
                        sc.nextLine();
                        file = sc.nextLine();
                        graph.save(graph,file);
                        System.out.println("File: \"" + file + "\" successfully saved (serialized)."); 
                        break;

                case 9: System.out.println("You chose Exit option! See ya!:-)");
                        break;

                default: System.out.println("\n<<Please choose a valid option.>>\n");
            }//End switch
        }while(choice != 9); //loops until user chooses exit option.

   }//End menu()

}//End cryptoGraph

