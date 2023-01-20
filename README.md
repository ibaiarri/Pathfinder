Resumen del proyecto


La idea es crear un programa para gestión de personajes en juegos de rol, en este programa se guardaran los personajes de cada jugador, para que tengan un acceso más rápido y sencillo que las tradicionales hojas.



La pagina web seria , lista todos los personajes y habrá un login y depende que tipo de usuario sea
te renvía al back o al Front. 

BACK = **administrador será el único que puede borrar  personajes y reinsértalos.**

Front = **los usuarios crear personajes , listar  sus  personajes , modificar su personaje y eliminar sus personajes.**

# TAG 0.1

Imagen de la informacion de la base de datos

	

Instalación 
Rápida 




Creación de la workspace

Comenzamos desde el explorador de archivos donde en ruta deseada crearemos nuestra workSpace totalmente Vacío. En nuestro caso lo pondremos en la siguiente ruta.
C:\Users\ik_jav\Desktop\Pathfinder

	

Después nos dirigiremos hacia nuestro repositorio Git y copiaremos la URL.  
https://github.com/ibaiarri/Pathfinder.git


Importar Los Proyectos 

Abrimos nuestra IDE eclipse   y  procederemos a importar los proyectos de nuestro repositorio GitHub  de la siguiente manera 
File/Import/Git/proyectFrom Git(Smart Import).
Añadimos la URL previamente  copiada en la nuestro repositorio de git y a continuación autenticamos nuestro usuario y password de git (Nota: es necesario tener una cuenta en git para importar el proyecto).


 Añadimos la ruta local donde tendremos nuestra workspace. Y al darle siguiente podremos verificar en la siguiente pestaña todos los proyectos que utilizamos para poder desplegar correctamente.

Finalmente podemos verificar en nuestro ide eclipse el cómo se nos han generado los diferentes proyecto dentro de nuestro workspace. Tal y como está nuestra aplicación en este momento ya podemos utilizar y probar el modelo de nuestra Aplicación.

En cambio para el resto de proyectos tendremos que agregar una  biblioteca del modelo. (Se explica detenidamente a Continuación con las particularidades  de cada uno de los proyectos)


IMPORTAR NUESTRA SCRIPT DE BASE DE DATOS

La base de datos ya tiene por defecto varias filas insertadas las cuales serán necesarias para el correcto funcionamiento de nuestra Aplicación. Para ello será necesario importar desde el principio nuestro script.( Nota: Script  facilitado  desde nuestra entrega).


Vamos a nuestra base de datos en nuestro caso Xampp. Creamos una base de datos  y  dentro de la base de datos vamos a la pestaña de importar y en la primera opción  insertamos el script y ejecutar

IMPORTAR EL MODELO EN EL REST

El primer proyecto que vamos a desplegar sería nuestro servicio RestFul. Para que nuestro restful pueda hacer correctamente las peticiones vamos a necesitar importar por maven nuestro modelo de la siguiente manera.


Vamos a nuestro modelos y con clic derecho le damos a runAS/6-mavenInstall.
Lo que nos genera un Jar de nuestro modelo y lo implementaremos en el nuestro proyecto rest como una librería.Jar.

El jar está en la siguiente ruta de nuestro equipo. 

C:\Users\ik_jav\.m2\repository\com\txurdi\pathfinder\modelo\0.0.1-SNAPSHOT

Después vamos a nuestro Rest Y clic Derecho/build Path/add External Jar

Finalmente podemos probar que nuestro Rest funciona yendo a nuestro navegador favorito  y probando   una de las listas.

localhost:8081/api/lis1

NOTA : Importante A la de poner la ruta acordaros que estamos utilizando el puerto 8081 y no el puerto 8080.

IMPORTAR EL MODELO EN EL WEBREST Y REST

El siguiente en  desplegar sería nuestro servicio webrest. Para que nuestro webrest pueda hacer correctamente las peticiones vamos a necesitar importar por maven nuestro modelo de la siguiente manera.

Vamos a nuestro proyecto  modelo  y  Rest con clic derecho le damos a runAS/6-mavenInstall.

Lo que nos genera un Jar de nuestro modelo y lo implementaremos en el nuestro proyecto rest como una librería.Jar.

El jar está en la siguiente ruta de nuestro equipo. 

Link Web Rest:
C:\Users\ik_jav\.m2\repository\com\txurdi\pathfinder\rest\0.0.1-SNAPSHOT
Link Web:
C:\Users\ik_jav\.m2\repository\com\txurdi\pathfinder\modelo\0.0.1-SNAPSHOT

Después vamos a nuestro Webrest Y clic Derecho/build Path/add External Jar

Hacemos una búsqueda en el marketplace para descargar las versiones de tomcat para la creación del servidor

Después crearemos un nuevo servidor tomcat en Eclipse, para ello vamos a la ventana server :


Hacemos clic derecho en la parte en blanco de la ventana y seleccionamos la opción new>server.

Una vez seleccionado el tomcat que deseemos, hacemos clic en finish.

Tras seleccionar la opción finish en la ventana nos debería de aparece un servidor tomcat de esta forma:

Ahora deberíamos añadir los proyectos con los que este servidor va a trabajar, en este caso son los proyectos web rest y web server, después clicamos en finish y quedarán agregados al servidor.

Lo único que nos restaría hacer es iniciar el servidor dando clic derecho sobre el tomcat y seleccionando la opción start.

 	NOTA : recordar que para que funcione la extracción de datos la base de datos debe de estar activa.



