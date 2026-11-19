import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hands7 {
    static Path logFile = Paths.get("log.txt");
    static List<String> log = new ArrayList<>();

    static void catat(String pesan) {
        String baris = LocalDateTime.now() + " - " + pesan;
        System.out.println(baris);
        log.add(baris);
    }

    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");

        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            catat("report.txt berhasil dibuat");

            if (Files.exists(source)) {
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                    catat("Folder backup dibuat");
                }
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                catat("Backup berhasil: " + backup);
            } else {
                catat("GAGAL: file sumber tidak ditemukan");
            }
        } catch (IOException e) {
            catat("ERROR: " + e.getMessage());
        }

        try {
            Files.write(logFile, log);
        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }
}
