import java.util.Scanner;

class SumThread extends Thread {
    private long startNum;
    private long endNum;
    private long partialSum = 0;

    // Variabel statis yang digunakan bersama oleh semua thread
    private static long totalSum = 0;
    private static final Object lock = new Object();

    public SumThread(String name, long startNum, long endNum) {
        super(name);
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public void run() {
        // Output tugas yang dikerjakan
        System.out.println(getName() + ": Menjumlahkan " + startNum + " - " + endNum);

        // Menghitung hasil parsial
        for (long i = startNum; i <= endNum; i++) {
            partialSum += i;
        }

        // Output hasil parsial
        System.out.println("Hasil parsial " + getName() + ": " + partialSum);

        // Sinkronisasi untuk menyetorkan nilai ke total akhir (Thread-safety)
        synchronized (lock) {
            totalSum += partialSum;
        }
    }

    public static long getTotalSum() {
        return totalSum;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();

        System.out.print("Masukkan Angka Akhir: ");
        long finalNumber = scanner.nextLong();

        Thread[] threads = new Thread[numThreads];
        long range = finalNumber / numThreads; // Pembagian tugas dasar
        long currentStart = 1;

        System.out.println("\n--- Eksekusi Thread ---");

        // Mekanisme Pembagian Tugas (Divide)
        for (int i = 0; i < numThreads; i++) {
            // Memastikan thread terakhir mendapatkan sisa pembagian jika tidak habis dibagi
            long currentEnd = (i == numThreads - 1) ? finalNumber : (currentStart + range - 1);

            threads[i] = new SumThread("Thread " + (i + 1), currentStart, currentEnd);
            threads[i].start();

            currentStart = currentEnd + 1;
        }

        // Sinkronisasi Thread Induk (Join)
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total penjumlahan 1 sampai " + finalNumber + " = " + SumThread.getTotalSum());
        
        scanner.close();
    }
}