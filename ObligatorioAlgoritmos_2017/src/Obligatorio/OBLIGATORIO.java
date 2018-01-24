package Obligatorio;

public class OBLIGATORIO {

    public static void main(String[] args) {
        Sistema S = new Sistema();
        prueba P = new prueba();

       prueba0(S,P);
//       preuba1(S,P);
//       prueba2(S,P);
//       prueba3(S,P);
//       prueba4(S,P);
//       prueba5(S,P);
//       prueba6(S,P);
//       prueba7(S,P);
//       prueba8(S,P);
//       prueba9(S,P);
//       prueba10(S,P);
//       prueba11(S,P);
//       prueba12(S,P);
//       prueba13(S,P);
//       prueba14(S,P);
//       prueba15(S,P);      
//       
        
    }
    
  public static void prueba0(Sistema s, prueba p) {
        
        System.out.println("------------------CREACION DEL SISTEMA------------------");
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas con un tope de 5 ciudades");
        p.ver(s.crearSistemaReservas(-3).resultado,Retorno.Resultado.ERROR_1,"No se crea el sistema de reservas por tener tope negativo");

        System.out.println("------------------INGRESO DE CIUDADES------------------");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("Panamá").resultado, Retorno.Resultado.OK, "Se ingresa Panamá");
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.ERROR_2, "No se ingresa New York, por superar el tope");
        
        System.out.println("------------------LISTO CIUDADES------------------");
        s.getListaCiudades().mostrar();//listo ciudades ingresadas
        
        System.out.println("------------------REGISTRO CRUCEROS------------------");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000).resultado, Retorno.Resultado.OK, "Se registra crucero MSC a Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500).resultado, Retorno.Resultado.OK, "Se registra crucero Carnival a Montevideo");
        p.ver(s.registrarCrucero("Panamá", "Costa Cruise", 3, 3000).resultado, Retorno.Resultado.OK, "Se registra crucero Costa Cruise a Panamá");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 4000).resultado, Retorno.Resultado.OK, "Se registra crucero Royal Caribbean Int. a San Pablo");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 4, 3200).resultado, Retorno.Resultado.OK, "Se registra crucero Disney Cruise Line a Santiago");
        p.ver(s.registrarCrucero("Santiago", "Holland America Line", 6, 2800).resultado, Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");  
        p.ver(s.registrarCrucero("Santiago", "Princess Cruises", 5, -1).resultado, Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 4, 3100).resultado, Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("New York", "Norwegian Cruise Line", 5, 3000).resultado, Retorno.Resultado.ERROR_4, "La ciudad no existe");
        
        System.out.println("------------------LISTO CRUCEROS INGRESADOS------------------");
        s.getListaCrucerosRanking().mostrarListaGeneral();//listo cruceros ingresados
        
        System.out.println("------------------REGISTRO SERVICIOS------------------");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo").resultado, Retorno.Resultado.OK, "Servicio Shopping a bordo en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Guarderia").resultado, Retorno.Resultado.OK, "Servicio guarderia en MSC Montevideo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Shopping a bordo").resultado, Retorno.Resultado.OK, "Servicio Shopping a bordo en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Guarderia").resultado, Retorno.Resultado.OK, "Servicio guarderia en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Holland America Line", "Guarderia").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.ingresarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado, Retorno.Resultado.ERROR_2, "La ciudad no existe");
    
        System.out.println("------------------ELIMINO SERVICIOS------------------");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Wifi").resultado, Retorno.Resultado.OK, "Borro servicio wifi en MSC Montevideo");
        p.ver(s.borrarServicio("San Pablo", "Holland America Line", "Guarderia").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Lavanderia").resultado, Retorno.Resultado.ERROR_2, "No existe el servicio en el crucero");
        p.ver(s.borrarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado, Retorno.Resultado.ERROR_3, "La ciudad no existe");
        
        System.out.println("------------------REALIZO RESERVAS------------------");
        p.ver(s.realizarReserva(1, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Holland America Line").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.realizarReserva(7, "New York", "Norwegian Cruise Line").resultado, Retorno.Resultado.ERROR_2, "La ciudad no existe");

        System.out.println("------------------CANCELO RESERVAS------------------");
        p.ver(s.cancelarReserva(2, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Se elimina reserva");
        p.ver(s.cancelarReserva(8, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.ERROR_2, "El cliente no tiene reserva en el crucero");
        p.ver(s.cancelarReserva(2, "Montevideo", "Holland America Line").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.cancelarReserva(3, "New York", "Holland America Line").resultado, Retorno.Resultado.ERROR_3, "La ciudad no existe");
//
        System.out.println("------------------INGRESO COMENTARIO------------------");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Mala limpieza", 2).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Nos gusto mucho el crucero", 3).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy recomendable", 10).resultado, Retorno.Resultado.ERROR_1, "Ranking mayor a 5");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.ERROR_2, "No existe el crucero en la ciudad");
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.ERROR_3, "No existe la ciudad");
        
        System.out.println("------------------LISTO SERVICIOS------------------");
        p.ver(s.listarServicios("Panamá", "Costa Cruise").resultado, Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarServicios("Buenos Aires", "MSC Poesia").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad");
       
        System.out.println("------------------LISTO CRUCEROS POR CIUDAD------------------");
        p.ver(s.listarCrucerosCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosCiudad("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosCiudad("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");

        System.out.println("------------------LISTO CRUCEROS POR RANKING ASCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingAsc("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingAsc("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingAsc("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingAsc("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");
        
        System.out.println("------------------LISTO CRUCEROS POR RANKING DESCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingDesc("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingDesc("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingDesc("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");
        
        System.out.println("------------------LISTO TODOS LOS CRUCEROS POR RANKING------------------");
        p.ver(s.listarCrucerosRanking().resultado, Retorno.Resultado.OK, "Listado de cruceros por ranking");
        
        System.out.println("------------------LISTO COMENTARIOS------------------");
        p.ver(s.listarComentarios("Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Santiago", "Disney Cruise Line").resultado, Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Lima", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarComentarios("San Francisco", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad");
//        
        System.out.println("------------------CAMINO MAS CORTO------------------");
        int [][]ciudades = {{0,10,25,15,30},
                            {10,0,20,0,0},
                            {25,20,0,0,0},
                            {15,0,0,0,0},
                            {30,0,0,0,0}};
       
        p.ver(s.cargarDistancias(ciudades).resultado, Retorno.Resultado.OK, "Se cargan las distancias"); //se estan cargando 5 ciudades y la matriz ingresadas es para 6, NO VALIDA
        p.ver(s.buscarCamino(ciudades, "Montevideo", "Santiago").resultado, Retorno.Resultado.OK, "Buscar camino mas corto");
        
        System.out.println("------------------SE DESTRUYE EL SISTEMA DE RESERVAS------------------");
        p.ver(s.destruirSistemaReservas().resultado,Retorno.Resultado.OK,"Se elimina el sistema de reservas");
        
        p.imprimirResultadosPrueba();
    } 
    
    
  public static void preuba1(Sistema s, prueba p){
   p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se registra Montevideo");
   p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar Montevideo nuevamente"); 
   p.ver(s.registrarCiudad("Tacuarembo").resultado, Retorno.Resultado.OK, "Se intenta registrar Montevideo nuevamente");         
   p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.OK, "Se registra Maldonado");
   p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se registra Rocha");
   p.ver(s.registrarCiudad("Flores").resultado, Retorno.Resultado.OK, "Se registra Flores");   
   p.ver(s.registrarCiudad("Atlantida").resultado, Retorno.Resultado.ERROR_2, "Se registra Atlantida");
   p.imprimirResultadosPrueba();
   }

  public static void prueba2(Sistema s, prueba p){
   p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se registra Montevideo");
   p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar Montevideo nuevamente");         
   p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.OK, "Se registra Maldonado");
   p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se registra Rocha");
   p.ver(s.registrarCiudad("Flores").resultado, Retorno.Resultado.OK, "Se registra Flores");
   p.ver(s.registrarCiudad("Punta del este").resultado, Retorno.Resultado.OK, "Se registra Punta del Este");
   p.ver(s.registrarCiudad("Atlantida").resultado, Retorno.Resultado.OK, "Se registra Atlantida");
   p.imprimirResultadosPrueba();
 }
 
 //_crearSistemaReservas
   public static void prueba3(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(4).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas para 4 ciudades");
        p.ver(s.crearSistemaReservas(0).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas sin limite de ciudades");
        p.ver(s.crearSistemaReservas(-1).resultado, Retorno.Resultado.ERROR_1, "La cantidad de ciudades no pueden ser menores a 0");
        p.imprimirResultadosPrueba();
    }

 //_destruirSistemaReservas
    public static void prueba4(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(1).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye el sistema de reservas");
        p.imprimirResultadosPrueba();
    }

   
  //_registrarCiudad
 public static void prueba5(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo que ya existe");
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
        p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se ingresa BsAires pero sobrepasa el limite de ciudades definido");
        p.imprimirResultadosPrueba();
    }  
 
   //_registrarCrucero
   public static void prueba6(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800).resultado, Retorno.Resultado.ERROR_1, "Se intenta agregar Carnival Cruise Lines pero La cantidad de estrellas no esta  entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1).resultado, Retorno.Resultado.ERROR_2, "Se intenta agregar Royal Caribbean Int pero La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100).resultado, Retorno.Resultado.ERROR_3, "Se intenta agregar Royal Caribbean Int. pero Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.ERROR_4, "Se intenta agregar Disney Cruise Line pero La ciudad no existe");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.OK, "Se registra Disney Cruise Line en Santiago");
        p.ver(s.listarCrucerosCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Listado de Cruceros en Montevideo");
        p.ver(s.listarCrucerosCiudad("Santiago").resultado, Retorno.Resultado.OK, "Listado de Cruceros en Santiago");
        p.imprimirResultadosPrueba();
    }


//_ingresarServicio
    public static void prueba7(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino").resultado, Retorno.Resultado.OK, "Se ingresa servicio Casino en Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.OK, "Se ingresa servicio Wifi en Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "All Inclusive").resultado, Retorno.Resultado.OK, "Se ingresa servicio All Inclusive en Royal Caribbean Int. en Montevideo");
        p.imprimirResultadosPrueba();
    }


//_borrarServicio
    public static void prueba8(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino").resultado, Retorno.Resultado.OK, "Se ingresa Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Disney Cruise Line", "Casino").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina").resultado, Retorno.Resultado.ERROR_2, "No existe un servicio Piscina en el Royal Caribbean Int.");
        p.ver(s.borrarServicio("Santiago", "Royal Caribbean Int.", "Casino").resultado, Retorno.Resultado.ERROR_3, "No existe la ciudad Santiago");
        p.imprimirResultadosPrueba();
    }

//_realizarRerserva
    public static void prueba9(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 3 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "El cliente 4 queda en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "Se intenta agregar crucero a ciuedad que No existe la ciudad San Pablo");
        p.ver(s.listarReservasYCola("Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "reservas");
        p.ver(s.cancelarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "El cliente 7 no tiene reservas para el Royal Caribbean Int. de Montevideo");
        p.ver(s.listarReservasYCola("Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "reservas");
        p.imprimirResultadosPrueba();
    }

//_cancelarRerserva
    public static void prueba10(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "El cliente 4 queda en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se cancela la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo, pasa el cliente 4 de a lista de espera");
        p.ver(s.cancelarReserva(5, "Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.cancelarReserva(7, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "El cliente 7 no tiene reservas para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(2, "San Pablo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_3, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

//_ingresarComentario
    public static void prueba11(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresÃ³ Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "El crucero es excelente", 5).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "No me gusto nada", -1).resultado, Retorno.Resultado.ERROR_1, "El ranking del comentario no estÃ¡ entre 0 y 5");
        p.ver(s.ingresarComentario("Montevideo", "Disney Cruise Line", "El crucero esta¡ muy bueno", 4).resultado, Retorno.Resultado.ERROR_2, "No se encontra un crucero con ese nombre para Montevideo");
        p.ver(s.ingresarComentario("San Pablo", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3).resultado, Retorno.Resultado.ERROR_3, "No se encontra la ciudad San Pablo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Tienen que mejorar la limpieza", 2).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Montevideo");
        p.imprimirResultadosPrueba();
    }


//_listarServicios
    public static void prueba12(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino").resultado, Retorno.Resultado.OK, "Se ingresa Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina").resultado, Retorno.Resultado.OK, "Se ingresa Piscina como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes").resultado, Retorno.Resultado.OK, "Se ingresa Masajes como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "HabitaciÃ³n King").resultado, Retorno.Resultado.OK, "Se ingresa HabitaciÃ³n King Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarServicios("San Pablo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

//_listarCrucerosCiudad
    public static void prueba13(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Carnival Cruise Lines", 4, 2800).resultado, Retorno.Resultado.OK, "Se ingresa Carnival Cruise Lines en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Celebrity Reflection", 3, 1300).resultado, Retorno.Resultado.OK, "Se ingresa Celebrity Reflection en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.OK, "Se ingresa Disney Cruise Line en San Pablo");
        p.ver(s.listarCrucerosCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se listan los cruceros de San Pablo por nombre");
        p.ver(s.listarCrucerosCiudad("Lima").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad Lima");
        p.imprimirResultadosPrueba();
    }

//_listarCrucerosRanking
    public static void prueba14(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCrucero("Lima", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Lima");
        p.ver(s.registrarCrucero("Lima", "Carnival Cruise Lines", 4, 2800).resultado, Retorno.Resultado.OK, "Se ingresa Carnival Cruise Lines en Lima");
        p.ver(s.registrarCrucero("Lima", "Celebrity Reflection", 3, 1300).resultado, Retorno.Resultado.OK, "Se ingresa Celebrity Reflection en Lima");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.OK, "Se ingresa Disney Cruise Line en Lima");
        p.ver(s.ingresarComentario("Lima", "Royal Caribbean Int.", "Recomendable", 3).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Lima");
        p.ver(s.ingresarComentario("Lima", "Celebrity Reflection", "El crucero es excelente", 5).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Celebrity Reflection de Lima");
        p.ver(s.ingresarComentario("Lima", "Disney Cruise Line", "Descuidada la higiene", 2).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Disney Cruise Line de Lima");
        p.ver(s.listarCrucerosRankingAsc("Lima").resultado, Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("New York").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.ver(s.listarCrucerosRankingDesc("Lima").resultado, Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking descendente");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.imprimirResultadosPrueba();
    }


//_listarComentarios
    public static void prueba15(Sistema s, prueba p) {
        p.ver(s.crearSistemaReservas(6).resultado, Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
//        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
//        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Excelente", 5).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
//        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Me gustÃ³ mucho", 4).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
//        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy recomendable, excelente piscina", 5).resultado, Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
//        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "La comida estaba en mal estado", 2).resultado, Retorno.Resultado.OK, "Se ingresÃ³ un comentario en el Royal Caribbean Int. en Montevideo");
//        p.ver(s.listarComentarios("Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
//        p.ver(s.listarComentarios("Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
//        p.ver(s.listarComentarios("San Pablo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        
       p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Bs As").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("POA").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("RIO").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("MIA").resultado, Retorno.Resultado.OK, "Montevideo ya existe");
        p.ver(s.registrarCiudad("SP").resultado, Retorno.Resultado.OK, "Se ingresa Panamá");
//        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.ERROR_2, "No se ingresa New York, por superar el tope");
        
        //camino mas corto
        int[][] matdistancias = new int[][] {{0,7,3,0,0,14},
                            {7,0,10,15,14,0},
                            {9,10,0,11,3,2},
                            {0,15,11,0,6,0},
                            {0,14,3,6,0,9},
                            {14,0,2,0,9,0}};
      
        
        
        p.ver(s.cargarDistancias(matdistancias).resultado, Retorno.Resultado.OK, "Se cargo matriz de distancias"); 
        String resultado = s.buscarCamino(matdistancias, "Montevideo", "MIA").valorString;
        p.ver(s.buscarCamino(matdistancias, "Montevideo", "MIA").resultado, Retorno.Resultado.OK, "Buscar camino mas corto");
        System.out.println(resultado);
        
        p.imprimirResultadosPrueba();

    }
    
   
   
   
   
}




 


 

//---------------------------------------------------------

