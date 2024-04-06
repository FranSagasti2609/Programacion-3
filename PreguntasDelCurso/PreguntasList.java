package PreguntasDelCurso;

import java.io.Serializable;

/**
 * @file PreguntasList.java
 * @brief Clase que representa una lista de preguntas para ser utilizada en un juego de preguntas y respuestas.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import PreguntasDelCursoMVC.Randomizer;
import PreguntasDelCursoMVC.Modelo.Pregunta;

 /**
  * @class PreguntasList
  * @brief Clase que representa una lista de preguntas para ser utilizada en un juego de preguntas y respuestas.
  */
 public class PreguntasList implements Serializable, List<Pregunta>  {
     private ArrayList<Pregunta> questionList; 
 
     /**
      * @brief Constructor para la clase PreguntasList.
      */
     public PreguntasList() {
         questionList = new ArrayList<>();
     }
 
     /**
      * @brief Método para agregar una pregunta a la lista.
      * @param q La pregunta a agregar a la lista.
      */
     public void addQuestion(Pregunta q) {
         questionList.add(q);
     }
 
     /**
      * @brief Método para eliminar una pregunta de la lista.
      * @param q La pregunta a eliminar de la lista.
      */
     public void removeQuestion(Pregunta q) {
         questionList.remove(q);
     }
 
     /**
      * @brief Método para obtener una pregunta de la lista.
      * @param index El índice de la pregunta a obtener.
      * @return La pregunta en el índice especificado.
      */
     public Pregunta getQuestion(int index) {
         return questionList.get(index);
     }
 
     /**
      * @brief Método para obtener el número de preguntas en la lista.
      * @return El número de preguntas en la lista.
      */
     public int size() {
         return questionList.size();
     }
 
     /**
      * @brief Método para obtener una pregunta aleatoria de la lista.
      * @return Una pregunta aleatoria de la lista.
      */
     public Pregunta getRandomQuestion() {
         int randomIndex = Randomizer.getRandomIndex(0, questionList.size() - 1);
         return questionList.get(randomIndex);
     }
 
     /**
      * @brief Método para verificar si una pregunta ya está en la lista.
      * @param q La pregunta a verificar.
      * @return Verdadero si la pregunta está en la lista, falso en caso contrario.
      */
     public boolean containsQuestion(Pregunta q) {
         return questionList.contains(q);
     }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<Pregunta> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(Pregunta e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends Pregunta> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Pregunta> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Pregunta get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Pregunta set(int index, Pregunta element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, Pregunta element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Pregunta remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<Pregunta> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<Pregunta> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<Pregunta> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
 }
 