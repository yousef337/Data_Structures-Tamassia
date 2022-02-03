package com.company.CH6;

public class main {

    public static void main(String[] args) throws StackOutOfBoundException {
        testLinkedLeakyStack();
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

        LinkedLeakyStack<Integer> lls = new LinkedLeakyStack(3);
        lls.add(3);
        lls.add(4);
        System.out.println(lls.get());
        System.out.println(lls.remove());
        System.out.println(lls.get());

    }


}
