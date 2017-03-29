/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.listperson;

/**
 *
 * @author infot
 */
public class List {

    NodeList Start;

    public List() {
        this.Start = null;

    }

    public boolean isEmpty() {
        return this.Start == null;
    }

    public void setFirst(Person t) {
        NodeList nL = new NodeList(t);
        if (isEmpty()) {
            nL.Next = this.Start;
        }
        this.Start = nL;
    }

    public void removeFirst() {
        NodeList aux;
        if (!isEmpty()) {
            aux = this.Start;
            this.Start = this.Start.Next;
            aux = null;
            // El marquem per al recol·lector de brossa
        }
    }

    public Person printFirst() {
        return this.Start.p;
    }

    public void setLast(Person t) {
        NodeList aux = new NodeList(t);
        NodeList aux_tmp;
        if (isEmpty()) {
            setFirst(t);
        } else {
            aux_tmp = Start;
            //busquem l'últim node
            while (aux_tmp.getNext() != null) {
                aux_tmp = aux_tmp.getNext();
            }
            // Actualitzem el següent de l'últim
            aux_tmp.setNext(aux);
        }
    }

    public void removeLast() {
        NodeList aux = this.Start;
        if (aux.getNext() == null) {
            isEmpty();
        }
        if (!isEmpty()) {
            aux = this.Start;
        }
        //   Busquem   el   penúltim,   per   això   hi   han   dos        getNexts
        while (aux.getNext().getNext() != null) {
            aux = aux.getNext();
        }
        //Marquem el   següent   del   antepenúltim   com   nul,        eliminant l   'últim
        aux.setNext(null);
    }

    public Person printLast() {
        Person t = new Person();
        NodeList aux;
        if (!isEmpty()) {
            aux = this.Start;
            // Recorrem
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            t = aux.getP();
        }
        return t;
    }

    public int comptaElements() {
        NodeList aux;
        int numElements = 0;
        aux = this.Start;
        // Recorrem
        while (aux != null) {
            numElements++;
            aux = aux.getNext();
        }
        return numElements;
    }

    public Person mostrarDada(int pos) {
// retorna la dada indicada en la posició pos
        NodeList aux = this.Start;
        int cont = 0;
        Person dada = new Person();
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            //recorrem
            while (aux != null) {
                if (pos == cont) {
                    dada = aux.getP();
                }
                aux = aux.getNext();
                cont++;
            }
        }
        return dada;
    }

    public NodeList retornarNode(int pos) {
        // retorna el node de la posició indicada (pos)
        NodeList aux = this.Start;
        int cont = 0;
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            // recorrem
            while (aux != null) {
                if (pos == cont) {
                    // Retorne aux, i sortim
                    return aux;
                }
                // Actualitze el següent
                aux = aux.getNext();
                cont++;
            }
        }
        return aux;
    }

    public void addWithPos(int pos, Person dada) {
        NodeList aux = this.Start;
        // Creem un node per inserir la dada i el punter
        NodeList auxDada = null;
        NodeList anterior = this.Start;
        int cont = 0;
        if (pos < 0 || pos > comptaElements()) {
            System.out.println("Posició incorrecta");
        } else if (pos == 0) {
            setFirst(dada);
        } else if (pos == comptaElements()) {
            setLast(dada);
        } else {
            // Recorrem
            while (aux != null) {
                if (pos == cont) {
                    // cree el node
                    auxDada = new NodeList(dada, aux);
                    anterior.setNext(auxDada);
                }
                // Actualitza anterior
                anterior = aux;
                cont++;
                // Actualitze següent
                aux = aux.getNext();
            }
        }
    }

    public void modifyWithPos(int pos, Person dada) {
        NodeList aux = this.Start;
        int cont = 0;
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            // Recorrem
            while (aux != null) {
                if (pos == cont) {
                    // Modifiquem la dada directament
                    aux.setP(dada);
                }
                cont++;
                aux = aux.getNext();
            }
        }
    }

    public void removeWithPos(int pos) {
        NodeList aux = this.Start;
        NodeList anterior = null;
        int cont = 0;
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            while (aux != null) {
                if (pos == cont) {
                    if (anterior == null) {
                        this.Start = this.Start.getNext();
                    } else {
                        anterior.setNext(aux.getNext());
                    }
                    aux = null;
                } else {
                    anterior = aux;
                    aux = aux.getNext();
                    cont++;
                }
            }

        }
    }
}
