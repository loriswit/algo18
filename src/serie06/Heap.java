package serie06;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements IPriorityQueue<T>
{
    private ArrayList<T> array = new ArrayList<>();
    
    // O(log(n))
    @Override
    public void insert(T elem)
    {
        array.add(elem);
        
        int index = 0;
        int parent = array.size() - 1;
        while(index != parent)
        {
            index = parent;
            
            if(greaterThan(parent(index), parent))
                parent = parent(index);
            
            swap(parent, index);
        }
        
        check(1);
        System.out.println("alright");
    }
    
    // O(log(n))
    @Override
    public T remove()
    {
        swap(0, array.size() - 1);
        T min = array.remove(array.size() - 1);
        
        int index = array.size();
        int child = 0;
        while(index != child)
        {
            index = child;
            
            if(left(index) < array.size() && lessThan(left(index), child))
                child = left(index);
            
            if(right(index) < array.size() && lessThan(right(index), child))
                child = right(index);
            
            swap(child, index);
        }
    
        check(0);
        System.out.println("alright");
        
        return min;
    }
    
    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
    
    // helpers
    
    private void swap(int indexA, int indexB)
    {
        T tmp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, tmp);
    }
    
    private boolean lessThan(int indexA, int indexB)
    {
        return array.get(indexA).compareTo(array.get(indexB)) < 0;
    }
    
    private boolean greaterThan(int indexA, int indexB)
    {
        return array.get(indexA).compareTo(array.get(indexB)) > 0;
    }
    
    private int parent(int index)
    {
        return (index - 1) / 2;
    }
    
    private int left(int index)
    {
        return (index + 1) * 2 - 1;
    }
    
    private int right(int index)
    {
        return (index + 1) * 2;
    }
    
    ///
    
    void check(int i)
    {
        if(i * 2 < array.size())
        {
            assert lessThan(i - 1, i * 2 - 1);
            check(i * 2);
        }
    
        if(i * 2 + 1 < array.size())
        {
            assert lessThan(i - 1, i * 2);
            check(i * 2 + 1);
        }
    }
}
