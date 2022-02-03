package com.company.CH6;

/**
 * This class is intended to answer P-6.30 question in the book.
 * This class does assume that both stacks contains the same data type.
 * This class does assume both stacks does not have equal sizes, the second class assumes they do
 */

public class DoubleColoredStack <E> {

    private E[] data;
    private int redTracker;
    private int blueTracker;

    public DoubleColoredStack(int size){
        data = (E[]) new Object[size];
        redTracker = -1;
        blueTracker = size+1;
    }

    public void pushRed(E element) throws StackOutOfBoundException {
        if (redTracker+1 != blueTracker)
            data[++redTracker] = element;
        else
            throw new StackOutOfBoundException();
    }

    public E popRed(){
        if (redTracker >= 0) {
            E element = data[redTracker];
            data[redTracker] = null;
            redTracker--;
            return element;
        }
        return null;
    }

    public void pushBlue(E element) throws StackOutOfBoundException{
        if (blueTracker-1 != redTracker)
            data[--blueTracker] = element;
        else
            throw new StackOutOfBoundException();
    }

    public E popBlue(){
        if (blueTracker < data.length) {
            E element = data[blueTracker];
            data[blueTracker] = null;
            blueTracker++;
            return element;
        }
        return null;
    }


}
