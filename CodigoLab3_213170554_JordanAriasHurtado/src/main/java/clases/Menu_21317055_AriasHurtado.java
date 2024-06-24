package clases;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;

    public Menu_21317055_AriasHurtado() {
        scanner = new Scanner(System.in);
    }
    public void menuLoad() {
        int option;
        do{
            System.out.println("------------------- Sistema Metro - Cargar información del sistema de metro -------------------");
            System.out.println("Opciones: ");
            System.out.println("1. Creación de una línea de metro básica (cargar archivo lineas.txt)");
            System.out.println("2. Combinaciones entre estaciones entre Líneas  (cargar archivo combinaciones.txt)");
            System.out.println("3. Definición de trenes con distintos número de carros (cargar archivo trenes.txt)");
            System.out.println("4. Conductores asignados a una Línea (cargar archivo conductores.txt)");
            System.out.println("5. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(option != 5);
    }
    public void menuView(){
        int option;
        do {
            System.out.println("------------------- Sistema Metro - Visualización del estado actual del sistema de metros  -------------------");
            System.out.println("1. Desplegar en pantalla el estado actual de la red de metros.");
            System.out.println("2. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while (option != 2) ;
    }


    public void menuInteract(){
        int option;

        do {
            System.out.println("------------------- Sistema Metro - Interactuar con el sistema de metros -------------------");
            System.out.println("1. lineLength: obtener el largo total de una línea.");
            System.out.println("2. lineSectionLength: determinar el tracto entre una estación origen y final.");
            System.out.println("3. lineCost: determinar el costo total de recorrer una línea.");
            System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
            System.out.println("5. isLine: verificar si una línea cumple con las restricciones especificadas.");
            System.out.println("6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.");
            System.out.println("7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida");
            System.out.println("8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
            System.out.println("9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
            System.out.println("10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
            System.out.println("11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
            System.out.println("12. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default:
                    break;
            }
        }while (option != 12) ;
    }

}



