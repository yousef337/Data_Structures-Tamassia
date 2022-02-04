package com.company.CH6;

/**
 * This class represents only the data structure itself and not the running mechanism that allows a user to use it
 */
public class CapitalGain {

    private Share[] shares;
    private int pointer;
    private int currentSize;

    public CapitalGain(int size){
        shares = new Share[size];
        pointer = 0;
        currentSize = 0;
    }

    public void addShare(int size, int amt){
        if (currentSize == shares.length)
            return;
        shares[(pointer+currentSize)%shares.length] = new Share(size, amt);
        currentSize++;
    }

    public double sellShares(int size, int sellingAmt){
        int financialReturns = 0;
        int remainingSize = size;

        while (remainingSize != 0){ // != have replaced  > since it will reveal if there was a calculation error by the presence of infinite loop

            int requiredSize = remainingSize;
            if (remainingSize > shares[pointer].getShares())
                requiredSize = shares[pointer].getShares();

            financialReturns += requiredSize*(sellingAmt-shares[pointer].getPrice());
            shares[pointer].subtractShare(requiredSize);

            if (shares[pointer].getShares() == 0){
                shares[pointer] = null;
                pointer++;
            }

            size -= requiredSize;
        }

        return financialReturns;
    }

    public class Share{
        private int shares;
        private int price;

        public Share(int shares, int price){
            this.shares = shares;
            this.price = price;
        }

        public void subtractShare(int numberOfShares){
            shares -= numberOfShares;
        }

        public int getShares() {
            return shares;
        }

        public int getPrice() {
            return price;
        }
    }

}
