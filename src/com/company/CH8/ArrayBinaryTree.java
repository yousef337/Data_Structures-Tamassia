package com.company.CH8;

import java.lang.annotation.ElementType;

//P-8.54
public class ArrayBinaryTree <E> {

    private final int DEFAULT_SIZE = 64;
    private E[] tree;
    private int size = 0;

    public ArrayBinaryTree(int size){
        tree = (E[]) new Object[size];
    }

    public ArrayBinaryTree(){
        tree = (E[]) new Object[DEFAULT_SIZE];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean addRoot(E e){
        if (tree[0] != null)
            return false;

        tree[0] = e;
        return true;
    }

    public E getRoot(){
        return tree[0] == null? null : tree[0];
    }

    public E getParent(E element){
        int index = getElementIndex(element);
        if (index == -1 || index == 0)
            return null;

        return index%2 == 0? tree[(index-2)/2] : tree[(index-1)/2];

    }

    public E getLeft(E element){
        int index = getElementIndex(element);
        if (index == -1 || tree[index*2 + 1] != null)
            return null;

        return tree[index*2 + 1];
    }


    public E getRight(E element){
        int index = getElementIndex(element);
        if (index == -1 || tree[index*2 + 2] != null)
            return null;

        return tree[index*2 + 2];
    }

    public E getSibling(E element){
        int index = getElementIndex(element);
        if (index == -1 || index == 0 || index+1 < tree.length)
            return null;

        return index%2 == 0? tree[index-1] : tree[index+1];
    }

    public E[] getChildren(E element){
        E[] children = (E[]) new Object[2];

        int index = getElementIndex(element);
        if (index == -1)
            return null;

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < tree.length && tree[leftChildIndex] != null)
            children[0] = tree[leftChildIndex];

        if (rightChildIndex < tree.length && tree[rightChildIndex] != null)
            children[0] = tree[rightChildIndex];

        return children;
    }

    public int getNumOfChildren(E element){
        int counter = -1;

        int index = getElementIndex(element);
        if (index == -1)
            return counter;

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < tree.length && tree[leftChildIndex] != null)
            counter++;

        if (rightChildIndex < tree.length && tree[rightChildIndex] != null)
            counter++;

        return counter;
    }

    public boolean isRoot(E element){
        return getElementIndex(element) == 0;
    }

    public boolean isInternal(E element){
        int index = getElementIndex(element);
        if (index == -1)
            return false;

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        return (leftChildIndex < tree.length && tree[leftChildIndex] != null) || (rightChildIndex < tree.length && tree[rightChildIndex] != null);
    }

    public boolean isExternal(E element){
        int index = getElementIndex(element);
        if (index == -1)
            return false;

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        return (leftChildIndex < tree.length && tree[leftChildIndex] == null) && (rightChildIndex < tree.length && tree[rightChildIndex] == null);
    }

    private int getElementIndex(E element){
        for (int i = 0; i < tree.length; i++)
            if (tree[i].equals(element))
                return i;

        return -1;
    }

    public boolean addLeft(E parent, E element){
        int index = getElementIndex(parent);
        if (index == -1 || tree[index*2 + 1] != null)
            return false;

        tree[index*2 + 1] = element;
        return true;
    }

    public boolean addRight(E parent, E element){
        int index = getElementIndex(parent);
        if (index == -1 || tree[index*2 + 2] != null)
            return false;

        tree[index*2 + 2] = element;
        return true;
    }

    public boolean set(E oldElement, E newElement){
        int index = getElementIndex(oldElement);

        if (index == -1)
            return false;

        tree[index] = newElement;
        return true;
    }

    public E remove(E e){

        int index = getElementIndex(e);
        if (index == -1)
            return null;

        E element = tree[index];
        tree[index] = null;

        return element;
    }

    public int getDepth(E element){
        if (element == null)
            return -1;

        int counter = 0;
        E searchElement = element;

        while (getParent(searchElement) != null) {
            searchElement = getParent(searchElement);
            counter++;
        }

        return counter;
    }

    public int getHeight(){
        // find the depth of the last element
        E element = null;
        for (int i = tree.length-1; i >= 0 ; i--)
            if (tree[i] != null){
                element = tree[i];
                break;
            }

        return getDepth(element);
    }

}
