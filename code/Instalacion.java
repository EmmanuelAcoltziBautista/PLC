import java.io.*;
public class Instalacion{
public static void main(String args[]){

	String direccion=System.getProperty("user.home");//Direccion





	String temp="";
	String contenido="";
//creo un archivo
	File ArchivoLectura;

//agrego la ruta a un archivo
	ArchivoLectura=new File(direccion+"/PLC(Sources)/Ins.bin");
	try{
//le digo en donde esta
	BufferedReader bf=new BufferedReader(new FileReader(ArchivoLectura));
//le creo algo para que lo lea	
	String bfReader;

//mientas tenga lineas que las lea siempre y cuando siga teniendo texto
	while((bfReader=bf.readLine())!=null){
//lo agrego
	temp=temp+bfReader;
	}
//asigno
	contenido=temp;
	System.out.println("COntenido"+contenido);
	}catch(Exception E){
	}


//si existe el archivo

	if(contenido.equals("1")){
	System.out.println("No es necesario");
    Cargando C=new Cargando();
    C.setBounds(0,0,500,200);
    C.setLocationRelativeTo(null);
    C.setVisible(true);
    C.setResizable(false);
	}


//si no hay el archivo
	else{


	System.out.println("es necesario");
//Mover archivos

	try{
	new ProcessBuilder("cmd","/c","move PLC(Sources) "+direccion).inheritIO().start().waitFor();
	}catch(Exception E){}


//creacion de archivo


	String texto="1";
	String NombreArchivo="Ins.bin";

	File Archivo;
	FileWriter escribir;
	PrintWriter Lineas;

//le digo la ruta y el nombre del archivo	

	String ruta=direccion+"/PLC(Sources)/"+NombreArchivo;

//creao el archivo

	Archivo=new File(ruta);
	try{
	Archivo.createNewFile();
//le digo que lo voy a editar
	escribir=new FileWriter(Archivo,true);
	Lineas=new PrintWriter(escribir);
//coloco el texto
	Lineas.println(texto);
	Lineas.close();
	escribir.close();
	System.out.println("Creado");
	}catch(Exception E){}
    Cargando C=new Cargando();
    C.setBounds(0,0,500,200);
    C.setLocationRelativeTo(null);
    C.setVisible(true);
    C.setResizable(false);

	}



	}
}