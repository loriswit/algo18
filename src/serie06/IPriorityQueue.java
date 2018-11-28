package serie06;

public interface IPriorityQueue<T extends Comparable<T>>
{
    void insert(T elem);
    
    T remove();
    
    boolean isEmpty();
}
