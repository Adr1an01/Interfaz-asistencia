
package user.GUI;

import java.util.Date;

/**
 *
 * @author Adrian
 */
public class Registro {

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }


    
    
    private int id;
    private String nombres;
    private String apellido;
    private String curso;
    private Date fecha;
    private String modalidad;
    private String asistencia;

    public Registro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", nombres=" + nombres + ", apellido=" + apellido + ", curso=" + curso + ", fecha=" + fecha + ", modalidad=" + modalidad + ", asistencia=" + asistencia + '}';
    }

    public Registro(int id, String nombres, String apellido, String curso, Date fecha, String modalidad, String asistencia) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.curso = curso;
        this.fecha = fecha;
        this.modalidad = modalidad;
        this.asistencia = asistencia;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public void setFechaString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}
