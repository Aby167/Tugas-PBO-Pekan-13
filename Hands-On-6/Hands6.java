import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class Hands6 {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");

        if (!Files.exists(path)) {
            System.out.println("File " + path + " tidak ditemukan!");
            return;
        }

        ArrayList<String> daftar = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                daftar.add(line);  
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Jumlah baris terbaca: " + daftar.size());

        try {
            Files.write(Paths.get("copy_employees.txt"), daftar, StandardCharsets.UTF_8);
            System.out.println("Berhasil ditulis ke copy_employees.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis file: " + e.getMessage());
        }
    }
}
