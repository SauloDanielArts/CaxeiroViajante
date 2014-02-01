/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheiroviajante;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author saulo
 */
public class Viajante {

    private int[] caminho = new int[10];
    private float distP;//sistancia percorida

    public Viajante() {
        distP = 0;

        for (int i = 0; i < 10; i++) {
            caminho[i] = i + 1;
        }
    }

    public int[] getCaminho() {
        return caminho;
    }

    public float getDistP() {
        return distP;
    }

    public void setDistP(float distP) {
        this.distP = distP;
    }

    

    public void setCaminho(int[] caminho) {
        this.caminho = caminho;
    }

    public void RandCaminho() {
        //sorteia um caminho formado por pomtos de 1 a 10

        Random random = new Random();

        caminho[0] = 0;

        for (int i = 1; i < 10; i++) {

            boolean eq;

            do {
                eq = false;

                caminho[i] = random.nextInt(9);

                for (int j = i - 1; j > 0; j--) {
                    if (caminho[i] == caminho[j]) {
                        eq = true;
                    }
                }
            } while (eq == true);

        }

        for (int i = 1; i < 10; i++) {
            if (caminho[i] == caminho[0]) {
                caminho[i] = 9;}
        }

        //String s = "";
        //System.out.println("\n Caminho: \n");
        //for (int i = 0; i < 10; i++) {
        //    s = s + " " + caminho[i];
        //}
        //System.out.println(s);


    }

public void CalDistancia(float[][] rota) {
        //calcula a distancia Euclidiana para cada rota

        float dp = 0;
        for (int i = 0; i < 9; i++) {

                   dp = dp + rota[caminho[i]][caminho[i+1]];
                  // System.out.println("\n: " + rota[caminho[i]-1][caminho[i+1]-1]);

        }

        dp = dp + rota[caminho[0]][caminho[9]];
        //System.out.println("\n: " + rota[caminho[0]-1][caminho[9]-1]);

        //System.out.println("\n Distancia: " + dp);

        distP = dp;
    }
}
