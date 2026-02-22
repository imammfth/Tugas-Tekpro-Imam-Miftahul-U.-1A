public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    //GETTER & SETTER
    public String getNamaMakanan(int id) {
        return nama_makanan[id];
    }

    public void setNamaMakanan(int id, String nama) {
        this.nama_makanan[id] = nama;
    }

    public double getHargaMakanan(int id) {
        return harga_makanan[id];
    }

    public void setHargaMakanan(int id, double harga) {
        this.harga_makanan[id] = harga;
    }

    public int getStok(int id) {
        return stok[id];
    }

    public void setStok(int id, int stokBaru) {
        this.stok[id] = (stokBaru < 0) ? 0 : stokBaru; 
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stok);
        nextId(); 
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(getNamaMakanan(i) + "[" + getStok(i) + "]\tRp. " + getHargaMakanan(i));
            }
        }
    }

    public boolean isOutOfStock(int id) {
        return getStok(id) == 0;
    }

    public void pesanMenu(int idMenu, int jumlah) {
        if (idMenu < id && getStok(idMenu) >= jumlah) {
            setStok(idMenu, getStok(idMenu) - jumlah); 
            System.out.println("Pemesanan berhasil!");
        } else {
            System.out.println("Stok tidak cukup atau menu salah!");
        }
    }

    private static void nextId() {
        id++;
    }
}