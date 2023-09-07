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

Para implementar la solución a esta problemática, en primer lugar, utilizaremos el mismo proyecto
creado en la sección anterior “universidadEjemplo” y vamos a aplicar el patrón MVC (Modelo-
Vista- Controlador) en dónde agruparemos las clases que vamos a utilizar en paquetes de acuerdo
a su responsabilidad (tarea), es decir, por un lado las clases que van a representar a nuestro modelo
de datos, por otro, las clases que van a actuar como intermediarias entre el Modelo y la Vista,
gestionando el flujo de información entre ellos y las transformaciones para adaptar los datos a las
necesidades de cada uno y por último, las clases que representarán las interfaz gráfica a través de
las cuales los usuarios interactuaran con nuestra aplicación como: menús, formularios, entre otros.

## Estructura del Proyecto:

Ilustración 2 “Estructura de proyecto java”

Dentro del paquete principal de nuestro proyecto, crearemos 3(tres) paquetes de nombre:

-entidades
-accesoADatos
-vistas

Como se muestra en la “ilustración 2”.


