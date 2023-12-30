import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class Licencia extends JFrame implements ActionListener,ChangeListener{
	private JLabel label1,label2,label3;
	private JTextArea AREA;
	private JScrollPane DESPLAZAR;
	private JCheckBox CHECK1;
	private JButton BOTON1;
	String direccion="";
	String texto="";
	public Licencia(){
	setLayout(null);
	setTitle("License");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	


//ubicacion de archivo
	File Archivo;	//creo un archivo
	String bfReader="";	//variable almacenante
	direccion=System.getProperty("user.home");	//establesco la direccion


	Archivo=new File(direccion+"/PLC(Sources)/LICENSE.txt");//asigno ubicacion
	try{
	BufferedReader bf=new BufferedReader(new FileReader(Archivo));	//le digo el archivo
	while((bfReader=bf.readLine())!=null){	//Mientras encuentre mas texto
	texto=texto+bfReader+"\n";	//concateno y incorporo un salto de linea
	}
	}catch(Exception E){}

//agrego el icono al programa
	setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());


	label1=new JLabel("License");
	label1.setFont(new Font("Andale Mono",1,20));
	label1.setForeground(new Color(255,255,255));
	label1.setBounds(100,10,300,20);
	add(label1);
	
	AREA=new JTextArea();
	AREA.setText(texto);
	AREA.setEditable(false);
	DESPLAZAR=new JScrollPane(AREA);
	DESPLAZAR.setBounds(10,80,500,300);
	add(DESPLAZAR);
	
	CHECK1=new JCheckBox("I agree terms and conditions");
	CHECK1.setForeground(new Color(255,255,255));
	CHECK1.setBackground(new Color(155,155,255));
	CHECK1.setBounds(10,400,300,30);
	CHECK1.addChangeListener(this);
	add(CHECK1);

	BOTON1=new JButton("Next");
	BOTON1.setEnabled(false);
	BOTON1.setBackground(new Color(155,155,255));
	BOTON1.setForeground(new Color(255,255,255));
	BOTON1.setBounds(10,450,200,30);
	BOTON1.addActionListener(this);
	add(BOTON1);

	label2=new JLabel();
	label2.setBounds(0,0,530,600);
	add(label2);

	ImageIcon im=new ImageIcon(direccion+"/PLC(Sources)/1.PNG");
	Icon i=new ImageIcon(im.getImage().getScaledInstance(label2.getWidth(),label2.getHeight(),Image.SCALE_DEFAULT));
	label2.setIcon(i);

	}
public void stateChanged(ChangeEvent E){
	if(CHECK1.isSelected()==true){
	BOTON1.setEnabled(true);
	}else{
	BOTON1.setEnabled(false);
	}
}
public void actionPerformed(ActionEvent A){
	if(A.getSource()==BOTON1){
	//Acepto la licencia
	System.out.println("Licencia aceptada");

	String Lic="1";
	String NombreArchivo="License.bin";

	File Archivo1;
	FileWriter escribir;
	PrintWriter Lineas;
	String ruta=direccion+"/PLC(Sources)/"+NombreArchivo;
	System.out.println(ruta);
//Creacion del archivo
	Archivo1=new File(ruta);
	try{
	Archivo1.createNewFile();
	System.out.println("Creando archivo...");
	escribir=new FileWriter(Archivo1,true);
	Lineas=new PrintWriter(escribir);
	Lineas.println(Lic);
	Lineas.close();
	escribir.close();
	}catch(Exception E){
	System.out.println("Error al crear archivo..."+E);
	}finally{
	System.out.println("Licencia creada con exito");
	Cargando C=new Cargando();
	C.setBounds(0,0,500,200);
	C.setLocationRelativeTo(null);
	C.setVisible(true);
	C.setResizable(false);
	this.setVisible(false);
	}

	}
	}
public static void main(String args[]){
	Licencia L=new Licencia();
	L.setBounds(0,0,530,600);
	L.setVisible(true);
	L.setLocationRelativeTo(null);
	L.setResizable(false);
	}
}
