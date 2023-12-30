import java.io.*;
public class Instalacion{
public static void main(String args[]){

	String direccion=System.getProperty("user.home");//Direccion





	String temp="";
	String contenido="";
//creo un archivo
	File ArchivoLectura;

//agrego la ruta a un archivo
	ArchivoLectura=new File(direccion+"/PLC-Sources/Ins.bin");
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
	System.out.println("Realizando lectura");
	}catch(Exception E){
	System.out.println("Error en la lectura: "+E);
	
	}finally{
	System.out.println("Lectura finalizada con exito");
	}


//si existe el archivo

	if(contenido.equals("1")){
	System.out.println("Instalacion no necesaria");
/*
Compruebo si ya se creo la licencia
*/


        File ArchivoLe;
        String contenidoLe="";
        String Ubicaciones=System.getProperty("user.home");
        String Ubicaciones1=Ubicaciones+"/PLC-Sources/License.bin";
        ArchivoLe=new File(Ubicaciones1);
        try{
        BufferedReader bf11=new BufferedReader(new FileReader(ArchivoLe));
        String bfR1="";
        while((bfR1=bf11.readLine())!=null){
	contenidoLe=contenidoLe+bfR1;
	}
	if(contenidoLe!=null){
	System.out.println("Licencia encontrada redireccionando...");
	Cargando C=new Cargando();
	C.setBounds(0,0,500,200);
	C.setLocationRelativeTo(null);
	C.setVisible(true);
	C.setResizable(false);
        }else{
        System.out.println("Licencia no encontrada");
	Licencia L=new Licencia();
	L.setBounds(0,0,530,600);
	L.setVisible(true);
	L.setLocationRelativeTo(null);
	L.setResizable(false);
        }
        }catch(Exception E){}

	}


//si no hay el archivo
	else{


	System.out.println("Instalacion necesaria");
	System.out.println("Instalando...");
//Mover archivos

	try{
	String comando="sudo mv PLC-Sources "+direccion;
	System.out.println(comando);
	Process proceso=Runtime.getRuntime().exec(comando);
	System.out.println("Moviendo archivos");
//para ver que aparece al  ejecutar el comando
	BufferedReader bf=new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	String contenidoSalida="";
	String contenedor=bf.readLine();
	while(contenedor!=null){
	System.out.println(contenedor);
	}


	}catch(Exception E){
	System.out.println("Error al mover: "+E);
	}
	finally{
	System.out.println("Se movio con exito");
	}


//creacion de archivo


	String texto="1";
	String NombreArchivo="Ins.bin";

	File Archivo;
	FileWriter escribir;
	PrintWriter Lineas;

//le digo la ruta y el nombre del archivo	

	String ruta=direccion+"/PLC-Sources/"+NombreArchivo;



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
	System.out.println("Creando archivos necesarios");
	}catch(Exception E){
	System.out.println("Error en la instalacion archivos de instalacion no generados"+E);
	}
	finally{
	System.out.println("Instalacion Finalizada...");
	System.out.println("Listo");
	}
	Licencia L=new Licencia();
	L.setBounds(0,0,530,600);
	L.setVisible(true);
	L.setLocationRelativeTo(null);
	L.setResizable(false);
	}



	}
}
