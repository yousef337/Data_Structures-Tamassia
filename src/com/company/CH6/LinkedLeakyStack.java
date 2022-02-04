package com.company.CH6;


public class LinkedLeakyStack <E>{

    private Node first;
    private Node beforeLast;
    private Node last;
    private int maxSize;
    private int currentSize = 0;

    public LinkedLeakyStack(int size){
        if (size < 0)
            size = 0;
        this.maxSize = size;
    }

    public void add(E e){

        if (currentSize < maxSize) {

            if (last == null) {
                last = new Node(null, e);
                first = last;
            }else if (beforeLast == null){
                beforeLast = first;
                last = new Node(null, e);
                last.setBack(beforeLast);
            }else{
                beforeLast = last;
                last = new Node(null, e);
                last.setBack(beforeLast);
            }
            currentSize++;

        }else{

            first.setData(e);
            first.setBack(last);
            beforeLast = last;
            last = first;

            Node second = beforeLast;
            while (second.getBack() != first)
                second = second.getBack();

            first = second;
            first.nullifyBack();
        }

    }

    public E get(){
        if (currentSize == 0)
            return null;
        return (E) last.getData();
    }

    public E remove(){
        if (currentSize == 0)
            return null;

        Object data = last.getData();

        if (currentSize == 1){
            last = null;
            first = null;
        }else {
            last.setData(null);
            last = beforeLast;
            beforeLast = beforeLast.getBack();
        }

        currentSize--;

        return (E) data;
    }


    private class Node <E>{

        private Node back;
        private E data;

        public Node(Node n, E e){
            last = n;
            data = e;
        }

        public E getData() {
            return data;
        }

        public Node getBack() {
            return back;
        }

        public void setBack(Node next) {
            this.back = next;
        }

        public void setData(E data) {
            this.data = data;
        }

        public void nullifyBack(){
            back = null;
        }

    }

}
