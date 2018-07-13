/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Aul4-1
 */
public class Contacto implements Serializable{
    private String nombre;
    private int numero;
    private String direccion;
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", numero=" + numero + ", direccion=" + direccion + '}';
    }
    
    public void agregar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre.");
        this.nombre = sc.nextLine();
        System.out.println("Escribe el número.");
        this.numero = sc.nextInt();
    }
    
}
