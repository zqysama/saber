package com.zqysama.algorithmsList;

public class AlgorithmsList {

    private Node head;

    private Node last;

    private int size;

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            last.next = insertedNode;
            last = insertedNode;
        } else {
            Node prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size ++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removedNode = null;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prevNode = get(index - 1);
            prevNode.next = null;
            removedNode = last;
            last = prevNode;
        } else {
            removedNode = get(index);
            Node prevNode = get(index - 1);
            prevNode.next = removedNode.next;
        }
        size --;
        return removedNode;
    }

    public void outPut() throws Exception {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public static void main(String[] args) throws Exception {
        AlgorithmsList list = new AlgorithmsList();
        list.insert(3,0);
        list.insert(7,1);
        list.insert(9,2);
        list.insert(5,3);
        list.insert(6,4);
        System.out.println("init");
        list.outPut();
        list.remove(3);
        System.out.println("remove1");
        list.outPut();
        list.remove(3);
        System.out.println("remove2");
        list.outPut();
    }
}
