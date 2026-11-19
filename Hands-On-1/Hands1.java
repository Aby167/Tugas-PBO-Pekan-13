public class Hands1 {
    public static void main(String[] args) {

        System.out.println("Daftar tipe akun:");
        for (AccountType t : AccountType.values()) {
            System.out.println("- " + t);
        }

        Account a = new Account(AccountType.DEPOSIT);
        System.out.println("Tipe akun a: " + a.getType());
    }
}

enum AccountType {
    SAVINGS, CREDIT, DEPOSIT;

    @Override
    public String toString() {
        switch (this) {
            case SAVINGS: return "SAVINGS - Akun tabungan biasa";
            case CREDIT:  return "CREDIT - Akun kartu kredit";
            case DEPOSIT: return "DEPOSIT - Akun deposito berjangka";
            default:      return name();
        }
    }
}

class Account {
    private AccountType type;
    public Account(AccountType type) { this.type = type; }
    public AccountType getType() { return type; }
}
