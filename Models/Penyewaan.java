package Models;
import java.util.ArrayList;

public class Penyewaan {
    // private AlatCamping alat;
    private ArrayList<ItemSewa> items;
    private int durasi;

    public Penyewaan( int durasi) {
        this.items = new ArrayList<>();
        this.durasi = durasi;
    }

    public ArrayList<ItemSewa> getItems(){
        return items;
    }

    public void addItem(ItemSewa item){
        items.add(item);
    }

    public int getDurasi(){
        return durasi;
    }

    public int hitungTotal(){
        int total = 0;
        for (ItemSewa item : items){
            total += item.getAlatSewa().getHarga() * item.getJumlah() * durasi;
        }
        return total;
    }

    // public int hitungHarga() {
    //     return alat.getHarga() * jumlah * durasi;
    // }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Durasi: ").append(durasi).append(" hari\n");
        for (ItemSewa item : items) {
            builder.append("- ").append(item.toString()).append("\n");
        }
        return builder.toString();
    }
}