/*
Creado por Emmanuel Acoltzi Bautista
fecha de creacion:01/09/2023
Correo:basedeemma@gmail.com
*/
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Robot extends JFrame implements ActionListener{
	private JTextField TEXTO1,TEXTO2;
	private JTextArea AREA;
	private JScrollPane DESPLAZAR;
	private JButton BOTON1,BOTON2,BOTON3,BOTON4,BOTON5;
	private JPanel PANEL;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
	private JMenuBar BAR;
	private JMenu MENU1,MENU2;
	private JMenuItem item1,item2,item3,item4,item5;
	String temp="";
	String texto="";
	String direccion=System.getProperty("user.home");
//escala
	public static int escala=10;

	public Robot(String texto){
	this.texto=texto;
	System.out.println(direccion+"/");
	setLayout(null);
//para la optimizacion
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("PLC");

//agrego el constructor es decir la parte visual

	BAR=new JMenuBar();
	BAR.setForeground(new Color(255,255,255));
	BAR.setBackground(new Color(155,155,255));
	setJMenuBar(BAR);
	

	MENU1=new JMenu("Options");
	MENU1.setForeground(new Color(255,255,255));
	MENU1.setBackground(new Color(155,155,255));
	BAR.add(MENU1);

	item1=new JMenuItem("Save");
	item1.setForeground(new Color(255,255,255));
	item1.setBackground(new Color(155,155,255));
	item1.addActionListener(this);
	MENU1.add(item1);

	item2=new JMenuItem("Open");
	item2.setForeground(new Color(255,255,255));
	item2.setBackground(new Color(155,155,255));
	item2.addActionListener(this);
	MENU1.add(item2);

	item5=new JMenuItem("Nuevo");
	item5.setForeground(new Color(255,255,255));
	item5.setBackground(new Color(155,155,255));
	item5.addActionListener(this);
	MENU1.add(item5);


	MENU2=new JMenu("About");
	MENU2.setForeground(new Color(255,255,255));
	MENU2.setBackground(new Color(155,155,255));
	BAR.add(MENU2);


	item3=new JMenuItem("The programmer");
	item3.setForeground(new Color(255,255,255));
	item3.setBackground(new Color(155,155,255));
	item3.addActionListener(this);
	MENU2.add(item3);

	item4=new JMenuItem("The software");
	item4.setForeground(new Color(255,255,255));
	item4.setBackground(new Color(155,155,255));
	item4.addActionListener(this);
	MENU2.add(item4);

//agrego el icono al programa
	setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());

	label1=new JLabel("PLC");
	label1.setForeground(new Color(255,255,255));
	label1.setFont(new Font("Andale Mono",1,25));
	label1.setBounds(300,0,200,30);
	add(label1);

	PANEL=new JPanel();
	PANEL.setBounds(10,40,400,400);
	add(PANEL);

	AREA=new JTextArea(texto);
	AREA.setBackground(new Color(155,155,255));
	AREA.setForeground(new Color(255,255,255));
	AREA.setFont(new Font("Andale Mono",1,20));
	DESPLAZAR=new JScrollPane(AREA);
	DESPLAZAR.setBounds(10,450,400,120);
	add(DESPLAZAR);	

	BOTON1=new JButton("Run");
	BOTON1.setBackground(new Color(155,155,255));
	BOTON1.setForeground(new Color(255,255,255));
	BOTON1.setFont(new Font("Andale Mono",1,20));
	BOTON1.setBounds(420,450,200,30);
	BOTON1.addActionListener(this);
	add(BOTON1);

	BOTON4=new JButton("Reset All");
	BOTON4.setBackground(new Color(155,155,255));
	BOTON4.setForeground(new Color(255,255,255));
	BOTON4.setFont(new Font("Andale Mono",1,20));
	BOTON4.setBounds(420,100,200,30);
	BOTON4.addActionListener(this);
	add(BOTON4);

	BOTON5=new JButton("Reset Panel");
	BOTON5.setBackground(new Color(155,155,255));
	BOTON5.setForeground(new Color(255,255,255));
	BOTON5.setFont(new Font("Andale Mono",1,20));
	BOTON5.setBounds(420,130,200,30);
	BOTON5.addActionListener(this);
	add(BOTON5);


	label10=new JLabel("Scale:");
	label10.setFont(new Font("Andale Mono",1,20));
	label10.setForeground(new Color(255,255,255));
	label10.setBounds(420,50,200,30);
	add(label10);

	BOTON2=new JButton("-");
	BOTON2.setBackground(new Color(155,155,255));
	BOTON2.setForeground(new Color(255,255,255));
	BOTON2.setFont(new Font("Andale Mono",1,20));
	BOTON2.setFont(new Font("Andale Mono",1,15));
	BOTON2.setBounds(630-100,50,50,30);
	BOTON2.addActionListener(this);
	add(BOTON2);

	TEXTO2=new JTextField("10");
	TEXTO2.setHorizontalAlignment(JTextField.CENTER);
	TEXTO2.setBackground(new Color(155,155,255));
	TEXTO2.setForeground(new Color(255,255,255));
	TEXTO2.setFont(new Font("Andale Mono",1,20));
	TEXTO2.setEditable(false);
	TEXTO2.setBounds(680-100,50,30,30);
	add(TEXTO2);
	
	BOTON3=new JButton("+");
	BOTON3.setBackground(new Color(155,155,255));
	BOTON3.setForeground(new Color(255,255,255));
	BOTON3.setFont(new Font("Andale Mono",1,20));
	BOTON3.setFont(new Font("Andale Mono",1,15));
	BOTON3.setBounds(710-100,50,50,30);
	BOTON3.addActionListener(this);
	add(BOTON3);

	label5=new JLabel("L=Left");
	label5.setBounds(420,150,200,30);
	add(label5);


	label6=new JLabel("R=Right");
	label6.setBounds(420,170,200,30);
	add(label6);

	label7=new JLabel("D=Down");
	label7.setBounds(420,190,190,30);
	add(label7);

	label8=new JLabel("U=Up");
	label8.setBounds(420,210,210,30);
	add(label8);


	label3=new JLabel("By Emmanuel Acoltzi Bautista ©");
	label3.setBounds(200,590,300,30);
	add(label3);

	label4=new JLabel();
	label4.setBounds(0,0,700,700);
	add(label4);

//agrego el fondo del programa

	ImageIcon im=new ImageIcon(direccion+"/PLC-Sources/1.PNG");
	Icon i=new ImageIcon(im.getImage().getScaledInstance(label4.getWidth(),label4.getHeight(),Image.SCALE_DEFAULT));
	label4.setIcon(i);


	}
@Override
public void actionPerformed(ActionEvent A){
//si toca el boton1 que es de run
	if(A.getSource()==BOTON1){
//obtengo el codigo
	String Texto=AREA.getText();
//mando a llamar y envio datos
	PINTAR P=new PINTAR(PANEL,Texto,escala);
	P.Pain();
	}
	
//boton3=decrementar
	if(A.getSource()==BOTON2){
	if(escala>1){//mayor a 1 para que no llegue a escala 0
	escala=escala-1;
	TEXTO2.setText(""+escala);
	}else{//si es 1 que ya no siga decrementando
	TEXTO2.setText(""+escala);
	}
	}
	if(A.getSource()==BOTON3){//que incremente
	escala=escala+1;
	TEXTO2.setText(""+escala);
	}
	if(A.getSource()==BOTON4){
	dispose();
	Robot R=new Robot("");
	R.setBounds(0,0,700,700);
	R.setLocationRelativeTo(null);
	R.setVisible(true);
	R.setResizable(false);
	this.setVisible(false);	
	PINTAR P=new PINTAR(PANEL,"",escala);//envio valores

	P.ancho=200;//le digo que resetee todos los valores
	P.alto=200;
	}





	if(A.getSource()==BOTON5){
	String texto1=AREA.getText();
//	System.out.println("boton5");
	dispose();
	Robot R=new Robot(texto1);
	R.setBounds(0,0,700,700);
	R.setLocationRelativeTo(null);
	R.setVisible(true);
	R.setResizable(false);
	this.setVisible(false);	
	PINTAR P=new PINTAR(PANEL,"",escala);//envio valores

	P.ancho=200;//le digo que resetee todos los valores
	P.alto=200;
	}




//item1 guarda archivo


	if(A.getSource()==item1){
//obtengo el codigo
	String Texto=AREA.getText();
//pregunto el nombre del archivo
	String NOMBREARCHIVO="";
	NOMBREARCHIVO=JOptionPane.showInputDialog(null,"File name:");
	File Archivo;
//creo el archivo y lo que edita el doc y imprime
	FileWriter escribir;
	PrintWriter Lineas;
//pregunto la ruta
	String ruta=System.getProperty("user.home");
	String r=ruta+"/Desktop/"+NOMBREARCHIVO+".bin";
//creo el archivo y asigno la ubicacion
	Archivo=new File(r);
	try{
//le digo que lo cree
	Archivo.createNewFile();
//le digo que lo edite
	escribir=new FileWriter(Archivo,true);
//le asigno informacion al doc
	Lineas=new PrintWriter(escribir);
	Lineas.println(Texto);
	Lineas.close();
	escribir.close();
	}catch(Exception E){
	System.out.println(E);
	}
	JOptionPane.showMessageDialog(null,"File created successfully");
	}


//item2 abro un archivo


	if(A.getSource()==item2){
//creo un archivo
	File Archivo;
//pregunto el nombre del archivo
	String NOMBREARCHIVO=JOptionPane.showInputDialog(null,"What the file is called");
//ubico la ruta
	String ruta=System.getProperty("user.home");
	String root=ruta+"/Desktop/"+NOMBREARCHIVO+".bin";
	System.out.println(root);
//agrego la ruta a un archivo
	Archivo=new File(root);
	try{
//le digo en donde esta
	BufferedReader bf=new BufferedReader(new FileReader(Archivo));
//le creo algo para que lo lea	
	String bfReader;

//mientas tenga lineas que las lea siempre y cuando siga teniendo texto
	while((bfReader=bf.readLine())!=null){
//lo agrego
	temp=temp+bfReader+"\n";
	}
//asigno
	texto=temp;
	}catch(Exception E){
	}
//lo imprimo
	System.out.println(texto);
	AREA.setText(texto);
	}

//item3 es creador
	if(A.getSource()==item3){
	JOptionPane.showMessageDialog(null,"By Emmanuel Acoltzi Bautista © \n basedeemma@gmail.com");
	}
//item4 es programa
	if(A.getSource()==item4){
	JOptionPane.showMessageDialog(null,"PLC Designed for educational purposes \n\n\n PLC Version 1.0 \n All rights reserves ©");
	}


	if(A.getSource()==item5){
	Robot R=new Robot("");
	R.setBounds(0,0,700,600);
	R.setLocationRelativeTo(null);
	R.setVisible(true);
	R.setResizable(false);

	}

}
public static void main(String args[]){
//lo que establece como va a estar el programa
	Robot R=new Robot("");
	R.setBounds(0,0,700,700);
	R.setLocationRelativeTo(null);
	R.setVisible(true);
	R.setResizable(false);
	}
}
