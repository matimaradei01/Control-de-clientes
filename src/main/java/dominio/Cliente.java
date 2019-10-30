package dominio;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private double saldo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellido, String email, double saldo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.saldo = saldo;
        this.telefono = telefono;
    }

    public Cliente(int idCliente, String nombre, String apellido, String email, double saldo, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.saldo = saldo;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", saldo=" + saldo + ", telefono=" + telefono + '}';
    }

}
