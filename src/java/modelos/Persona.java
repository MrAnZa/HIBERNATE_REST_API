package modelos;
// Generated 20/06/2019 08:58:17 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Persona generated by hbm2java
 */
public class Persona implements java.io.Serializable {

    private int perId;
    private String perNom;
    private String perApe;
    private Byte perEdad;

    public Persona() {
        this.perId = 0; //se pone 0 porque la base de datos tiene el campo como auto increment
    }

    public Persona(int perId) {
        this.perId = perId;
    }

    /*public Persona(BigDecimal perId, String perNom, String perApe, Byte perEdad) {
       this.perId = perId;
       this.perNom = perNom;
       this.perApe = perApe;
       this.perEdad = perEdad;
    }*/
    public Persona(String perNom, String perApe, Byte perEdad) {
        this.perNom = perNom;
        this.perApe = perApe;
        this.perEdad = perEdad;
    }

    public int getPerId() {
        return this.perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerNom() {
        return this.perNom;
    }

    public void setPerNom(String perNom) {
        this.perNom = perNom;
    }

    public String getPerApe() {
        return this.perApe;
    }

    public void setPerApe(String perApe) {
        this.perApe = perApe;
    }

    public Byte getPerEdad() {
        return this.perEdad;
    }

    public void setPerEdad(Byte perEdad) {
        this.perEdad = perEdad;
    }

}
