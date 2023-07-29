package com.lld.ATMCashWithdrawl;

import java.util.HashMap;
import java.util.Map;

public class TwoThousandCashWithdrawlProcessor extends CashWithdrawlProcessor{

   public TwoThousandCashWithdrawlProcessor(CashWithdrawlProcessor next){
        super(next);
    }

    public Map<Integer,Integer> processCashWithdrawl(ATM atm, int remainingAmount) throws Exception {
//        System.out.println("Inside TwoThousandCashWithdrawlProcessor with remainingAmount "+remainingAmount);
        Map<Integer,Integer> deductibleDenominations = new HashMap<>();
        int required2KNotes = remainingAmount/ CommonConstants.TWO_THOUSAND_RUPEE_NOTE;
        int available2KNotes = atm.getTwoThousandRupeeNoteCount();
        int availableToDispense = Math.min(required2KNotes,available2KNotes);
        int balance = remainingAmount - availableToDispense* CommonConstants.TWO_THOUSAND_RUPEE_NOTE;
        deductibleDenominations.put(CommonConstants.TWO_THOUSAND_RUPEE_NOTE,availableToDispense);
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
