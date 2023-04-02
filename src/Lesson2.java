import java.util.Random;

public class Lesson2 {
    public static void main(String[] args) {
        int[] array = fillArray(20);
        printArray(array);
        heapifySort(array);
        printArray(array);
    }


    //Заполнение массива случайными числами
    public static int[] fillArray(int size){
        int[] array = new int[size];
        Random rnd = new Random();
        for(int i = 0; i< array.length; i++){
            array[i] = rnd.nextInt(size);
        }
        return array;
    }

    //Вывод в консоль
    public static void printArray(int[] array){
        for(int number : array){
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Пирамидальная сортировка
    public static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализация наибольшего элимента как корень
        int leftChild = 2* rootIndex + 1; // левый
        int rightChild = 2* rootIndex + 2; // правый

        //Если правый дочерний элимент больше корня
        if(leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        //Если правый дочерний элимент болеше, чем самый большой элемент на данный момент
        if(rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }

        //Если самый большой элемент не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            //Рекурсивно преобразуем в двоичную кучу затронутую поддерево
            heapify(array, heapSize, largest);
        }
    }

    public static void heapifySort(int[] array){
        // Построение кучи(перегрупируем массив)
        for(int i = array.length/2 -1; i >= 0; i--){
            heapify(array, array.length, i);
        }
        // Один за другим извлекаем элименты из кучи
        for(int i = array.length-1; i>=0; i--){
            //Перемещаем текущий корень в конец
            int temp = array[0];
            array[0]= array[i];
            array[i] = temp;

            //вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
}
