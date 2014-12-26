package entities;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

import utils.ESInteractiva;

/**
 *
 * @description Entity Class for Mi Vector
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class MiVector {
    private Vector vector;
    private Random random;

    /**
     *
     * @description Constructor by default
     * @param coche
     */
    public MiVector() {
        this.vector = new Vector();
        this.random = new Random();
        Integer in;
        int nAle = 0, i = 0, base = 900, top = 100;
        while (i != 10) {
            nAle = base + random.nextInt(top);
            in = new Integer(nAle);
            vector.addElement(in);
            i++;
        }

    }

    /**
     *
     * @description Parametrized Constructor
     * @param n Vector size
     */
    public MiVector(Integer n) {
        this.vector = new Vector();
        this.random = new Random();
        Integer in;
        int nAle = 0, i = 0, base = 900, top = 100;
        while (i != n) {
            nAle = base + random.nextInt(top);
            in = new Integer(nAle);
            vector.addElement(in);
            i++;
        }

    }

    /**
     * @description Method to get a formated string representing vector values
     * @return vectorFormat
     */
    public String toString() {
        String vectorFormat = "{", element;
        for (int i = 0, size = vector.size(); i != size; i++) {
            element = Integer.toString((Integer) vector.elementAt(i));
            if (i <= size - 2) {
                vectorFormat += element + ",";
            } else {
                vectorFormat += element + "}";
            }
        }
        return vectorFormat;

    }

    /**
     * @description Method to get a the maximun value within the range of vector values
     * @return mayor Maximun value
     */
    public Integer valorMayor() {
        int mayor = 0, valor = 0;
        Enumeration e = this.vector.elements();
        while (e.hasMoreElements()) {
            valor = (Integer) e.nextElement();
            if (valor > mayor) {
                mayor = valor;
            }
        }
        return mayor;
    }

    /**
     * @description Method to get a the minimun value within the range of vector values
     * @return menor Minimun value
     */
    public Integer valorMenor() {
        int menor = 9999, valor = 0;
        Enumeration e = this.vector.elements();
        while (e.hasMoreElements()) {
            valor = (Integer) e.nextElement();
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    /**
     * @description Method to get a the index asociated to the maximun value within the range of vector values
     * @return mayor Index asociated to the maximun value
     */
    public Integer posicionMayor() {
        //base = 1, vector indexes starts at 0, so 1 is summed to become more human friendly
        int index = 0, posMay = 0, mayor = 0, valor = 0, base = 1;
        while (index < this.vector.size()) {
            valor = (Integer) this.vector.elementAt(index);
            if (valor > mayor) {
                mayor = valor;
                posMay = index + base;
            }
            index++;
        }
        return posMay;
    }

    /**
     * @description Method to get a the average value among the range of vector values
     * @return average Average
     */
    public Double media() {
        int index = 0;
        Double sumTotal = 0.0;
        while (index < this.vector.size()) {
            sumTotal += (Integer) this.vector.elementAt(index);
            index++;
        }
        return sumTotal / index;
    }

    /**
     * @description Method to get a the mediana value
     * @return mediana Index asociated to the mediana value
     */
    @SuppressWarnings("unchecked")
    public Double mediana() {
        Integer inOri;
        int indexActualPos = 0, indexInserc = 0, index = 0, menor = 9999, valor = 0, posEnMedio =0;
        Double posMediana = 0.0,posMediana_1=0.0,posMediana_2=0.0;
        Vector vectorSorted  = new Vector();
        Enumeration e = this.vector.elements();
        // Inserting values to vector to be sorted
        while (e.hasMoreElements()) {
            inOri = (Integer) e.nextElement();
            vectorSorted.addElement(inOri);
        }
        // Sortering vector
        while (indexInserc < vectorSorted.size()) {
            index = indexInserc;
            menor = 9999;
            while (index < vectorSorted.size()) {
                valor = (Integer) vectorSorted.elementAt(index);
                if (valor < menor) {
                    menor = valor;
                    indexActualPos = index;
                }
                index++;
            }
            vectorSorted.removeElementAt(indexActualPos);
            vectorSorted.insertElementAt(menor, indexInserc);
            indexInserc++;
        }
        ESInteractiva.escribe("Vector original: " + this.vector.toString());
        ESInteractiva.escribe("Vector ordenado: " + vectorSorted.toString());
        // Mediana calculations, different for odd and even vector size
        posEnMedio = vectorSorted.size() / 2;
        posMediana = (double)((Integer) vectorSorted.elementAt(posEnMedio));
        if (vectorSorted.size()%2==0){
            posMediana_1 = (double)((Integer)vectorSorted.elementAt(posEnMedio));
            posMediana_2 = (double)((Integer)vectorSorted.elementAt(posEnMedio-1));
            posMediana=(posMediana_1+posMediana_2)/2;
        }
        return posMediana;
    }

    /**
     * @description Method to get a the average value among the range of vector values
     * @return mayor Index asociated to the maximun value
     */
    public boolean equals(Object obj) {
        boolean res = false;
        boolean equalsFlag = true;
        if (this == obj) {
            res = true;
        } else if ((obj != null) && (getClass() == obj.getClass())) {
            MiVector otroVector = (MiVector) obj;
            if (this.vector.size() == otroVector.vector.size()) {
                for (int i = 0; i <= this.vector.size() && equalsFlag; i++) {
                    if (this.vector.elementAt(i) != otroVector.vector.elementAt(i)) {
                        equalsFlag = false;
                    }
                }
                res = equalsFlag;
            }

        }
        return res;
    }
}
