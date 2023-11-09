package com.example.bo3_proyecte;

public class Especialista {

    private String NombreEsp;
    private String FotoEsp;
    private String AvilidadesEsp;
    private String TipoEsp;

    public String getNombreEsp() {
        return NombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        NombreEsp = nombreEsp;
    }

    public String getFotoEsp() {
        return FotoEsp;
    }

    public void setFotoEsp(String fotoEsp) {
        FotoEsp = fotoEsp;
    }

    public String getAvilidadesEsp() {
        return AvilidadesEsp;
    }

    public void setAvilidadesEsp(String avilidadesEsp) {
        AvilidadesEsp = avilidadesEsp;
    }

    public String getTipoEsp() {
        return TipoEsp;
    }

    public void setTipoEsp(String tipoEsp) {
        TipoEsp = tipoEsp;
    }

    @Override
    public String toString() {
        return "POJO{" +
                "NombreEsp='" + NombreEsp + '\'' +
                ", FotoEsp='" + FotoEsp + '\'' +
                ", AvilidadesEsp='" + AvilidadesEsp + '\'' +
                ", TipoEsp='" + TipoEsp + '\'' +
                '}';
    }
}
