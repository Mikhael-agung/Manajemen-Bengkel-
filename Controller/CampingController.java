package Controller;

import Models.AlatCamping;
import Models.CampingModel;
import Models.ItemSewa;
import Models.Penyewaan;
import Views.CampingView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CampingController {
    private CampingModel model;
    private CampingView view;

    public CampingController(CampingModel model, CampingView view) {
        this.model = model;
        this.view = view;

        model.tambahAlat("Tenda", "Camping", 50000);
        model.tambahAlat("Sleeping-Bag", "Camping", 20000);
        model.tambahAlat("Kompor", "Camping", 30000);

        view.setAlatOptions(model.getDaftarAlat().stream().map(Object::toString).toArray(String[]::new));

        view.addTambahListener(new TambahListener());
        view.addHapusListener(new HapusListener());
        view.addHitungListener(new HitungListener());

        view.setVisible(true);
    }

    class TambahListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String alatStr = view.getSelectedAlat();
            int jumlah = Integer.parseInt(view.getJumlahField());
            int durasi = Integer.parseInt(view.getDurasiField());

            if (durasi > 10 || jumlah <= 0) {
                JOptionPane.showMessageDialog(view, "Durasi maksimal 10 hari dan jumlah harus positif.");
                return;
            }

            // Cari alat
            String alatNama = alatStr.split(" ")[0];
            AlatCamping alat = model.cariAlat(alatNama);
            if (alat == null) {
                JOptionPane.showMessageDialog(view, "Alat tidak ditemukan.");
                return;
            }

            // Tambah item ke penyewaan
            Penyewaan penyewaan = new Penyewaan(durasi);
            penyewaan.addItem(new ItemSewa(alat, jumlah));
            model.tambahSewa(penyewaan);
            updateView();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Input jumlah dan durasi harus angka valid.");
        }
    }
}

    
    

    class HapusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getSelectedSewaIndex();
            if (index >= 0) {
                int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus?");
                if (confirm == JOptionPane.YES_OPTION) {
                    model.hapusSewa(index);
                    updateView();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Pilih item untuk dihapus.");
            }
        }
    }

    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int total = model.hitungTotalHarga();
            view.setTotalLabel("Total: Rp " + total);
        }
    }

    private void updateView() {
        view.updateSewaList(model.getDaftarSewa().stream().map(Penyewaan::toString).toArray(String[]::new));
    }
}
