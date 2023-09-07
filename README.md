# UniversidadGrupo22

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

Ilustración 1 Modelo Relacional Universidad

## DESARROLLO

Para implementar la solución a esta problemática, en primer lugar, utilizaremos el mismo proyecto creado en la sección anterior “universidadEjemplo” y vamos a aplicar el patrón MVC (Modelo-Vista-Controlador) en dónde agruparemos las clases que vamos a utilizar en paquetes de acuerdo a su responsabilidad (tarea), es decir, por un lado las clases que van a representar a nuestro modelo de datos, por otro, las clases que van a actuar como intermediarias entre el Modelo y la Vista, gestionando el flujo de información entre ellos y las transformaciones para adaptar los datos a las necesidades de cada uno y por último, las clases que representarán las interfaz gráfica a través de las cuales los usuarios interactuaran con nuestra aplicación como: menús, formularios, entre otros.

## Estructura del Proyecto:

Ilustración 2 “Estructura de proyecto java”

Dentro del paquete principal de nuestro proyecto, crearemos 3(tres) paquetes de nombre:

-entidades
-accesoADatos
-vistas

Como se muestra en la “ilustración 2”.

## CLASES ENTIDAD:

Para que desde el lenguaje de programación Java se pueda tratar cada registro o fila de las tablas como un objeto Java, se debe crear una clase asociada a cada tabla de la base de datos y las relaciones entre ellas. A ese tipo de clases se las conoce como Clases Entidad (Entity Classes).

Ilustración 3 Clases entidades

Como se puede observar en el diagrama UML cada clase entidad tiene los mismos atributos que las tablas de la base de datos, y 3 constructores: uno vacío, uno con todos los atributos incluido el id y otro con todos los atributos sin incluir el id; otros miembros adicionales de las clases serán los métodos getter y setter; además de las relaciones entre ellas plasmadas como asociaciones, es decir, la tabla Inscripción tendrá un atributo de tipo Materia y otro de tipo Alumno; lo que en la base de datos eran claves foráneas, aquí son asociaciones.

## ESTABLECIENDO LA CONEXIÓN A LA BASE DE DATOS:

Dentro de nuestro proyecto crearemos una clase especial que será no sólo la responsable de cargar los drivers de conexión al gestor de base de datos MySQL, sino también la de establecer la conexión a la base de datos que vamos a utilizar; empleando las clases vistas en la guía anterior.
Se muestra a continuación el código de la clase “Conexión.java” y la explicación.

<code>
</code>

Como se en la imagen, desde la línea 15 hasta las 18, están declaradas una serie de constantes de tipo String con información que utilizaremos para la conexión.

En la constante URL la cadena establece que utilizaremos un conexión utilizando jdbc a una base de datos MySql y que se encuentra disponible en la misma PC (localhost); si la base de datos se encontrara en otro host, reemplazaríamos localhost por el ip o nombre del equipo en dónde se encuentra.

La constante DB contiene el nombre de la base de datos a la que vamos a querer acceder.

Cuando instalamos XAMPP, al agregarnos el gestor MYSQL, establece una configuración por defecto, en donde el usuario de acceso a la base de datos es “root” sin contraseña. Eso es lo que está definido en las constantes USUARIO y PASSWORD.

En la línea 20, la constante “connection” representará a un objeto de tipo Connection a través del cual podremos enviar nuestras peticiones a la Base de Datos.

La Clase Conexion, tiene un único constructor, pero es privado, como se observa en la línea 25.
La consecuencia de tener un único constructor y encima privado, es que no nos permitirá crear instancias de la clase Conexion. Esto nos posibilitará como lo van a ver más adelante en el código, tener un único objeto Connection activo durante la ejecución de nuestra aplicación.


