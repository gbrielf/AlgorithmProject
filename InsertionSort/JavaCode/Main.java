import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class InsertionSort
{
    private int[] ordenedList = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas
    private int lengthList;

    public InsertionSort(int[] ordenedList, int lengthList)
    {
        this.ordenedList = ordenedList;
        this.lengthList = lengthList;
    }

    public int[] OrdenedList()
    {
        int i, j, aux;

        for(i = 1; i < lengthList; i++)
        {
            j = i;
            while (j > 0 && ordenedList[j] < ordenedList[j-1])
            {
                aux = ordenedList[j];
                ordenedList[j] = ordenedList[j-1];
                ordenedList[j-1] = aux;
                j--;
            }
        }
        return ordenedList;
    }

    public void PrintList(int[] sortedList, int lengthList)
    {
        for(int i = 0; i < lengthList; i++)
        {
            System.out.printf("%d ", sortedList[i]);
        }
        System.out.print("\n");
    }
}

public class Main {
    public static void main(String arg[]) throws IOException
    {   
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;

        // Informação da Quantidade de Entradas
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();

        scanner.close();

        while(count < 4){
            int[] list = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

            for(int i = 0; i < lengthList; i++)
            {
                list[i] = random.nextInt(lengthList);
            }

            InsertionSort insertionsort = new InsertionSort(list, lengthList);

            // Medir o Tempo de Processamento do Algoritmo Insertion Sort
            long start = System.nanoTime();
            list = insertionsort.OrdenedList();
            long end = System.nanoTime() - start;

            System.out.println(end);
            // insertionsort.PrintList(list, lengthList); // Imprimir a Lista Ordenada

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);

            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}