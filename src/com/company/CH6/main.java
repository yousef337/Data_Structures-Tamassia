package com.company.CH6;

public class main {

    public static void main(String[] args) throws StackOutOfBoundException {
        testDeque();
    }

    /**
     * This method is NOT intended to simulate unit testing.
     */
    public static void testDeque(){
        Deque<Integer> d = new Deque(7);
        d.addFront(1);
        d.addRear(2);
        d.addRear(3);
        d.addFront(4);
        d.addFront(5);
        d.addRear(6);
        d.addFront(7);
        d.removeRear();
        d.removeRear();
        d.printRear();
    }

    /**
     * This method is NOT intended to simulate unit testing.
     * @throws StackOutOfBoundException
     */
    public static void testDoubleColoredStack() throws StackOutOfBoundException{
        DoubleColoredStack<String> dcs = new DoubleColoredStack<>(4);
        dcs.pushRed("s");
        dcs.pushRed("2s");
        dcs.pushBlue("b");
        dcs.popRed();
        dcs.pushRed("D");
        dcs.popBlue();
        dcs.pushBlue("f");
        System.out.println(dcs.popBlue());

    }

    /**
     * This method is NOT intended to simulate unit testing.
     */
    public static void testLinkedLeakyStack(){

        LinkedLeakyStack<Integer> lls = new LinkedLeakyStack(5);
        lls.add(3);
        lls.add(4);
        lls.add(7);
        lls.add(8);
        lls.add(9);
        lls.add(10);
        lls.add(11);
        System.out.println(lls.remove());
        System.out.println(lls.remove());
        System.out.println(lls.remove());
        System.out.println(lls.remove());
        System.out.println(lls.remove());
        System.out.println(lls.remove());

    }


}
