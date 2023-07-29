package com.lld.ATMCashWithdrawl;

import java.util.HashMap;
import java.util.Map;

public class CashWithdrawlHelper {
    CashWithdrawlProcessor cashWithdrawlProcessor;

    CashWithdrawlHelper(CashWithdrawlProcessor cashWithdrawlProcessor){
        this.cashWithdrawlProcessor = cashWithdrawlProcessor;
    }

    void dispenseCash(ATM atm, int amountToWithdraw){
        Map<Integer,Integer> deductibleDenominations = new HashMap<>();
        try {
            deductibleDenominations.putAll(cashWithdrawlProcessor.processCashWithdrawl(atm, amountToWithdraw));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        int deduct2KNoteCount = deductibleDenominations.getOrDefault(CommonConstants.TWO_THOUSAND_RUPEE_NOTE,0);
        int deduct500NoteCount = deductibleDenominations.getOrDefault(CommonConstants.FIVE_HUNDRED_RUPEE_NOTE,0);
        int deduct100NoteCount = deductibleDenominations.getOrDefault(CommonConstants.ONE_HUNDRED_RUPEE_NOTE,0);

        atm.deductBalance(deduct2KNoteCount,deduct500NoteCount,deduct100NoteCount);
        System.out.println("successfully deducted "+amountToWithdraw);
    }
}
