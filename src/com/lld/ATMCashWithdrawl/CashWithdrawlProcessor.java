package com.lld.ATMCashWithdrawl;

import java.util.Map;

public abstract class CashWithdrawlProcessor {
    CashWithdrawlProcessor next;

    CashWithdrawlProcessor(CashWithdrawlProcessor next){
        this.next=next;
    }

    Map<Integer,Integer> processCashWithdrawl(ATM atm, int remainingAmount) throws Exception {
        if(next!=null){
            return next.processCashWithdrawl(atm, remainingAmount);
        }
        throw new Exception("Unable to dispense");
    }

}
