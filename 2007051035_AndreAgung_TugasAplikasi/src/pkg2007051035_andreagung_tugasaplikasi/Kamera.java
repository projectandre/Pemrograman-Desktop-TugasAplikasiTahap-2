/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2007051035_andreagung_tugasaplikasi;

/**
 *
 * @author ANDRE
 */
public class Kamera {
    private String id;
    private String nama;
    private String alamat;
    private String tgl_beli;
    private String warna;
    private String jenis_kamera;
    private Integer harga;

    public Kamera( String id, String nama, String alamat, String tgl_beli, String warna, String jenis_kamera, Integer harga) {
       
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_beli = tgl_beli;
        this.warna = warna;
        this.jenis_kamera = jenis_kamera;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTgl_beli() {
        return tgl_beli;
    }

    public void setTgl_beli(String tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getJenis_kamera() {
        return jenis_kamera;
    }

    public void setJenis_kamera(String jenis_kamera) {
        this.jenis_kamera = jenis_kamera;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

   
    
    
    
}
