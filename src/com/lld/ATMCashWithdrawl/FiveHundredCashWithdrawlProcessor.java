package com.lld.ATMCashWithdrawl;

import java.util.HashMap;
import java.util.Map;

public class FiveHundredCashWithdrawlProcessor extends CashWithdrawlProcessor{

   public FiveHundredCashWithdrawlProcessor(CashWithdrawlProcessor next){
        super(next);
    }

    public Map<Integer,Integer> processCashWithdrawl(ATM atm, int remainingAmount) throws Exception {
//        System.out.println("Inside OneHundredCashWithdrawlProcessor with remainingAmount "+remainingAmount);
        int required500Notes = remainingAmount/ CommonConstants.FIVE_HUNDRED_RUPEE_NOTE;
        int available500Notes = atm.getFiveHundredRupeeNoteCount();
        int availableToDispense = Math.min(required500Notes,available500Notes);
        int balance = remainingAmount - availableToDispense* CommonConstants.FIVE_HUNDRED_RUPEE_NOTE;
        Map<Integer,Integer> deductibleDenominations = new HashMap<>();
        deductibleDenominations.put(CommonConstants.FIVE_HUNDRED_RUPEE_NOTE,availableToDispense);
        if(balance==0){
            return deductibleDenominations;
        }
        //get remaining denomination
        try {
            deductibleDenominations.putAll(super.processCashWithdrawl(atm,balance));
        }catch (Exception ex){
            throw ex;
        }
        return deductibleDenominations;
    }
}
