package Models;

import java.util.ArrayList;
import java.util.List;

public class CampingModel {
    private List<AlatCamping> daftarAlat = new ArrayList<>();
    private List<Penyewaan> daftarSewa = new ArrayList<>();

    public void tambahAlat(String nama, String jenis, int harga) {
        daftarAlat.add(new AlatCamping(nama, jenis, harga));
    }

    public List<AlatCamping> getDaftarAlat() {
        return daftarAlat;
    }

    public void tambahSewa(Penyewaan sewa) {
        daftarSewa.add(sewa);
    }

    public List<Penyewaan> getDaftarSewa() {
        return daftarSewa;
    }

    public void hapusSewa(int index) {
        if (index >= 0 && index < daftarSewa.size()) {
            daftarSewa.remove(index);
        }
    }

    public int hitungTotalHarga() {
        return daftarSewa.stream().mapToInt(Penyewaan::hitungTotal).sum();
    }

    public AlatCamping cariAlat(String nama) {
        for (AlatCamping alat : daftarAlat) {
            if (alat.getNama().equalsIgnoreCase(nama)) {
                return alat;
            }
        }
        return null;
    }
}
