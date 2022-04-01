package leetcode;

public class Demo2043 {
    private long[] balance;
    public Demo2043(long[] balance) {
        this.balance=balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(balance.length<account1||balance.length<account2){
            return false;
        }
        if(balance[account1-1]-money>0){
            balance[account1-1]-=money;
            balance[account2-1]+=money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(balance.length>=account){
            balance[account-1]+=money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(account<=balance.length&&balance[account-1]-money>0){
            balance[account-1]-=money;
            return true;
        }
        return false;
    }
}
