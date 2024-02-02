package ConecToBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import user.GUI.Registro;

/**
 *
 * @author Adrian
 */


public class ConexionBD {


	// CONFIGURACION PARA REALIZAR LA CONEXION AL SERVIDOR DE DONDE SE CONECTARÁ, PARA REALIZAR LAS CONSULTAS E INGRESAR LOS DATOS
    private final String bd ;
    private final String user ;
    private final String pass ;
    private final String ip ;
    private final String puerto ;

    private final String cadena ;

    public ArrayList<String> listaNombres(String curso, String modalidad) throws SQLException {
        ArrayList<String> lista = new ArrayList<>();
        String query = "select nombres,apellidos from matriculados_enero where curso_id = ? and modalidad = ?";
        try (Connection con = DriverManager.getConnection(cadena, user, pass); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, curso);
            ps.setString(2, modalidad);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(rs.getString("nombres").trim() + "," + rs.getString("apellidos").trim());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al iniciar la consulta" + e.toString());
        }

        return lista;
    }

    public void enviarDatos(ArrayList<Registro> Dataset, String modalidad) {
        String query1 = " INSERT INTO asistencias_enero (`nombres`,`apellidos`,`curso`,`modalidad`,`fecha`,`verificar_asistencia`) VALUES (?,?,?,?,?,?); ";
        if (Dataset.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return;
        }
        try (Connection conED = DriverManager.getConnection(cadena, user, pass);) {
            conED.setAutoCommit(false);
            try (PreparedStatement stmt = conED.prepareStatement(query1)) {
                for (Registro r : Dataset) {
                    stmt.setString(1, r.getNombres());
                    stmt.setString(2, r.getApellido());
                    stmt.setString(3, r.getCurso());
                    stmt.setString(4, modalidad);
                    stmt.setDate(5, (Date) r.getFecha());
                    if (r.getAsistencia().equals("Asistio")) {
                        stmt.setInt(6, 1);
                    } else {
                        stmt.setInt(6, 0);
                    }
                    stmt.addBatch();
                }
                stmt.executeBatch();
                conED.commit();
                JOptionPane.showMessageDialog(null, "Asistencia registrada con éxito.");

            } catch (Exception e) {
                conED.rollback();
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta : "+e.toString());
            } finally {
                conED.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al inicar la consulta : "+ex.toString());
        }
    }

    public ArrayList<Registro> consultaAsistencia(String curso, String modalidad, String fecha) throws SQLException {
        ArrayList<Registro> listaConsulta = new ArrayList<>();
        String query2 = "SELECT id_asistencias,nombres, apellidos, curso, modalidad, fecha, verificar_asistencia FROM asistencias_enero WHERE curso = ? AND modalidad = ? AND fecha = ? ";

        try (Connection con = DriverManager.getConnection(cadena, user, pass); PreparedStatement ps = con.prepareStatement(query2)) {
            ps.setString(1, curso);
            ps.setString(2, modalidad);
            ps.setString(3, fecha);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Registro iter = new Registro();
                    iter.setId(rs.getInt("id_asistencias"));
                    iter.setNombres(rs.getString("nombres"));
                    iter.setApellido(rs.getString("apellidos"));
                    iter.setCurso(rs.getString("curso"));
                    iter.setFecha(rs.getDate("fecha"));
                    iter.setAsistencia("" + rs.getInt("verificar_asistencia"));
                    listaConsulta.add(iter);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al iniciar la consulta : " + e.toString());
        }

        return listaConsulta;
    }

    public void resanarLista(ArrayList<Registro> setData) {
        String query2 = " UPDATE asistencias_enero SET verificar_asistencia = ? WHERE id_asistencias = ?;";
        if (setData.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return;
        }
        try (Connection conRL = DriverManager.getConnection(cadena, user, pass);) {
            conRL.setAutoCommit(false);
            try (PreparedStatement stmt = conRL.prepareStatement(query2)) {

                for (Registro r : setData) {
                    if (r.getAsistencia().equals("Asistio")) {
                        stmt.setBoolean(1, true);
                    } else {
                        stmt.setBoolean(1, false);
                    }
                    stmt.setInt(2, r.getId());
                    stmt.addBatch();
                }

                stmt.executeBatch();
                conRL.commit();
                stmt.clearBatch();
                JOptionPane.showMessageDialog(null, "Asistencia actualizada con éxito.");

            } catch (Exception e) {
                conRL.rollback();
                JOptionPane.showMessageDialog(null, "Error al enviar los datos : " + e.toString());
            } finally {
                conRL.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al enviar los datos : " + ex.toString());

        }
    }

}
