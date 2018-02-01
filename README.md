### Sistem Terdistribusi (Tugas 2)

# Persiapkan Server
- Periksa localhost sudah berjalan
- Jalankan server

<img src="https://github.com/Danboru/Sistem-Terdistribusi-Tugas-2-/blob/master/IMAGES/1.png"  width="400" height="300" />

# Persiapkan Client
- Pastikan server sudah berjalan
- Aplikasi siap digunakan
- Input sesuai dengan keiginan

<img src="https://github.com/Danboru/Sistem-Terdistribusi-Tugas-2-/blob/master/IMAGES/2.png?raw=true"  width="400" height="300" />

# Sedikit Pembahasan
## Server side

- Pengaturan Koneksi
  - Yang pertama bisa seperti ini :

        connectionDatabase = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_konversi", "root", "root");
            
  - Sedangkan ini cara yang kedua :
            
        connectionDatabase = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=root");

- Sesuaikan dengan port yang di gunakan oleh mysql di komputer kalian (Hapus jika terjadi kesalahan)

## Client Side

- Penggunaan Registry sebagai media komunikasi
          
      Registry registry = null;
      Konversi serviceContract = null;
      private String hasilKonversi = "";
    
      public ControllerClient() throws RemoteException, NotBoundException  {
        
      registry = LocateRegistry.getRegistry("localhost", 3333);        
      serviceContract = (Konversi) registry.lookup("Server");//Case Sensitive
    
- Di sisi Server
                
      ServerController databaseController = new ServerController();
        
      Registry reg = LocateRegistry.createRegistry(3333);
        
      //Server Name
      reg.bind("Server", databaseController); //Di butuhkan di class ControllerClient

- Pastika port dan nama yang di gunakan sama (Antara yang di server dan di client)

# Demo App
- Buka Link Berikut untuk melihat demo 
