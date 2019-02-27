package Pantallas;

import java.util.ArrayList;

import algomon.Algomon;
import ataque.Ataque;
import elemento.Elemento;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import juego.ControladorJuego;

public class PanelTurno {
	
	private Button botonAtacar;
	private Button botonCambio;
	private Button botonElemento;
	private Button botonAtras;
	private TextArea display;
	private BorderPane pane;
	private ControladorJuego controlador;
	private PantallaJuego pantallaJuego;
	
	public PanelTurno(ControladorJuego controlador,PantallaJuego pantallajeugo ){
		this.controlador = controlador;
		this.pantallaJuego = pantallajeugo;
		this.pane = new BorderPane();
//		
//		GridPane layout = new GridPane();
//		layout.setPadding(new Insets(5));
//		layout.setAlignment(Pos.CENTER);
//		layout.setHgap(5);
//		layout.setVgap(5);
//		
//        this.display = new TextArea();
//        this.display.setPrefRowCount(4);
//        this.display.setWrapText(true);
//        this.display.setEditable(false);
//        this.display.setScrollTop(Double.MIN_VALUE); //autoscroll
//        
//        GridPane.setHalignment(this.display, HPos.CENTER);
//        layout.add(this.display, 0, 1);
//
//        String string = "Consola por donde se mostrara lo que sucede en forma de texto.";        
//        this.display.setText(string);

        GridPane layout2 = new GridPane();
		layout2.setPadding(new Insets(17));
  		layout2.setAlignment(Pos.BOTTOM_CENTER);
  		layout2.setHgap(17);
   		layout2.setVgap(17);
        
   		//this.botonAtacar = botonPanel("Atacar",listaOpcionAtaque(this.controlador.getAtaques()));
   		
        this.botonAtacar = new Button("Atacar");
        this.botonAtacar.setMinSize(80, 10);
        this.botonAtacar.setOnAction(e -> {
        	Panel panel = new Panel(this,this.controlador.getAtaques(),this.controlador,this.pantallaJuego);
        	panel.setTexto(listaOpcionAtaque(this.controlador.getAtaques()));
        	this.pane.setLeft(panel.getPanel());
        	setAtras(false);	
		});
        
        this.botonCambio = new Button("Algomones");
        this.botonCambio.setMinSize(80, 10);
        this.botonCambio.setOnAction(e -> {
        	Panel panel = new Panel(this,this.controlador.getAlgomonesVivos(),this.controlador,this.pantallaJuego);
        	panel.setTexto(listaOpcionAlgomon(this.controlador.getAlgomonesVivos()));
        	this.pane.setLeft(panel.getPanel());
        	setAtras(false);
		});
        
        
        this.botonElemento = new Button("Elementos");
        this.botonElemento.setMinSize(80, 10);
        this.botonElemento.setOnAction(e -> {
        	Panel panel = new Panel(this,this.controlador.getElementos(),this.controlador,this.pantallaJuego);
        	panel.setTexto(listaOpcionElemento(this.controlador.getElementos()));
        	this.pane.setLeft(panel.getPanel());
        	setAtras(false);
		});
        
        this.botonAtras = new Button("Atras");
        this.botonAtras.setMinSize(80, 10);
        this.botonAtras.setDisable(true);
        this.botonAtras.setOnAction(e -> {
        	this.pane.setLeft(null);
        	setAtras(true);
		});
        
        GridPane.setConstraints(this.botonAtacar, 0, 0);
        GridPane.setConstraints(this.botonCambio, 0, 1);
        GridPane.setConstraints(this.botonElemento, 1, 0);
        GridPane.setConstraints(this.botonAtras, 1, 1);
        layout2.getChildren().addAll(this.botonAtacar,this.botonCambio,this.botonElemento,this.botonAtras);
        
        this.pane.setRight(layout2);
		//this.pane.setBottom(layout);
		
	}



	private void setAtras(boolean var){
    	this.botonAtras.setDisable(var);
    	this.botonAtacar.setDisable(!var);
    	this.botonCambio.setDisable(!var);
    	this.botonElemento.setDisable(!var);
	}
	
	public void setAreaText(String string){
		//this.display.appendText("\n"+string);
	}
	
	public BorderPane getPanel(){
		return this.pane;
		
	}
	
	
	private String listaOpcionElemento (ArrayList<Elemento> lista){
		String texto="";
		for (Elemento i: lista) {
			texto+=  (lista.indexOf(i)+1)+") "+ i + "  cantidad=" +((i).getCantidad()) +"\n";
		}
		return texto;
	}
	private String  listaOpcionAlgomon(ArrayList<Algomon> lista){
		String texto="";
		for (Algomon i: lista) {
			texto+=  (lista.indexOf(i)+1)+") "+ i +"\n";
		}
		return texto;
	}
	private String listaOpcionAtaque (ArrayList<Ataque> lista){
		String texto="";
		for (Ataque i: lista) {
			texto+=  (lista.indexOf(i)+1)+") "+ i + "  cantidad=" +((i).getCantidad()) +"\n";
		}
		return texto;
	}

	public void finalizoEleccion() {
		this.pane.setLeft(null);
    	setAtras(true);
	}	
	
	public void setCambioObligado(){
		PanelCambioObligado panel = new PanelCambioObligado(this, this.controlador.getAlgomonesVivos(), this.controlador,this.pantallaJuego);
		panel.setTexto("Tu algomon murio! Elegí un algomon\n vivo de la siguiente lista:\n"+listaOpcionAlgomon(this.controlador.getAlgomonesVivos()));
		this.pane.setLeft(panel.getPanel());
		this.botonAtras.setDisable(true);
    	this.botonAtacar.setDisable(true);
    	this.botonCambio.setDisable(true);
    	this.botonElemento.setDisable(true);
	}
	
	public void setComentario(String string){
		this.pantallaJuego.setComentario(string);
	}
	
	
}
