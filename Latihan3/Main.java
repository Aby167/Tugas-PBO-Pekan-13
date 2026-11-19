interface Vehicle {
    void jalan();
}

interface EngineStartable {
    void startEngine();
}

interface Refuelable {
    void isiBahanBakar();
}

interface Chargeable {
    void isiBaterai();
}

class MobilListrik implements Vehicle, EngineStartable, Chargeable {
    public void startEngine() {
        System.out.println("Menyalakan motor listrik...");
    }

    public void isiBaterai() {
        System.out.println("Mengisi baterai kendaraan listrik...");
    }

    public void jalan() {
        startEngine();
        System.out.println("Mobil listrik berjalan.");
    }
}

class MobilBensin implements Vehicle, EngineStartable, Refuelable {
    public void startEngine() {
        System.out.println("Menyalakan mesin bensin...");
    }

    public void isiBahanBakar() {
        System.out.println("Mengisi bahan bakar kendaraan...");
    }

    public void jalan() {
        startEngine();
        System.out.println("Mobil bensin berjalan.");
    }
}

class Sepeda implements Vehicle {
    public void jalan() {
        System.out.println("Sepeda dikayuh.");
    }
}

class VehicleController {
    private Vehicle vehicle;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void operate() {
        vehicle.jalan();
    }
}

public class Main {
    public static void main(String[] args) {
        new VehicleController(new MobilListrik()).operate();
        new VehicleController(new MobilBensin()).operate();
        new VehicleController(new Sepeda()).operate();
    }
}