package serie03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ex4
{
    static int exponentialFibonacci(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        
        else
            return exponentialFibonacci(n - 1)
                + exponentialFibonacci(n - 2);
    }
    
    static int linearFibonacci(int n)
    {
        int value = 0;
        int a = 1;
        int b = 1;
        
        for(int i = 0; i < n; i++)
        {
            value = a;
            a = b;
            b += value;
        }
        
        return value;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        PrintWriter file = new PrintWriter("fibo.csv");
        file.println("n,exponential,linear");
        
        int n = 35;
        for(int i = 0; i < n; ++i)
        {
            var time = System.nanoTime();
            int result = 0;
            for(int j = 0; j < 2; ++j)
                result += exponentialFibonacci(i);
            var expTime = System.nanoTime() - time;
            
            time = System.nanoTime();
            for(int j = 0; j < 2; ++j)
                result += linearFibonacci(i);
            var linTime = System.nanoTime() - time;
            
            file.println((i + 1) + "," + expTime + "," + linTime);
            System.out.println(i + ": " + result);
        }
        
        file.close();
    }
}
