package home.mensagens;

/**
 * Created by root on 31/01/17.
 */

public class BDFrasesTeste {
    private int id;
    private String frase;

    public BDFrasesTeste(){}

    public BDFrasesTeste(int id, String frase)
    {
        this.id = id;
        this.frase = frase;

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public String toString() {
        return "BDFrasesTeste{" +
                "id=" + id +
                ", frase='" + frase +
                '}';
    }
}
