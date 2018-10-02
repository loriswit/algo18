package serie02;

public class Stack<T>
{
    private Node<T> head = null;
    
    public void Push(T element)
    {
        head = new Node<>(element, head);
    }
    
    public T Peek()
    {
        assert head != null;
        return head.value;
    }
    
    public T Pop()
    {
        assert head != null;
        
        var value = head.value;
        head = head.next;
        return value;
    }
    
    public boolean IsEmpty()
    {
        return head == null;
    }
}
