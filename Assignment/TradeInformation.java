/********************************************************************************************
* Name: TradeInformation.java                                                               *
* Author: Muskan Vig                                                                        *
* Date created: 23 October 2020                                                             *
* Date modified: 23 October 2020                                                            *
* Purpose: It is to store each trade's data as an object in the weight of the graph's edge.  *
*********************************************************************************************/

import java.util.*;
import java.io.*;

public class TradeInformation implements Serializable
{   
    double priceChangePercent;
    double weightedAvgPrice;
    double bidPrice;
    double askPrice;
    double bidQty;
    double askQty;
    double volume;
    double quoteVolume;
    int count;
    String symbol;

    public boolean equals(Object o) 
    {
        boolean equal = true;
        TradeInformation other = (TradeInformation) o;
        //check values between both objects
        if(this.priceChangePercent != other.priceChangePercent)
            equal = false;
        else if(this.weightedAvgPrice != other.weightedAvgPrice)
            equal = false;
        else if(this.bidPrice != other.bidPrice)
            equal = false;
        else if(this.askPrice != other.askPrice)
            equal = false;
        else if(this.bidQty != other.bidQty)
            equal = false;
        else if(this.askQty != other.askQty)
            equal = false;
        else if(this.volume != other.volume)
            equal = false;
        else if(this.quoteVolume != other.quoteVolume)
            equal = false;
        else if(this.count != other.count)
            equal = false;
        else if(!this.symbol.equals(other.symbol))
            equal = false;
        else 
            equal = true;

        return equal;
    }

    /********************************************************************************************************
    * Name: toString                                                                                        *
    * Imports: none                                                                                         *
    * Export: display(String)                                                                               *
    * Purpose: Returns the string with required information to be displayed as edge's value (weight).       *
    * It is trade's data.                                                                                   *
    *********************************************************************************************************/

    public String toString()
    {
        String display;
        String pCP = String.valueOf(priceChangePercent);
        String wAP = String.valueOf(weightedAvgPrice);
        String bP = String.valueOf(bidPrice);
        String aP = String.valueOf(askPrice);
        String bQ = String.valueOf(bidQty); 
        String aQ = String.valueOf(askQty);
        String v = String.valueOf(volume);
        String qV = String.valueOf(quoteVolume);
        String c = String.valueOf(count);
        String sym = symbol;

        display = "\nTrade information:-\n \nsymbol(exchange) " + sym + "\npriceChangePercent: " + pCP + "\nweightedAvgPrice: " + wAP 
        + "\nbidPrice: " + bP + "\naskPrice: " + aP + "\nbidQty: " + bQ + "\naskQty: " + aQ + "\nvolume: " 
        + v + "\nquoteVolume: " + qV + "\ncount: " + c +  /*+ "\nsymbol(exchange) " + sym +*/ "\n";

        return display;
       
    }
}//End TradeInformation
