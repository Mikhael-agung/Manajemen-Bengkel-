package Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CampingView extends JFrame {
    private JComboBox<String> alatComboBox;
    private JTextField jumlahField, durasiField;
    private JButton tambahButton, hapusButton, hitungButton;
    private JList<String> sewaList;
    private DefaultListModel<String> sewaListModel;
    private JLabel totalLabel;

    public CampingView() {
        setTitle("Penyewaan Alat Camping");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Alat:"));
        alatComboBox = new JComboBox<>();
        inputPanel.add(alatComboBox);
        inputPanel.add(new JLabel("Jumlah:"));
        jumlahField = new JTextField();
        inputPanel.add(jumlahField);
        inputPanel.add(new JLabel("Durasi (hari):"));
        durasiField = new JTextField();
        inputPanel.add(durasiField);
        tambahButton = new JButton("Tambah Sewa");
        inputPanel.add(tambahButton);
        hapusButton = new JButton("Hapus Sewa");
        inputPanel.add(hapusButton);

        add(inputPanel, BorderLayout.NORTH);

        sewaListModel = new DefaultListModel<>();
        sewaList = new JList<>(sewaListModel);
        add(new JScrollPane(sewaList), BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Total: Rp 0");
        hitungButton = new JButton("Hitung Total");
        footerPanel.add(totalLabel, BorderLayout.WEST);
        footerPanel.add(hitungButton, BorderLayout.EAST);

        add(footerPanel, BorderLayout.SOUTH);
    }

    public void setAlatOptions(String[] alat) {
        alatComboBox.setModel(new DefaultComboBoxModel<>(alat));
    }

    public String getSelectedAlat() {
        return (String) alatComboBox.getSelectedItem();
    }

    public String getJumlahField() {
        return jumlahField.getText();
    }

    public String getDurasiField() {
        return durasiField.getText();
    }

    public int getSelectedSewaIndex() {
        return sewaList.getSelectedIndex();
    }

    public void updateSewaList(String[] sewaItems) {
        sewaListModel.clear();
        for (String item : sewaItems) {
            sewaListModel.addElement(item);
        }
    }

    public void setTotalLabel(String total) {
        totalLabel.setText(total);
    }

    public void addTambahListener(ActionListener listener) {
        tambahButton.addActionListener(listener);
    }

    public void addHapusListener(ActionListener listener) {
        hapusButton.addActionListener(listener);
    }

    public void addHitungListener(ActionListener listener) {
        hitungButton.addActionListener(listener);
    }
}
