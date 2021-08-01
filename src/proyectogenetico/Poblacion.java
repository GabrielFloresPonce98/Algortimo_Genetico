package proyectogenetico;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class Poblacion {

    private int tamIndividuo;
    private int op;
    private int xMax;

    private double[] Adaptacion1;
    private double[] Adaptacion2;
    private double[] XUNO;
    private double[] XDOS;
    private int xMINIMA;
    private int LongitudBinaria;
    private int Binario;
    private String[] aux;
    private String genoCadme[];
    private String[] Cad;
    private String[] BinBuenos;
    private String[] BinMalos;
    private int TamaniBinario;
    private int ContAux = 0;
    private double[] Evaluacion;
    private double[] NumeroMenor;
    private double[] NumeroMayor;
    private double[] Torneo;
    private String[] AuxGeno;
    private Individuo [] GeneticoUno;
    private Individuo [] Genetio_Dos;
    private double Sust;
    private double AUI;
    private double Acumula;
    private double Acumula2;
    private double Division;
    private double x;
    private double FunCionX;
    private double Precision;
    private int[] PoscionJK;
    private int genotipo[];
    private int[] PosicionCORRE;
    private int[] PosicionINCORRECTOS;
    private String GenoCadena2;
    private String Mensaje;
    private String Mensaje2;
    private double[] TamanioGenera;
    private final double[] Adapta;



    private double tamPar;

    public Poblacion(int tamIndividuo) {
        this.tamIndividuo = tamIndividuo;
        Sust = Acumula = Acumula2 = Division = x = FunCionX = Precision = tamPar = 0;
      TamaniBinario = LongitudBinaria = Binario = op = xMax = xMINIMA = 0;
      ContAux=0;
        GenoCadena2 = Mensaje = Mensaje2 = "";
        AUI = ale();
        PoscionJK = new int[tamIndividuo];

        XUNO = new double[tamIndividuo];
        XDOS = new double[tamIndividuo];
        Evaluacion = new double[tamIndividuo];
        Adapta = new double[tamIndividuo];
        Adaptacion1 = new double[tamIndividuo];
        Adaptacion2 = new double[tamIndividuo];
        Torneo = new double[tamIndividuo];
        NumeroMayor = new double[3];
        NumeroMenor = new double[3];

        aux = new String[tamIndividuo];
        AuxGeno = new String[tamIndividuo];
        genoCadme = new String[tamIndividuo];
        GeneticoUno = new Individuo[tamIndividuo];
        Genetio_Dos = new Individuo[tamIndividuo];
        Cad = new String[tamIndividuo];



    }

    public void logBin() {
        double lb3 = 0, lb2 = 0;
        lb3 = Math.log((1 + ((xMax - xMINIMA) / Precision))) / Math.log(2);
        lb3 = Math.round(lb3);
        lb2 = Math.round(lb3);

        LongitudBinaria = (int) lb2;
       

    }

    public void tamPorcion() {
        tamPar = ((xMax - xMINIMA) / (Math.pow(2, Math.round(LongitudBinaria)) - 1));
      
    }

    public void genYCad() {
        int vc;
        GenoCadena2 = "";
        genotipo = new int[LongitudBinaria];
        for (vc = 0; vc < LongitudBinaria; vc++) {

            if (Math.random() > .5) {

                GenoCadena2 += String.valueOf(genotipo[vc] = 1);
            } else {

                GenoCadena2 += String.valueOf(genotipo[vc] = 0);
            }

        }

    }

    public void converBin() {
      
        Binario = 0;
      
        Binario = Integer.parseInt(GenoCadena2, 2);
      
        

    }

    public void BuscX() {

        x = 0;

        x = xMINIMA + (Binario * (tamPar));
   

    }

    public void funX() {

        FunCionX = 0;

        FunCionX = -(Math.pow(x, 2)) + (5 * (x)) + 3;
      
        
    }

    public void proAdaptacion(double di, double fa) {
   
Division=0;
        Division = di / fa;
    
    }

    public void SumaYDivide() {
        Acumula2 = Acumula2 + Division;
       
    }

    public int RandomSelecc(int tam) {
        return (int) (Math.random() * tam);
    }

    public void X1_x2(double ta, double ta1, int i, String a1, int op, int tam, int av) {
        DecimalFormat df = new DecimalFormat("#0.0000");

        XUNO[i] = ta;
        XDOS[i] = ta1;
        aux[i] = a1;

        if (op == 1) {
            Evaluacion[i] = ale();
            
        }
        if (op == 2) {
            Evaluacion[i] = MetodoEstoca(tam, av);
        }

    }

    public double ale() {
        return (double) (Math.random() * 100000 / 100000);

    }

    public void Ruleta(int tam) {
        double x = 0, x_2 = 0;
        int q = -1;
        for (int i = 0; i < tam; i++) {
            x=XUNO[i];
            x_2=XDOS[i];
        }
   
        for (int j = 0; j < tam; j++) {

            for (int i = 0; i < tam; i++) {

                if (Evaluacion[j] >= XUNO[i] && Evaluacion[j] <= XDOS[i]) {
                   
                    PoscionJK[i] = i + 1;
                 
                    genoCadme[j] = aux[i];
                   
                }
            }
        }

    }

    public double MetodoEstoca(int tam, int av) {
        double aj = 0;

        aj = ((AUI + av) - 1) / tam;
        return aj;
    }

    public String Sel(int i) {
        return genoCadme[i];
    }

    public void llenAdap(double adap, int i, int a) {
        Adapta[i] = adap;
        Adaptacion2[i] = a;
    }

    public void AlToreno(int Tam) {
        int ax = 0;
        int tamtr = 0;
        tamtr = Tam * 3;

        for (int i = 0; i < tamIndividuo; i++) {
            for (int j = 0; j < 3; j++) {
                ax = RandomSelecc(Tam);
                NumeroMayor[j] = Adapta[ax];
                NumeroMenor[j] = Adaptacion2[ax];

            }
            Compara(i);

        }

    }

    public void Compara(int i) {

        if (NumeroMayor[0] >= NumeroMayor[1] && NumeroMayor[0] >= NumeroMayor[2]) {

            Torneo[i] = NumeroMenor[0];

        } else if (NumeroMayor[1] >= NumeroMayor[0] && NumeroMayor[1] >= NumeroMayor[2]) {

            Torneo[i] = NumeroMenor[1];

        } else if (NumeroMayor[2] >= NumeroMayor[1] && NumeroMayor[2] >= NumeroMayor[0]) {

            Torneo[i] = NumeroMenor[2];

        }

    }

    public String ObtPos(int tam, int i, String geno) {

        genoCadme[i] = geno;
        int torn = 0;
        torn = (int) Torneo[i];
      
        return genoCadme[torn - 1];
    }

    public void SelecRestos(double proAdap, int i, int tam, String Geno, double adapta) {

        double[] Rest2 = new double[tam];
        Rest2[i] = (proAdap * tam);
        String[] Cade = new String[tam];
        Cade[i] = Geno;
        double[] adap = new double[tam];

        Evaluacion[i] = ale();

        int ax = 0;
        if (Rest2[i] > 1) {

            Cad[i] = Cade[i];

        }
        if (Rest2[i] < 1) {
            for (int h = 0; h < tam; h++) {

                if (Evaluacion[i] >= XUNO[h] && Evaluacion[i] <= XDOS[h]) {
                    PoscionJK[h] = h + 1;

                    genoCadme[i] = aux[h];

                    Cad[i] = genoCadme[i];

                }
            }
        }
    }

    public void Seleccionar_Uno() {
        int vc = 0, vj = 0;

        double[] a = new double[tamIndividuo];
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                GeneticoUno[i].setSelecCadena(GeneticoUno[i].getGenoCad());

                vj++;
            }

        }

        int jk = 0;
        int jq = 0;
        PosicionCORRE = new int[vc];
        PosicionINCORRECTOS = new int[vj];
        BinBuenos = new String[vc];
        BinMalos = new String[vj];
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .4) {

                BinBuenos[jk] = GeneticoUno[i].getGenoCad();
                PosicionCORRE[jk] = i;

                jk++;
            } else {
                BinMalos[jq] = GeneticoUno[i].getGenoCad();
                PosicionINCORRECTOS[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            llenarPar(vc);
        }
        if (vc % 2 == 1) {
            llenarImpar(vj, vc);
        }

    }

    public void llenarPar(int vc) {

        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * GeneticoUno[0].getGenoCad().length());
            cag = i + 1;

            GeneticoUno[PosicionCORRE[i]].setSelecCadena(GeneticoUno[PosicionCORRE[i]].getGenoCad().substring(0, AleLong) + GeneticoUno[PosicionCORRE[cag]].getGenoCad().substring(AleLong));
            GeneticoUno[PosicionCORRE[cag]].setSelecCadena(GeneticoUno[PosicionCORRE[cag]].getGenoCad().substring(0, AleLong) + GeneticoUno[PosicionCORRE[i]].getGenoCad().substring(AleLong));
            i = cag;
        }

    }

    public void llenarImpar(int vj, int vc) {

        int vl = vc + 1;
  
        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = PosicionCORRE[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * PosicionINCORRECTOS.length);
            poc[posicion] = PosicionINCORRECTOS[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = GeneticoUno[poc[i]].getGenoCad();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * GeneticoUno[0].getGenoCad().length());
            cog2 = i + 1;

            GeneticoUno[poc[i]].setSelecCadena(GeneticoUno[poc[i]].getGenoCad().substring(0, AleLong) + GeneticoUno[poc[cog2]].getGenoCad().substring(AleLong));
            GeneticoUno[poc[cog2]].setSelecCadena(GeneticoUno[poc[cog2]].getGenoCad().substring(0, AleLong) + GeneticoUno[poc[i]].getGenoCad().substring(AleLong));
            i = cog2;
        }
    }

    public void SeleccionarUnoCruce() {
        int vc = 0, vj = 0;

        double[] a = new double[tamIndividuo];
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                GeneticoUno[i].setCruce(GeneticoUno[i].getSelecCadena());

                vj++;
            }

        }

        int jk = 0;
        int jq = 0;
        PosicionCORRE = new int[vc];
        PosicionINCORRECTOS = new int[vj];
        BinBuenos = new String[vc];
        BinMalos = new String[vj];
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .4) {

                BinBuenos[jk] = GeneticoUno[i].getSelecCadena();
                PosicionCORRE[jk] = i;

                jk++;
            } else {
                BinMalos[jq] = GeneticoUno[i].getSelecCadena();
                PosicionINCORRECTOS[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            llenarParCruce(vc);
        }
        if (vc % 2 == 1) {
            llenarImparCruce(vj, vc);
        }

    }

    public void llenarParCruce(int vc) {
        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * GeneticoUno[0].getSelecCadena().length());
            cag = i + 1;

            GeneticoUno[PosicionCORRE[i]].setCruce(GeneticoUno[PosicionCORRE[i]].getSelecCadena().substring(0, AleLong) + GeneticoUno[PosicionCORRE[cag]].getSelecCadena().substring(AleLong));
            GeneticoUno[PosicionCORRE[cag]].setCruce(GeneticoUno[PosicionCORRE[cag]].getSelecCadena().substring(0, AleLong) + GeneticoUno[PosicionCORRE[i]].getSelecCadena().substring(AleLong));
            i = cag;
        }

    }

    public void llenarImparCruce(int vj, int vc) {

        int vl = vc + 1;

        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = PosicionCORRE[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * PosicionINCORRECTOS.length);
            poc[posicion] = PosicionINCORRECTOS[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = GeneticoUno[poc[i]].getSelecCadena();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * GeneticoUno[0].getSelecCadena().length());
            cog2 = i + 1;

            GeneticoUno[poc[i]].setCruce(GeneticoUno[poc[i]].getSelecCadena().substring(0, AleLong) + GeneticoUno[poc[cog2]].getSelecCadena().substring(AleLong));
            GeneticoUno[poc[cog2]].setCruce(GeneticoUno[poc[cog2]].getSelecCadena().substring(0, AleLong) + GeneticoUno[poc[i]].getSelecCadena().substring(AleLong));
            i = cog2;
        }
    }

    public void Mutacion() {

        double[] a = new double[tamIndividuo];
        String[] Aux = new String[tamIndividuo];
        int vj = 0;
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);
            if (a[i] > .1) {
                vj++;

            } else {

                GeneticoUno[i].setMutacion(GeneticoUno[i].getCruce());

            }

        }
    
        String[] Mutar = new String[vj];
        int[] PosMutar = new int[vj];

        int jk = 0;
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .1) {
                Mutar[jk] = GeneticoUno[i].getCruce();
                PosMutar[jk] = i;
                jk++;
            }

        }
        for (int j = 0; j < vj; j++) {
            int numAle = (int) (Math.random() * Mutar[0].length());
            StringBuilder Binario2 = new StringBuilder(Mutar[j]);

            if (Mutar[j].charAt(numAle) == '1') {
                Binario2.setCharAt(numAle, '0');
                GeneticoUno[PosMutar[j]].setMutacion(String.valueOf(Binario2.toString()));
            } else if (Mutar[j].charAt(numAle) == '0') {

                Binario2.setCharAt(numAle, '1');
                GeneticoUno[PosMutar[j]].setMutacion(String.valueOf(Binario2.toString()));

            }
        }

    }

    public void Evalular() {
        double mej = GeneticoUno[0].getAdaptacion();

        for (int j = 0; j < tamIndividuo; j++) {
            if (GeneticoUno[j].getAdaptacion() > mej) {
                mej = GeneticoUno[j].getAdaptacion();
            }

        }
        GeneticoUno[0].setEvaluacion(mej);
    }
    
   
    
    public void EvalularGen() {
   
        double mej = Genetio_Dos[0].getAdaptacion();

        for (int j = 0; j < tamIndividuo; j++) {
            if (Genetio_Dos[j].getAdaptacion() > mej) {
                mej = Genetio_Dos[j].getAdaptacion();
            }

        }
        Genetio_Dos[0].setEvaluacion(mej);
        Sust = mej;
    
          
        TamanioGenera[ContAux]=Sust;
      
      ContAux++;
    }


    

    public void llenarPoblacion() {

        int inta = 0;
        double fa = 0;

        logBin();
        tamPorcion();

        for (int j = 0; j < GeneticoUno.length; j++) {
            FunCionX=0;
x=0;
            inta++;
            genYCad();
            converBin();
            BuscX();
            funX();

            GeneticoUno[j] = new Individuo();
            GeneticoUno[j].setIntv(inta);
            GeneticoUno[j].setGenoCad(GenoCadena2);
            GeneticoUno[j].setFenotipo(x);
            GeneticoUno[j].setAdaptacion(FunCionX);
            fa += FunCionX;
        }

        double[] axu = new double[tamIndividuo];

        for (int vi = 0; vi < GeneticoUno.length; vi++) {

            proAdaptacion(GeneticoUno[vi].getAdaptacion(), fa);
            SumaYDivide();

            GeneticoUno[vi].setProAdaptacio(Division);
            GeneticoUno[vi].setSumAdaptacio(Acumula2);

        }
        int co = -1;
        int ca = 0;

        axu[0] = 0.00;
        for (int i = 0; i < GeneticoUno.length - 1; i++) {
            co++;
            ca++;

            axu[ca] = GeneticoUno[co].getSumAdaptacio();
        }
        int av = 0;

        for (int i = 0; i < GeneticoUno.length; i++) {
            av++;
            X1_x2(axu[i], GeneticoUno[i].getSumAdaptacio(), i, GeneticoUno[i].getGenoCad(), op, tamIndividuo, av);

        }

        switch (op) {
            case 1:
                Ruleta(tamIndividuo);
                for (int i = 0; i < GeneticoUno.length; i++) {
                    GeneticoUno[i].setSelecCadena(Sel(i));
                }

                break;

            case 2:
                Ruleta(tamIndividuo);
                for (int i = 0; i < GeneticoUno.length; i++) {
                    GeneticoUno[i].setSelecCadena(Sel(i));
                }

                break;

            case 3:
                Ruleta(tamIndividuo);
                for (int i = 0; i < tamIndividuo; i++) {
                    llenAdap(GeneticoUno[i].getAdaptacion(), i, GeneticoUno[i].getIntv());

                }

                AlToreno(tamIndividuo);

                for (int i = 0; i < tamIndividuo; i++) {
                    GeneticoUno[i].setSelecCadena(ObtPos(tamIndividuo, i, GeneticoUno[i].getGenoCad()));
                }

                break;

            case 4:

                for (int i = 0; i < tamIndividuo; i++) {
                    SelecRestos(GeneticoUno[i].getProAdaptacio(), i, tamIndividuo, GeneticoUno[i].getGenoCad(), GeneticoUno[i].getAdaptacion());
                }

                for (int i = 0; i < tamIndividuo; i++) {
                    GeneticoUno[i].setSelecCadena(Cad[i]);
                }

                break;

            case 5:
                Seleccionar_Uno();

                break;

        }
        SeleccionarUnoCruce();
        Mutacion();
        Evalular();

    }

    public void Evolucion() {
           TamanioGenera = new double[TamaniBinario];
         System.out.println(TamaniBinario);
  int intv = 0;
      double fa = 0;
      FunCionX = 0;
            x = 0;
        for (int i = 0; i < tamIndividuo; i++) {
              
           
            GenoCadena2 = GeneticoUno[i].getMutacion();
            converBin();
            BuscX();
            funX();
            intv++;
           
            Genetio_Dos[i] = new Individuo();
            Genetio_Dos[i].setIntv(intv);
            Genetio_Dos[i].setGenoCad(GeneticoUno[i].getMutacion());
            Genetio_Dos[i].setFenotipo(x);
            Genetio_Dos[i].setAdaptacion(FunCionX);
     
            fa += FunCionX;

        }

        double[] axu = new double[tamIndividuo];
        Division = 0;
        Acumula2 = 0;
        for (int vi = 0; vi < tamIndividuo; vi++) {

            proAdaptacion(Genetio_Dos[vi].getAdaptacion(), fa);
            SumaYDivide();

            Genetio_Dos[vi].setProAdaptacio(Division);
            Genetio_Dos[vi].setSumAdaptacio(Acumula2);

        }
        int co = -1;
        int ca = 0;

        axu[0] = 0.00;
        for (int i = 0; i < tamIndividuo - 1; i++) {
            co++;
            ca++;

            axu[ca] = Genetio_Dos[co].getSumAdaptacio();

        }
        int av = 0;

        for (int i = 0; i < tamIndividuo; i++) {
            av++;

            X1_x2(axu[i], Genetio_Dos[i].getSumAdaptacio(), i, Genetio_Dos[i].getGenoCad(), op, tamIndividuo, av);

        }

        if (op == 1) {
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {

                Genetio_Dos[i].setSelecCadena(Sel(i));

            }
        }

        if (op == 2) {
  
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(Sel(i));
            }
        }
        if (op == 3) {
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {
                llenAdap(Genetio_Dos[i].getAdaptacion(), i, Genetio_Dos[i].getIntv());

            }

            AlToreno(tamIndividuo);

            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(ObtPos(tamIndividuo, i, Genetio_Dos[i].getGenoCad()));
            }
        }
        if (op == 4) {
            for (int i = 0; i < tamIndividuo; i++) {
                SelecRestos(Genetio_Dos[i].getProAdaptacio(), i, tamIndividuo, Genetio_Dos[i].getGenoCad(), Genetio_Dos[i].getAdaptacion());
            }

            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(Cad[i]);

            }
        }
        if (op == 5) {
            SeleccionarUnoGeneracion();
        }
SeleccionarUnoCruceGeneracion();
        MutacionGeneracion();
      
        for (int i = 0; i < tamIndividuo; i++){
      
           AuxGeno[i]=Genetio_Dos[i].getMutacion();
          
        }
    EvalularGen();
  
        
    }

    public void EvolucionRep() {
      
        double fa = 0;
        int intv = 0;
    
          GenoCadena2="";       
          
        for (int i = 0; i < tamIndividuo; i++) { 
           FunCionX = 0;
            x = 0;

            GenoCadena2 = AuxGeno[i];
            converBin();
            BuscX();
            funX();

            intv++;
           
            Genetio_Dos[i] = new Individuo();
            Genetio_Dos[i].setIntv(intv);
            Genetio_Dos[i].setGenoCad(GenoCadena2);
            Genetio_Dos[i].setFenotipo(x);
            Genetio_Dos[i].setAdaptacion(FunCionX);
            
            fa += FunCionX;

        }

        double[] axu = new double[tamIndividuo];
        Division = 0;
            Acumula2 = 0;
        for (int vi = 0; vi < tamIndividuo; vi++) {
            
            proAdaptacion(Genetio_Dos[vi].getAdaptacion(), fa);
            SumaYDivide();

            Genetio_Dos[vi].setProAdaptacio(Division);
            Genetio_Dos[vi].setSumAdaptacio(Acumula2);

        }
        int co2 = -1;
        int ca2 = 0;

        axu[0] = 0.00;
        for (int i = 0; i < tamIndividuo - 1; i++) {
            co2++;
            ca2++;

            axu[ca2] = Genetio_Dos[co2].getSumAdaptacio();

        }
        int av2 = 0;

        for (int i = 0; i < tamIndividuo; i++) {
            av2++;
            

            X1_x2(axu[i], Genetio_Dos[i].getSumAdaptacio(), i, Genetio_Dos[i].getGenoCad(), op, tamIndividuo, av2);
           
        }

        if (op == 1) {
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {

                Genetio_Dos[i].setSelecCadena(Sel(i));

            }
        }

        if (op == 2) {
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(Sel(i));
            }
        }
        if (op == 3) {
            Ruleta(tamIndividuo);
            for (int i = 0; i < tamIndividuo; i++) {
                llenAdap(Genetio_Dos[i].getAdaptacion(), i, Genetio_Dos[i].getIntv());

            }

            AlToreno(tamIndividuo);

            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(ObtPos(tamIndividuo, i, Genetio_Dos[i].getGenoCad()));
            }
        }
        if (op == 4) {
            for (int i = 0; i < tamIndividuo; i++) {
                SelecRestos(Genetio_Dos[i].getProAdaptacio(), i, tamIndividuo, Genetio_Dos[i].getGenoCad(), Genetio_Dos[i].getAdaptacion());
            }

            for (int i = 0; i < tamIndividuo; i++) {
                Genetio_Dos[i].setSelecCadena(Cad[i]);

            }
        }
        if (op == 5) {
            SeleccionarUnoGeneracion();
        }
        SeleccionarUnoCruceGeneracion();
        MutacionGeneracion();
     
        for (int i = 0; i < tamIndividuo; i++) {
            AuxGeno[i] = Genetio_Dos[i].getMutacion();
         }
       EvalularGen();
   

    }
    
    
    
    
    
    
    
    
    
    public void SeleccionarUnoGeneracion() {
        int vc = 0, vj = 0;

        double[] a = new double[tamIndividuo];
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                Genetio_Dos[i].setSelecCadena(Genetio_Dos[i].getGenoCad());

                vj++;
            }

        }

        int jk = 0;
        int jq = 0;
        PosicionCORRE = new int[vc];
        PosicionINCORRECTOS = new int[vj];
        BinBuenos = new String[vc];
        BinMalos = new String[vj];
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .4) {

                BinBuenos[jk] = Genetio_Dos[i].getGenoCad();
                PosicionCORRE[jk] = i;

                jk++;
            } else {
                BinMalos[jq] = Genetio_Dos[i].getGenoCad();
                PosicionINCORRECTOS[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            llenarParGeneracion(vc);
        }
        if (vc % 2 == 1) {
            llenarImparGeneracion(vj, vc);
        }

    }

    public void llenarParGeneracion(int vc) {

        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * Genetio_Dos[0].getGenoCad().length());
            cag = i + 1;

            Genetio_Dos[PosicionCORRE[i]].setSelecCadena(Genetio_Dos[PosicionCORRE[i]].getGenoCad().substring(0, AleLong) + Genetio_Dos[PosicionCORRE[cag]].getGenoCad().substring(AleLong));
            Genetio_Dos[PosicionCORRE[cag]].setSelecCadena(Genetio_Dos[PosicionCORRE[cag]].getGenoCad().substring(0, AleLong) + Genetio_Dos[PosicionCORRE[i]].getGenoCad().substring(AleLong));
            i = cag;
        }

    }

    public void llenarImparGeneracion(int vj, int vc) {

        int vl = vc + 1;

        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = PosicionCORRE[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * PosicionINCORRECTOS.length);
            poc[posicion] = PosicionINCORRECTOS[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = Genetio_Dos[poc[i]].getGenoCad();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * Genetio_Dos[0].getGenoCad().length());
            cog2 = i + 1;

            Genetio_Dos[poc[i]].setSelecCadena(Genetio_Dos[poc[i]].getGenoCad().substring(0, AleLong) + Genetio_Dos[poc[cog2]].getGenoCad().substring(AleLong));
            Genetio_Dos[poc[cog2]].setSelecCadena(Genetio_Dos[poc[cog2]].getGenoCad().substring(0, AleLong) + Genetio_Dos[poc[i]].getGenoCad().substring(AleLong));
            i = cog2;
        }
    }

    public void SeleccionarUnoCruceGeneracion() {
        int vc = 0, vj = 0;

        double[] a = new double[tamIndividuo];
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                Genetio_Dos[i].setCruce(Genetio_Dos[i].getSelecCadena());

                vj++;
            }

        }

        int jk = 0;
        int jq = 0;
        PosicionCORRE = new int[vc];
        PosicionINCORRECTOS = new int[vj];
        BinBuenos = new String[vc];
        BinMalos = new String[vj];
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .4) {

                BinBuenos[jk] = Genetio_Dos[i].getSelecCadena();
                PosicionCORRE[jk] = i;

                jk++;
            } else {
                BinMalos[jq] = Genetio_Dos[i].getSelecCadena();
                PosicionINCORRECTOS[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            llenarParCruceGeneracion(vc);
        }
        if (vc % 2 == 1) {
            llenarImparCruceGeneracion(vj, vc);
        }

    }

    public void llenarParCruceGeneracion(int vc) {
        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * Genetio_Dos[0].getSelecCadena().length());
            cag = i + 1;

            Genetio_Dos[PosicionCORRE[i]].setCruce(Genetio_Dos[PosicionCORRE[i]].getSelecCadena().substring(0, AleLong) + Genetio_Dos[PosicionCORRE[cag]].getSelecCadena().substring(AleLong));
            Genetio_Dos[PosicionCORRE[cag]].setCruce(Genetio_Dos[PosicionCORRE[cag]].getSelecCadena().substring(0, AleLong) + Genetio_Dos[PosicionCORRE[i]].getSelecCadena().substring(AleLong));
            i = cag;
        }

    }

    public void llenarImparCruceGeneracion(int vj, int vc) {

        int vl = vc + 1;

        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = PosicionCORRE[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * PosicionINCORRECTOS.length);
            poc[posicion] = PosicionINCORRECTOS[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = Genetio_Dos[poc[i]].getSelecCadena();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * Genetio_Dos[0].getSelecCadena().length());
            cog2 = i + 1;

            Genetio_Dos[poc[i]].setCruce(Genetio_Dos[poc[i]].getSelecCadena().substring(0, AleLong) + Genetio_Dos[poc[cog2]].getSelecCadena().substring(AleLong));
            Genetio_Dos[poc[cog2]].setCruce(Genetio_Dos[poc[cog2]].getSelecCadena().substring(0, AleLong) + Genetio_Dos[poc[i]].getSelecCadena().substring(AleLong));
            i = cog2;
        }
    }

    public void MutacionGeneracion() {

        double[] a = new double[tamIndividuo];
        String[] Aux = new String[tamIndividuo];
        int vj = 0;
        for (int i = 0; i < tamIndividuo; i++) {
            a[i] = (double) (Math.random() * 1);
            if (a[i] > .1) {
                vj++;

            } else {

                Genetio_Dos[i].setMutacion(Genetio_Dos[i].getCruce());

            }

        }

        String[] Mutar = new String[vj];
        int[] PosMutar = new int[vj];

        int jk = 0;
        for (int i = 0; i < tamIndividuo; i++) {
            if (a[i] > .1) {
                Mutar[jk] = Genetio_Dos[i].getCruce();

                PosMutar[jk] = i;
                jk++;
            }

        }
        for (int j = 0; j < vj; j++) {
            int numAle = (int) (Math.random() * Mutar[0].length());
            StringBuilder Binario2 = new StringBuilder(Mutar[j]);

            if (Mutar[j].charAt(numAle) == '1') {
                Binario2.setCharAt(numAle, '0');
                Genetio_Dos[PosMutar[j]].setMutacion(String.valueOf(Binario2.toString()));
            } else if (Mutar[j].charAt(numAle) == '0') {

                Binario2.setCharAt(numAle, '1');
                Genetio_Dos[PosMutar[j]].setMutacion(String.valueOf(Binario2.toString()));

            }
        }

    }

    public void imPoblacion() {
        DecimalFormat df = new DecimalFormat("#0.0000");

        Mensaje = "Numero" + "------" + "GENOTIPO" + "--------" + "Fenotipo" + "-------" + "Adaptacion" + "-------" + "Seleccion" + "-------" + "Cruce" + "--------" + "Mutacion" + "\n";
        for (int i = 0; i < GeneticoUno.length; i++) {
            Mensaje += GeneticoUno[i].getIntv() + "\t     "
                    + GeneticoUno[i].getGenoCad() + "\t       "
                    + String.valueOf(df.format(GeneticoUno[i].getFenotipo())) + "\t     "
                    + String.valueOf(df.format(GeneticoUno[i].getAdaptacion())) + "\t     "
                    + GeneticoUno[i].getSelecCadena() + "\t     "
                    + GeneticoUno[i].getCruce() + "\t      "
                    + GeneticoUno[i].getMutacion() + "\n";

        }
        Mensaje += String.valueOf("MEJOR:   " + df.format(GeneticoUno[0].getEvaluacion())) + "\t      " + "\n";
    }

    public void imPoblacion2() {
        double Auxi = 0;
        DecimalFormat df = new DecimalFormat("#0.0000");

        Mensaje2 = "--------------------------------------------" + "\n";
        for (int i = 0; i < Genetio_Dos.length; i++) {
            Mensaje2 += Genetio_Dos[i].getIntv() + "\t     "
                    + Genetio_Dos[i].getGenoCad() + "\t"
                    + String.valueOf(df.format(Genetio_Dos[i].getFenotipo())) + "\t     "
                    + String.valueOf(df.format(Genetio_Dos[i].getAdaptacion())) + "\t     "
                    + Genetio_Dos[i].getSelecCadena() + "\t     "
                    + Genetio_Dos[i].getCruce() + "\t      "
                    + Genetio_Dos[i].getMutacion() + "\n";

        }

        Mensaje2 += String.valueOf("MEJOR:   " + df.format(Genetio_Dos[0].getEvaluacion())) + "\t      " + "\n";

    }

    public void MejorMejor() {

        DecimalFormat df = new DecimalFormat("#0.000");

        double mej = TamanioGenera[0];

        for (int j = 0; j < TamaniBinario; j++) {
            if (TamanioGenera[j] > mej) {
                mej = TamanioGenera[j];
            }

        }

        System.out.println("MEJOR DE TODOS:  " + df.format(mej));

    }


    public int getxMax() {
        return xMax;
    }

    public int getMin() {
        return xMINIMA;
    }

    public double getPre() {
        return Precision;
    }

    public void setMax(int max) {
        this.xMax = max;
    }

    public void setMin(int min) {
        this.xMINIMA = min;
    }

    public void setPre(double pre) {
        this.Precision = pre;
    }

    public String getMsg() {
        return Mensaje;
    }

    public String getMsg2() {
        return Mensaje2;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public void setTamBin(int tamBin) {
        this.TamaniBinario = tamBin;
    }

    public int getTamBin() {
        return TamaniBinario;
    }
    

}
