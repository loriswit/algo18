package serie08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount
{
    static class WordFrequency implements Comparable<WordFrequency>
    {
        String word;
        Integer freq;
        
        WordFrequency(String w, Integer f)
        {
            word = w;
            freq = f;
        }
        
        @Override
        public int compareTo(WordFrequency o)
        {
            return freq.compareTo(o.freq);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length < 1)
        {
            System.out.println("missing filename argument");
            return;
        }
        
        Scanner input = new Scanner(new File(args[0]));
        var table = new SortedSymbolTable<String, Integer>();
        
        while(input.hasNext())
        {
            var word = input.next();
            if(word.length() >= 8)
            {
                var count = table.get(word);
                
                if(count == null)
                    count = 1;
                else
                    ++count;
                
                table.put(word, count);
            }
        }
        
        var queue = new SortedPriorityQueue<WordFrequency>();
        for(var key : table.keys())
            queue.insert(new WordFrequency(key, table.get(key)));
        
        for(int i = 0; i < 10; ++i)
        {
            var wordFreq = queue.remove();
            System.out.println(wordFreq.word + " => " + wordFreq.freq);
        }
    }
}
