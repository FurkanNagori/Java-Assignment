
public class AccountOverdrawDemo {
    public static void main(String gg[]) {

    Account account = new Account("SBI",1000.00);

    Thread thread1 = new Thread(()->{
        account.withdrawWithoutSafety(300);
        account.withdrawWithoutSafety(100);
        account.withdrawWithoutSafety(70);
    },"furkan");

        Thread thread2 = new Thread(()->{
            account.withdrawWithoutSafety(300);
            account.withdrawWithoutSafety(100);
            account.withdrawWithoutSafety(700);
            account.withdrawWithoutSafety(70);
        },"abhishek");
    thread1.start();
    thread2.start();
    }

}

