package wallet.model.entity;

public class Usuario {
    private Persona persona;
    private String email;
    private String password;
    private boolean aceptaTerminos;

    public String getEmail() {
        return email;
    }

    public Usuario(Persona persona, String email, String password, boolean aceptaTerminos) {
        this.persona = persona;
        this.email = email;
        this.password = password;
        this.aceptaTerminos = aceptaTerminos;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAceptaTerminos() {
        return aceptaTerminos;
    }

    public void setAceptaTerminos(boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }

}