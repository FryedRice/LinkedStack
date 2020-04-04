/**
* @ Description: Java实现下压链栈的数据结构：LinkedStack<Item>
* @ Date: Feb.19th 2020
* @ Author: Jay Sonic
*/
import java.util.Iterator;

public class TestLinkedStack {
    public static void main(String[] args) {
        LinkedStack<Integer> test = new LinkedStack<Integer>();
        
        System.out.printf("********入栈测试开始.********\n");
        for(int i=1; i<=21; ++i){
            test.push(i);
            System.out.printf("当前栈元素个数: %d.\n",test.size());
        }
        System.out.printf("********入栈测试结束.********\n");
        
        
        System.out.printf("********迭代器测试开始********.\n");
        Iterator<Integer> it = test.iterator();
        while(it.hasNext()){
            System.out.printf("%d  ",it.next());
        }System.out.println("");
        System.out.printf("********迭代器测试结束********.\n");
        
        
        System.out.printf("********出栈测试开始.********\n");
        int popedItem;
        for(int i=1; i<20; ++i){
            popedItem = test.pop();
            System.out.printf("元素%3d已出栈.\t",popedItem);
            System.out.printf("剩余元素个数:%2d.\n",test.size());
        }
        System.out.printf("********出栈测试结束.********\n");

    }
}

class LinkedStack<Item> implements Iterable<Item> {
    private Node first; //栈顶指针
    private int N;
    private class Node{ //用内部类来定义节点
        Item item;
        Node next;
    }
    
    public boolean isEmpty(){
        return N == 0; //或者 first == null;
    }
    
    public int size(){
        return N;
    }
    
    public void push(Item val){ //入栈
        Node oldFirst = first;
        first = new Node();
        first.item = val;
        first.next = oldFirst;
        ++N;
    }
    
    public Item pop(){ //出栈
        Item outcome = first.item;
        first = first.next;
        --N;
        return outcome;
    }
    
    public Iterator<Item> iterator(){ //本方法用于实现Iterable<Item>接口
        return new ListIterator(); //返回一个迭代器类ListIterator的实例
    }
    private class ListIterator implements Iterator<Item>{ //迭代器类必须实现Iterator<Item>接口
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove() { }
        public Item next(){
            Item outcome = current.item;
            current = current.next;
            return outcome;
        }
    }
    
}