/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aul4-1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        ArrayList<Contacto> contactos = (ArrayList<Contacto>) leer();
        Contacto c;

        Scanner sc = new Scanner(System.in);
        boolean salir=false;
        while (!salir) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1 - Agregar contacto");
            System.out.println("2 - Ver contactos");
            System.out.println("3 - Guardar y Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Agrega el contacto");
                    c = new Contacto();
                    c.agregar();
                    contactos.add(c);
                    break;
                case 2:
                    for (int i = 0; i < contactos.size(); i++) {
                        System.out.println(contactos.get(i));
                    }
                    System.out.println("Prueba");
                    break;
                case 3:
                    escribir(contactos);
                    salir=true;
                    break;
            }
        }
    }

    public static void escribir(ArrayList contactos) {
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Object leer() {
        Object o = null;

        try {
            FileInputStream fos = new FileInputStream("data.dat");
            ObjectInputStream oos = new ObjectInputStream(fos);
            o = oos.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
