public class AccountOverdrawSafeDemo {
    public static void main(String[] gg) {
        Account account = new Account("HDFC", 1000.00);
        //created new thread
        // using lambdas expression, in which it directly implements runnable interface and use run method
        Thread thread1 = new Thread(() -> {
            account.withdrawWithSafety(300);
            account.withdrawWithSafety(200);
            account.withdrawWithSafety(60);

        }, "Furkan");
        Thread thread2 = new Thread(() -> {
            account.withdrawWithSafety(400);
            account.withdrawWithSafety(600);
            account.withdrawWithSafety(50);

        }, "Priyansh");

        thread1.start();
        thread2.start();

    }
}
