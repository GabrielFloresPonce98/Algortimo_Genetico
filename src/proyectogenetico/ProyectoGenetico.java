
package proyectogenetico;

import java.util.Scanner;


public class ProyectoGenetico {

    public static void main(String[] args) {
        int TAMANIO = 0;
        Scanner Tecla = new Scanner(System.in);
        System.out.println("Cuantos individuos quiere generar?");
        Poblacion ObjePoblacion = new Poblacion(TAMANIO = Tecla.nextInt());
        System.out.println("MINIMO");
        ObjePoblacion.setMin(Tecla.nextInt());
        System.out.println("MAXIMO");
        ObjePoblacion.setMax(Tecla.nextInt());
        System.out.println("PRECISION");
        ObjePoblacion.setPre(Tecla.nextDouble());
        System.out.println("Metodo de seleccion: " + "\n"
                + "1. Ruleta" + "\n"
                + "2. Estocastico" + "\n"
                + "3. Torneo" + "\n"
                + "4. Restos" + "\n"
                + "5. Cruce" + "\n");
        ObjePoblacion.setOp(Tecla.nextInt());
        ObjePoblacion.llenarPoblacion();
        ObjePoblacion.imPoblacion();
        System.out.println(ObjePoblacion.getMsg() + "\t");
        System.out.println("CUANTAS GENERACIONES A GENERAR:");
        int GeneticoTam = Tecla.nextInt();
        ObjePoblacion.setTamBin(GeneticoTam);
        
        ObjePoblacion.Evolucion();
        ObjePoblacion.imPoblacion2();

        System.out.println(ObjePoblacion.getMsg2() + "\t");
        System.out.println("GENERACION: " + 1);
        int Contra = 1;
     
        while (Contra < GeneticoTam) {
            ObjePoblacion.EvolucionRep();
            ObjePoblacion.imPoblacion2();
            System.out.println(ObjePoblacion.getMsg2() + "\t");
Contra++;
        }
        ObjePoblacion.MejorMejor();

    }

}
