/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

/**
 *
 * @author PC
 */
public class HelperFunctions {
    // Método estático para validar un email
    public static boolean esEmailValido(String email) {
        if (email == null) {
            return false;
        }

        // Verifica que el email contenga '@' y '.' después del '@'
        int indexArroba = email.indexOf('@');
        int indexPunto = email.lastIndexOf('.');

        // Debe tener un '@', un '.' después del '@', y algo antes y después de esos caracteres
        return indexArroba > 0 && indexPunto > indexArroba + 1 && indexPunto < email.length() - 1;
    }
}
