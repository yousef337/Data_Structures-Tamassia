package com.company.CH6;

/**
 * This class is intended to answer P-6.30 question in the book.
 * This class does assume that both stacks contains the same data type.
 * This class does assume both stacks have equal sizes, the second class assumes not
 */

public class BalancedDoubleColoredStack <E> {

    private E[] data;
    private int redTracker;
    private int blueTracker;

    public BalancedDoubleColoredStack(int size){
        data = (E[]) new Object[size];
        redTracker = -1;
        blueTracker = (size/2)-1; // Assuming both stacks have equal size
    }

    public void pushRed(E element) throws StackOutOfBoundException {
        if (redTracker+1 < data.length/2)
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
        if (blueTracker+1 < data.length)
            data[++blueTracker] = element;
        else
            throw new StackOutOfBoundException();
    }

    public E popBlue(){
        if (blueTracker >= 0) {
            E element = data[blueTracker];
            data[blueTracker] = null;
            blueTracker--;
            return element;
        }
        return null;
    }


}
