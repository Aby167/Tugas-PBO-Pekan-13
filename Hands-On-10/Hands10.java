import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Hands10 {
    public static void main(String[] args) {
        List<Produk<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop", 15000000.0, 5));
        produkList.add(new Produk<>("Mouse", 150000.0, 40));
        produkList.add(new Produk<>("Keyboard", 350000.0, 25));

        Path filePath = Paths.get("produk_output.txt");
        simpan(produkList, filePath);
        baca(filePath);

        List<Pelanggan> pelanggan = List.of(new Pelanggan("Budi", "Makassar"),
                                            new Pelanggan("Dewi", "Gowa"));
        simpan(pelanggan, Paths.get("pelanggan.txt"));
        baca(Paths.get("pelanggan.txt"));

        List<Transaksi> transaksi = List.of(new Transaksi("TRX001", 250000.0),
                                            new Transaksi("TRX002", 1200000.0));
        simpan(transaksi, Paths.get("transaksi.txt"));
        baca(Paths.get("transaksi.txt"));
    }

    static <T> void simpan(List<T> data, Path path) {
        List<String> lines = new ArrayList<>();
        for (T item : data) {
            lines.add(item.toString());
        }
        try {
            Files.write(path, lines);
            System.out.println("Berhasil menyimpan ke " + path);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    static void baca(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println("Isi " + path + ":");
            for (String l : lines) {
                System.out.println("  " + l);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
}

class Produk<T, U, V> {
    private T nama;
    private U harga;
    private V stok;

    public Produk(T nama, U harga, V stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

class Pelanggan {
    private String nama, kota;
    Pelanggan(String nama, String kota) { this.nama = nama; this.kota = kota; }
    @Override public String toString() { return nama + "," + kota; }
}

class Transaksi {
    private String id;
    private double total;
    Transaksi(String id, double total) { this.id = id; this.total = total; }
    @Override public String toString() { return id + "," + total; }
}
