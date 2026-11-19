public class Hands3 {
    public static void main(String[] args) {
        Cell<Integer> angka = new Cell<>();
        angka.setValue(100);

        Cell<String> teks = new Cell<>();
        teks.setValue("Halo Generic");

        System.out.println("Isi angka : " + angka.getValue());
        angka.displayType();
        System.out.println("Isi teks  : " + teks.getValue());
        teks.displayType();

    }
}

class Cell<T> {
    private T data;

    public void setValue(T data) { this.data = data; }
    public T getValue() { return data; }

    public void displayType() {
        if (data == null) {
            System.out.println("Tipe data: belum ada isinya");
        } else {
            System.out.println("Tipe data: " + data.getClass().getSimpleName());
        }
    }
}
