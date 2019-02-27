package algomon;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import juego.ControladorJuego;

public class PanelInformacion extends StackPane {

	private ControladorJuego controlador;
	private Algomon algomon;
	private TreeItem<String> rootTree;
	
	public PanelInformacion(ControladorJuego controlador){
		this.controlador = controlador;
		setMaxSize(150, 400);
		setPadding(new Insets(0, 15, 0, 0));		
		
		this.rootTree = new TreeItem<String> ();
		this.limpiarInformacion();
		
		TreeView<String> tree = new TreeView<String> (rootTree); 
		tree.setShowRoot(false);
		
		getChildren().add(tree);
	}
	
	public void limpiarInformacion() {
		this.rootTree.getChildren().add( obtenerInformacion("Ataques", null) );		     
		this.rootTree.getChildren().add( obtenerInformacion("Vida",null) );;	
	}

	private TreeItem<String> obtenerInformacion(String texto, ArrayList lista){
		TreeItem<String> rootItem = new TreeItem<String> (texto);
		rootItem.setExpanded(true);
		if ( lista != null ){
			for (int i = 0; i < lista.size(); i++) {
			    TreeItem<String> item = new TreeItem<String> (lista.get(i).toString());            
			    rootItem.getChildren().add(item);
			}        
		}
		return rootItem;
	}

	public void setAlgomon(Algomon algomon) {
		this.algomon = algomon;		
	}

	public void actualizarInformacion() {
		this.rootTree.getChildren().clear();
		this.rootTree.getChildren().add( obtenerInformacion("Ataques", this.controlador.getAtaques(this.algomon)) );		     
		this.rootTree.getChildren().add( obtenerInformacion("Vida", this.controlador.getVida(this.algomon)) );;
	}
	
	
}
