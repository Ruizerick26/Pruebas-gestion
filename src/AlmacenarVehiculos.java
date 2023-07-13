import java.io.*;
import java.util.Scanner;

public class AlmacenarVehiculos {
    public static void main(String[] args) {
        // Crear los objetos de vehículo
        Vehiculo vehiculo1 = new Vehiculo();
        Vehiculo vehiculo2 = new Vehiculo();
        Vehiculo vehiculo3 = new Vehiculo();

        // Array de vehículos
        Vehiculo[] vehiculos = {vehiculo1, vehiculo2, vehiculo3};

        // Nombre del archivo
        String nombres[]={"archivo1.txt","archivo2.txt","archivo3.txt"};

        Scanner rc = new Scanner(System.in);
        String modelo;
        String marca;
        String anio;
        for (int i = 0; i<vehiculos.length;i++){
            System.out.println("Ingrese La marca del vehiculo "+ (i+1));
            marca = rc.nextLine();
            vehiculos[i].setMarca(marca);
            System.out.println("Ingrese el modelo del vehiculo "+ (i+1));
            modelo = rc.nextLine();
            vehiculos[i].setModelo(modelo);
            System.out.println("Ingrese el año del vehiculo "+ (i+1));
            anio = rc.nextLine();
            vehiculos[i].setAnio(anio);
        }
        for(int i=0;i<nombres.length;i++) {
            try {
                // Crear un ObjectOutputStream para escribir objetos en el archivo
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombres[i]));

                // Escribir el array de vehículos en el archivo
                outputStream.writeObject(vehiculos[i]);

                // Cerrar el ObjectOutputStream
                outputStream.close();

                System.out.println("La información de los vehículos se ha almacenado en el archivo " + nombres[i]);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }


            // Leer la información de los vehículos desde el archivo
            try {
                // Crear un ObjectInputStream para leer objetos desde el archivo
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombres[i]));

                // Leer el array de vehículos desde el archivo
                Vehiculo[] vehiculosLeidos = (Vehiculo[]) inputStream.readObject();

                // Cerrar el ObjectInputStream
                inputStream.close();

                // Mostrar la información de los vehículos leídos
                for (Vehiculo vehiculo : vehiculosLeidos) {
                    System.out.println(vehiculo);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }
}
