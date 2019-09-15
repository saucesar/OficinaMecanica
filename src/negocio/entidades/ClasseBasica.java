package negocio.entidades;

public abstract class ClasseBasica {
    boolean eNumerico(String string){
        try {Double.parseDouble(string); }
        catch (NumberFormatException | NullPointerException nfe) { return false; }
        return true;
    }

    public abstract boolean dadosValidos();
}
