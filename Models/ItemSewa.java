package Models;

public class ItemSewa {
    private AlatCamping alatSewa;
    private int jumlah;

    public ItemSewa(AlatCamping alatSewa, int jumlah){
        this.alatSewa = alatSewa;
        this.jumlah = jumlah;
    }

    public AlatCamping getAlatSewa(){
        return alatSewa;
    }

    public void setAlatSewa(AlatCamping alatSewa){
        this.alatSewa = alatSewa;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return alatSewa.getNama() + " x" + jumlah + " (" + alatSewa.getHarga() + " perhari)";
    }
}
