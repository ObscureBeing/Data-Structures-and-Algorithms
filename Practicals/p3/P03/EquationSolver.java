/*******************************************************************************
* Name: EquationSolver                                                         *
* Date created: 29 September 2020                                              *
* Author: Muskan vig                                                           *
* Purpose: Converts infix equation to postfix equation and then evaluates it.  *
********************************************************************************/

import java.util.*;

public class EquationSolver
{
    public static double solve(String equation)
    {
        DSAShufflingQueue q = new DSAShufflingQueue(equation.length());
        
        q = parseInfixToPostfix(equation);

        System.out.println("\nPostfix expression is: ");

        for(int i = 0; i < q.queue.length; i++)
        {
            System.out.print(q.queue[i] + " "); 
        }
        System.out.println();
        double finalResult = evaluatePostfix(q);
        return finalResult;
    } 

    private static DSAShufflingQueue parseInfixToPostfix(String equation)
    {
        String[] term = parseNextTerm(equation);
        DSAShufflingQueue postfix = new DSAShufflingQueue(term.length);
        DSAStack opStack = new DSAStack();


        int count = 0;
        while(count != term.length)
        {
            
            if(term[count].equals("("))
            {
                opStack.push("(");
            }
            else if(term[count].equals(")"))
            {
                while(!opStack.top().equals("("))
                {    
                    postfix.enqueue(opStack.pop());
                }
                opStack.pop();
            }
            else if((term[count].equals("+")) || (term[count].equals("-")) || (term[count].equals("*")) || (term[count].equals("/")))
            {

                while ((!opStack.isEmpty()) && (!opStack.top().equals("(")) && (precedenceOf((String)opStack.top())) >= 
                                                                                                                (precedenceOf(term[count])))
                {   
                    postfix.enqueue(opStack.pop());
                }
                opStack.push(term[count]);
            }
            else
            {
                postfix.enqueue(Double.valueOf(term[count]));
            }
                System.out.println();
                System.out.println("Queue[" + count + "]: " + term[count]);
                count++;
        }

        while(!opStack.isEmpty())
        {
            postfix.enqueue(opStack.pop());
        }

       
         return postfix;

    }

    private static String[] parseNextTerm(String equation)
    {
        String splitted[] = equation.split(" "); 
        return splitted;
    } 

    private static double evaluatePostfix(DSAQueue postfixQueue)
    {
        DSAStack operandStack = new DSAStack(postfixQueue.queue.length);
        double result = 0;
        int check = 0;
        while(check != postfixQueue.queue.length && (postfixQueue.queue[check] != null))
        {
        if(postfixQueue.queue[check] instanceof Double)
        {
            operandStack.push(postfixQueue.queue[check]);    
        }
        else
        {
            double top1 = (double)operandStack.top();
            operandStack.pop();
            double top2 = (double)operandStack.top();

            result = executeOperation((String)postfixQueue.queue[check], top1, top2, operandStack);
            operandStack.pop();
            operandStack.pop();
            operandStack.push(result);
            System.out.println("result: " + result);
         }
              check++;
    
        }

        return result;
    } 

    private static int precedenceOf(String theOp)
    {
        int value = 0;

        switch(theOp)
        {
            case "+": value = 1;
                      break;
            case "-": value = 1;
                      break;
            case "*": value = 2;
                      break;
            case "/": value = 2;
                      break;
        }
        
        return value;
    }

    private static double executeOperation(String op, double op1, double op2, DSAStack operandStack)
    {
        double value = 0.0;
        switch(op)
        {
            case "+": value = op2 + op1;
                      System.out.println("\noperator: " + op + " operand1: " + op1 + " operand2: " + op2 + " value: " + value);
                      operandStack.push(value);
                      break;
            case "-": value = op2 - op1;
                      System.out.println("\noperator: " + op + " operand1: " + op1 + " operand2: " + op2 + " value: " + value);
                      operandStack.push(value);
                      break;
            case "*": value = op2 * op1;
                      System.out.println("\noperator: " + op + " operand1: " + op1 + " operand2: " + op2 + " value:  " + value);
                      operandStack.push(value);
                      break;
            case "/": value = op2 / op1;
                      System.out.println("\noperator: " + op + " operand1: " + op1 + " operand2: " + op2 + " value: " + value);
                      operandStack.push(value);
                      break;
        }
         
        return value;
    } 
    
}
