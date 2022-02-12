/********************************************************************************************************************
* Name: unitTestTradeInformation                                                                                    *
* Author: Muskan Vig                                                                                                *
* Date created: 25 October 2020                                                                                     *
* Date modified: 25 October 2020                                                                                    *
* Purpose: Stores the trade information in its object and that object is stroed as weigh in crypto graph's edge.    *
* Testing the class' functionality.                                                                                 *
*********************************************************************************************************************/

import java.util.*;

public class UnitTestTradeInformation
{
    public static void main(String[] args)
    {
        System.out.println("\nUnit testing for TradeInformation class whose objects will be stored as value (weight) in graph's edge.\n");

        TradeInformation tradeData = new TradeInformation();
        tradeData.count = 10;
        tradeData.symbol = "ETHBTC";
        tradeData.priceChangePercent = 0.2;
        tradeData.weightedAvgPrice = 34.5;
        tradeData.bidPrice = 56.753;
        tradeData.askPrice = 89.21;
        tradeData.bidQty = 9.67;
        tradeData.askQty = 66.8;
        tradeData.volume = 893.782;
        tradeData.quoteVolume = 98.34;
        
        System.out.println("count: " + tradeData.count);
        System.out.println("symbol: " + tradeData.symbol);
        System.out.println("priceChangePercent: " + tradeData.priceChangePercent);
        System.out.println("weightedAvgPrice: " + tradeData.weightedAvgPrice);
        System.out.println("bidPrice: " + tradeData.bidPrice);
        System.out.println("askPrice: " + tradeData.askPrice);
        System.out.println("bidQty: " + tradeData.bidQty);
        System.out.println("askQty: " + tradeData.askQty);
        System.out.println("volume: " + tradeData.volume);
        System.out.println("quoteVolume: " + tradeData.quoteVolume);

        System.out.println(tradeData.toString()); 
    }
}//End UnitTestTradeInformation
