package com.company.CH6;

public class LeakyStack <E> {

    private E[] array;
    private int pointer;
    private int size;

    public LeakyStack(int size){
        array = (E[]) new Object[size];
        pointer = -1;
    }

    public void push(E e){
        array[(++pointer)%array.length] = e;
        if (size < array.length)
            size++;
    }

    public E pop(){
        if (size > 0)
            return array[pointer];
        return null;
    }
}
