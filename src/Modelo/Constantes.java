package Modelo;


public class Constantes {
    public static final double TAMANIO_CASILLERO = 50;

//    Mapa
    public static final int ALTO_MAPA = 25;
    public static final int ANCHO_MAPA = 50;
    public static int SEED_CASTILLO_J1 = 2;
    public static int SEED_PLAZA_CENTRAL_J1 = 7;
    public static int SEED_CASTILLO_J2 = 43;
    public static int SEED_PLAZA_CENTRAL_J2 = 40;

//    Tamanio Unidad en view
    public static double ALTURA_UNIDAD = 1;
    public static double ANCHO_UNIDAD = 0.5;

    //    Tamanio Castillo en view
    public static double ALTURA_CASTILLO = 4;
    public static double ANCHO_CASTILLO = 4;

    //    Tamanio Edificio en view
    public static double ALTURA_EDIFICIO = 2;
    public static double ANCHO_EDIFICIO = 2;

    //    Costo oro de cada Entidad
    public static int COSTO_CUARTEL = 50;
    public static int COSTO_PLAZA_CENTRAL = 100;
    public static int COSTO_ALDEANO = 25;
    public static int COSTO_ESPADACHIN = 50;
    public static int COSTO_ARQUERO = 75;
    public static int COSTO_ARMA_ASEDIO = 200;

//    Propiedades iniciales del Jugador
    public static final int CANTIDAD_ALDEANOS_INICIAL = 3;
    public static final int CANTIDAD_ORO_INICIAL = 100;
    public static final int LIMITE_POBLACION = 50;

//    Castillo
    public static final int VIDA_CASTILLO = 1000;
    public static final int VELOCIDAD_REPARACION_CASTILLO = 15;
    public static final int DISTANCIA_MAXIMA_ATAQUE_CASTILLO = 3;
    public static final int DANIO_CASTILLO = 20;
    
//    Cuartel
    public static final int VIDA_CUARTEL = 250;
    public static final int VELOCIDAD_REPARACION_CUARTEL = 50;
    public static final int TURNOS_CONSTRUCCION_CUARTEL = 3;
    
//    PlazaCentral
    public static final int VIDA_PLAZA_CENTRAL = 450;
    public static final int VELOCIDAD_REPARACION_PLAZA_CENTRAL = 25;
    public static final int TURNOS_CONSTRUCCION_PLAZA_CENTRAL = 3;
    
//    Aldeano
    public static final int VIDA_ALDEANO = 50;
    public static final int RANGO_ALDEANO = 1;
    
//    ArmaAsedio
    public static final int VIDA_ARMA_ASEDIO = 150;
    public static final int RANGO_ARMA_ASEDIO = 5;
    public static final int DANIO_EDIFICIO_ARMA_ASEDIO = 75;
    
//    Arquero
    public static final int VIDA_ARQUERO = 75;
    public static final int RANGO_ARQUERO = 3;
    public static final int DANIO_UNIDAD_ARQUERO = 15;
    public static final int DANIO_EDIFICIO_ARQUERO = 10;
    
//    Espadachin
    public static final int VIDA_ESPADACHIN = 100;
    public static final int DANIO_UNIDAD_ESPADACHIN = 25;
    public static final int DANIO_EDIFICIO_ESPADACHIN = 15;
    public static final int RANGO_ESPADACHIN = 1;
}
