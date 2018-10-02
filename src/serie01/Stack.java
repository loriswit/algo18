package serie01;

public class Stack<T>
{
    private final static int MAX_SIZE = 1000;
    
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[MAX_SIZE];
    private int size = 0;
    
    public void Push(T element)
    {
        assert size != MAX_SIZE;
        data[size++] = element;
    }
    
    public T Peek()
    {
        return data[size - 1];
    }
    
    public T Pop()
    {
        assert !IsEmpty();
        return data[--size];
    }
    
    public boolean IsEmpty()
    {
        return size == 0;
    }
}
