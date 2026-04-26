public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Bala-Bala", 2000, 20);
        menu.tambahMenuMakanan("Gehu", 2000, 15);
        menu.tambahMenuMakanan("Tahu Pedas", 2500, 10);
        menu.tambahMenuMakanan("Pisang Goreng", 2000, 5);

        System.out.println("DAFTAR MENU AWAL:");
        menu.tampilMenuMakanan();

        System.out.println("\n Melakukan Pemesanan ");
        
        System.out.print("Pesan Bala-Bala 5: ");
        menu.pesanMenu(0, 5); 

        System.out.print("Pesan Pisang Goreng 10: ");
        menu.pesanMenu(3, 10); 

        System.out.println("\nDAFTAR MENU SETELAH PEMESANAN:");
        menu.tampilMenuMakanan();
    }
}