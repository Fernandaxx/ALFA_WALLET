package wallet.model.entity;

public class Usuario {
    private int id_Persona;
    private String email;
    private String password;
    private boolean aceptaTerminos;

    public boolean autenticar(String email, String password) {
        // Lógica de autenticación
        return "admin@example.com".equals(email) &&
                "password123".equals(password);
    }
}