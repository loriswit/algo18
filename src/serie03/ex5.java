package serie03;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class ex5
{
    static int binarySearch(int array[], int value)
    {
        int top = array.length - 1;
        int bottom = 0;
        
        while(bottom <= top)
        {
            int index = bottom + (top - bottom) / 2;
            
            if(array[index] == value)
                return index;
            
            if(array[index] < value)
                bottom = index + 1;
            else
                top = index - 1;
        }
        
        return -1;
    }
    
    static int threeSum(int array[])
    {
        int total = 0;
        
        for(int a : array)
            for(int b : array)
                for(int c : array)
                    if(a + b + c == 0)
                        ++total;
        
        return total;
    }
    
    static int threeSumFast(int array[])
    {
        Arrays.sort(array);
        int total = 0;
        
        for(int a : array)
            for(int b : array)
                if(binarySearch(array, -a - b) != -1)
                    ++total;
        
        return total;
    }
    
    @Test
    void testSearch()
    {
        var array = new int[]{1, 6, 9, 13, 17, 25, 28, 36, 37, 41, 49, 55, 58, 70, 79, 82, 90, 93};
        
        assert binarySearch(array, 0) == -1;
        assert binarySearch(array, 1) == 0;
        assert binarySearch(array, 28) == 6;
        assert binarySearch(array, 70) == 13;
        assert binarySearch(array, 93) == 17;
        assert binarySearch(array, 100) == -1;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        PrintWriter file = new PrintWriter("3sum.csv");
        file.println("n,naive,fast");
        
        // use a set to avoid duplicates
        var values = new HashSet<Integer>();
        
        int max = 200;
        for(int i = 0; i < max; ++i)
        {
            while(values.size() != i + 1)
                values.add(ThreadLocalRandom.current().nextInt(-10000, 10000));
            
            var array = values.stream().mapToInt(Number::intValue).toArray();
            
            var time = System.nanoTime();
            int result = 0;
            for(int j = 0; j < 2; ++j)
                result += threeSum(array);
            var naiveTime = System.nanoTime() - time;
            
            time = System.nanoTime();
            for(int j = 0; j < 2; ++j)
                result += threeSumFast(array);
            var fastTime = System.nanoTime() - time;
            
            file.println((i + 1) + "," + naiveTime + "," + fastTime);
            System.out.println(i + ": " + result);
        }
        
        file.close();
    }
}
