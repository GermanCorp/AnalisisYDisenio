
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static royal_gym.Pagos.resultado;

/**
 *
 * @author Jazmin Vargas
 */
public class Expediente {

    private static Statement statement;
    static ResultSet resultado;
    int contador = 0;

    public Expediente() {
    }

    public void insertarProblemasdeSalud(
            String id,
            boolean gastritis,
            boolean colitis,
            boolean estreñimiento,
            boolean ulcera,
            boolean cansancio,
            boolean diabetes,
            boolean presionAlta,
            boolean colesterol,
            boolean alergias,
            boolean estres,
            boolean dolordecabeza,
            boolean dolordecuello,
            boolean doloresdeespalda,
            boolean artritis,
            boolean ansiedad,
            boolean embarazo,
            boolean retencionliquidos,
            boolean malacirculacion,
            boolean calambres,
            boolean varices,
            boolean doloresdehueso,
            boolean anemia,
            boolean problemadevesicula,
            boolean problemaderiñon,
            boolean celulitis) {

        try {
            String sql = "insert into problemasdesalud(id_cliente,Gastritis,Colitis,Estreñimiento,Ulcera,Cansancio,Diabetes,PresionAlta,"
                    + "Colesterol,Alergias,Estres,Dolordecabeza,Dolordecuello,Doloresdeespalda,Artritis,Ansiedad,EmbarazoLactancia,"
                    + "Retenciondeliquidos,Malacirculacion,Calambres,Varices,Doloresdehueso,Anemia,ProblemadeVesicula,Problemaderiñon,Celulitis)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);

            consulta.setString(1, id);
            consulta.setBoolean(2, gastritis);
            consulta.setBoolean(3, colitis);
            consulta.setBoolean(4, estreñimiento);
            consulta.setBoolean(5, ulcera);
            consulta.setBoolean(6, cansancio);
            consulta.setBoolean(7, diabetes);
            consulta.setBoolean(8, presionAlta);
            consulta.setBoolean(9, colesterol);
            consulta.setBoolean(10, alergias);
            consulta.setBoolean(11, estres);
            consulta.setBoolean(12, dolordecabeza);
            consulta.setBoolean(13, dolordecuello);
            consulta.setBoolean(14, doloresdeespalda);
            consulta.setBoolean(15, artritis);
            consulta.setBoolean(16, ansiedad);
            consulta.setBoolean(17, embarazo);
            consulta.setBoolean(18, retencionliquidos);
            consulta.setBoolean(19, malacirculacion);
            consulta.setBoolean(20, calambres);
            consulta.setBoolean(21, varices);
            consulta.setBoolean(22, doloresdehueso);
            consulta.setBoolean(23, anemia);
            consulta.setBoolean(24, problemadevesicula);
            consulta.setBoolean(25, problemaderiñon);
            consulta.setBoolean(26, celulitis);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }// fin de insertar pago

    public void insertarCambiosCorporales(String peso, String imc, String grasa, String musculo, String calorias, String edad, String grasaviceral, String id, String fecha) {
        try {
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, calorias, edad , grasaviceral, id_cliente, fecha) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);

            consulta.setString(1, peso);
            consulta.setString(2, imc);
            consulta.setString(3, grasa);
            consulta.setString(4, musculo);
            consulta.setString(5, calorias);
            consulta.setString(6, edad);
            consulta.setString(7, grasaviceral);
            consulta.setString(8, id);
            consulta.setString(9, fecha);

            consulta.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }// fin de insertar pago

    /*public Object[][] getCambios(String id) {
        Object[][] datosPago = null;

        try {
            String consulta = "SELECT * FROM cambioscorporales where id_Cliente = ? order by id_cambio DESC ";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, id);
            resultado = statement.executeQuery(consulta);

            ArrayList<Object[]> filas = new ArrayList<>();
            {

                while (resultado.next()) {
                    filas.add(
                            new Object[]{
                                resultado.getString(consulta)
                                resultado.getDouble("peso"),
                                resultado.getDouble("imc"),
                                resultado.getDouble("porcentajedegrasa"),
                                resultado.getDouble("porcentajedemusculo"),
                                resultado.getDouble("calorias"),
                                resultado.getInt("edad"),
                                resultado.getInt("grasaviceral"),});
                    datosPago = new Object[filas.size()][];
                    filas.toArray(datosPago);
                }
            }
        } catch (Exception e) {
        }
        return datosPago;
    }*/

    public void actualizarTablaClientes(String telefonoTra, String direccion, String mejorHoraParaLlamar,
            String fechaInicio, String telefonoCasa, String celular, String edad, String pesoIdeal, Boolean subir,
            Boolean mantener, Boolean bajar, String id) {
        try {
            String sql = "update cliente set TelefonoTrabajo = ?, Direccion = ?, MejorHoraParaLlamar = ?, FechaDeInicio = ?,"
                    + " TelefonoCasa = ? , Celular = ? , Edad = ? , PesoIdeal = ? , PesoQuiereSubir = ?,PesoQuiereMantener = ?, PesoQuiereBajar = ? "
                    + " where idCliente = ?";

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, telefonoTra);
            consulta.setString(2, direccion);
            consulta.setString(3, mejorHoraParaLlamar);
            consulta.setString(4, fechaInicio);
            consulta.setString(5, telefonoCasa);
            consulta.setString(6, celular);
            consulta.setString(7, edad);
            consulta.setString(8, pesoIdeal);
            consulta.setBoolean(9, subir);
            consulta.setBoolean(10, mantener);
            consulta.setBoolean(11, bajar);
            consulta.setString(12, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Cliente" + e.getMessage());
        }
    }

    public void actualizarCambiosCorporales(String peso, String imc, String grasa, String musculo, String calorias, String edad, String grasaviceral, String id) {
        try {
            String sql = "update cambioscorporales set peso = ?, imc = ?, porcentajedegrasa = ?, porcentajedemusculo = ?,"
                    + " calorias = ? , edad = ? , grasaviceral = ? "
                    + " where id_cliente = ?";

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, peso);
            consulta.setString(2, imc);
            consulta.setString(3, grasa);
            consulta.setString(4, musculo);
            consulta.setString(5, calorias);
            consulta.setString(6, edad);
            consulta.setString(7, grasaviceral);
            consulta.setString(8, id);

            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Cliente" + e.getMessage());
        }
    }

    public void actualizarProblemasDeSalud(String id,
            boolean gastritis,
            boolean colitis,
            boolean estreñimiento,
            boolean ulcera,
            boolean cansancio,
            boolean diabetes,
            boolean presionAlta,
            boolean colesterol,
            boolean alergias,
            boolean estres,
            boolean dolordecabeza,
            boolean dolordecuello,
            boolean doloresdeespalda,
            boolean artritis,
            boolean ansiedad,
            boolean embarazo,
            boolean retencionliquidos,
            boolean malacirculacion,
            boolean calambres,
            boolean varices,
            boolean doloresdehueso,
            //boolean anemia,
            boolean problemadevesicula,
            boolean problemaderiñon,
            boolean celulitis) {

        try {
            String sql = "update  problemasdesalud set Gastritis = ?,Colitis= ?,Estreñimiento= ?,Ulcera= ?,Cansancio= ?,Diabetes= ?,PresionAlta= ?,"
                    + "Colesterol= ?,Alergias= ?,Estres= ?,Dolordecabeza= ?,Dolordecuello= ?,Doloresdeespalda= ?,Artritis= ?,Ansiedad= ?,EmbarazoLactancia= ?,"
                    + "Retenciondeliquidos= ?,Malacirculacion= ?,Calambres= ?,Varices= ?,Doloresdehueso= ?,ProblemadeVesicula= ?,Problemaderiñon= ?,Celulitis= ?"
                    + " where id_cliente = ?";

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, id);
            consulta.setBoolean(2, gastritis);
            consulta.setBoolean(3, colitis);
            consulta.setBoolean(4, estreñimiento);
            consulta.setBoolean(5, ulcera);
            consulta.setBoolean(6, cansancio);
            consulta.setBoolean(7, diabetes);
            consulta.setBoolean(8, presionAlta);
            consulta.setBoolean(9, colesterol);
            consulta.setBoolean(10, alergias);
            consulta.setBoolean(11, estres);
            consulta.setBoolean(12, dolordecabeza);
            consulta.setBoolean(13, dolordecuello);
            consulta.setBoolean(14, doloresdeespalda);
            consulta.setBoolean(15, artritis);
            consulta.setBoolean(16, ansiedad);
            consulta.setBoolean(17, embarazo);
            consulta.setBoolean(18, retencionliquidos);
            consulta.setBoolean(19, malacirculacion);
            consulta.setBoolean(20, calambres);
            consulta.setBoolean(21, varices);
            consulta.setBoolean(22, doloresdehueso);
            // consulta.setBoolean(23, anemia);
            consulta.setBoolean(23, problemadevesicula);
            consulta.setBoolean(24, problemaderiñon);
            consulta.setBoolean(25, celulitis);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Cliente" + e.getMessage());
        }

    }

}
