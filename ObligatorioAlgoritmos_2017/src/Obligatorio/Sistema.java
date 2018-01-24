package Obligatorio;

import TADs.ListaCiudad;
import TADs.ListaCruceroRanking;
import Interfaces.ISistema;
import Obligatorio.Retorno.Resultado;
import TADs.NodoCiudad;
import TADs.NodoCrucero;
import TADs.NodoCruceroRanking;
import TADs.NodoReserva;
import TADs.NodoCruceroNombre;

public class Sistema implements ISistema {
    
    private ListaCiudad listaCiudades;
    private ListaCruceroRanking listaCrucerosRanking;  
    private int[][] matrizDistancias;
    
    //<editor-fold defaultstate="collapsed" desc="Métodos de Interfaz">
        
        //recibe un int >= 0 correspondiente al limite de ciudades permitidas en el sistema, si es 0 no se valida
        //PRE:
        //POS: Se crea un nuevo sistema de reservas
	@Override
	public Retorno crearSistemaReservas(int cantCiudades) {
            Retorno ret = new Retorno();
            
            if(cantCiudades >= 0){
                listaCrucerosRanking = new ListaCruceroRanking();
                listaCiudades = new ListaCiudad(); 
                listaCiudades.setCapacidad(cantCiudades);
                ret.resultado = Resultado.OK;
            }
            else{
                System.out.println("La cantidad de ciudades debe ser 0 o mayor.");
                ret.resultado = Resultado.ERROR_1;
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se destruyen las listas
	@Override
	public Retorno destruirSistemaReservas() {
            // se setean las listas a null para que el Garbage Collector las destruya y libere la memoria almacenada
            Retorno ret = new Retorno();
            listaCrucerosRanking.vaciar();
            listaCrucerosRanking = null;
            listaCiudades.vaciar();
            listaCiudades = null;
            ret.resultado = Resultado.OK;
                    
            return ret;
	}
        
        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se registra una nueva ciudad en el sistema
	@Override
	public Retorno registrarCiudad(String nombreCiudad) {
            Retorno ret = new Retorno();
            if(listaCiudades.buscarciudad(nombreCiudad) == null)
            {
                if(listaCiudades.getCapacidad() == 0){//se agrega sin validar cantidad
                    NodoCiudad tmpCiudad = new NodoCiudad(nombreCiudad);
                    this.listaCiudades.agregarFinal(tmpCiudad);
                    ret.resultado = Resultado.OK;
                }
                else if(listaCiudades.getCapacidad() > 0){ //se valida cantidad
                    if (listaCiudades.getCapacidad() > listaCiudades.getCantelementos()) {
                        NodoCiudad tmpCiudad = new NodoCiudad(nombreCiudad);
                        this.listaCiudades.agregarFinal(tmpCiudad);
                        ret.resultado = Resultado.OK;      
                    }
                    else {//la ciudad no es ingresada porque se ha alcanzado el numero maximo 
                        ret.resultado = Resultado.ERROR_2; 
                    }
                }
            }
            else{
                ret.resultado = Resultado.ERROR_1; 
            }
            return ret;
        } //A STE METODO SE LE AGREGO UN ERROR_2 QUE VALIDA LA CANTIDAD DE CIUDADES PERMITIDAS

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se registra un nuevo crucero en el sistema
	@Override
	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
                if(estrellas >= 1 && estrellas <= 5){
                    if(capacidad >= 0){
                        NodoCiudad c = listaCiudades.buscarciudad(ciudad);
                        if(c != null){
                            if(c.getLC().obtenerElemento(nombre, ciudad) == null){
                                NodoCrucero tmp = new NodoCrucero(nombre,ciudad,estrellas,capacidad); //Creo el NodoCrucero a ser agregado a la LC de la ciudad
                                c.getLC().agregarFinal(tmp);
                                
                                NodoCruceroRanking tmpCruceroRanking = new NodoCruceroRanking(tmp);// Creo el NodoCruceroRanking a ser agregado a la listaCrucerosRanking del sistema
                                listaCrucerosRanking.agregarFinal(tmpCruceroRanking);
                                
                                NodoCruceroNombre tmpCruceroNombre = new NodoCruceroNombre(tmp);// Creo el NodoCruceroNombre a ser agregado a la LCNombre de la ciudad
                                c.getLCNombre().agregarOrd(tmpCruceroNombre); 
                                
                                ret.resultado = Resultado.OK; 
                            }
                            else{
                                ret.resultado = Resultado.ERROR_3;
                            }
                        }
                        else{
                            ret.resultado = Resultado.ERROR_4;
                        }
                    }
                    else{
                        ret.resultado = Resultado.ERROR_2;
                    }
                }
                else{
                    ret.resultado = Resultado.ERROR_1;
                }	
		return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se resgistra un nuevo servicio en un crucero registrado en una ciudad
	@Override
	public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                if(cruceroTmp != null){
                    cruceroTmp.getListaServicios().agregarFinal(servicio);
                    ret.resultado = Resultado.OK;
                }
                else{
                    ret.resultado = Resultado.ERROR_1;
                }
            }
            else{
                ret.resultado = Resultado.ERROR_2;
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se borra un servicio previamente ingresado en crucero registrado en una ciudad
	@Override
	public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                if(cruceroTmp != null){ 
                    if(cruceroTmp.getListaServicios().borrarServicio(servicio)){
                         ret.resultado = Resultado.OK;
                    }
                    else{
                        ret.resultado = Resultado.ERROR_2;
                    }
                }
                else{
                     ret.resultado = Resultado.ERROR_1;
                }
            }
            else{
                ret.resultado = Resultado.ERROR_3;
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se registra una nueva reserva en la lista de reservas de un crucero registrado en una ciudad, si la capacidad maxima del crucero ha sido alcanzada, se registra la reserva en la cola de espera
	@Override
	public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
           Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                if(cruceroTmp != null){ 
                    if(cruceroTmp.getCapacidad() >  cruceroTmp.getListaReservas().getCantidadReservas()){
                       NodoReserva tmp = new NodoReserva(cliente, ciudad, crucero);
                       cruceroTmp.getListaReservas().agregarInicio(tmp);   
                    }
                    else{
                        NodoReserva tmp = new NodoReserva(cliente, ciudad, crucero);
                        cruceroTmp.getColaReservas().encolar(tmp);
                    }
                    ret.resultado = Resultado.OK;
                }
                else{
                     ret.resultado = Resultado.ERROR_1;
                }
            }
            else{
                ret.resultado = Resultado.ERROR_2;
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se borra la primera reserva encontrada del cliente ingresado
	@Override
	public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                if(cruceroTmp != null){ 
                    if(cruceroTmp.getListaReservas().borrar(cliente)){
                        NodoReserva tmp = cruceroTmp.getColaReservas().desencolar();
                        if(tmp != null) // si hay alguna reserva en la lista de espera se agrega al lugar liberado
                            cruceroTmp.getListaReservas().agregarInicio(tmp);
                        ret.resultado = Resultado.OK;
                    }
                    else{
                        ret.resultado = Resultado.ERROR_2; //El cliente no tiene reservas en el crucero
                    }   
                }
                else{
                     ret.resultado = Resultado.ERROR_1; //No existe Crucero
                }
            }
            else{
                ret.resultado = Resultado.ERROR_3; //No existe Ciudad
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se ingresa un nuevo comentario en la lista de comentarios de un crucero registrado en una ciudad
	@Override
	public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmpLC = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                NodoCruceroRanking cruceroTmpRanking = listaCrucerosRanking.obtenerElemento(crucero, ciudad);
                if(cruceroTmpLC != null){ 
                    if(ranking >= 0 && ranking <= 5){
                        cruceroTmpLC.getListaComentarios().agregarInicio(comentario, ranking);
                        cruceroTmpLC.ActualizarRaking();
                        if(listaCrucerosRanking.borrarElemento(crucero, ciudad) && ciuTmp.getLC().borrarElemento(crucero, ciudad)){
                            listaCrucerosRanking.agregarOrd(cruceroTmpRanking);
                            ciuTmp.getLC().agregarOrd(cruceroTmpLC);
                        }
                        ret.resultado = Resultado.OK;  
                    }
                    else{
                        ret.resultado = Resultado.ERROR_1; //La puntuacion ingresada no esta dentro del rango permitdo
                    }
                }
                else{
                    ret.resultado = Resultado.ERROR_2; //No existe Crucero
                }
            }
            else{
                ret.resultado = Resultado.ERROR_3; //No existe Ciudad
            }
            return ret;
	}
        
        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los servicios contenidas en la lista de servicios de un crucero registrado en una ciudad
	@Override
	public Retorno listarServicios(String ciudad, String crucero) {
		Retorno ret = new Retorno();
                NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
                if(ciuTmp != null){
                    NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                    if(cruceroTmp != null){
                        if(cruceroTmp.getListaServicios().getCantServicios()>0){
                            System.out.println("Servicios del Crucero "+cruceroTmp.getNombre()+" "+cruceroTmp.getCiudad());
                            ret.valorString = cruceroTmp.getListaServicios().mostrar();
                            System.out.println(); // para separar y que quede mas claro
                        }
                        else
                        {
                            System.out.println("No existen servicios registrados en el Crucero "+cruceroTmp.getNombre()+" "+cruceroTmp.getCiudad());
                        }
                        ret.resultado = Resultado.OK;  
                    }
                    else{
                        ret.resultado = Resultado.ERROR_1; //No existe Crucero
                    }       
                }
                else{
                    ret.resultado = Resultado.ERROR_2; //No existe Ciudad
                }
		
		return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los cruceros contenidas en la lista de cruceros de una ciudad registrada
	@Override
	public Retorno listarCrucerosCiudad(String ciudad) { //////ALFABETICO
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                if(!ciuTmp.getLCNombre().esVacia())
                {
                    System.out.println("Cruceros en " + ciuTmp.getNombre());
                    ret.valorString = ciuTmp.getLCNombre().mostrar();
                    System.out.println(); // para separar y que quede mas claro
                }
                else
                {
                    System.out.println("No existen Cruceros registrados en " + ciuTmp.getNombre());
                }
                ret.resultado = Resultado.OK;
            }
            else{
                ret.resultado = Resultado.ERROR_1; //No existe Ciudad
            }		
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los cruceros contenidos en la lista de cruceros de una ciudad registrada ordenados por ranking de forma ascendente
	@Override
	public Retorno listarCrucerosRankingAsc(String ciudad) {
		Retorno ret = new Retorno();
                NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
                if(ciuTmp != null){
                    if(!ciuTmp.getLC().esVacia())
                    {
                        System.out.println("Cruceros ordenados por ranking ");
                        System.out.println(ciuTmp.getNombre());
                        ret.valorString = ciuTmp.getNombre();
                        ciuTmp.getLC().setCadena("");
                        ret.valorString += ciuTmp.getLC().mostrarRecursivoAsc(ciuTmp.getLC().getInicio());
                    }
                    else
                    {
                        System.out.println("No existen Cruceros registrados en " + ciuTmp.getNombre());
                    }
                    ret.resultado = Resultado.OK;
                }
                else{
                    ret.resultado = Resultado.ERROR_1; //No existe Ciudad
                }		
                return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los cruceros contenidos en la lista de cruceros de una ciudad registrada ordenados por ranking de forma descendente
	@Override
	public Retorno listarCrucerosRankingDesc(String ciudad) {
		Retorno ret = new Retorno();
                NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
                if(ciuTmp != null){
                    if(!ciuTmp.getLC().esVacia())
                    {
                        System.out.println("Cruceros ordenados por ranking ");
                        System.out.println(ciuTmp.getNombre());
                        ret.valorString = ciuTmp.getNombre();
                        ciuTmp.getLC().setCadena("");
                        ret.valorString += ciuTmp.getLC().mostrarRecursivoDesc(ciuTmp.getLC().getInicio());
                    }
                    else
                    {
                        System.out.println("No existen Cruceros registrados en " + ciuTmp.getNombre());
                    }
                    ret.resultado = Resultado.OK;
                }
                else{
                    ret.resultado = Resultado.ERROR_1; //No existe Ciudad
                }		
                return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los cruceros contenidas en la lista de cruceros de una ciudad registrada de forma descendente
        @Override
        public Retorno listarCrucerosRanking(String ciudad) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                if(!ciuTmp.getLC().esVacia())
                {
                    System.out.println("Cruceros ordenados por ranking ");          
                    System.out.println(ciuTmp.getNombre());
                    ciuTmp.getLC().mostrarCrucerosDeCiudadRanking();
                }
                else
                {
                    System.out.println("No hay registros de cruceros en el sistema. ");
                }
                ret.resultado = Resultado.OK;
            }
            else{
                ret.resultado = Resultado.ERROR_1; //No existe Ciudad
            }		
            return ret;
        }
        
        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los cruceros registrados en el sistema ordenados por ranking de forma descendente
	@Override
	public Retorno listarCrucerosRanking() {
		Retorno ret = new Retorno();
                
                if(!listaCrucerosRanking.esVacia())
                {
                    System.out.println("\nCruceros ordenados por ranking\n");
                    ret.valorString = listaCrucerosRanking.mostrarListaGeneral();   
                }
                else
                {
                    System.out.println("\nNo hay registros de Cruceros en el sistema\n");
                }
                ret.resultado = Resultado.OK;
                	
                return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
        //POS: Se imprimen todos los comentarios contenidos en una lista de comentarios de un crucero registrado en una ciudad
	@Override
	public Retorno listarComentarios(String ciudad, String crucero) {
		Retorno ret = new Retorno();
                NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
                if(ciuTmp != null){
                    NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                    if(cruceroTmp != null){
                        if(!cruceroTmp.getListaComentarios().esVacia()){
                            System.out.println("Listado de servicios para el Crucero "+cruceroTmp.getNombre()+" de la ciudad "+cruceroTmp.getCiudad());
                            ret.valorString = cruceroTmp.getListaComentarios().mostrar();
                            System.out.println(); // para separar y que quede mas claro
                        }
                        else
                        {
                            System.out.println("No se han agregado comentarios al Crucero "+cruceroTmp.getNombre()+" "+cruceroTmp.getCiudad());
                        }
                        
                        ret.resultado = Resultado.OK;  
                    }
                    else{
                        ret.resultado = Resultado.ERROR_1; //No existe Crucero
                    }       
                }
                else{
                    ret.resultado = Resultado.ERROR_2; //No existe Ciudad
                }
		
		return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0 
        //POS: Se ingresa al sistema una matriz de distancias entre las ciudades
	@Override
	public Retorno cargarDistancias(int[][] distancias) {
            Retorno ret = new Retorno();
            int columnas = distancias[0].length;
            boolean matrizValida = true;
            if(listaCiudades.getCantelementos() == columnas){
                for (int i = 0; i < columnas; i++) {
                    if(distancias[i].length != columnas){
                        matrizValida = false;
                        ret.valorString = "La matriz ingresada no es cuadrada";
                        ret.resultado = ret.resultado.ERROR_1;
                    }
                    if(distancias[i][i] != 0){
                        matrizValida = false;
                        ret.valorString = "Una ciudad no puede tener conexion consigo misma";
                        ret.resultado = ret.resultado.ERROR_2;
                    }
                    if(distancias[i].length == columnas){
                        for (int j = 0; j < columnas; j++) {
                            if(distancias[i][j] < 0){
                                matrizValida = false;
                                ret.valorString = "Una distancia no puede tener un valor negativo";
                                ret.resultado = ret.resultado.ERROR_3;
                            }
                        }
                    }
                }
            }
            else
            {
                matrizValida = false;
                ret.valorString = "La matriz ingresada no es valida";
                ret.resultado = ret.resultado.ERROR_4;
            }
            if(matrizValida){
                ret.resultado = ret.resultado.OK;
                this.matrizDistancias = distancias;
            }
            return ret;
	}

        //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
         //POS: Se imprime en camino mas corto entre el origen ingresado y el destino (De existir)
	@Override
	public Retorno buscarCamino(int[][] M, String origen, String destino) {
            Retorno ret = new Retorno();
            int indiceOrigen = -1;
            int indiceDestino = -1;
            int indiceContador = 0;
            String camino="";
            NodoCiudad aux = listaCiudades.getInicio();
            while(aux != null){
                if(aux.getNombre() == origen){
                    indiceOrigen = indiceContador;
                }
                if(aux.getNombre() == destino){
                 indiceDestino = indiceContador;
                }
                indiceContador ++;
                aux = aux.getSig();
            }
            if(indiceOrigen != -1 && indiceDestino != -1){
                int columnas =this.matrizDistancias[0].length;
                int distancia=Integer.MAX_VALUE;
                int indiceEscala=-1;
                if (this.matrizDistancias[indiceOrigen][indiceDestino]!=0){
                    camino = origen + " , " + destino + " con distancia (" + this.matrizDistancias[indiceOrigen][indiceDestino] + ")";
                }
                else{
                    String nombreEscala = "";
                    for (int i = 0; i < columnas; i++) {
                        if (this.matrizDistancias[indiceOrigen][i]!=0 && this.matrizDistancias[indiceDestino][i]!=0 && this.matrizDistancias[indiceOrigen][i]+this.matrizDistancias[indiceDestino][i]<distancia){
                            distancia =this.matrizDistancias[indiceOrigen][i]+this.matrizDistancias[indiceDestino][i];
                            indiceEscala=i;
                        }
                    }
                    indiceContador = -1;
                    aux = listaCiudades.getInicio();
                    while(aux.getSig() != null && indiceContador != indiceEscala){
                        nombreEscala = aux.getNombre();
                        indiceContador ++;
                        aux = aux.getSig();
                    }
                    camino =origen + " , " + nombreEscala + " , " + destino + " con distancia (" + distancia + ")";
                }
                ret.resultado = ret.resultado.OK;
                ret.valorString = camino;
            }
            else{
                ret.valorString = "Inicio y/o Destino no valido";
                ret.resultado = ret.resultado.ERROR_1;
            }
            return ret;
	}
        
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get/Set Listas">
    
    
    public ListaCiudad getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ListaCiudad listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
    
    public ListaCruceroRanking getListaCrucerosRanking() {
        return listaCrucerosRanking;
    }

    public void setListaCrucerosRanking(ListaCruceroRanking listaCrucerosRanking) {
        this.listaCrucerosRanking = listaCrucerosRanking;
    }
    //</editor-fold>
    
    //PRE: El sistema debe estar creado con una cantidad de ciudades igual o mayor a 0
    //POS: Se imprimen todas las reservas contenidas en la lista de reservas y la cola de espera
    public Retorno listarReservasYCola(String ciudad, String crucero) {
            Retorno ret = new Retorno();
            NodoCiudad ciuTmp = listaCiudades.buscarciudad(ciudad);
            if(ciuTmp != null){
                NodoCrucero cruceroTmp = ciuTmp.getLC().obtenerElemento(crucero, ciudad);
                if(cruceroTmp != null){
                    System.out.println("\n**************************Lista de Reservas***********************\n");
                    cruceroTmp.getListaReservas().mostrar();
                    System.out.println("\n**************************Lista de Espera***********************\n");
                    cruceroTmp.getColaReservas().mostrar();

                    ret.resultado = Resultado.OK;  
                }
                else{
                    ret.resultado = Resultado.ERROR_1; //No existe Crucero
                }       
            }
            else{
                ret.resultado = Resultado.ERROR_2; //No existe Ciudad
            }

            return ret;
    }
}
