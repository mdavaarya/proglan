package org.example;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    String nama;
    int harga;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}

public class WarungMakan {
    private static ArrayList<Menu> daftarMenu = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        daftarMenu.add(new Menu("Nasi Goreng", 15000));
        daftarMenu.add(new Menu("Ayam Bakar", 20000));
        daftarMenu.add(new Menu("Soto Ayam", 12000));
        daftarMenu.add(new Menu("Es Teh", 5000));
        daftarMenu.add(new Menu("Es Jeruk", 7000));
        System.out.println("Selamat datang di Warung Makan!");
        tampilkanMenu();

        ArrayList<Menu> pesanan = new ArrayList<>();
        while (true) {
            System.out.print("Masukkan nomor menu yang ingin dipesan (0 untuk selesai): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                break;
            } else if (pilihan > 0 && pilihan <= daftarMenu.size()) {
                pesanan.add(daftarMenu.get(pilihan - 1));
                System.out.println(daftarMenu.get(pilihan - 1).getNama() + " telah ditambahkan.");
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        tampilkanRingkasanPesanan(pesanan);
        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("\nDaftar Menu:");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMenu.get(i).getNama() + " - Rp " + daftarMenu.get(i).getHarga());
        }
    }

    public static void tampilkanRingkasanPesanan(ArrayList<Menu> pesanan) {
        System.out.println("\nRingkasan Pesanan:");
        int total = 0;
        for (Menu item : pesanan) {
            System.out.println(item.getNama() + " - Rp " + item.getHarga());
            total += item.getHarga();
        }
        System.out.println("Total yang harus dibayar: Rp " + total);
        System.out.println("Terima kasih telah memesan!");
    }
}
