
package Controlador;
import Modelo.ModeloCrudUsuario;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Vista.VCrudUsuario;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.table.DefaultTableModel;

public class ControladorPrincipal implements ActionListener , MouseListener {
    
 /////////////////////////////////////////////////////// 
 // Definición de controles - vistas - modelos
 ///////////////////////////////////////////////////////    
    ControlLogin CL = new ControlLogin();
    ControlMenu CM = new ControlMenu();
    ControlCrudusuario CCU = new ControlCrudusuario();
    ControlAvanzado CA = new ControlAvanzado();
    ControlIntermedio CI = new ControlIntermedio();
    ControlPrincipiante CP = new ControlPrincipiante();
    
    Vista.VCrudUsuario CrudVista = new Vista.VCrudUsuario();
    Vista.VMenu VistaMenu = new Vista.VMenu();
    Vista.VAvanzado VistaAva = new Vista.VAvanzado();
    Vista.VIntermedio VistaInter = new Vista.VIntermedio();
    Vista.VPrincipiante VistaPri = new Vista.VPrincipiante();
    Vista.VLogin VistaLogin = new Vista.VLogin();

    ModeloLogin ML = new ModeloLogin();
    ModeloCrudUsuario ModeloCrud = new ModeloCrudUsuario();
    ModeloMenu MMen = new ModeloMenu();
    ModeloPrincipiante MPrincipiante = new ModeloPrincipiante();
    ModeloIntermedio MIntermedio = new ModeloIntermedio();
    ModeloAvanzado MAvanzado = new ModeloAvanzado();
  
 //////////////////////////////////////////////////////////// 
 //Variables globlales para almacenar Tipo Usuario y Punteo
 ///////////////////////////////////////////////////////////   
 String GTipoUsuario = "";
 String GUsuarioIngresado = "";
 int GPunteo = 0;
 int id1 = 0;
 int id2 = 0;
 int numRegistros;
 
 //////////////////////////////////////////////////////////// 
 //Variables globlales para almacenar resultado Principiante
 ///////////////////////////////////////////////////////////
 double totsuma1,totsuma2,totresta1,totresta2,totmult,totdiv;
 int puntosprincipante=0;
 int puntosintermedio=0;
 int puntosavanzado=0;
 
 private Object ActionEvent;
 
 //////////////////////////////////////////////////////////// 
 //1. Controlador del Login
 /////////////////////////////////////////////////////////// 
 public ControladorPrincipal (Vista.VLogin VistaLogin, ModeloLogin ML){
   this.ML = ML;
   this.VistaLogin = VistaLogin;
   
   VistaLogin.btnlogin.addActionListener(this);
   VistaLogin.btnsalir.addActionListener(this);
   VistaLogin.MsgLogin.addActionListener(this);     
 }    
   
 //////////////////////////////////////////////////////////// 
 //2. Controlador Vista Menu 
 /////////////////////////////////////////////////////////// 
// ControladorPrincipal (Vista.VMenu VistaMenu, ModeloMenu MMen
 public ControladorPrincipal (Vista.VMenu VistaMenu, ModeloMenu MMen ) {
 
    this.VistaMenu=VistaMenu;
    this.MMen = MMen;
   
     VistaMenu.btnsalir.addActionListener(this);
     VistaMenu.btnCrud.addActionListener(this);
     VistaMenu.btnImprimir.addActionListener(this);
     VistaMenu.btnAvanzado.addActionListener(this);
     VistaMenu.btnIntermedio.addActionListener(this);
     VistaMenu.btnPrincipiante.addActionListener(this);
//     VistaMenu.ComboTUsuario.addItemListener(this);
     
     
//     No es posible conservar que usuario ingreso en la ventana Login
//     MMen = CM.readTipoUsuario("admin");
//     GTipoUsuario = MMen.getTipousuario();
//     GTipoUsuario == "Administrador"

     VistaMenu.btnCrud.setVisible(false);
     VistaMenu.btnImprimir.setVisible(false);
     
     VistaMenu.btnIntermedio.setVisible(false);
     VistaMenu.btnPrincipiante.setVisible(false);
     VistaMenu.btnAvanzado.setVisible(false);
    
     MenuMostrarBoton();
      
} 
 
 //////////////////////////////////////////////////////////// 
 //3. Controlador Crud
 /////////////////////////////////////////////////////////// 
  public ControladorPrincipal (Vista.VCrudUsuario CrudVista, Modelo.ModeloCrudUsuario ModeloCrud  ){
    ControlCrudusuario MCrud = new ControlCrudusuario(); //Dao
    this.CrudVista = CrudVista;
    this.ModeloCrud= ModeloCrud;
   
    CrudVista.btncrearUsuario.addActionListener(this);
    CrudVista.btneliminarUsuario.addActionListener(this);
    CrudVista.btnactualizarUsuario.addActionListener(this);
    CrudVista.btnlimpiarUsuario.addActionListener(this);
    CrudVista.btnregresarUsuario.addActionListener(this);
    CrudVista.btnSeleccionar.addActionListener(this);
    
    llenarcombos();
    refrescarTabla();      
   }

  
 //////////////////////////////////////////////////////////// 
 //4. Controlador Principiante
 /////////////////////////////////////////////////////////// 
 public ControladorPrincipal (Vista.VPrincipiante VistaPri, ModeloPrincipiante MPrincipiante){
   this.MPrincipiante = MPrincipiante;
   this.VistaPri = VistaPri;
   
   VistaPri.btnStar.addActionListener(this);
   VistaPri.btnPuntaje.addActionListener(this);
   VistaPri.btnAvanza.addActionListener(this);
   VistaPri.btnSalirp.addActionListener(this);
     
     Limpiaroperadores();     
 }  
 
//////////////////////////////////////////////////////////// 
 //5. Controlador Intermedio
 /////////////////////////////////////////////////////////// 
  public ControladorPrincipal (Vista.VIntermedio VistaInter, ModeloIntermedio MIntermedio){
   this.MIntermedio = MIntermedio;
   this.VistaInter = VistaInter;
   
   VistaInter.btnVerificaIntermedio.addActionListener(this);
   VistaInter.btnAvanzaintermedio.addActionListener(this);
  
//   Limpiaroperadores2();   
 }  
 
  //////////////////////////////////////////////////////////// 
 //6. Controlador Avanzado
 /////////////////////////////////////////////////////////// 
  public ControladorPrincipal (Vista.VAvanzado VistaAva, ModeloAvanzado MAvanzado){
   this.MAvanzado = MAvanzado;
   this.VistaAva = VistaAva;
   
   VistaAva.btnStarAvanzado.addActionListener(this);
   VistaAva.btnVerificaAvanzado.addActionListener(this);
   VistaAva.btnsalirAvanzado.addActionListener(this);
   IniciarAvanzado();  
            
 }  
 
/////////////////////////////////////////////////////////// 
//Metodos MENU
/////////////////////////////////////////////////////////// 
// Determinar Botones a mostrar     
///////////////////////////////////////////////////////////
 
 public void MenuMostrarBoton() {

    
    
// Accion a realizar cuando el JComboBox cambia de item seleccionado.
VistaMenu.ComboTUsuario.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
        String NivelSeleccion = "";
        NivelSeleccion = VistaMenu.ComboTUsuario.getSelectedItem().toString();

        if (NivelSeleccion == "Administrador") {  
            VistaMenu.btnCrud.setVisible(true);
            VistaMenu.btnImprimir.setVisible(true);

            VistaMenu.btnIntermedio.setVisible(false);
            VistaMenu.btnPrincipiante.setVisible(false);
            VistaMenu.btnAvanzado.setVisible(false);
        }

       if (NivelSeleccion == "Avanzado") {  
            VistaMenu.btnCrud.setVisible(false);
            VistaMenu.btnImprimir.setVisible(false);
            VistaMenu.btnIntermedio.setVisible(false);
            VistaMenu.btnPrincipiante.setVisible(false);

            VistaMenu.btnAvanzado.setVisible(true);
         }

      if (NivelSeleccion == "Intermedio") {  
            VistaMenu.btnCrud.setVisible(false);
            VistaMenu.btnImprimir.setVisible(false);
            VistaMenu.btnAvanzado.setVisible(false);
            VistaMenu.btnPrincipiante.setVisible(false);

            VistaMenu.btnIntermedio.setVisible(true);
         }  

        if (NivelSeleccion == "Principiante") {  
            VistaMenu.btnCrud.setVisible(false);
            VistaMenu.btnImprimir.setVisible(false);
            VistaMenu.btnAvanzado.setVisible(false);
            VistaMenu.btnIntermedio.setVisible(false);

            VistaMenu.btnPrincipiante.setVisible(true);
         } 

        if (NivelSeleccion == "Seleccionar") {  
            VistaMenu.btnCrud.setVisible(false);
            VistaMenu.btnImprimir.setVisible(false);

            VistaMenu.btnIntermedio.setVisible(false);
            VistaMenu.btnPrincipiante.setVisible(false);
            VistaMenu.btnAvanzado.setVisible(false);
        }
        
        

        }
});
                





}

/////////////////////////////////////////////////////////// 
//Metodos CRUD
/////////////////////////////////////////////////////////// 
// CRUD Limpiar Usuario     
/////////////////////////////////////////////////////////// 
   
     public void limpliarUsuario(){
         
       this.CrudVista.txtIdusuario.setText("");
       this.CrudVista.txtnombreusuario.setText("");
       this.CrudVista.txtapellidousuario.setText("");
       this.CrudVista.txtedadusuario.setText("");
       this.CrudVista.txtuserusuario.setText("");
       this.CrudVista.txtpassusuario.setText("");
       this.CrudVista.comboestado.setSelectedItem(0);
       this.CrudVista.combodetipousuario.setSelectedItem(0);
       this.CrudVista.comboestado.removeAllItems();
       this.CrudVista.combodetipousuario.removeAllItems();
       
        refrescarTabla();
        llenarcombos();    
  } 
   
// CRUD Refrescar Tabla   
///////////////////////////////////////////////////////////
    public void refrescarTabla() {
  
    DefaultTableModel modeloT = new DefaultTableModel();
    CrudVista.tablaUsuario.setModel(modeloT);

    modeloT.addColumn("ID");
    modeloT.addColumn("Nombre");
    modeloT.addColumn("Apellido");
    modeloT.addColumn("Edad");
    modeloT.addColumn("User");
    modeloT.addColumn("Password");
    modeloT.addColumn("ID Estado");
    modeloT.addColumn("Tipo Usuario");

    Object [] columna = new Object [8];

       int    numRegistros  = CCU.LeerListausuario().size();

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = CCU.LeerListausuario().get(i).getId_usuario();
                columna[1] = CCU.LeerListausuario().get(i).getNombre_usuario();
                columna[2] = CCU.LeerListausuario().get(i).getApellido_usuario();
                columna[3] = CCU.LeerListausuario().get(i).getEdad_usuario();
                columna[4] = CCU.LeerListausuario().get(i).getUser();
                columna[5] = CCU.LeerListausuario().get(i).getPassword();
                columna[6] = CCU.LeerListausuario().get(i).getId_usuario();
                columna[7] = CCU.LeerListausuario().get(i).getId_tipo_usuario();
                modeloT.addRow(columna);

            }
    }  

// CRUD llenarcombos  
///////////////////////////////////////////////////////////
 public void llenarcombos() {
     
          CCU.ConsultarEstados(CrudVista.comboestado);
          CCU.ConsultarTipos(CrudVista.combodetipousuario);
         
          int id3 = 0;
          int id4 = 0;
          String estado_codigo, estado2_nombre;
          String tipo_codigo, tipo_nombre;
          
          estado_codigo = CrudVista.comboestado.getSelectedItem().toString();
          tipo_codigo = CrudVista.combodetipousuario.getSelectedItem().toString();
                   
          id3 = Integer.parseInt(estado_codigo);
          id4 = Integer.parseInt(tipo_codigo);
          
          ModeloCrud = CCU.readEstadoNombre(id3);
          ModeloCrud = CCU.readTipoUsuarioNombre(id4);
          
          estado2_nombre = ModeloCrud.getNombre_estado();
          tipo_nombre = ModeloCrud.getNombre_Tusuario();
          
          System.out.println(estado2_nombre);
          System.out.println(tipo_nombre);
          
          CrudVista.LabelEstado.setText(estado2_nombre);
          CrudVista.LabelTusuario.setText(tipo_nombre);
         
     }

/////////////////////////////////////////////////////////// 
//Metodos Principaiante
/////////////////////////////////////////////////////////// 
// PRINCIPIANTE Limpiar Operadores    
/////////////////////////////////////////////////////////// 
   
     public void Limpiaroperadores(){
       
     // Limpiar variables
     VistaPri.txtsuma1.setText("");
     VistaPri.txtsuma1.setText("");
     VistaPri.txtsuma2.setText("");
     VistaPri.txtsuma3.setText("");
     VistaPri.txtsuma4.setText("");
     VistaPri.txtresta1.setText("");
     VistaPri.txtresta2.setText("");
     VistaPri.txtresta3.setText("");
     VistaPri.txtresta4.setText("");
     VistaPri.txtmult1.setText("");
     VistaPri.txtmult2.setText("");
     VistaPri.txtdiv1.setText("");
     VistaPri.txtdiv2.setText("");
     VistaPri.txtsumares1.setText("");
     VistaPri.txtsumares2.setText("");
     VistaPri.txtrestares1.setText("");
     VistaPri.txtrestares2.setText("");
     VistaPri.txtmultres.setText("");
     VistaPri.txtdivres.setText("");
     VistaPri.MsgPrincipiante.setText("");
          
     VistaPri.txtsumares1.setBackground(Color.white);
     VistaPri.txtsumares2.setBackground(Color.white);
     VistaPri.txtrestares1.setBackground(Color.white);
     VistaPri.txtrestares2.setBackground(Color.white);
     VistaPri.txtmultres.setBackground(Color.white);
     VistaPri.txtdivres.setBackground(Color.white);
     
     VistaPri.ErrorR01.setText("");
     VistaPri.ErrorR02.setText("");
     VistaPri.ErrorR03.setText("");
     VistaPri.ErrorR04.setText("");
     VistaPri.ErrorR05.setText("");
     VistaPri.ErrorR06.setText("");
         
    // Asignar  Valores
    Integer int_rand = 0;
     
     String valrandom = "";
   
    // Calcular la 1er Suma
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+50);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtsuma1.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+39);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtsuma2.setText(valrandom);
     
     totsuma1 = 0;
     totsuma1 = Integer.parseInt(VistaPri.txtsuma1.getText())+Integer.parseInt(VistaPri.txtsuma2.getText());
     totsuma1 = Math.round(totsuma1*100.0)/100.0;
               
    // Calcular la 2da Suma        
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+45);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtsuma3.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+33);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtsuma4.setText(valrandom);
     
     totsuma2 = 0;
     totsuma2 = Integer.parseInt(VistaPri.txtsuma3.getText())+Integer.parseInt(VistaPri.txtsuma4.getText());
     totsuma2 = Math.round(totsuma2*100.0)/100.0;
            
    // Calcular la 1er Resta  
     
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+25);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtresta1.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(15-5+1)+18);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtresta2.setText(valrandom);
     
     totresta1 = 0;
     totresta1 = Integer.parseInt(VistaPri.txtresta1.getText())- Integer.parseInt(VistaPri.txtresta2.getText());
     totresta1 = Math.round(totresta1*100.0)/100.0;
 
    // Calcular la 2da Resta 
     
     int_rand = (int)Math.floor(Math.random()*(100-50+1)+45);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtresta3.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(18-8+1)+3);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtresta4.setText(valrandom);
     
     totresta2 = 0;
     totresta2 = Integer.parseInt(VistaPri.txtresta3.getText())- Integer.parseInt(VistaPri.txtresta4.getText());
     totresta2 = Math.round(totresta2*100.0)/100.0;

    // Calcular la Multiplicacion 
     
     int_rand = (int)Math.floor(Math.random()*(12-4+1)+2);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtmult1.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(8-3+1)+4);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtmult2.setText(valrandom);
     
     totmult = 0;
     totmult = Integer.parseInt(VistaPri.txtmult1.getText())* Integer.parseInt(VistaPri.txtmult2.getText()); 
     totmult = Math.round(totmult*100.0)/100.0;
 
    // Calcular la Division 
        
     int_rand = (int)Math.floor(Math.random()*(50-25+1)+12);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtdiv1.setText(valrandom);
     
     int_rand = (int)Math.floor(Math.random()*(15-4+1)+3);
     valrandom = String.valueOf(int_rand);
     VistaPri.txtdiv2.setText(valrandom);
    
     totdiv = 0;
     if (Integer.parseInt(VistaPri.txtdiv2.getText()) == 0.00) totdiv = 0.00;
     if (Integer.parseInt(VistaPri.txtdiv2.getText()) != 0.00) totdiv = 0.00; {
      totdiv = Integer.parseInt(VistaPri.txtdiv1.getText()) / Integer.parseInt(VistaPri.txtdiv2.getText()); 
     }      
      totdiv = Math.round(totdiv*100.0)/100.0;   
     
  } 

// PRINCIPIANTE CalcularPrincipiante  
///////////////////////////////////////////////////////////      
     public void CalcularPrincipiante(){
     
       puntosprincipante = 0;
       
       //Validar 1er Resultado   
       if (isNumeric(VistaPri.txtsumares1.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtsumares1.getText()) == totsuma1) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtsumares1.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtsumares1.getText()) != totsuma1) {
              VistaPri.txtsumares1.setBackground(Color.yellow);
        } 
           
       } else VistaPri.ErrorR01.setText("No es número / Blanco");
        
        //Validar 2do Resultado         
        if (isNumeric(VistaPri.txtsumares2.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtsumares2.getText()) == totsuma2) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtsumares2.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtsumares2.getText()) != totsuma2) {
              VistaPri.txtsumares2.setBackground(Color.yellow);
        } 
           
       } else VistaPri.ErrorR02.setText("No es número / Blanco");
        
      
        //Validar 3er Resultado         
       if (isNumeric(VistaPri.txtrestares1.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtrestares1.getText()) == totresta1) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtrestares1.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtrestares1.getText()) != totresta1) {
              VistaPri.txtrestares1.setBackground(Color.yellow);
        } 
           
       } else VistaPri.ErrorR03.setText("No es número / Blanco");
        
                
        //Validar 4to Resultado     
         if (isNumeric(VistaPri.txtrestares2.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtrestares2.getText()) == totresta2) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtrestares2.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtrestares2.getText()) != totresta2) {
              VistaPri.txtrestares2.setBackground(Color.yellow);
        } 
           
       } else VistaPri.ErrorR04.setText("No es número / Blanco");  
           
             
        //Validar 5to Resultado       
        if (isNumeric(VistaPri.txtmultres.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtmultres.getText()) == totmult) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtmultres.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtmultres.getText()) != totmult) {
              VistaPri.txtmultres.setBackground(Color.yellow);
        } 
           
       } else VistaPri.ErrorR05.setText("No es número / Blanco");  
        
             
        //Validar 6to Resultado  
        
        if (isNumeric(VistaPri.txtdivres.getText()) == true) {
           if (Integer.parseInt(VistaPri.txtdivres.getText()) == totdiv) {
              puntosprincipante = puntosprincipante + 5;
              VistaPri.txtdivres.setBackground(Color.green);
        }
          if (Integer.parseInt(VistaPri.txtdivres.getText()) != totdiv) {
              VistaPri.txtdivres.setBackground(Color.yellow);
        } 
          
       }    else VistaPri.ErrorR06.setText("No es número / Blanco");
        
        
        VistaPri.MsgPrincipiante.setText("");
        String MensajePri = "El Resultado obtenido fué de: " + Integer.toString(puntosprincipante) + " puntos";
        VistaPri.MsgPrincipiante.setText("no es numero / blanco");
        
        
        
   }
 
// INTERMEDIO Limpiar Variables  
///////////////////////////////////////////////////////////      
     public void IniciarIntermedio(){
     
      VistaInter.ComboP1.setForeground(Color.black);
      VistaInter.ComboP1.setForeground(Color.black);
      VistaInter.ComboP2.setForeground(Color.black);
      VistaInter.ComboP4.setForeground(Color.black);
      VistaInter.ComboP5.setForeground(Color.black);
      VistaInter.ComboP1.setForeground(Color.black);
      VistaInter.MsgIntermedio.setText("");
      puntosintermedio=0;
     }
     
// AVANZADO Limpiar Variables  
///////////////////////////////////////////////////////////      
     public void IniciarAvanzado(){
     
      VistaAva.txtamor.setText("");
      VistaAva.txtfeliz.setText("");
      VistaAva.txtpaz.setText("");
      VistaAva.txtvalores0a15.setText("");
      VistaAva.MsgAvanzado.setText("");
      VistaAva.ErrorNumero.setText("");
      VistaAva.NumeroxAdivinar.setText("");
      puntosavanzado=0;
      VistaAva.txtfeliz.setBackground(Color.white);
      VistaAva.txtpaz.setBackground(Color.white);
      VistaAva.txtamor.setBackground(Color.white);
      VistaAva.txtvalores0a15.setBackground(Color.white);
     }
   
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
        
     
/////////////////////////////////////////////////////////// 
// CAPTURA DE EVENTOS     
///////////////////////////////////////////////////////////   
    @Override
    public void actionPerformed(ActionEvent e) {
        
    //*****************************************************************************************
    //EVENTOS VENTANA LOGIN
    //****************************************************************************************
      if (e.getSource() == VistaLogin.btnlogin){
      
      //Control de errores en la ventana Login       
             Integer banderalogin = 0;
             
             //Valida que usuario y password no esten en blanco
             if (VistaLogin.txtuser.getText().isEmpty()) {
                 VistaLogin.MsgLogin.setText("Usuario / Contraseña vacio ... escriba texto");
                 banderalogin = 1;
                 }
             
             if (VistaLogin.txtpass.getText().isEmpty()) {
                 VistaLogin.MsgLogin.setText("Usuario / Contraseña vacio ... escriba texto");
                 banderalogin = 1;
             }  
              
            //Valida que usuario y password existan en la base de datos
             if (banderalogin == 0) {
                 
               ML.setUser(VistaLogin.txtuser.getText());
               ML.setPassword(VistaLogin.txtpass.getText());  
               
               String ErrorLogin="";
               String Contrasena="";
               
               ML = CL.readUsuarioSistema(VistaLogin.txtuser.getText(),VistaLogin.txtpass.getText());
               Contrasena = ML.getPassword2();
               
               
                 if (Contrasena != null && !Contrasena.isEmpty()) {
                     GUsuarioIngresado=VistaLogin.txtuser.getText();
                     
//                     System.out.println(Contrasena);
//                     ML = CL.readTipoUsuario(VistaLogin.txtuser.getText());
//                     GTipoUsuario = ML.getTipousuario();
//                     System.out.println(GTipoUsuario);
//                     
//                     ML = CL.readPunteo(VistaLogin.txtuser.getText());
//                     GPunteo = ML.getPunteo();
//                     System.out.println(GPunteo);  
                     
                     //Cerrar Ventana Login
                     VistaLogin.setVisible(false);
                     
                     //Abrir Venta Menu
                     ModeloMenu MMenu = new ModeloMenu();
                     ControladorPrincipal cm = new ControladorPrincipal(VistaMenu,MMenu);

                     VistaMenu.setVisible(true);
                     
                 }else{ VistaLogin.MsgLogin.setText("Usuario / Contraseña inválidos ... ingresar de nuevo"); }

             } // Bandera = 0
         
         } // Boton Login
  
 
 //*****************************************************************************************
 //EVENTOS MENU
 //******************************************************************************************
 //Accesar a la administración del CRUD
 if (e.getSource() == VistaMenu.btnCrud){
      
              VCrudUsuario VistaC = new VCrudUsuario();
              ModeloCrudUsuario ModeloCrud = new ModeloCrudUsuario();
              ControladorPrincipal c1 = new ControladorPrincipal(VistaC, ModeloCrud); 
              
              VistaMenu.setVisible(false);
              VistaC.setVisible(true);
  
 }
 //Accesar a nivel PRINCIPIANTE
  if (e.getSource() == VistaMenu.btnPrincipiante){
      
              Vista.VPrincipiante VistaP = new Vista.VPrincipiante();
              ModeloPrincipiante ModeloP = new ModeloPrincipiante();
              ControladorPrincipal cp = new ControladorPrincipal(VistaP, ModeloP); 
              
              VistaMenu.setVisible(false);
              VistaP.setVisible(true);
  
 }
 //Accesar a nivel INTERMEDIO
 if (e.getSource() == VistaMenu.btnIntermedio){
      
              Vista.VIntermedio VistaI = new Vista.VIntermedio();
              ModeloIntermedio ModeloI = new ModeloIntermedio();
              ControladorPrincipal cint = new ControladorPrincipal(VistaI, ModeloI); 
              
              VistaMenu.setVisible(false);
              VistaI.setVisible(true);
  
 }
  //Accesar a nivel AVANZADO
 if (e.getSource() == VistaMenu.btnAvanzado){
      
              Vista.VAvanzado VistaAva = new Vista.VAvanzado();
              ModeloAvanzado ModeloA = new ModeloAvanzado();
              ControladorPrincipal cava = new ControladorPrincipal(VistaAva, ModeloA); 
              
              VistaMenu.setVisible(false);
              VistaAva.setVisible(true);
  
 }
  
  
  
 
 //*******************************************************************************************************
 //EVENTOS CRUD
 //******************************************************************************************************
 //Crear usuario del sistema
  if (e.getSource() == CrudVista.btncrearUsuario) {
          // Crear usuarios
            ModeloCrud.setNombre_usuario(CrudVista.txtnombreusuario.getText());    
            ModeloCrud.setApellido_usuario(CrudVista.txtapellidousuario.getText());
            ModeloCrud.setEdad_usuario(Integer.parseInt(CrudVista.txtedadusuario.getText()));
            ModeloCrud.setUser(CrudVista.txtuserusuario.getText());
            ModeloCrud.setPassword(CrudVista.txtpassusuario.getText());
            ModeloCrud.setId_estado(Integer.parseInt(CrudVista.comboestado.getSelectedItem().toString()));
            ModeloCrud.setId_tipo_usuario(Integer.parseInt(CrudVista.combodetipousuario.getSelectedItem().toString()));

            if (CCU.crearUsuario(ModeloCrud)) {
                JOptionPane.showMessageDialog(this.CrudVista, "Se inserto los datos ");
//                 CCU.crearScore(ModeloCrud);
            } else {

                JOptionPane.showMessageDialog(this.CrudVista, "no se inserto los registros");
            }
           limpliarUsuario();        
        }
  
  //Suprimir usuario del sistema
    if (e.getSource() == CrudVista.btneliminarUsuario) {

    int x = JOptionPane.showConfirmDialog(this.CrudVista, "Esta seguro de eliminar fila");
    if (x == 0 && id1 > 0) {
        if (CCU.eliminarUsuario(id1)) {
            JOptionPane.showMessageDialog(this.CrudVista, "Se Elimino registro");
//            CCU.eliminarScore(id1);
        } else {
            JOptionPane.showMessageDialog(this.CrudVista, "No se Elimino registro");
        }
    }
     limpliarUsuario();
    }
 
  //Actualizar usuario del sistema
     if (e.getSource() == CrudVista.btnactualizarUsuario) {

        ModeloCrud.setNombre_usuario(CrudVista.txtnombreusuario.getText());    
        ModeloCrud.setApellido_usuario(CrudVista.txtapellidousuario.getText());
        ModeloCrud.setEdad_usuario(Integer.parseInt(CrudVista.txtedadusuario.getText()));
        ModeloCrud.setUser(CrudVista.txtuserusuario.getText());
        ModeloCrud.setPassword(CrudVista.txtpassusuario.getText());
        ModeloCrud.setId_estado(Integer.parseInt(CrudVista.comboestado.getSelectedItem().toString()));
        ModeloCrud.setId_tipo_usuario(Integer.parseInt(CrudVista.combodetipousuario.getSelectedItem().toString()));

        if (!CCU.ActualizarUsuario(ModeloCrud)) {
            JOptionPane.showMessageDialog(this.CrudVista, "No se actualizo registro");
            CCU.ActualizarUsuario(ModeloCrud);
        }
        limpliarUsuario();
    }

 //Limpiar información usuario
        if (e.getSource() == CrudVista.btnlimpiarUsuario) {
            this.limpliarUsuario();
        }
        
 //Seleccionar registros del Grid   
        if (e.getSource () == CrudVista.btnSeleccionar) {
            
            System.out.println("estoy aqui");
            int fila = CrudVista.tablaUsuario.getSelectedRow();
            
            id1 = Integer.parseInt(CrudVista.tablaUsuario.getValueAt(fila, 0).toString());
            
            System.out.println(id1);
            ModeloCrud = CCU.MostrarUsuario(id1);
            
            CrudVista.txtIdusuario.setText("" + ModeloCrud.getId_usuario());
            CrudVista.txtnombreusuario.setText(ModeloCrud.getNombre_usuario());
            CrudVista.txtapellidousuario.setText(ModeloCrud.getApellido_usuario());
            CrudVista.txtedadusuario.setText((ModeloCrud.getEdad_usuario().toString()));
            CrudVista.txtuserusuario.setText(ModeloCrud.getUser());
            CrudVista.txtpassusuario.setText(ModeloCrud.getPassword());
            this.CrudVista.comboestado.setSelectedItem(0);
            this.CrudVista.combodetipousuario.setSelectedItem(0);

            CrudVista.comboestado.addItem(ModeloCrud.getId_estado().toString());
            CrudVista.combodetipousuario.addItem(ModeloCrud.getId_tipo_usuario().toString());
        }
     
      //Retorno a Menu Principal    
          if (e.getSource() == CrudVista.btnregresarUsuario) {
              
              Vista.VMenu VistaM = new Vista.VMenu();
              ModeloMenu MMenu = new ModeloMenu();
              ControladorPrincipal c2 = new ControladorPrincipal(VistaM, MMenu);
              
              CrudVista.setVisible(false);
              VistaM.setVisible(true);
        }
        
   
 //**********************************************************************************************************
 //EVENTOS PRINCIPIANTE
 //*********************************************************************************************************
 if (e.getSource() == VistaPri.btnStar){
           Limpiaroperadores();       
  }
 
 if (e.getSource() == VistaPri.btnPuntaje){
       CalcularPrincipiante(); 
 }
 
  if (e.getSource() == VistaPri.btnAvanza){
       if (puntosprincipante == 30) {
         Vista.VIntermedio VistaI2 = new Vista.VIntermedio();
         ModeloIntermedio ModeloI2 = new ModeloIntermedio();
         ControladorPrincipal cint2 = new ControladorPrincipal(VistaI2, ModeloI2); 
        VistaPri.setVisible(false);
        VistaI2.setVisible(true);
      }
  }
   
 //*****************************************************************************************************
 //EVENTOS INTERMEDIO
 //*****************************************************************************************************
  if (e.getSource() == VistaInter.btnVerificaIntermedio){
     
      String Resultado1 ="15 DE SEPTIEMBRE 1821";
      String Resultado2 ="VOLCAN TAJUMULCO";
      String Resultado3 ="LAGO DE IZABAL";
      String Resultado4 ="JORGE UBICO";
      String Resultado5 ="51";
      
      puntosintermedio=0;
  
     
      //obtener resultado 1
      if (VistaInter.ComboP1.getSelectedItem()== Resultado1) {
           VistaInter.ComboP1.setForeground(Color.green);
           puntosintermedio=puntosintermedio + 5;
      }
      if (VistaInter.ComboP1.getSelectedItem()!= Resultado1) {
           VistaInter.ComboP1.setForeground(Color.red);
     }
      
      //obtener resultado 2
      if (VistaInter.ComboP2.getSelectedItem()== Resultado2) {
           VistaInter.ComboP2.setForeground(Color.green);
           puntosintermedio=puntosintermedio + 5;
      }
      if (VistaInter.ComboP2.getSelectedItem()!= Resultado2) {
           VistaInter.ComboP2.setForeground(Color.red);
     }  
      
      //obtener resultado 3
      if (VistaInter.ComboP3.getSelectedItem()== Resultado3) {
           VistaInter.ComboP3.setForeground(Color.green);
           puntosintermedio=puntosintermedio + 5;
      }
      if (VistaInter.ComboP3.getSelectedItem()!= Resultado3) {
           VistaInter.ComboP3.setForeground(Color.red);
     }   
      
     //obtener resultado 4
      if (VistaInter.ComboP4.getSelectedItem()== Resultado4) {
           VistaInter.ComboP4.setForeground(Color.green);
           puntosintermedio=puntosintermedio + 5;
      }
      if (VistaInter.ComboP4.getSelectedItem()!= Resultado4) {
           VistaInter.ComboP4.setForeground(Color.red);
     }  
     
          //obtener resultado 5
      if (VistaInter.ComboP5.getSelectedItem()== Resultado5) {
           VistaInter.ComboP5.setForeground(Color.green);
           puntosintermedio=puntosintermedio + 5;
      }
      if (VistaInter.ComboP5.getSelectedItem()!= Resultado5) {
           VistaInter.ComboP5.setForeground(Color.red);
     } 
     
       VistaInter.MsgIntermedio.setText("");
        String MensajeInter = "El Resultado obtenido fué de: " + Integer.toString(puntosintermedio) + " puntos";
        VistaInter.MsgIntermedio.setText(MensajeInter);
      
      
  }
  if (e.getSource() == VistaInter.btnAvanzaintermedio){
      
         
       if (puntosintermedio == 25) {
           
         Vista.VAvanzado VistaAv = new Vista.VAvanzado();
         ModeloAvanzado ModeloAva = new ModeloAvanzado();
         ControladorPrincipal cint2 = new ControladorPrincipal(VistaAv, ModeloAva); 
              
        VistaInter.setVisible(false);
        VistaAv.setVisible(true);
          
      }
     
 }
  if (e.getSource() == VistaInter.btnLimpiarIntermedio){
      
         IniciarIntermedio();
     
 }
  
  //*******************************************************************************************************
 //EVENTOS AVANZADO
 //*******************************************************************************************************
  
  if (e.getSource() == VistaAva.btnStarAvanzado){
      
      IniciarAvanzado();        
  }
  
 if (e.getSource() == VistaAva.btnVerificaAvanzado){
     
      puntosavanzado=0;
      String ResultadoA1 = "";
      String ResultadoA2 = "";
      String ResultadoA3 = "";
      
      String Palabra1 = "HAPPY";
      String Palabra2 = "PEACE";
      String Palabra3 = "LOVE";
      
      String Adivina = "";
      Integer AdivinaN = 0;
      
      // Adivinar numero de 0 al 15
      Integer int_randA = (int)Math.floor(Math.random()*(15-0+1)+0);
          
      Adivina = VistaAva.txtvalores0a15.getText();
      if (isNumeric(Adivina) == true) {
            AdivinaN = Integer.parseInt(Adivina);
            if (AdivinaN == int_randA) {
                puntosavanzado = puntosavanzado + 5;
                VistaAva.txtvalores0a15.setBackground(Color.green);
            }
            else VistaAva.txtvalores0a15.setBackground(Color.yellow);
            
            
        } else { VistaAva.ErrorNumero.setText("No es un numero .. ");      
                   
        }
      
      // Verifica la palabra traducida FELIZ en MAYUSCULAS
        ResultadoA1 = VistaAva.txtfeliz.getText();
        if (ResultadoA1.equalsIgnoreCase(Palabra1))
         {
                puntosavanzado = puntosavanzado + 5;
                VistaAva.txtfeliz.setBackground(Color.green);
          }
        else VistaAva.txtfeliz.setBackground(Color.yellow);

     // Verifica la palabra traducida PAZ en MAYUSCULAS
      ResultadoA2 = VistaAva.txtpaz.getText();
       if (ResultadoA2.equalsIgnoreCase(Palabra2)) {
                puntosavanzado = puntosavanzado + 5;
                VistaAva.txtpaz.setBackground(Color.green);
          }
        else VistaAva.txtpaz.setBackground(Color.yellow);
        
     // Verifica la palabra traducida AMOR en MAYUSCULAS
        ResultadoA3 = VistaAva.txtamor.getText();
        if (ResultadoA3.equalsIgnoreCase(Palabra3)) {
                puntosavanzado = puntosavanzado + 5;
                VistaAva.txtamor.setBackground(Color.green);
          }
        else VistaAva.txtamor.setBackground(Color.yellow);   
 
        VistaAva.MsgAvanzado.setText("");
        VistaAva.NumeroxAdivinar.setText("");
        VistaAva.NumeroxAdivinar.setText(Integer.toString(int_randA));
        
        
        String MensajeAvan = "El Resultado obtenido fué de: " + Integer.toString(puntosavanzado) + " puntos";
        VistaAva.MsgAvanzado.setText(MensajeAvan);
             
  }
  

  
       
      }  //actionPerformed
    
      


    @Override
    public void mouseClicked(MouseEvent e) {
     
         
    } //mouseClicked
    
          

    @Override
    public void mousePressed(MouseEvent e) {       
    }

    @Override
    public void mouseReleased(MouseEvent e) {        
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {      
    }
    

    @Override
    public void mouseExited(MouseEvent e) {     
    }


      
    
} //Public Class

