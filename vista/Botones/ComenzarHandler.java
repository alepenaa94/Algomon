package Botones;

import Pantallas.*;
import Partida.NombreJugadorRepetidoError;
import Partida.NombreVacioError;
import algomon.PantallaSeleccionAlgomon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import juego.ControladorJuego;


/**
 * Created by Rodrigo on 24-Nov-16.
 */
public class ComenzarHandler implements EventHandler<ActionEvent>{

    private  TextField infoJugador2;
    private  TextField infoJugador1;
    private Button boton;
    private TextFieldNombre areaJugador1;
    private TextFieldNombre areaJugador2;
    private Pantalla pantalla;
    private ControladorJuego controladorJuego;
	private NavegadorPantallas navegador;


    public ComenzarHandler(Button botonComenzar, TextFieldNombre area1, TextFieldNombre area2, TextField infoJugador1,
                           TextField infoJugador2, PantallaSeleccion pantallaSeleccion, ControladorJuego controlador,NavegadorPantallas navegador) {

        this.boton = botonComenzar;
        this.areaJugador1 = area1;
        this.areaJugador2 = area2;
        this.pantalla = pantallaSeleccion;
        this.controladorJuego = controlador;
        this.infoJugador1 = infoJugador1;
        this.infoJugador2 = infoJugador2;
        this.navegador = navegador;

    }


    @Override
    public void handle(ActionEvent event) {

        this.validar(this.areaJugador1,this.infoJugador1);
        this.validar(this.areaJugador2,this.infoJugador2);

        if ( this.areaJugador1.getValidado()
                &&  this.areaJugador2.getValidado()){
			PantallaSeleccionAlgomon seleccionAlgomon = new PantallaSeleccionAlgomon(this.navegador,this.pantalla.getStage(),this.pantalla.getControlador());
			seleccionAlgomon.setId("seleccionAlgomon");
			this.navegador.agregarPantalla("seleccionAlgomon", seleccionAlgomon.getRoot());
            this.pantalla.irAPantalla("seleccionAlgomon");          
        }

    }



    private void validar(TextFieldNombre areaJugador, TextField infoJugador) {

        if (!areaJugador.getValidado()){

            try {
                this.controladorJuego.getPartida().crearYAgregarJugador(areaJugador.getText().trim());
                infoJugador.setStyle("-fx-text-inner-color: #ff0a00;");
                infoJugador.setText("");
                areaJugador.validar();
                areaJugador.setDisable(true);
            }catch (NombreJugadorRepetidoError error1){

            	infoJugador.setStyle("-fx-text-transform: capitalize;  -fx-background-color: rgba(255, 0, 0, 0.8); -fx-background-radius: 10;");
                infoJugador.setText("El nombre ya fue usado");
                areaJugador.requestFocus();
            }
            catch (NombreVacioError error2){
            	infoJugador.setStyle("-fx-text-transform: capitalize;  -fx-background-color: rgba(255, 0, 0, 0.8); -fx-background-radius: 10;");
                infoJugador.setText("Debe ingresar un nombre");
                areaJugador.requestFocus();
            }
        }

    }


}
