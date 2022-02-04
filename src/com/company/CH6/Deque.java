package com.company.CH6;

public class Deque <E> {

    private E[] data;
    private int frontPointer;
    private int rearPointer;

    public Deque(int size){
        data = (E[]) new Object[size];
        frontPointer = 0;
        rearPointer = 0;
    }

    public void addFront(E e){
        if ((rearPointer-frontPointer+ data.length)% data.length == data.length-1)
            return;
        data[(--frontPointer+ data.length)% data.length] = e;
    }

    public void printRear(){
        System.out.println(data[(rearPointer+ data.length)% data.length]);
    }

    public void removeFront(){
        if ((rearPointer-frontPointer+ data.length)% data.length == 0)
            return;
        data[((frontPointer++)+data.length)% data.length] = null;
    }

    public void addRear(E e){
        if ((rearPointer-frontPointer+ data.length)% data.length == data.length-1)
            return;
        data[(++rearPointer)% data.length] = e;
    }

    public void removeRear(){
        if ((rearPointer-frontPointer+ data.length)% data.length == 0)
            return;
        data[((rearPointer--)+data.length)% data.length] = null;
    }

}
