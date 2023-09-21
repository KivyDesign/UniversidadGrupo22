package UniversidadGrupo22.accesoADatos;

import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    // Creo el atributo (con) de tipo Connection y  lo inicializo a null para
    // poder verificar si se pudo o no conectar a la DB
    private Connection con = null;

    // Creo los atributos aluData y matData para acceder mas comodamente a
    // los metodos de los paquetes entidades AlumnoData y MateriaData
    private AlumnoData aluData = new AlumnoData();
    private MateriaData matData = new MateriaData();

    // Aqui inicializo Connection en el constructor
    public InscripcionData() {
        // Creo el objeto (con) que hereda de la Clase Conexion.java y es el que
        // realiza toda la magia de la conexión
        this.con = Conexion.getConexion();
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void guardarInscripcion(Inscripcion insc)
    // /////////////////////////////////////////////////////////////////////////
    public void guardarInscripcion(Inscripcion ins) {
        // Preparo la consulta SQL para ser enviada cuando la necesite a la DB
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";

        // Englobo todo el codigo por si ocurren errores en la conexion
        try {
            // Obtengo la clave del ID generada de la posicion 0 del DB
            // Esto es necesario por que aún no existe el ID que se crea en la DB
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Cargo idAlumno, idMateria y nota de las posiciones 1, 2 y 3 respectivamente
            // El objeto ins es el que trae los aributos de tipo Nota, Alumno y Materia
            // A los atributos los seteo al tipo de dato que corresponde para cada caso
            // el ORDEN de los artibutos es MUY IMPORTANTE, deben coincidir con
            // el orden en la tabla cuando se los pasemos con VALUES (?, ?, ?)
            // al ejecutar la consulta SQL
            ps.setDouble(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());

            // Ejecuto el INSERT y almaceno la consulta en la DB
            ps.executeUpdate();

            // Obtengo la lista de claves con el ID de la clave primaria que SQL
            // genero, y actualizo el rs
            ResultSet rs = ps.getGeneratedKeys();

            // Verifico que exista el ID que insertamos para saber si se genero
            // al menos una clave
            if (rs.next()) {
                // Actualizo el ID de la inscripcion desde la única columna
                // que tiene el rs
                ins.setIdInscripcion(rs.getInt(1));

                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
                JOptionPane.showMessageDialog(null, "Inscripción agregada de forma exitosa");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
        }

        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void actualizarNota(int idAlumno, int idMateria, double nota)
    // /////////////////////////////////////////////////////////////////////////
    public void actualizarNota(double nota, int idAlumno, int idMateria) {
        // Preparo la consulta SQL para ser enviada cuando la necesite a la DB
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Cargo nota, idAlumno y idMateria de las posiciones 1, 2 y 3 respectivamente
            // El objeto ins es el que trae los aributos de tipo Nota, Alumno y Materia
            // A los atributos los seteo al tipo de dato que corresponde para cada caso
            // el ORDEN de los artibutos es MUY IMPORTANTE, deben coincidir con
            // el orden en la tabla cuando se los pasemos con VALUES (?, ?, ?)
            // al ejecutar la consulta SQL
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            // Ejecuto el UPDATE y almaceno la consulta en la DB
            int rs = ps.executeUpdate();

            // Como la consulta es un executeUpdate que devuelve un entero,
            // entonces solo hay que verificar si es mayor a 0, de otra forma
            // algo no esta funcionando bien
            if (rs > 0) {
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido encontrar el alumno para actulizar la nota");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }

        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria)
    // /////////////////////////////////////////////////////////////////////////
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        // Este metodo recibe los IDs de alumno y materia, debera encontrarlos
        // en la tabla para borrar la inscripcion correcta

        // Preparo la consulta a la DB
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno y el ID de la materia
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            // Ejecuto la consulta
            int rs = ps.executeUpdate();

            // Como la consulta es un executeUpdate que devuelve un entero,
            // entonces solo hay que verificar si es mayor a 0, de otra forma
            // algo no esta funcionando bien
            if (rs > 0) {
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
                JOptionPane.showMessageDialog(null, "Inscripción borrada");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripción no se pudo encontrar");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }

        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerInscripciones()
    // /////////////////////////////////////////////////////////////////////////
    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        // Preparo la consulta a la DB, se seleccionan todas por que el borrado
        // es fisico, ergo todas las inscipciones son activas
        String sql = "SELECT * FROM inscripcion";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorremos el ResultSet mientras el mismo tenga elementos y 
            // recuperamos los datos de las inscripciones
            while (rs.next()) {
                // Creo una inscripcion en el objeto ins utilizando el
                // constructor vacio Inscripcion()
                Inscripcion ins = new Inscripcion();

                // Recupero una inscripcion en el objeto ins que obtengo del rs
                ins.setIdInscripcion(rs.getInt("idInscripcion"));

                // Recupero un alumno en el objeto alu que obtengo del rs
                // utilizando aluData para poder acceder a su metodo buscarAlumno
                // que espera un id del tipo int
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));

                // Recupero un materia en el objeto mat que obtengo del rs
                // utilizando matData para poder acceder a su metodo buscarMateria
                // que espera un id del tipo int
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));

                // Ahora seteo los datos que procese a inscripcion (ins)
                ins.setAlumno(alu);
                ins.setMateria(mat);

                // La nota esta en rs y es de tipo double y se encuentra en la
                // columna nota de la tabla inscripcion
                ins.setNota(rs.getDouble("nota"));

                // Una ves armada la inscripcion (ins). Por cada una de las
                // inscripciones debemos agregarla a la lista de cursadas que
                // es una ArrayList utilizando el metodo add propio del ArrayList
                cursadas.add(ins);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista de cursadas que obtuve
        return cursadas;

        // ---------------------------------------------------------------------
//        // Preparo la consulta a la DB
//        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
//
//        // Declaro a (i) y lo inicializo a null por las dudas
//        Inscripcion i = null;
//
//        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
//        try {
//            // Preparo la consulta
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            // Para obtener el ID del alumno y el ID de la materia
//            ps.setInt(1, idAlumno);
//            ps.setInt(2, idMateria);
//
//            // Ejecuto la consulta
//            ResultSet rs = ps.executeQuery();
//
//            // Como la consulta es un executeQuery que devuelve un objeto,
//            // entonces solo hay que procesarlo, de otra forma (i) se quedaria
//            // null y algo no estaria funcionando bien, para eso recorro el
//            // ResultSet (rs)
//            while (rs.next()) {
//                // Creo el famoso objeto (i)
//                i = new Inscripcion();
//
//                // Le agrego la ID de la inscripcion
//                i.setIdInscripcion(rs.getInt("idInscripcion"));
//
//                // Aqui buscamos el Alumno por su ID
//                Alumno a = aluData.buscarAlumno(idAlumno);
//
//                // Se lo cargo al objeto (i)
//                i.setAlumno(a);
//
//                // Realizo la misma operacion para materia y nota
//                Materia m = matData.buscarMateria(idMateria);
//                i.setMateria(m);
//                i.setNota(rs.getDouble("nota"));
//            }
//
//            // Cierro la consulta
//            ps.close();
//        } catch (SQLException ex) {
//            // En caso de que explote la consulta se lo informo al pobre
//            // y desafortunado DataEntry
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
//        }
//
//        // Si todo salio bien, entonces retorno la inscripcion que obtuve
//        return i;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerInscripcionesPorAlumno(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> cursadasPorAlumno = new ArrayList<>();

        // Preparo la consulta a la DB, se seleccionan todas por que el borrado
        // es fisico, ergo todas las inscipciones son activas
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Seteo el parametro que corresponde al int idAlumno que requiere
            // la consulta a traves del ps para filtrarlo por ID
            ps.setInt(1, idAlumno);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorremos el ResultSet mientras el mismo tenga elementos y 
            // recuperamos los datos de las inscripciones
            while (rs.next()) {
                // Creo una inscripcion en el objeto ins utilizando el
                // constructor vacio Inscripcion()
                Inscripcion ins = new Inscripcion();

                // Recupero una inscripcion en el objeto ins que obtengo del rs
                ins.setIdInscripcion(rs.getInt("idInscripcion"));

                // Recupero un alumno en el objeto alu que obtengo del rs
                // utilizando aluData para poder acceder a su metodo buscarAlumno
                // que espera un id del tipo int
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));

                // Recupero un materia en el objeto mat que obtengo del rs
                // utilizando matData para poder acceder a su metodo buscarMateria
                // que espera un id del tipo int
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));

                // Ahora seteo los datos que procese a inscripcion (ins)
                ins.setAlumno(alu);
                ins.setMateria(mat);

                // La nota esta en rs y es de tipo double y se encuentra en la
                // columna nota de la tabla inscripcion
                ins.setNota(rs.getDouble("nota"));

                // Una ves armada la inscripcion (ins). Por cada una de las
                // inscripciones debemos agregarla a la lista de cursadas que
                // es una ArrayList utilizando el metodo add propio del ArrayList
                cursadasPorAlumno.add(ins);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista de cursadas que obtuve
        return cursadasPorAlumno;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, alumno.getIdAlumno());

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                mat = new Materia();

                // Le cargo los valores que necesito
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto matData hereda de Materia
                listaDeMateriasInscripto.add(matData.buscarMateria(rs.getInt("idMateria")));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // posea la tabla materia en la DB universidadulp
        return listaDeMateriasInscripto;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriasCursadas(int idAlumno) {
//    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<>();

        // Preparo la consulta a la DB. Solamente en las materias en las que
        // el Alumno esta insripto
//        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        // Al ser un producto cartesiano se filtra en el WHERE para que
        // solo queden los que posean un ID igual
//        SELECT inscripcion.idMateria, inscripcion.nota, nombre, anio
//        FROM inscripcion, materia
//        WHERE inscripcion.idMateria = materia.idMateria 
//        AND inscripcion.idAlumno = 3;
        //String sql = "SELECT inscripcion.idMateria, inscripcion.nota, materia.nombre, materia.anio FROM inscripcion, materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?";
        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            String sql = "SELECT i.idMateria, i.nota, m.nombre, m.anio FROM inscripcion AS i JOIN materia AS m ON (i.idMateria = m.idMateria) WHERE i.idAlumno = ?";

            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, idAlumno);
            System.out.println("ID: " + idAlumno);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();
            System.out.println("paso algo por aca");

            // Recorro el rs mientras tenga elementos
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                Materia materia = new Materia();

                // Le cargo los valores que necesito
                materia.setIdMateria(rs.getInt("idMateria"));
                System.out.println("IdMateria: " + rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setActivo(true);

                // Agrego la materia al array materia
                listaDeMateriasInscripto.add(materia);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // posea la tabla materia en la DB universidadulp
        return listaDeMateriasInscripto;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasNOCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriaNoInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasNoInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, alumno.getIdAlumno());

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                mat = new Materia();

                // Le cargo los valores que necesito
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
//                listaDeMateriasNoInscripto.add(mat.obtenerMateriaPorId(rs.getInt("idMateria")));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // no posea la tabla materia en la DB universidadulp
        return listaDeMateriasNoInscripto;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasNOCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        // Creo una lista listaDeMateriasInscriptos para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasNoInscriptos = new ArrayList<Materia>();

        // Preparo la consulta a la DB utilizando una subconsulta a inscripcion
        // para que busque todos los ID idMateria en las que NO esta inscripto
        // un alumno utilizando NOT IN para no incluirlos
        String sql = "SELECT * FROM materia"
                + "WHERE estado = 1"
                + "AND idMateria"
                + "NOT IN"
                + "(SELECT idMateria"
                + "FROM inscripcion"
                + "WHERE idAlumno = ?);";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, idAlumno);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                Materia materia = new Materia();

                // Le cargo los valores que necesito
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));

                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaDeMateriasNoInscriptos.add(materia);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // no posea la tabla materia en la DB universidadulp
        return listaDeMateriasNoInscriptos;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Alumno> obtenerAlumnoXMateria(int idMateria)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Alumno> obtenerAlumnoXMateria(Materia materia) {
        ArrayList<Alumno> listaAlumnoXMateria = new ArrayList<Alumno>();
        Alumno alu;
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alu = new Alumno();
                alu.setNombre(rs.getString("nombre"));
                alu.setApellido(rs.getString("apellido"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno o materia: " + ex.getMessage());
        }
        return listaAlumnoXMateria;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Alumno> obtenerAlumnosXMateria(int idMateria)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> listaAlumnosXMateria = new ArrayList<>();

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Consulta para filtrar alumnos que esten inscriptos en una determinada
            // materia
            // La consulta SQL funciona
            // SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado
            // FROM inscripcion i, alumno a
            // WHERE i.idAlumno = a.idAlumno
            // AND idMateria = 3
            // AND a.estado = 1
//            String sql = "SELECT i.idMateria, i.nota, m.nombre, m.anio"
//                    + "FROM inscripcion AS i"
//                    + "JOIN materia AS m ON (i.idMateria = m.idMateria) AND i.idAlumno = ?";
            String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado FROM inscripcion i JOIN alumno a ON (i.idAlumno = a.idAlumno) where idMateria = ? AND a.estado = 1";
                    
                   
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del materia
            ps.setInt(1, idMateria);
            System.out.println("ID: " + idMateria);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();
            System.out.println("Paso algo por AQUÍ >>> SQL");

            // Recorro el rs mientras tenga filas para recorrer
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                Alumno alumno = new Alumno();

                // Le cargo los valores que necesito
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                // Los agrego a los valores al ArrayList utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaAlumnosXMateria.add(alumno);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a una de las tabla: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // no posea la tabla materia en la DB universidadulp
        return listaAlumnosXMateria;
    }
        public List<Alumno> obtenerAlumnosPorMateriaEnzo(int idMateria) {
    List<Alumno> listaAlumnosPorMateria = new ArrayList<>();

    String sql = "SELECT a.idAlumno, a.dni, a.nombre, a.apellido, a.fechaNacimiento, a.estado "
            + "FROM inscripcion i, alumno a "
            + "WHERE i.idAlumno = a.idAlumno "
            + "AND i.idMateria = ? "
            + "AND a.estado = 1";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idMateria);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                listaAlumnosPorMateria.add(alumno);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a una de las tablas: " + ex.getMessage());
    }

    return listaAlumnosPorMateria;
}

}

