# ReadMe: Sistem Penyewaan Alat Camping

## Deskripsi
Proyek ini adalah aplikasi berbasis Java yang dirancang untuk mengelola penyewaan alat camping. Aplikasi ini memungkinkan pengguna untuk:
- Menambahkan alat camping ke dalam daftar sewa.
- Menghitung total biaya berdasarkan jumlah dan durasi penyewaan.
- Menghapus item penyewaan tertentu.

Aplikasi menggunakan konsep Object-Oriented Programming (OOP) dan memiliki relasi antar kelas untuk merepresentasikan alat camping, item sewa, dan penyewaan secara keseluruhan.

---

## Struktur Kelas

### 1. **AlatCamping**
- **Deskripsi:** Merepresentasikan alat camping yang dapat disewa.
- **Atribut:**
  - `nama` (String): Nama alat camping.
  - `jenis` (String): Jenis alat camping.
  - `harga` (int): Harga sewa per hari.
- **Method:**
  - Getter dan Setter untuk setiap atribut.
  - `toString()`: Mengembalikan informasi alat camping dalam format yang mudah dibaca.

---

### 2. **ItemSewa**
- **Deskripsi:** Merepresentasikan item dalam penyewaan, yaitu alat camping yang disewa beserta jumlahnya.
- **Atribut:**
  - `alatSewa` (AlatCamping): Objek alat camping yang disewa.
  - `jumlah` (int): Jumlah alat camping yang disewa.
- **Method:**
  - Getter dan Setter untuk setiap atribut.
  - `toString()`: Mengembalikan informasi item sewa dalam format yang mudah dibaca.

---

### 3. **Penyewaan**
- **Deskripsi:** Merepresentasikan sebuah penyewaan yang terdiri dari beberapa item sewa dan durasi penyewaan.
- **Atribut:**
  - `itemSewaList` (ArrayList<ItemSewa>): Daftar item yang disewa.
  - `durasi` (int): Durasi penyewaan dalam hari.
- **Method:**
  - `tambahItemSewa(ItemSewa item)`: Menambahkan item ke dalam daftar penyewaan.
  - `hitungTotal()`: Menghitung total biaya penyewaan.
  - `toString()`: Mengembalikan informasi penyewaan dalam format yang mudah dibaca.

---

### 4. **CampingModel**
- **Deskripsi:** Model untuk mengelola data alat camping dan penyewaan.
- **Atribut:**
  - `daftarAlat` (ArrayList<AlatCamping>): Daftar alat camping yang tersedia.
  - `penyewaan` (Penyewaan): Objek penyewaan aktif.
- **Method:**
  - `tambahAlat(String nama, String jenis, int harga)`: Menambahkan alat camping ke dalam daftar.
  - `cariAlat(String nama)`: Mencari alat camping berdasarkan nama.
  - `tambahItemSewa(String nama, int jumlah)`: Menambahkan item ke dalam penyewaan.
  - `hitungTotalHarga()`: Menghitung total biaya penyewaan dari penyewaan aktif.

---

## Contoh Penggunaan

### Penambahan Alat Camping
```java
CampingModel model = new CampingModel();
model.tambahAlat("Tenda", "Camping", 50000);
model.tambahAlat("Sleeping Bag", "Camping", 20000);
model.tambahAlat("Kompor", "Camping", 30000);
```

### Penambahan Item ke Penyewaan
```java
model.tambahItemSewa("Tenda", 2);
model.tambahItemSewa("Sleeping Bag", 3);
```

### Menghitung Total Biaya
```java
int total = model.hitungTotalHarga();
System.out.println("Total Biaya: Rp " + total);
```

---

## Relasi Antar Kelas
1. **`Penyewaan`** memiliki hubungan **"mengandung"** (composition) dengan **`ItemSewa`**, karena setiap penyewaan dapat memiliki banyak item sewa.
2. **`ItemSewa`** memiliki hubungan **"menggunakan"** (aggregation) dengan **`AlatCamping`**, karena setiap item sewa mereferensikan alat camping tertentu.
3. **`CampingModel`** mengelola data terkait alat camping dan penyewaan.

---

## Catatan Penting
- Durasi penyewaan maksimal 10 hari.
- Jumlah alat yang disewa harus positif.
- Setiap alat yang ditambahkan ke daftar sewa harus ada dalam daftar alat camping yang tersedia.

