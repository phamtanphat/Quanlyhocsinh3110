package com.ptp.phamtanphat.quanlyhocsinh3110;

/**
 * Created by KhoaPhamPC on 16/1/2018.
 */

public class Hocsinh {
    private int Id;
    private String Ten;
    private String Namsinh;
    private String Diachi;

    public Hocsinh(int id, String ten, String namsinh, String diachi) {
        Id = id;
        Ten = ten;
        Namsinh = namsinh;
        Diachi = diachi;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNamsinh() {
        return Namsinh;
    }

    public void setNamsinh(String namsinh) {
        Namsinh = namsinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
}
