package com.lld.ATMCashWithdrawl;

import java.util.HashMap;
import java.util.Map;

public class OneHundredCashWithdrawlProcessor extends CashWithdrawlProcessor{

   public OneHundredCashWithdrawlProcessor(CashWithdrawlProcessor next){
        super(next);
    }

    public Map<Integer,Integer> processCashWithdrawl(ATM atm, int remainingAmount) throws Exception {
//        System.out.println("Inside OneHundredCashWithdrawlProcessor with remainingAmount "+remainingAmount);
        int required100Notes = remainingAmount/ CommonConstants.ONE_HUNDRED_RUPEE_NOTE;
        int available100Notes = atm.getOneHundredRupeeNoteCount();
        int availableToDispense = Math.min(available100Notes,required100Notes);
        int balance = remainingAmount - availableToDispense* CommonConstants.ONE_HUNDRED_RUPEE_NOTE;
        Map<Integer,Integer> deductibleDenominations = new HashMap<>();
        deductibleDenominations.put(CommonConstants.ONE_HUNDRED_RUPEE_NOTE,availableToDispense);

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
