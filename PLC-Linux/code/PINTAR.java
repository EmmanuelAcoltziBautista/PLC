/*
Creado por Emmanuel Acoltzi Bautista
Fecha de creacion:01/09/2023
basedeemma@gmail.com
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PINTAR{
	
	private JPanel PANEL;
	String TEXTO;
	public static int escala;
//posicion
	public static int ancho=200;
	public static int alto=200;

	int pAncho,pAlto;
	int posicionTexto;
	String textoPosicion;

	public PINTAR(JPanel PANEL,String TEXTO,int escala){
	this.PANEL=PANEL;
	this.escala=escala;
//obtengo el texto
	this.textoPosicion=TEXTO;
//le pregunto cuantos datos hay
	this.posicionTexto=TEXTO.length();	
	System.out.println(posicionTexto);
	
	}
	public void Pain(){
	Graphics2D G=(Graphics2D)PANEL.getGraphics();
	G.setColor(new Color(0,0,0));

//le digo que haga un ciclo para que lea caracter por caracter
	for(int i=0;i<=posicionTexto-1;i++){

//para que lea caracter por caracter
	TEXTO=textoPosicion.substring(i,i+1);
	System.out.println(TEXTO);

//le digo que entre a la siguiente condicion los caracteres
	if(TEXTO.equalsIgnoreCase("D")){
	alto=alto+escala;	
	G.fillRect(ancho,alto,escala,escala);
	

	}else if(TEXTO.equalsIgnoreCase("U")){
	alto=alto-escala;	
	G.fillRect(ancho,alto,escala,escala);

	}else if(TEXTO.equalsIgnoreCase("L")){
	ancho=ancho-escala;	
	G.fillRect(ancho,alto,escala,escala);

	}
	else if(TEXTO.equalsIgnoreCase("R")){
	ancho=ancho+escala;	
	G.fillRect(ancho,alto,escala,escala);

	}

	try{
//animacion
	Thread.sleep(100);
	}catch(Exception E){}
}

	}
}