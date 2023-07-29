package com.lld.ATMCashWithdrawl;

import lombok.Getter;

@Getter
public class ATM {
    int twoThousandRupeeNoteCount;
    int fiveHundredRupeeNoteCount;
    int oneHundredRupeeNoteCount;
    int atmBalance;

    public ATM(int twoThousandRupeeNoteCount,int fiveHundredRupeeNoteCount, int oneHundredRupeeNoteCount){
        this.twoThousandRupeeNoteCount = twoThousandRupeeNoteCount;
        this.fiveHundredRupeeNoteCount = fiveHundredRupeeNoteCount;
        this.oneHundredRupeeNoteCount = oneHundredRupeeNoteCount;

        atmBalance =  twoThousandRupeeNoteCount * CommonConstants.TWO_THOUSAND_RUPEE_NOTE +
                fiveHundredRupeeNoteCount * CommonConstants.FIVE_HUNDRED_RUPEE_NOTE +
                oneHundredRupeeNoteCount * CommonConstants.ONE_HUNDRED_RUPEE_NOTE;

        System.out.println("ATM initialised with balance "+atmBalance);
    }


    public void deductBalance(int twoThousandRupeeNoteCount,int fiveHundredRupeeNoteCount,
                              int oneHundredRupeeNoteCount){
        this.twoThousandRupeeNoteCount -= twoThousandRupeeNoteCount;
        this.fiveHundredRupeeNoteCount -= fiveHundredRupeeNoteCount;
        this.oneHundredRupeeNoteCount -= oneHundredRupeeNoteCount;

        atmBalance -=  twoThousandRupeeNoteCount * CommonConstants.TWO_THOUSAND_RUPEE_NOTE +
                fiveHundredRupeeNoteCount * CommonConstants.FIVE_HUNDRED_RUPEE_NOTE +
                oneHundredRupeeNoteCount * CommonConstants.ONE_HUNDRED_RUPEE_NOTE;
    }

    public void getCurrencyWiseBalance() {
        System.out.println("remaining 2K notes: "+twoThousandRupeeNoteCount);
        System.out.println("remaining 500 notes: "+fiveHundredRupeeNoteCount);
        System.out.println("remaining 100 notes: "+oneHundredRupeeNoteCount);
    }
}
