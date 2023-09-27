![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/00.jpg)

# Desarrollo de aplicaciones JAVA

## Guía V - “Proyecto Transversal: Gestión Universidad”

# Vistas del Form principal Menú y los InternalFrames

Vistas finales de las pantallas que componen todo el Proyecto Transversal de Integración realizado durante la Etapa 5, desarrollado completamente por el Grupo 22

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/20.png)

<p align="center">Pantalla de Bienvenida</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/21.png)

<p align="center">Formulario de Alumnos</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/22.png)

<p align="center">Formulario de Materias</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/23.png)

<p align="center">Formulario de Inscripciones</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/24.png)

<p align="center">Modificación de Notas por Alumno y  Materia</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/25.png)

<p align="center">Listado de Alumnos por Materia</p>

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/26.png)

<p align="center">Pantalla de agradecimiento por todo el esfuerzo y la buena predisposición de los integrantes del equipo para salir adelante y completar el Proyecto Transversal de Integración. Gracias !TOTALES¡</p>

## UniversidadGrupo22

En la guía anterior, aprendimos cómo establecer una conexión desde una aplicación Java hacia una base de datos relacional utilizando el framework JDBC, y realizar operaciones sobre ella.
Ahora, en esta nueva guía, daremos un paso más allá al explorar las mejores prácticas de la programación orientada a objetos para estructurar nuestro proyecto. Construiremos una aplicación completa en la cual el usuario interactuará a través de una interfaz gráfica, brindándole una experiencia más intuitiva y amigable.
Es importante que repartan las tareas entre los miembros del equipo, de tal forma que: uno crea repositorio en GitHub, agrega a sus compañeros como colaboradores y luego los demás clonan, y cada uno hace una de las clases que forman parte del proyecto y suben al repositorio los cambios.

## Sistema de gestión para la Universidad de La Punta:

La Universidad de La Punta cree necesario utilizar un sistema para poder llevar el registro de los alumnos de la institución y las materias que se dictan en la misma. Adicionalmente se necesita poder registrar las materias que cursa cada alumno. El sistema debe permitir cargar la calificación obtenida (nota) cuando un alumno rinde un examen final. Para cada materia que cursa un alumno solo se registrará la última calificación obtenida, o sea no se mantiene registro de las notas obtenidas anteriormente, por lo que, si un alumno rinde el examen final de una materia y obtiene una calificación de “2”, y luego rinde nuevamente el examen para la materia y obtiene una calificación de “9” solo quedará registro de esta última.

## Funcionalidad: el sistema deberá

1. Permitir al personal administrativo listar las materias que cursa un alumno.
2. Permitir al personal administrativo listar los alumnos inscriptos en una determinada materia.
3. Permitir que un alumno se pueda inscribir o des-inscribir en las materias que desee.
4. Permitir registrar la calificación final de una materia que está cursando un alumno.
5. Permitir el alta, baja y modificación de los alumnos y las materias.

## Modelo de BD sugerido.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/01.jpg)

<p align="center">Ilustración 1 Modelo Relacional Universidad</p>

## DESARROLLO

Para implementar la solución a esta problemática, en primer lugar, utilizaremos el mismo proyecto creado en la sección anterior “universidadEjemplo” y vamos a aplicar el patrón MVC (Modelo-Vista-Controlador) en dónde agruparemos las clases que vamos a utilizar en paquetes de acuerdo a su responsabilidad (tarea), es decir, por un lado las clases que van a representar a nuestro modelo de datos, por otro, las clases que van a actuar como intermediarias entre el Modelo y la Vista, gestionando el flujo de información entre ellos y las transformaciones para adaptar los datos a las necesidades de cada uno y por último, las clases que representarán las interfaz gráfica a través de las cuales los usuarios interactuaran con nuestra aplicación como: menús, formularios, entre otros.

## Estructura del Proyecto:

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/02.jpg)

<p align="center">Ilustración 2 “Estructura de proyecto java”</p>

Dentro del paquete principal de nuestro proyecto, crearemos 3(tres) paquetes de nombre:

-entidades
-accesoADatos
-vistas

Como se muestra en la “ilustración 2”.

## CLASES ENTIDAD:

Para que desde el lenguaje de programación Java se pueda tratar cada registro o fila de las tablas como un objeto Java, se debe crear una clase asociada a cada tabla de la base de datos y las relaciones entre ellas. A ese tipo de clases se las conoce como Clases Entidad (Entity Classes).

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/03.jpg)

<p align="center">Ilustración 3 Clases entidades</p>

Como se puede observar en el diagrama UML cada clase entidad tiene los mismos atributos que las tablas de la base de datos, y 3 constructores: uno vacío, uno con todos los atributos incluido el id y otro con todos los atributos sin incluir el id; otros miembros adicionales de las clases serán los métodos getter y setter; además de las relaciones entre ellas plasmadas como asociaciones, es decir, la tabla Inscripción tendrá un atributo de tipo Materia y otro de tipo Alumno; lo que en la base de datos eran claves foráneas, aquí son asociaciones.

## ESTABLECIENDO LA CONEXIÓN A LA BASE DE DATOS:

Dentro de nuestro proyecto crearemos una clase especial que será no sólo la responsable de cargar los drivers de conexión al gestor de base de datos MySQL, sino también la de establecer la conexión a la base de datos que vamos a utilizar; empleando las clases vistas en la guía anterior.
Se muestra a continuación el código de la clase “Conexión.java” y la explicación.

```java
package UniversidadGrupo22.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class miConexion {

    private String url;
    private String usuario;
    private String password;
    private static Connection conexion = null;

    public miConexion(String url, String usario, String Password) {
        this.url = url;
        this.usuario = usario;
        this.password = password;
    }

    public Connection buscarConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse" + ex.getMessage());
            }
        }
        return conexion;
    }
}
```

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/04.jpg)

Como se ve en la imagen, desde la línea 15 hasta las 18, están declaradas una serie de constantes de tipo String con información que utilizaremos para la conexión.

En la constante URL la cadena establece que utilizaremos un conexión utilizando jdbc a una base de datos MySql y que se encuentra disponible en la misma PC (localhost); si la base de datos se encontrara en otro host, reemplazaríamos localhost por el ip o nombre del equipo en dónde se encuentra.

La constante DB contiene el nombre de la base de datos a la que vamos a querer acceder.

Cuando instalamos XAMPP, al agregarnos el gestor MYSQL, establece una configuración por defecto, en donde el usuario de acceso a la base de datos es “root” sin contraseña. Eso es lo que está definido en las constantes USUARIO y PASSWORD.

En la línea 20, la constante “connection” representará a un objeto de tipo Connection a través del cual podremos enviar nuestras peticiones a la Base de Datos.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/05.jpg)

La Clase Conexion, tiene un único constructor, pero es privado, como se observa en la línea 25.
La consecuencia de tener un único constructor y encima privado, es que no nos permitirá crear instancias de la clase Conexion. Esto nos posibilitará como lo van a ver más adelante en el código, tener un único objeto Connection activo durante la ejecución de nuestra aplicación.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/06.jpg)

La Clase Conexión tiene un único método público encargado de retornar un objeto de tipo Connection, este método tiene que ser static para que pueda ser invocado desde afuera de la clase sin necesitad crear una instancia de la misma, ya que no podríamos por el hecho de que tiene un único constructor privado.

En la línea 30 verifica si el atributo static “connection” es nulo, si es así significa que nadie ha llamado este método desde la aplicación para establecer una conexión a la base de datos (recordemos que el objetivo es mantener un único objeto Connection activo durante el ciclo de vida de nuestra aplicación)

En la línea 32 se cargan los driver de conexión al gestor de base de datos; previamente tuvimos que incorporar a nuestro proyecto las librerías de MariaDB o MYSQL como se explicó en la guía anterior. La invocación Class.forName() podría lanzar la ClassNotFoundException si no cargamos previamente dicha librería.

En la línea 34 se establece la conexión a la base de datos invocando al método getConnection() de la clase DriverManager pasando por parámetro un String que contiene la URL de la base de datos, PASSWORD y CONTRASEÑA como se indica a continuación.

```java
DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);
```

El método getConnection() puede lanzar la SQLException si la cadena que le pasamos como parámetro es incorrecta, por ejemplo el nombre de la base de datos no existe; excepción que capturamos en la línea 38, que de producirse se informará a través de un diálogo al usuario.

Al finalizar, en la línea 45, retornamos el objeto Connection.

Quiero aclarar, que la forma en como está implementada la clase Conexión es una sugerencia, cada uno de ustedes puede optar por su propia implementación; sólo deberán tener en cuenta que para poder establecer una conexión a la base de datos, primero se deben cargar los driver y luego establecer la conexión a través de la invocación del método getConnection().

## CLASES DE ACCESO A DATOS:

Estas clases se encargan de la persistencia de los datos y su acceso. En este proyecto utilizando tecnología JDBC (Java Database Connectivity) para interactuar con la base de datos. Proporcionan métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
Estas clases son: ‘AlumnoData’, ‘MateriaData’ e ‘InscripcionData’ y podríamos incluir aquí también una clase adicional que se encargue de cargar los driver y conexión a la base de datos.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/07.jpg)

A continuación detallaremos la implementación de AlumnoData para que en base a este ejemplo usted pueda implementar MateriaData y CursadaData; obviamente con ayuda de sus compañeros de equipo, los videos de soporte y aporte de su docente tutor.
Como mencionamos anteriormente, estas clases se van encargar tanto de la persistencia de datos como del acceso a los mismos; por lo tanto, en sus métodos valiéndonos de una Connection vamos a generar los PreparedStatement con las sentencias SQL que vamos a necesitar enviar al gestor de Bases de Datos.

# Implementación sugerida para AlumnoData

```java
package universidadejemplo.AccesoADatos;

import universidadejemplo.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            // localDate a Date
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            // if reducido
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno =  ? AND  estado = 1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumno;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
    }

    public void eliminarAlumno(int id) {
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }
}
```

## CLASE DE ACCESO A DATOS DE INSCRIPCIONES
(InscripcionData)

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/08.jpg)

Esta clase además de poseer los métodos que permitirán hacer un CRUD sobre la tabla Inscripcion, tiene métodos que permiten hacer operaciones un poco más complejas como el método “obtenerMateriasCursadas”, que recibiendo el id del alumno, nos retornará las materias en las que este está inscripto. La elección de mostrar en detalle la implementación de este método en particular es la suposición de que explicando cómo está construido, usted será capaz de implementar el resto de los métodos de la clase InscripcionData, con ayuda de este material escrito, los videos, debate entre los compañeros de equipo y por supuesto la colaboración de su tutor de clase.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/09.jpg)

Como podemos observar en la declaración del método en la línea 114, recibe como parámetro el id de un alumno y retornará una lista de las materias en las que está inscripto (List<Materia>). Por lo tanto, en la línea 115 creamos una lista vacía de materias que luego iremos llenando.

La sentencia que enviaremos a la base de datos será un SELECT en el que solicitaremos los datos de las materias en las que está inscripto el alumno cuyo id recibimos por parámetro; como puede usted observar en la línea 118.

```java
String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripción JOIN materia ON(inscripción.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ?";
```

```sql
SELECT inscripción.idMateria, nombre, anio
```

En la cláusula SELECT indicamos que vamos a proyectar los campos de la tabla Materia: idMateria, nombre y año; como en la cláusula FROM vamos a reunir dos tablas: INSCRIPCION y MATERIA tendríamos un inconveniente con aquellos campos que tenga el mismo nombre, como ocurre con idMateria, que figura tanto en la tabla INSCIPCION como MATERIA; por lo tanto en el SELECT nos vemos obligados para evitar un error de ambigüedad de nombre cualificar el campo idMateria con alguna de las tablas, en este caso elegía INSCRIPCION, es por ello que figura en el SELECT como inscripción.idMateria, aunque también podría haberlo escrito materia.idMateria.

```sql
FROM inscripción JOIN materia ON (inscripción.idMateria=materia.idMateria)
```

Para poder proyectar en la cláusula SELECT los datos de las materias, pero sólo de aquellas en las que está inscripto un determinado alumno, y sabemos que en la tabla inscripción solo tenemos el id del alumno y el id de la materia en el que éste está inscripto, por lo tanto si necesito completar la información con el resto de los datos de la materia que se corresponden con ese id, debo reunir (JOIN) las tablas INSCRIPCION y MATERIA, a través de clave primaria de Materia con la clave foránea idMateria en Inscripcion; es lo que indicamos en la cláusula ON(inscripción.idMateria=materia.idMateri).

```sql
WHERE inscripción.idAlumno = ?
```

En la cláusula Where colocaremos como condición de filtrado que solo queremos las filas en las que el idAlumno de la tabla Inscripcion sea un dato que reemplazaremos dinámicamente (?).

Ahora, para poder enviar esta sentencia a la base de datos, creamos un objeto del tipo PreparedStatement utilizando el objeto Connection (referenciado con la variable atributo con).

```java
PreparedStatement ps = con.prepareStatement(sql);
```

Como la sentencia que pretendemos enviar, tiene un parámetro dinámico (?) después de la cláusula Where, que representa el valor entero del id de un alumno, lo setearemos de la siguiente forma.

```java
ps.setInt(1, id);
```

Indicando al objeto PreparedStatement referenciado por la variable ps, a través del método setInt que el primer y único parámetro dinámico que tenemos en la sentencia sql, es un entero y que vamos a reemplazar ese signo ? por el id del alumno guardado en la variable entera id.

Una vez seteado el parámetro dinámico, enviaremos la sentencia a la base de datos utilizando el método executeQuery que nos devolverá un ResultSet que contendrá las Materias en las que el alumno está inscripto. En la guía anterior se explicó que representa un ResultSet, si no lo recuerda puede volver a leer dicha explicación.

```java
ResultSet rs = ps.executeQuery();
```

## VISTAS SUGERIDAS:

Menú Principal: Construido con un JFrame, JMenuBar, JMenu y JDesktopPane dentro del cual se visualizaran las JInternalFrame que corresponda a cada vista elegida por el usuario.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/10.jpg)

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/11.jpg)

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/12.jpg)

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/13.jpg)

A continuación se detallan cada una de las vistas y la clase de acceso a datos vinculada a dicha vista.

## Gestión de Alumnos

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/14.jpg)

## Gestión de Materias:

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/15.jpg)

## Inscripciones:

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/16.jpg)

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/17.jpg)

## Actualización de notas:

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/18.jpg)

## Consulta de Alumnos por materia.

![image](https://github.com/KivyDesign/UniversidadGrupo22/blob/main/IMGs/19.jpg)

# Miembros del Equipo 22

<p align="center">© 2023 Creative Guido, all rights reserved. Made with ❤️ for a better web.</p>
<p align="center">@https://github.com/germanesalvatierra</p>
<p align="center">@https://github.com/KivyDesign</p>
<p align="center">@https://github.com/arielMilton</p>

