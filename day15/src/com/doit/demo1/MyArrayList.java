package com.doit.demo1;

import java.util.*;

/**
 * @ClassName: MyArrayList
 * @Author: zll
 * @CreateTime: 2021/6/23 11:08
 * @Desc: java 程序
 * @Version: 1.0
 */

public class MyArrayList<E> {
    private int size;
    private Object[] data;
    private final static int DEFAULT_CAPACITY = 10;
    private final Object[] emptyArray = {};

    public MyArrayList(){
        this.data = emptyArray;
    }

    public boolean add(E e) {
        if(data.length==0){
             data = new Object[DEFAULT_CAPACITY];
        }
        grow();
        data[size++] = e;
        return true;
    }

    public void grow() {
        if (size == data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity + oldCapacity>>1;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public E remove(int index) {
        check(index);
        int length = size-index-1;
        System.arraycopy(data, index+1, data, index,length);
        data[--size]=null;
        return (E) data[index];
    }

    public E remove(E e) {
        for (int i = 0; i < size; ++i) {
            if (data[i].equals(e)) {
                int length = size-i-1;
                System.arraycopy(data, i+1, data, i,length);
                data[--size]=null;
                return (E) data[i];
            }
        }
        return null;
    }

    public boolean add(int index, E e){
        check(index);
        grow();
        int length = size - index;
        System.arraycopy(data, index, data, index+1, length);
        data[index] = e;
        size++;
        return true;
    }

    public void check(int index){
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("index越界了"+index);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (data == null){
            return "null";
        }
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i==size-1) {
                sb.append(']');
            }else {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    private class Itr implements Iterator<E> {
        int cursor;
        int i;

        public Itr() {
        }

        @Override
        public boolean hasNext() {
            return cursor !=size;
        }

        @Override
        public E next() {
            i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            cursor = i+1;
            return (E) MyArrayList.this.data[i];
        }
    }

    public Iterator<E> iterator() {
        return new Itr();
    }
}
