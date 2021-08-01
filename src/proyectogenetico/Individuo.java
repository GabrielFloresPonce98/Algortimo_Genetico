/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogenetico;

import java.text.DateFormat;
import java.text.DecimalFormat;

public class Individuo {

     private int intv;

    private double fenotipo;
    private double adaptacion;
    private double proAdaptacio;
    private double sumAdaptacio;
    private double evaluacion;

    private String selecCadena;
    private String Cruce;
    private String mutacion;
    private String genoCad;

    public Individuo() {
mutacion=Cruce=selecCadena = genoCad = "";
evaluacion=fenotipo =adaptacion = 0;
    intv=0;
   }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void setCruce(String Cruce) {
        this.Cruce = Cruce;
    }

    public void setMutacion(String mutacion) {
        this.mutacion = mutacion;
    }
    

    public double getEvaluacion() {
        return evaluacion;
    }

    public String getCruce() {
        return Cruce;
    }

    public String getMutacion() {
        return mutacion;
    }
    

    public int getIntv() {
        return intv;
    }

    public void setIntv(int intv) {
        this.intv = intv;
    }
    public String getGenoCad() {
        return genoCad;
    }

    public double getFenotipo() {
        return fenotipo;
    }

    public void setSelecCadena(String selecCadena) {
        this.selecCadena = selecCadena;
    }

    public String getSelecCadena() {
        return selecCadena;
    }

    public double getAdaptacion() {
        return adaptacion;
    }

    public double getSumAdaptacio() {
        return sumAdaptacio;
    }

    public void setSumAdaptacio(double sumAdaptacio) {
        this.sumAdaptacio = sumAdaptacio;
    }

    public void setGenoCad(String genoCad) {
        this.genoCad = genoCad;
    }

    public void setFenotipo(double fenotipo) {
        this.fenotipo = fenotipo;
    }

    public void setAdaptacion(double adaptacion) {
        this.adaptacion = adaptacion;
    }

    public void setProAdaptacio(double proAdaptacio) {
        this.proAdaptacio = proAdaptacio;
    }

    public double getProAdaptacio() {
        return proAdaptacio;
    }


}
