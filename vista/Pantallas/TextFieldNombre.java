package Pantallas;

import javafx.scene.control.TextField;

/**
 * Created by Rodrigo on 25-Nov-16.
 */
public class TextFieldNombre extends TextField {

    private boolean validado;

    public TextFieldNombre(){

        this.validado = false;
    }


    public void validar(){

        this.validado = true;
    }


    public boolean getValidado(){

        return this.validado;
    }
}
