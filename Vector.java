import javax.swing.JOptionPane;

public class Vector {
    
    /**
     * Variables privadas de la clase.
     */
    
    private int max;
    private int [] vector;
    private int indice=-1;
    
    /**
     * Constructor por defecto, sin parametros.
     */
    
    public Vector(){
        this.max=0;
        vector=null;
    }
    
    /**
     * Constructor con parametros recibe un entero como tamaño del vector.
     */
    
    public Vector(int max){
        this.max=max;
        vector = new int [this.max];
    }
    
    /**
     * Metodo que devuelve falso o verdadero si el vector esta vacío.
     */
    
    public boolean VectorVacio(){
        if(indice==-1)
            return true;
        else
            return false;
    }
    
    /**
     * Metodo que devuelve falso o verdadero si el vector esta lleno.
     */
    
    public boolean VectorLleno(){
        if(indice==max)
            return true;
        else
            return false;
    }
    
    /**
     * Metodo que devuelve falso o verdadero si el vector esta medio lleno

     */
    
    public boolean VectorMedioLleno(){
        if (indice==max/2||indice+1==max/2)
            return true;
        else
            return false;
    }
    
    /**
     * Metodo que inserta un valor en el vector
     */
    
    public void Insertar(){
        if(!VectorLleno()){
            indice++;
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor "));
            vector[indice]=numero;
            if(VectorLleno())
                JOptionPane.showMessageDialog(null, "El vector ha quedado lleno");
        }
        else
            JOptionPane.showMessageDialog(null, "Esta Lleno");
    }
    

    /**
     * Metodo que nos llena el vector
     */
    
    public void LlenarVector(){
        try{
            while(indice<max-1){
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor"));
                indice++;
                vector[indice]=numero;
            }
            JOptionPane.showMessageDialog(null, "El vector quedo lleno");
        }catch(Exception e){}        
    }
    
    /**
     * Metodo que nos imprime el vector en la consola
     */
    
    public void Imprimir(){
        if(!VectorVacio()){
            for(int i=0;i<this.max;i++)
                System.out.print("["+vector[i]+"]");
            System.out.println();
        } else {
            JOptionPane.showMessageDialog(null, "El vector esta vacio, no hay elementos");
        }        
    }
    
    /**

     * Metodo que nos busca un valor determinado en el vector
     * Devuelve -1 si no se encuentra el valor
     */
    
    public int Buscar(int num){
        int aux=0;
        int pos=-1;
        boolean sw=false;
        while (aux<max-1 && sw==false){
            if(vector[aux]==num){

                sw=true;
                pos=aux;
            }
            aux++;
        }
        if(sw==true)
            return pos;
        else {
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
            return pos;
        }
    }
    
    /**
     * Metodo que nos permite reemplazar un valor del vector.
     */
    
    public void Reemplazar(int num){
        try{
            int temp = Buscar(num);
            if (temp!=-1)
                vector[temp]= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número por el que reemplazar"));
        }catch(Exception e){}        
    }
}