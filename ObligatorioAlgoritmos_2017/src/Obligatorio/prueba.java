package Obligatorio;

import Obligatorio.Retorno;

public class prueba {
	static int	cantCorrectas, cantIncorrectas, cantNoImplementadas;
	void inicializarResultadosPrueba() {
		cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
	}

	public void ver(Retorno.Resultado tr, Retorno.Resultado TipoRetEsperado, String comentario){
		System.out.println( "----------------------------- Testeo --------------------------------");
		imprimirComentario(comentario);
		imprimirTipoRet(tr,TipoRetEsperado);
		System.out.println("");
		System.out.println("---------------------------------------------------------------------");
	    System.out.println();

	    if (tr.equals(TipoRetEsperado))
			cantCorrectas++;
		else
		{
			if (tr.equals(Retorno.Resultado.NO_IMPLEMENTADA))
				cantNoImplementadas++;
			else
				cantIncorrectas++;

		}
	}

	void imprimirComentario(String comentario)
	{
		if ( comentario!=null || !comentario.isEmpty())
			System.out.println("\n  Comentario: " + comentario );
	}

	public void imprimirTipoRet(Retorno.Resultado TipoRet, Retorno.Resultado TipoRetEsperado)
	{
		

		if ( TipoRet == TipoRetEsperado )
		{
			System.out.println( "  ...................OK...................." );
		}
		else
		{
			System.out.println( "  ...................ERROR...................." );
			System.out.println("  TipoRet de la app.: "+ TipoRet +" / Se esperaba: " + getStringTipoRet(TipoRetEsperado));
		}
	}

	public String getStringTipoRet(Retorno.Resultado TipoRet)
	{
		switch( TipoRet )
		{
			case OK:
				return "OK";
			case ERROR_1:
				return "ERROR_1";
			case ERROR_2:
				return "ERROR_2";
			case ERROR_3:
				return "ERROR_3";
			case NO_IMPLEMENTADA:
				return "NO_IMPLEMENTADA";
			default:
				return "NO_IMPLEMENTADA";
		}
	}

	void imprimirResultadosPrueba()
	{
		System.out.println();
		System.out.println( "  +------------------------------+");
		System.out.println("    RESULTADOS DE LA PRUEBA    ");
		System.out.println("    Pruebas Correctas: " + cantCorrectas);
		System.out.println("    Pruebas Incorrectas: " + cantIncorrectas );
		System.out.println("    Pruebas NI: " + cantNoImplementadas);
		System.out.println("  +------------------------------+");
		System.out.println();
	}

	public static void tituloPrueba(String s){
    	System.out.println("");   
        System.out.println("********************************************************************************************************");
        System.out.println("  "+ s );
        System.out.println("********************************************************************************************************");
    }

    public static void finPrueba(String s){
        System.out.println("**************************************** " + s +" ***************************************");
        System.out.println("********************************************************************************************************");
        System.out.println();
    }
}
