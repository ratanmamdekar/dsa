package com.lld.ATMCashWithdrawl;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(2,3,0);
        atm.getCurrencyWiseBalance();

        CashWithdrawlProcessor cashWithdrawlProcessor = new TwoThousandCashWithdrawlProcessor(
                new FiveHundredCashWithdrawlProcessor(new OneHundredCashWithdrawlProcessor(null)));

        CashWithdrawlHelper cashWithdrawlHelper = new CashWithdrawlHelper(cashWithdrawlProcessor);

        int amountToWithdraw = 3700;
        System.out.println("attempting to dispense "+amountToWithdraw);
        cashWithdrawlHelper.dispenseCash(atm,amountToWithdraw);

        System.out.println("Remaining balance "+atm.getAtmBalance());
        atm.getCurrencyWiseBalance();
    }
}
