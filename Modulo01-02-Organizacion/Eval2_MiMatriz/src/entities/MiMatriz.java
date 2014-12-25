package entities;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import utils.ESInteractiva;

/**
 *
 * @description Entity Class for Mi Matriz
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class MiMatriz {
    private int [][] matriz;
    private Random random;
    private int nfila;
    private int ncol;
    
    /**
     * Getter for matriz
     * @return
     */
    public int[][] getMatriz() {
        return matriz;
    }
    
    /**
     * Getter for random class
     * @return random
     */
    public Random getRandom() {
        return random;
    }
    
    /**
     * Getter for number of rows
     * @return nfila
     */
    public int getNfila() {
        return nfila;
    }
    
    /**
     * Getter for number of columns
     * @return ncol
     */
    public int getNcol() {
        return ncol;
    }

    /**
     *
     * @description Parametrized Constructor based on number of rows and columns
     * @param nfila Number of rows
     * @param ncol Number of columns
     */
    public MiMatriz(int nfila, int ncol){
        this.nfila=nfila;
        this.ncol=ncol;
        this.matriz = new int[this.getNfila()][this.getNcol()];
        this.random = new Random();
        int top=9;
        for(int i=0;i!=nfila;i++){
            for(int j=0;j!=ncol; j++){ 
               this.matriz[i][j]=this.getRandom().nextInt(top);
            }
        }    
    }

     /**
      *
      * @description Parametrized Constructor based on the same number of rows and columns
      * @param n Number rows and columns
      */
    public MiMatriz(int n) {
        this.nfila=n;
        this.ncol=this.nfila;
        this.matriz = new int[this.getNfila()][this.getNcol()];
        this.random = new Random();
        int top=9;
        for(int i=0;i!=n;i++){
            for(int j=0;j!=n; j++){ 
               this.matriz[i][j]=this.getRandom().nextInt(top);
            }
        }    
    }
     
    /**
     *
     * @description Parametrized Constructor based on matriz
     * @param n Number rows and columns
     */
    public MiMatriz(int [][] matriz) {
        this.matriz =  matriz;
        this.nfila=matriz.length;
        this.ncol=matriz[0].length;
    }

    /**
     * @description Method to get a formated string representing the matrix defined by rows
     * @return matrixFormat 
     */
    public String toStringFilas() {
        StringBuilder sb = new StringBuilder();
        sb. append("[");
        for(int i=0;i!=this.getNfila();i++){
            sb. append("{");
            for(int j=0;j!=this.getNcol(); j++){ 
                sb. append(Integer.toString(this.matriz[i][j]));
                    if (j < this.getNcol()-1) {
                        sb. append(",");
                    }
                }
            sb. append("}");
        }
        sb. append("]");
        return sb.toString();

    }
    
    /**
     * @description Method to get a formated string representing the matrix defined by columns
     * @return matrixFormat 
     */
    public String toStringCol() {
        StringBuilder sb = new StringBuilder();
        sb. append("[");
        for(int j=0;j!=this.getNcol(); j++){ 
            sb. append("{");
            for(int i=0;i!=this.getNfila();i++){
                sb. append(Integer.toString(this.matriz[i][j]));
                    if (i < this.getNfila()-1) {
                        sb. append(",");
                        }
            }
            sb. append("}");
        }
        sb. append("]");
        return sb.toString();
    }
    /**
     * @description Method to get a transpose of a Matrix 
     * @return transposedMatrix
     */
    public int [ ][ ] transpuesta() 
    {
        int [ ][ ] matrizTrans = new int[this.getNcol()][this.getNfila()];
            for(int j=0;j!=this.getNcol(); j++){ 
                for(int i=0;i!=this.getNfila();i++){
                    matrizTrans[j][i] = this.getMatriz()[i][j];
                }
            }
        return matrizTrans;
    }
    /**
     * @description Method to get a the itself transpose of a Matrix 
     * @return transposedMatrix
     */
    public MiMatriz transpuesta(MiMatriz matrizATRansponer)
    {
        MiMatriz miMatriz;
        int [ ][ ] matrizTrans = new int[matrizATRansponer.getNcol()][matrizATRansponer.getNfila()];
            for(int j=0;j!=matrizATRansponer.getNcol(); j++){ 
                for(int i=0;i!=matrizATRansponer.getNfila();i++){
                     matrizTrans[j][i]=matrizATRansponer.getMatriz()[i][j];
                }
            }
        // Properties update
        miMatriz = new MiMatriz(matrizTrans);
        return miMatriz;
    }

}
