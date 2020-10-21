//это дженерик, чтобы знать какой класс хранится в массиве
public class MyList<T> {
    private T[] mass = (T[]) new Object[0];
    private int curLen = 0;

    //тут различные конструкторы
    public MyList() {
    }

    public MyList(T[] mass) {
        this.mass = mass;
        curLen = mass.length;
    }

    public int length() {
        return curLen;
    }

    //заменяем элемент
    public void put(T element, int index) {
        mass[index] = element;
    }

    //добавляем элемент
    /*
    совпадает ли длина пассива с текущей длиной доступного списка
    если совпадает запоминаем массив и расширяем текущий на 1 элемент копируем обратно, добавляем элемент
    */
    public void push(T elem) {
        if (curLen == mass.length) {
            T[] tempMass = mass;
            mass = (T[]) new Object[curLen+1];
            //написал циклом, IDE предложила исправить
            System.arraycopy(tempMass, 0, mass, 0, tempMass.length);
        }
        mass[curLen] = elem;
        curLen++;
    }

    //добавляем на место
    /*
    если индекс больше текущей длины то ничего не добавляем иначе будут дыры в массиве
    если индекс равен текущей длине то см push
    совпадает ли длина пассива с текущей длиной доступного списка
    если совпадает запоминаем массив и расширяем текущий на 1 элемент копируем обратно,
    сдвигаем после n значения вправо чтобы освободить место
    добавляем элемент
    */
    public void pushTo(T elem, int index) {
        if (index > curLen) {
            return;
        }
        if (index == curLen) {
            push(elem);
            return;
        }
        if (curLen == mass.length) {
            T[] tempMass = mass;
            mass = (T[]) new Object[curLen+1];
            //то же самое
            System.arraycopy(tempMass, 0, mass, 0, tempMass.length);
        }
        curLen++;
        for (int i = curLen-2; i >= index; i--) {
            mass[i+1] = mass[i];
        }
        mass[index] = elem;
    }

    //удаляем последний элемент
    public T pop() {
        curLen--;
        return mass[curLen];
    }
    //удаляем элемент n
    public T pop(int n) {
        T r = mass[n];
        for (int i = n; i < curLen-1; i++) {
            mass[i] = mass[i+1];
        }
        curLen--;
        return r;
    }

    public T getIndexOf(int i) {
        return mass[i];
    }
}
