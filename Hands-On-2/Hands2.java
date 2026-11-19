public class Hands2 {
    public static void main(String[] args) {

        AccountType s = AccountType.SAVINGS;
        System.out.println("Nama: " + s.name() + ", Kode: " + s.getCode()
                + ", Bunga: " + s.getInterestRate() + "%");

    
        System.out.println("\nSemua tipe akun:");
        for (AccountType t : AccountType.values()) {
            System.out.println(t.name() + " -> kode " + t.getCode()
                    + ", bunga " + t.getInterestRate() + "%");
        }
    }
}

enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 18.0);

    private String code;
    private double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() { return code; }
    public double getInterestRate() { return interestRate; }
}
