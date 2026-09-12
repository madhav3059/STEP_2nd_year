class MessWallet {
    private double balance;

    // Constructor with negative balance check
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initialized to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Top-up method with validation
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Deduct method preventing negative balance
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
            System.out.println("Balance after deduct: " + this.balance);
        }
    }

    // Read-only getter
    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
