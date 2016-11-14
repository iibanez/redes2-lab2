# Lab 2 de sistemas de comunicación

# Compilación
```sh
$ javac Main.java LeerArchivo.java Codificacion.java Decodificacion.java
```
# Ejecución
```sh
$ java Main
```

# Explicación del algoritmo

+ Se introduce la contraseña que es solicitada por el algoritmo la que debe ser mayor o igual a 8 caracteres.
+ Se ingresa el tamaño de los bloques el cual debe ser mayor o igual a 32 caracteres.
+ Se parte leyendo el archivo de texto y quedando con la función "get_subtexto()" la que nos permitirá extraer subcadenas del largo del bloque - 2, esto es debido a que los últimos 2 caracteres se utilizaran para añadir 2 caracteres en hexadecimal que nos indique el tamaño real de la sub cadena.

#### Ejemplo 1

```
    bloques           = 32 
	cadena            = hola como estas este es ejempl (30 caracteres)
	cadena completada = hola como estas este es ejempl1e (32 caracteres)
```
#### Ejemplo 2:
```
	bloques           = 32
	cadena            = hola como estas (15 caracteres)
```
La cadena será completada con caracteres aleatorios y añadido al final el valor real.
```
	cadena completada = hola como estashhkjshdkjhasdhs0f (32 caracteres)
```

+ El algoritmo de encriptación inicia duplicando la contraseña hasta que alcanza el tamaño de los bloques.

```
	bloques              = 32
	contraseña           = codificacion (12 caracteres)
	contraseña duplicada = codificacioncodificacioncodifica (32 caracteres)
```

+ Luego de que se posee la cadena de caracteres y la contraseña duplicada se realiza el producto entre sustitución y trasposición, igual al tamaño del bloque.

+ La sustitución se realiza con la clave duplicada y la cadena completa sumando ambos caracteres:
```
	contraseña duplicada = codificacioncodificacioncodifica
	cadena completada    = hola como estas este es ejempl1e
	cadena sustitución   = ËÞÐÊÌÒÎÒÔá×Ð×ËÜ×ÆÎâÈÙÉÖÖÕÆ
```

+ Por último la trasposición tiene un poco de complicaciones y se enseñara con una cadena de 35 caracteres para que se entienda en su totalidad, se debe tener presente que antes de cada trasposición se realizara un sustitución, pero en esta ocasión se omitirá para entender mejor el proceso.
	
Esto corresponde a la contraseña y cadena inicial
```
	contraseña duplicada  = codificacioncodificacioncodificacio
	cadena completada     = hola como estas este es un ejempl21
```

#### TRANSPOSICIÓN 1:

Se comienza considerando los 8 primeros caracteres de la cadena y obteniendo su valor numérico el que nos permite ordenar las columnas de manera posterior.

	contraseña            =  c    o    d    i    f    i    c    a  
	valor numérico        =  99   111  100  105  102  105  99   97

Se ordenan los primeros 32 caracteres del mensaje en una matriz, considerar que existen caracteres que pueden ser espacios.

	valor numérico        =  99   111  100  105  102  105  99   97
	matriz 				  =  h    o    l    a         c    o    m
							 o         e    s    t    a    s 
							 e    s    t    e         e    s 
							 u    n         e    j    e    m    p

Procediendo a ordenar las columnas de menor a mayor obteniendo el siguiente mensaje traspuesto leyendo las columnas de arriba hacia abajo, en caso de existir dos columnas con igual valor se considera el primero de izquierda a derecha. 

	mensaje transpuesto   = m  phoeuossmlet  t jaseecaeeo snl21

#### TRANSPOSICIÓN 2:

Para obtener la contraseña en la segunda trasposición se mueve un carácter hacia la derecha al igual que para obtener los 32 caracteres del mensaje.

	contraseña            =  o    d    i    f    i    c    a    c  
 	valor numérico        =  111  100  105  102  105  99   97   99
	matriz				  =            p    h    o    e    u    o
						     s    s    m    l    e    t          
						     t         j    a    s    e    e    c
						     a    e    e    o         s    n    l
	mensaje transpuesto   =  mu eneteso cl s ehlaopmjeoes  sta21

#### TRANSPOSICIÓN 3:

	contraseña            =  d    i    f    i    c    a    c    i  
 	valor numérico        =  100  105  102  105  99   97   99   105 
 	matriz				  =       e    n    e    t    e    s    o
						          c    l         s         e    h
						     l    a    o    p    m    j    e    o
						     e    s              s    t    a    2
	mensaje transpuesto   =  mue jttsmsseea  lenlo ecase p oho21

#### TRANSPOSICIÓN 4:

	contraseña            =  i    f    i    c    a    c    i    o    
 	valor numérico        =  105  102  105  99   97   99   105  111
 	matriz				  =       j    t    t    s    m    s    s
						     e    e    a              l    e    n
						     l    o         e    c    a    s    e
						          p         o    h    o    2    1
	mensaje transpuesto   =  mues cht eomlaojeop el ta  ses2sne1

#### TRANSPOSICIÓN 5:

	contraseña            =  f    i    c    a    c    i    o    n      
 	valor numérico        =  102  105  99   97   99   105  111  110
 	matriz				  =  m    u    e    s         c    h    t
						          e    o    m    l    a    o    j
						     e    o    p         e    l         t
						     a              s    e    s    2    s 
	mensaje transpuesto   =  sm seop  leem eaueo calstjtsho 2ne1

#### TRANSPOSICIÓN 6:

Se mostrará hasta esta transposición que nos muestra exactamente el punto cuando en el mensaje ya no se puede avanzar más hacia la derecha por lo que vuelve al inicio del mensaje y se cuentan 32 caracteres, esto es lo mismo que se realiza si es que en la contraseña no se puede avanzar más, se cuenta desde el inicio y se obtienen 8 caracteres.

	contraseña            =   i    c    a    c    i    o    n    c        
 	valor numérico        =   105  99   97   99   105  111  110  99
 	matriz				  =   s    m         s    e    o    p     
						           l    e    e    m         e    a 
						      u    e    o         c    a    l    s
						      t    j    t    s    h    o         2 
	mensaje transpuesto   =    eotmlejse s as2s utemchpel o aone1

[//]: # ( http://dillinger.io/, https://stackedit.io/editor)
