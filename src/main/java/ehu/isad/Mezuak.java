package ehu.isad;

public class Mezuak {
    public String getNork() {
        return nork;
    }

    public void setNork(String nork) {
        this.nork = nork;
    }

    public String getNori() {
        return nori;
    }

    public void setNori(String nori) {
        this.nori = nori;
    }

    public String getMezua() {
        return mezua;
    }

    public void setMezua(String mezua) {
        this.mezua = mezua;
    }

    public Mezuak(String nork, String nori, String mezua) {
        this.nork = nork;
        this.nori = nori;
        this.mezua = mezua;
    }

    private String nork;
    private String nori;
    private String mezua;
}
