package RepartoEquitativo;

public class RepartoEquitativo {

    public static  boolean hayRepartoEquitativo(int[] bienes){
        int sumaBienes = suma(bienes);
        if (sumaBienes % 3 != 0)
            return false;
        else
            return hayRepartoEquitativoAux(bienes,0, 0, 0, 0, sumaBienes);
    }

    private static boolean hayRepartoEquitativoAux(int[] bienes, int n, int suma1, int suma2, int suma3, int totalBienes){
        if (n == bienes.length)
            return suma1 == suma2 && suma2 == suma3;
        else{
            //Existen tres posibles ramas, cada una de ellas significa asignar el bien a uno de los herederos
            if (suma1 + bienes[n] <= totalBienes/3) //primer heredero
                //no es necesario anotar ni desanotar por como esta implementado el algortimo
                if (hayRepartoEquitativoAux(bienes, n+1, suma1+bienes[n], suma2, suma3, totalBienes))
                    return true;
            if (suma2 + bienes[n] <= totalBienes/3)//segundo heredero
                if (hayRepartoEquitativoAux(bienes, n+1, suma1, suma2+bienes[n], suma3, totalBienes))
                    return true;
            if (suma3 + bienes[n] <= totalBienes/3) //tercer heredero
                if (hayRepartoEquitativoAux(bienes, n+1, suma1, suma2, suma3+bienes[n], totalBienes))
                    return true;
            return false;
        }
    }

    private static int suma(int[] arr){
        int suma = 0;
        for (int i = 0; i < arr.length ; i++)
            suma+= arr[i];
        return suma;
    }

    public static void main(String[] args){
        int[] bienes = {3,3,3,3};
        System.out.println(hayRepartoEquitativo(bienes));
    }
}
