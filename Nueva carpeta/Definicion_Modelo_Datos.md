# Definición del Modelo de Datos - Sistema de Reservas de Laboratorios

## Introducción

Nuestro sistema de reservas para los laboratorios de la ECI tiene como objetivo permitir a los usuarios consultar la disponibilidad de los laboratorios, realizar reservas y cancelarlas. Para lograr esto, es fundamental que definamos un modelo de datos adecuado que estructure la información y garantice la integridad de las reservas. En este documento presentamos las entidades principales del sistema, sus atributos y la relación entre ellas.

## Identificación de Entidades

Para la gestión de reservas, hemos identificado dos entidades principales: `Laboratorio` y `Reserva`. La entidad **<i>Laboratorio
</i>** representa los espacios físicos que pueden ser reservados por los usuarios, mientras que la entidad **<i>Reserva</i>** almacena los detalles de cada reserva realizada.

## Definición de Atributos

Cada entidad cuenta con atributos específicos que definen su estructura y permiten gestionar la información de manera eficiente.

### Laboratorio

| Atributo   | Tipo de Dato  | Descripción                                      |
|------------|--------------|--------------------------------------------------|
| id         | String (UUID) | Identificador único del laboratorio             |
| nombre     | String       | Nombre del laboratorio (Ej: "Lab Redes")        |
| capacidad  | Integer      | Capacidad máxima de personas                    |
| ubicacion  | String       | Ubicación física del laboratorio (edificio)               |
| estado     | Boolean      | Indica si el laboratorio está disponible o no   |

### Reserva

| Atributo       | Tipo de Dato  | Descripción                                             |
|---------------|--------------|---------------------------------------------------------|
| id            | String (UUID) | Identificador único de la reserva                      |
| idLaboratorio | String (UUID) | Referencia al laboratorio reservado                    |
| usuario       | String        | Nombre o identificador del usuario que realiza la reserva |
| fecha         | Date          | Fecha en la que se realizará la reserva               |
| horaInicio    | Date | Hora de inicio de la reserva                          |
| horaFin       | Date | Hora de finalización de la reserva                   |
| proposito     | String        | Motivo de la reserva                                  |
| estado        | String        | Estado de la reserva (Ej: "Confirmada", "Cancelada")  |

## Relación entre Entidades

Existe una relación uno a muchos (1..*) entre `Laboratorio` y `Reserva`, ya que un laboratorio puede tener múltiples reservas, pero cada reserva está asociada a un único laboratorio.

## Implementación

Para representar estas entidades en Java utilizando Spring Boot y MongoDB, podemos definir las siguientes clases:

### Laboratorio

```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laboratorios")
public class Laboratorio {
    
    @Id
    private String id;
    private String nombre;
    private int capacidad;
    private String ubicacion;
    private boolean estado;

}
```

### Reserva

```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "reservas")
public class Reserva {
    
    @Id
    private String id;
    private String idLaboratorio;
    private String usuario;
    private Date fecha;
    private String horaInicio;
    private String horaFin;
    private String proposito;
    private String estado;

}
```
