package Interfaces;

import Obligatorio.Retorno;

public interface ISistema {
	/*1.1*/Retorno crearSistemaReservas(int cantCiudades); 
	/*1.2*/Retorno destruirSistemaReservas();
	/*1.3*/Retorno registrarCiudad(String ciudad);
	/*1.4*/Retorno registrarCrucero(String ciudad, String nombre, int estrellas,int capacidad);
	/*1.5*/Retorno ingresarServicio(String ciudad, String crucero, String servicio);
	/*1.6*/Retorno borrarServicio(String ciudad, String crucero, String servicio);
	/*1.7*/Retorno realizarReserva(int cliente, String ciudad, String crucero);
	/*1.8*/Retorno cancelarReserva(int cliente, String ciudad, String crucero);
	/*1.9*/Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking);
	/*1.10*/Retorno listarServicios(String ciudad, String crucero);
	/*1.11*/Retorno listarCrucerosCiudad(String ciudad);
        /*1.12*/Retorno listarCrucerosRanking(String ciudad);
        /*1.13*/Retorno listarCrucerosRanking();
	/*1.14*/Retorno listarComentarios(String ciudad, String crucero);
	/*2.1*/Retorno cargarDistancias(int[][] ciudades);
	/*2.2*/Retorno buscarCamino(int [][] m, String origen, String destino);
	/*1.15*/Retorno listarCrucerosRankingAsc(String ciudad);
	/*1.16*/Retorno listarCrucerosRankingDesc(String ciudad);
}

