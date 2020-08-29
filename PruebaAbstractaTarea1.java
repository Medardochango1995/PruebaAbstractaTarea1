/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaabstractatarea1;

/**
 *
 * @author Fernando Padilla
 * @author Medardo Chango
 */

abstract class DiagnosticoBateria{
    private String marcaBateria;
    private String tipoBateria;
    private int numPlacas;
    private double voltaje;
    private String fallaBateria;
    
    
    public DiagnosticoBateria(String marcaBateria, String tipoBateria, int numPlacas, double voltaje, String fallaBateria){
       
        
        this.marcaBateria = marcaBateria;
        this.tipoBateria = tipoBateria;
        this.numPlacas = numPlacas;
        this.voltaje = voltaje;
        this.fallaBateria = fallaBateria;
    }
    
    public double DetectarFalla(){
        System.out.println("Detectar falla que tiene la Bateria");
        return 0.0;
    }
    
    public void AnalizarFallas(){
        System.out.println("Las fallas que se detecto son: "+fallaBateria+" "+tipoBateria);
    }
    
    public String toString(){
        return marcaBateria+""+tipoBateria+""+numPlacas+""+ voltaje+""+fallaBateria;
        
    }
    public String getMarcaBateria(){
        return marcaBateria;
    }
    public String getTipoBateria(){
        return tipoBateria;
    }
    public int getNumPlacas(){
        return numPlacas;
    }
    public double getVoltaje(){
        return voltaje;
    }
    public void setVoltaje(double nuevo){
        voltaje = nuevo;
    }
    public String getFallaBateria(){
        return fallaBateria;
    }

}

class CorrienteAlta extends DiagnosticoBateria{
    private double corrienteAlta;

    public CorrienteAlta(String marcaBateria, String tipoBateria, int numPlacas, 
            double voltaje, String fallaBateria, double corrienteAlta) {
        
        super(marcaBateria, tipoBateria, numPlacas, voltaje, fallaBateria);
        setCorrienteAlta(corrienteAlta);
    }
    
    public void AnalizarFallas(){
        
        System.out.println("Dentro del metodo Analizar falla de la clase Corriente Alta  ");
        System.out.println("Analizando la bateria de marca "+ getMarcaBateria ()+" con corriente alta: "
                +getCorrienteAlta() +" Amperios");
        System.out.println("\n\033[34m Integrando los datos de un Diagnostico de Bateria: ");
    }
    
    public double getCorrienteAlta(){
        return corrienteAlta;
    }
    public void setCorrienteAlta(double nuevo){
        if(nuevo > 2.0)
            corrienteAlta=nuevo;
    }
    public double DetectarFalla(){
        System.out.println("Se detecta la falla en la bateria de marca "+getMarcaBateria());
        return corrienteAlta*20;
    }   
}
class CorrienteBaja extends DiagnosticoBateria{
    private double corrienteBaja;

    public CorrienteBaja(String marcaBateria, String tipoBateria, int numPlacas, 
            double voltaje, String fallaBateria, double corrienteBaja) {
        super(marcaBateria, tipoBateria, numPlacas, voltaje, fallaBateria);
        setCorrienteAlta(corrienteBaja);
    }
    
    public void AnalizarFallas(){
        
        System.out.println("Dentro del metodo Analizar falla de la clase Corriente Baja  ");
        System.out.println("Analizando la bateria de marca "+ getMarcaBateria ()
                +" con corriente baja: "+getCorrienteAlta() +" Amperios");
        System.out.println("\n\033[34mIntegrando los datos, de un Diagnostico de Bateria: ");

    }
    
    public double getCorrienteAlta(){
        return corrienteBaja;
    }
    public void setCorrienteAlta(double nuevo){
        if(nuevo <= 1.8)
            corrienteBaja=nuevo;
    }
    public double CostoDiagnostico(){
        System.out.println("La Bateria de marca "+getMarcaBateria());
        return corrienteBaja*20;
    }   
}


public class PruebaAbstractaTarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("\033[31m       UNIVERSIDAD DE LAS FUERZAS ARMADAS ");
        System.out.println("\033[31m                ESPE-L            ");
        System.out.println("MATERIA:PROGRAMACION");
        System.out.println("NRC: 7450");
        System.out.println("DOCENTE: ING LUIS GUERRA");
    
        System.out.println("ESTUDIANTES  - MEDARDO CHANGO");
        System.out.println("             - FERNANDO PADILLA");
        
        System.out.println("\n \033[31m          TAREA PRUEBA ABSTRACTA TAREA 1");
        System.out.println("----------------------------------------------------------------");
        
        
        DiagnosticoBateria bateria1=new CorrienteAlta("Bosch","Bateria de Celda Humeda",6,11.3,"Falla con un exceso de corriente alta",3.5);
        CorrienteAlta bateria2=new CorrienteAlta("Ecuador","Bateria de Litio",8,12.5,"Falla con un exceso de corriente alta",4);
        CorrienteBaja bateria3=new CorrienteBaja("Yamaha","Bateria de Calcio ",9,12.0,"Falla con un descenso de correinte baja",1.2);
        
        
        System.out.println("\n\033[34mIntegrando los datos, de un Diagnostico de Bateria: ");
        System.out.println("LLamada a Analizar Falla de bateria usando la referencia"+ " de la clase DiagnosticoBateria***");
        bateria1.AnalizarFallas();
        System.out.println("LLamada a Analizar Falla de bateria usando la referencia"+ " de la clase CorrientaAlta***");
        bateria2.AnalizarFallas();
        System.out.println("LLamada a Analizar Falla de bateria usando la referencia"+ " de la clase CorrientaBaja***");
        bateria3.AnalizarFallas();    
    }
}
