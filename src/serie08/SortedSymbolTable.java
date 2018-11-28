package serie08;

import java.util.Collections;
import java.util.HashSet;

public class SortedSymbolTable<Key extends Comparable<Key>, Value> implements ISortedSymbolTable<Key, Value>
{
    private class Node
    {
        Key key;
        Value value;
        Node parent;
        Node left = null;
        Node right = null;
        
        Node(Key k, Value v, Node p)
        {
            key = k;
            value = v;
            parent = p;
        }
        
        boolean lessThan(Key k)
        {
            return key.compareTo(k) < 0;
        }
        
        boolean greaterThan(Key k)
        {
            return key.compareTo(k) > 0;
        }
    }
    
    private Node root = null;
    private HashSet<Key> keys = new HashSet<>();
    
    private Node find(Key key)
    {
        var node = root;
        while(node != null)
        {
            if(node.key.equals(key))
                return node;
            
            if(node.lessThan(key))
                node = node.right;
            else
                node = node.left;
        }
        
        return null;
    }
    
    @Override
    public void put(Key key, Value val)
    {
        keys.add(key);
        
        if(root == null)
        {
            root = new Node(key, val, null);
            return;
        }
        
        var node = root;
        while(true)
        {
            if(node.key.equals(key))
            {
                node.value = val;
                return;
            }
            
            if(node.lessThan(key))
            {
                if(node.right == null)
                {
                    node.right = new Node(key, val, node);
                    return;
                }
                else
                    node = node.right;
            }
            else
            {
                if(node.left == null)
                {
                    node.left = new Node(key, val, node);
                    return;
                }
                else
                    node = node.left;
            }
        }
    }
    
    @Override
    public Value get(Key key)
    {
        var node = find(key);
        if(node != null)
            return node.value;
        
        return null;
    }
    
    private void replaceChild(Node child, Node newChild)
    {
        if(child.parent == null)
            return;
        
        if(child.parent.right == child)
            child.parent.right = newChild;
        else if(child.parent.left == child)
            child.parent.left = newChild;
    }
    
    private boolean removeNode(Node node)
    {
        if(node.left != null && node.right != null)
            return false;
        
        else if(node.left == null && node.right == null)
            replaceChild(node, null);
        
        else if(node.left != null)
            replaceChild(node, node.left);
        
        else replaceChild(node, node.right);
        
        return true;
    }
    
    @Override
    public void delete(Key key)
    {
        keys.remove(key);
        
        var node = find(key);
        if(node == null)
            return;
        
        if(removeNode(node))
            return;
        
        Node successor = node.right;
        while(successor.left != null)
            successor = successor.left;
        
        removeNode(successor);
        node.key = successor.key;
        node.value = successor.value;
    }
    
    @Override
    public boolean contains(Key key)
    {
        return find(key) != null;
    }
    
    @Override
    public boolean isEmpty()
    {
        return root == null;
    }
    
    @Override
    public int size()
    {
        return keys.size();
    }
    
    @Override
    public Key min()
    {
        return Collections.min(keys);
    }
    
    @Override
    public Key max()
    {
        return Collections.max(keys);
    }
    
    @Override
    public Key floor(Key key)
    {
        Key floor = null;
        for(var k : keys)
            if(k.compareTo(key) < 0)
                if(floor == null || floor.compareTo(k) < 0)
                    floor = k;
        
        return floor;
    }
    
    @Override
    public Key ceiling(Key key)
    {
        Key ceiling = null;
        for(var k : keys)
            if(k.compareTo(key) > 0)
                if(ceiling == null || ceiling.compareTo(k) > 0)
                    ceiling = k;
        
        return ceiling;
    }
    
    @Override
    public int rank(Key key)
    {
        int rank = 0;
        for(var k : keys)
            if(k.compareTo(key) < 0)
                ++rank;
        
        return rank;
    }
    
    @Override
    public void deleteMin()
    {
        delete(min());
    }
    
    @Override
    public void deleteMax()
    {
        delete(max());
    }
    
    @Override
    public Iterable<Key> keys()
    {
        return keys;
    }
}
