package com.example.parcial_numero_2;

/*
 * no puedo mas con mi vida
 * Modelo de datos para sqlite
 */

public class ClaseReloj {
    public int imageResId;
    private int id;
    private String modelo;
    private String marca;
    private String descripcion;
    private double precio;

    public ClaseReloj(int id, String modelo, String marca, String descripcion, double precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
