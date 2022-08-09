package aut.testcreation.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        List<Integer> resultado = new ArrayList<Integer>();
        int contadorArr=0;
        int contadorBrr=0;

        for (int i=0; i<brr.size(); i++){
            Integer numbrrI=brr.get(i);
            for(int j=0; j<brr.size(); j++){
                Integer numbrrJ=brr.get(j);
                if (numbrrI.compareTo(numbrrJ)==0){
                    contadorBrr++;
                }             }
            for (int k=0; k<arr.size(); k++){
                Integer numbrrK= arr.get(k);
                if (numbrrI.compareTo(numbrrK)==0) {
                    contadorArr++;
                }
            }
            if (contadorBrr>contadorArr)resultado.add(brr.get(i));

        }
        Collections.sort(resultado);
        return resultado;

    }

    public static void main(String[] args) {
        List<Integer> Arr= new ArrayList<>();
        List<Integer> Brr= new ArrayList<>();

        Integer[] arr = {203 ,204 ,205, 206 ,207 ,208, 203 ,204 ,205, 206};
        Integer[] brr = {203 ,204, 204 ,205 ,206 ,207, 205 ,208 ,203, 206, 205 ,206, 204};

        for (Integer elem : brr){
            Brr.add(elem);
        }
        for (Integer elem : arr){
            Arr.add(elem);
        }

        missingNumbers(Arr,Brr);

        for(Integer e : missingNumbers(Arr,Brr)){
            System.out.println( e );
        }

    }


}
