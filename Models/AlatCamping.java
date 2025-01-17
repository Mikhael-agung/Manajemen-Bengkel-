package Models;

public class AlatCamping {
    private String nama;
    private String jenis;
    private int harga;

    public AlatCamping(String nama, String jenis, int harga) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " (" + jenis + ") - Rp " + harga + " / hari";
    }
} 

