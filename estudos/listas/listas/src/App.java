import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        List <String> list = new ArrayList<>();

        list.add("Arthur");
        list.add("felipe");
        list.add("Joao");
        list.add("Kayque");
        list.add("Heitor");
        list.add("Heitor Felipe");

        list.add(2, "Cristiano");/* Adicionou o Cristiano no lugar do joao, mas a lista so faz essa troca e continuar a mesma */
        list.remove(1); /* Remove o elemento 1 da lista, no caso, o Felipe */
        list.remove("Heitor"); /* Remove somente Heitor. Não remove outros nomes */
        list.add("Helena");


        System.out.println(list.size()); /* Tamanho da lista */

        for (String x : list){
            System.out.println(x);
        }
        System.out.println("-----------------------------------------------------");

        list.removeIf(x -> x.charAt(0) == 'H'); /* Remove todos os nomes com a letra H */

           for (String x : list){
            System.out.println(x);
        }

        System.out.println("Encontrar posição do elemento Kayque: " + list.indexOf("Kayque"));/* Encontrar posição do elemento */

        System.out.println("-----------------------------------------------------------");
        List <String> result = list.stream().filter (x -> x.charAt(0) == 'A').collect(Collectors.toList()); /* Mostra somente quem tem a letra A no começo */
        System.out.println(result);
        System.out.println("-----------------------------------------------------------");

        String name = list.stream().filter (x -> x.charAt(0) == 'A').findFirst() .orElse(null); /* Imprimir a primeira pessoa com a letra A na lista */
        System.out.println(name);
    }
}
