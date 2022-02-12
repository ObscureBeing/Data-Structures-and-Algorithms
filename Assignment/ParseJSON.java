/************************************************************
* Name: ParseJSON.java                                      *
* Author: Muskan Vig                                        *
* Date created: 21 October 2020                             *
* Date modified: 24 October 2020                            *
* Purpose: Reads the Json file and parse it to the graph.   *
*************************************************************/

import java.util.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.*;

public class ParseJSON
{

    /****************************************************************
    * Name: loadData                                                *
    * Imports: fileAsset(String), fileTrade(String)                 *
    * Export: graph(DSAGraph)                                       *
    * Purpose: parses the JSON data.                                *
    *****************************************************************/


    public static DSAGraph loadData(String fileAsset, String fileTrade)
    {
            Scanner sc = new Scanner(System.in);
            DSAGraph graph = new DSAGraph();            

        try
        {
            //Create instance of JSONTokener, JSONObject and JSONarray for assefile.
            JSONTokener jsonToken = new JSONTokener(new FileReader(fileAsset));
            JSONObject object = new JSONObject(jsonToken);
            JSONArray symbols = object.getJSONArray("symbols");

            //Create instance of JSONTokener, JSONObject for tradefile.
            JSONTokener jsonTradeToken = new JSONTokener(new FileReader(fileTrade));
            JSONArray exchanges = new JSONArray(jsonTradeToken);
 
            int keepCount = 0;

            //Iterate over symbols JSONArray to get the information
           // and set up the requiredgraph.
            for(int i = 0; i < symbols.length(); i++)
            {
                //Create instance of JsonObject to parse array of key "symbol".
                JSONObject symbol = (JSONObject)symbols.get(i);
                String status = (String)symbol.getString("status");

                //Creates the graph with base asset and quote asset as vertices.
                //Adds edges where status of trades (exchanges) in asset file is "Trading" and not "Break".
                //(We are excluding trades with status "Break" (in last 24 hours) from our graph. 

                if(status.equals("TRADING"))
                {
                    TradeInformation tradeData = new TradeInformation();
              
                    String baseAsset = symbol.getString("baseAsset");
                    String quoteAsset = symbol.getString("quoteAsset");

                    //Creates vertices with base and quote asset from asset file.
                    //Not storing value in vertices since not much information on assets was available.
                    graph.addVertex(baseAsset, " ");
                    graph.addVertex(quoteAsset, " ");
      
                    //Create instance of JSONObject to parse array of trades from tradefile.
                    JSONObject trades = (JSONObject)exchanges.get(i);
    
                    //Parse required data from file into TradeInformation object.
                    String symbolLabel = (String)trades.get("symbol");   
                    tradeData.priceChangePercent = Double.parseDouble((String)trades.get("priceChangePercent"));
                    tradeData.weightedAvgPrice = Double.parseDouble((String)trades.get("weightedAvgPrice"));
                    tradeData.bidPrice = Double.parseDouble((String)trades.get("bidPrice"));
                    tradeData.askPrice = Double.parseDouble((String)trades.get("askPrice"));
                    tradeData.volume = Double.parseDouble((String)trades.get("volume"));
                    tradeData.quoteVolume = Double.parseDouble((String)trades.get("quoteVolume"));
                    String c = String.valueOf(trades.get("count"));
                    tradeData.count = Integer.parseInt(c);
                    tradeData.symbol = ((String)trades.get("symbol"));
                    tradeData.bidQty = Double.parseDouble((String)trades.get("bidQty"));
                    tradeData.askQty = Double.parseDouble((String)trades.get("askQty"));

                    //Parse TradeInformation object to edges value between base asset and quote asset vertices.
                    graph.addEdge(baseAsset, quoteAsset, symbolLabel, tradeData);

                    keepCount++;

                }//End if
            }//End for
       }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return graph;

    }//End loadData()

}//End ParseJSON
