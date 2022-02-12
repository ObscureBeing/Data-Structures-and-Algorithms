import java.util.*;

public class EquationSolverTestHarness
{
    public static void main(String[] args)
    {

        try
        {
            Scanner sc = new Scanner(System.in);
            String str = " ";
            DSAShufflingQueue q = new DSAShufflingQueue(str.length());
            System.out.println("Enter the equation: ");
            str = sc.nextLine();
            double result = EquationSolver.solve(str);
            System.out.println("\nEvaluated result is: " + result);
        }
        catch(Exception e)
        {
            System.out.println("Something wrong happened. Check your equation syntax!.");
        }
   }


}
