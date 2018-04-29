package es.edu.java.compare;

public class MiObjeto implements Cloneable {
    public String campo1;
    public String campo2;

    public MiObjeto() {
        this.campo1 = "";
        this.campo2 = "";
    }

    public MiObjeto(String valor) {
        this.campo1 = valor;
    }

    @Override
    public MiObjeto clone() {
        try {
            return (MiObjeto)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Campo1: " + this.campo1 + "; Campo2: " + this.campo2;
    }
}