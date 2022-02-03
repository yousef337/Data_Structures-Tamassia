package com.company.CH6;

//TODO COMPLETE IT
public class LinkedLeakyStack <E>{

    private Node first;
    private Node second;
    private Node last;
    private int maxSize;
    private int currentSize = 0;

    public LinkedLeakyStack(int size){
        this.maxSize = size;
    }

    public void add(E e){
        if (currentSize < maxSize) {

            if (last == null) {
                last = new Node(null, e);
                first = last;
            }
            else if (second == null) {
                second = new Node(first, e);
                last = second;
            }

            currentSize++;

        }else{

            first.setData(e);
            first.setBack(second);
            second.nullifyBack();

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

        /*
        if (currentSize > 2)
            first = first.getBack();
        else
            first = null;
        currentSize--; // EXCEPT WHEN CURRENTSIZE==SIZE
         */

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

        public void setBack(Node back) {
            this.back = back;
        }

        public void setData(E data) {
            this.data = data;
        }

        public void nullifyBack(){
            back = null;
        }

    }

}
