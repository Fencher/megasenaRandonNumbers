/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Luiz
 */
public class Megasena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mega();

    }

    public static void mega() {
        System.out.println("Start! " + new Date());
        HashMap<Integer, Integer> mapaLances = new HashMap();
        boolean rodando = true;
        do {
            Random generator = new Random();
            Integer lance = generator.nextInt(60) + 1;

            boolean contains = false;
            for (Map.Entry<Integer, Integer> entry : mapaLances.entrySet()) {
                if (entry.getKey().equals(lance)) {
                    entry.setValue(entry.getValue() + 1);
                    contains = true;
                }
            }

            if (!contains) {
                mapaLances.put(lance, 1);
            }

            boolean ret = verificaSeisNumeros(mapaLances);
            if (ret) {
                rodando = false;
            }

        } while (rodando);

        System.out.println("Finish! " + new Date());
    }

    private static boolean verificaSeisNumeros(HashMap<Integer, Integer> mapaLances) {
        int contador = 0;
        List<Integer> list = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : mapaLances.entrySet()) {
            if (entry.getValue() > 10000) {
                contador++;
                list.add(entry.getKey());
            }
        }
        if (contador >= 6) {
            for (Integer numero : list) {
                System.out.println("Numero ~> " + numero + "\n");
            }
            return true;
        }
        return false;
    }

}
