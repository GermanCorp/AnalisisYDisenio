package royal_gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alxcr
 */
public class Expediente2 {

    Double rpeso;
    Double rimc;
    Double rgrasa;
    Double rmusculo;
    Double rcalorias;
    Double redad;
    Double rviceral;

    public Expediente2() {
    }

    // insertar cambios en la tabla de cambios corporales
    public void insertarCambiosCorporales(String peso, String imc, String grasa, String musculo, String calorias, String edad, String grasaviceral, String id, String fecha) {
        try {
            getUltimoCambiosCorporal(id);
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, calorias, edad , grasaviceral, id_cliente, fecha) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst1 = Conexion.getConexion().prepareStatement(sql);

            double pstPeso = rpeso - Double.parseDouble(peso);
            double pstImc = rimc - Double.parseDouble(imc);
            double pstGrasa = rgrasa - Double.parseDouble(grasa);
            double pstMusculo = rmusculo - Double.parseDouble(musculo);
            double pstCalorias = rcalorias - Double.parseDouble(calorias);
            double pstEdad = redad - Double.parseDouble(edad);
            double pstViceral = rviceral - Double.parseDouble(grasaviceral);

            /*pst1.setString(1, ((rpeso) > Double.parseDouble(peso)) ? "Disminuyó " + String.valueOf(pstPeso) + " Lbs" : "Aumentó " + String.valueOf(pstPeso*-1)+  " Lbs");
            pst1.setString(2, ((rimc) > Double.parseDouble(imc)) ? "Disminuyó en " + String.valueOf(pstImc) : "Aumentó en " + String.valueOf(pstImc * -1));
            pst1.setString(3, ((rgrasa) > Double.parseDouble(grasa)) ? "Disminuyó " + String.valueOf(pstGrasa) + "%" : "Aumentó " + String.valueOf(pstGrasa * -1) + "%");
            pst1.setString(4, ((rmusculo) > Double.parseDouble(musculo)) ? "Disminuyó en " + String.valueOf(pstMusculo) : "Aumentó en " + String.valueOf(pstMusculo * -1));
            pst1.setString(5, ((rcalorias) > Double.parseDouble(calorias)) ? "Disminuyó en " + String.valueOf(pstCalorias) : "Aumentó en " + String.valueOf(pstCalorias * -1));
            pst1.setString(6, ((redad) > Double.parseDouble(edad)) ? "Disminuyó en " + String.valueOf(pstEdad) : "Aumentó en " + String.valueOf(pstEdad * -1));
            pst1.setString(7, ((rviceral) > Double.parseDouble(grasaviceral)) ? "Disminuyó en " + String.valueOf(pstViceral) : "Aumentó en " + String.valueOf(pstViceral * -1));
            pst1.setString(8, id);
            pst1.setString(9, fecha);
            pst1.execute();*/
            pst1.setDouble(1, pstPeso * -1);
            pst1.setDouble(2, pstImc * -1);
            pst1.setDouble(3, pstGrasa * -1);
            pst1.setDouble(4, pstMusculo * -1);
            pst1.setDouble(5, pstCalorias * -1);
            pst1.setDouble(6, pstEdad * -1);
            pst1.setDouble(7, pstViceral * -1);
            pst1.setString(8, id);
            pst1.setString(9, fecha);
            pst1.execute();

        } catch (Exception e) {
        }
    }

    public void insertarTotal(String peso, String imc, String grasa, String musculo, String calorias, String edad, String grasaviceral, String id, String fecha) {
        try {
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, calorias, edad , grasaviceral, id_cliente, fecha) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst1 = Conexion.getConexion().prepareStatement(sql);

            pst1.setString(1, peso);
            pst1.setString(2, imc);
            pst1.setString(3, grasa);
            pst1.setString(4, musculo);
            pst1.setString(5, calorias);
            pst1.setString(6, edad);
            pst1.setString(7, grasaviceral);
            pst1.setString(8, id);
            pst1.setString(9, fecha);
            pst1.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insertarDiferencia(String peso, String imc, String grasa, String musculo, String calorias, String edad, String grasaviceral, String id, String fecha) {
        try {
            getUltimoCambiosCorporal(id);
            String sql = "insert into cambioscorporales(peso, imc, porcentajedegrasa , porcentajedemusculo, calorias, edad , grasaviceral, id_cliente, fecha) values(?,?,?,?,?,?,?,?,?";
            PreparedStatement pst1 = Conexion.getConexion().prepareStatement(sql);;

            pst1.setString(1, peso);
            pst1.setString(2, imc);
            pst1.setString(3, grasa);
            pst1.setString(4, musculo);
            pst1.setString(5, calorias);
            pst1.setString(6, edad);
            pst1.setString(7, grasaviceral);
            pst1.setString(8, id);
            pst1.setString(9, fecha);
            pst1.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // llena la tabla de cambios corporales
    public Object[][] getCambiosCorporales(String id) {
        Object[][] datosCambios = null;
        try {
            String consulta = "SELECT * FROM cambioscorporales WHERE id_cliente = ?";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, id);;

            ResultSet resultado = statement.executeQuery();

            ArrayList<Object[]> filas = new ArrayList<>();
            while (resultado.next()) {
                filas.add(
                        new Object[]{
                            resultado.getString("id_Cliente"),
                            resultado.getString("id_cambio"),
                            resultado.getString("peso"),
                            resultado.getString("imc"),
                            resultado.getString("porcentajedegrasa"),
                            resultado.getString("porcentajedemusculo"),
                            resultado.getString("calorias"),
                            resultado.getString("edad"),
                            resultado.getString("grasaviceral"),
                            resultado.getString("fecha"),}
                );
            }
            datosCambios = new Object[filas.size()][];
            filas.toArray(datosCambios);
        } catch (Exception e) {
            System.out.println("Excepcion en metodo getCambiosCorporales en la clase expediente2 " + e.getMessage());
        }
        return datosCambios;
    }

    public void getUltimoCambiosCorporal(String id) {
        try {
            String consulta = "SELECT * FROM cambioscorporales WHERE id_cliente = ? order by id_cambio DESC LIMIT 1";
            PreparedStatement statement = Conexion.getConexion().prepareStatement(consulta);
            statement.setString(1, id);;

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                rpeso = resultado.getDouble("peso");
                rimc = resultado.getDouble("imc");
                rgrasa = resultado.getDouble("porcentajedegrasa");
                rmusculo = resultado.getDouble("porcentajedemusculo");
                rcalorias = resultado.getDouble("calorias");
                redad = resultado.getDouble("edad");
                rviceral = resultado.getDouble("grasaviceral");
            }
        } catch (Exception e) {
            System.out.println("Excepcion en metodo getCambiosCorporales en la clase expediente2 " + e.getMessage());
        }
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

    }

    public void actualizarTablaClientes(String telefonoTra, String direccion, String mejorHoraParaLlamar,
            String telefonoCasa, String celular, String edad, String pesoIdeal, Boolean subir,
            Boolean mantener, Boolean bajar, String id) {
        try {
            String sql = "update cliente set TelefonoTrabajo = ?, Direccion = ?, MejorHoraParaLlamar = ?,"
                    + " TelefonoCasa = ? , Celular = ? , Edad = ? , PesoIdeal = ? , PesoQuiereSubir = ?, PesoQuiereMantener = ?, PesoQuiereBajar = ? "
                    + " where idCliente = ?";

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setString(1, telefonoTra);
            consulta.setString(2, direccion);
            consulta.setString(3, mejorHoraParaLlamar);
            consulta.setString(4, telefonoCasa);
            consulta.setString(5, celular);
            consulta.setString(6, edad);
            consulta.setString(7, pesoIdeal);
            consulta.setBoolean(8, subir);
            consulta.setBoolean(9, mantener);
            consulta.setBoolean(10, bajar);
            consulta.setString(11, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println("error en Modificar Cliente" + e.getMessage());
        }

    }

    public void actualizarProblemasDeSalud(
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
            String sql = "update  problemasdesalud set Gastritis = ?, Colitis= ?, Estreñimiento= ?, Ulcera= ?, Cansancio= ?, Diabetes= ?, PresionAlta= ?,"
                    + " Colesterol= ?, Alergias= ?,Estres= ?, Dolordecabeza= ?, Dolordecuello= ?, Doloresdeespalda= ?, Artritis= ?, Ansiedad= ?, EmbarazoLactancia= ?,"
                    + " Retenciondeliquidos= ?, Malacirculacion= ?, Calambres= ?, Varices= ?, Doloresdehueso= ?, anemia = ?, ProblemadeVesicula= ?, Problemaderiñon= ?, Celulitis= ?"
                    + " where id_cliente = ?";

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(sql);
            consulta.setBoolean(1, gastritis);
            consulta.setBoolean(2, colitis);
            consulta.setBoolean(3, estreñimiento);
            consulta.setBoolean(4, ulcera);
            consulta.setBoolean(5, cansancio);
            consulta.setBoolean(6, diabetes);
            consulta.setBoolean(7, presionAlta);
            consulta.setBoolean(8, colesterol);
            consulta.setBoolean(9, alergias);
            consulta.setBoolean(10, estres);
            consulta.setBoolean(11, dolordecabeza);
            consulta.setBoolean(12, dolordecuello);
            consulta.setBoolean(13, doloresdeespalda);
            consulta.setBoolean(14, artritis);
            consulta.setBoolean(15, ansiedad);
            consulta.setBoolean(16, embarazo);
            consulta.setBoolean(17, retencionliquidos);
            consulta.setBoolean(18, malacirculacion);
            consulta.setBoolean(29, calambres);
            consulta.setBoolean(20, varices);
            consulta.setBoolean(21, doloresdehueso);
            consulta.setBoolean(22, anemia);
            consulta.setBoolean(23, problemadevesicula);
            consulta.setBoolean(24, problemaderiñon);
            consulta.setBoolean(25, celulitis);
            consulta.setString(26, id);
            consulta.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
