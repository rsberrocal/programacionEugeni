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

    public void inserirPrimer(int t) {
        NodeList nou = new NodeList(t);
        if (isEmpty()) {
            nou.Next = this.Start;
        }
        this.Start = nou;
    }

    public void eliminarPrimer() {
        NodeList aux;
        if (!isEmpty()) {
            aux = this.Start;
            this.Start = this.Start.Next;
            aux = null;
            // El marquem per al recol·lector de brossa
        }
    }

    public int mostrarPrimer() {
        return this.Start.num;
    }

    public void inserirUltim(int t) {
        NodeList aux = new NodeList(t);
        NodeList aux_tmp;
        if (isEmpty()) {
            inserirPrimer(t);
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

    public void eliminarUltim() {
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

    public int mostrarUltim() {
        int t = 0;
        NodeList aux;
        if (!isEmpty()) {
            aux = this.Start;
            // Recorrem
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            t = aux.getNum();
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

    public int mostrarDada(int pos) {
// retorna la dada indicada en la posició pos
        NodeList aux = this.Start;
        int cont = 0;
        int dada = 0;
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            //recorrem
            while (aux != null) {
                if (pos == cont) {
                    dada = aux.getNum();
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

    public void introduirDada(int pos, int dada) {
        NodeList aux = this.Start;
        // Creem un node per inserir la dada i el punter
        NodeList auxDada = null;
        NodeList anterior = this.Start;
        int cont = 0;
        if (pos < 0 || pos > comptaElements()) {
            System.out.println("Posició incorrecta");
        } else if (pos == 0) {
            inserirPrimer(dada);
        } else if (pos == comptaElements()) {
            inserirUltim(dada);
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

    public void modificarDada(int pos, int dada) {
        NodeList aux = this.Start;
        int cont = 0;
        if (pos < 0 || pos >= comptaElements()) {
            System.out.println("Posició incorrecta");
        } else {
            // Recorrem
            while (aux != null) {
                if (pos == cont) {
                    // Modifiquem la dada directament
                    aux.setNum(dada);
                }
                cont++;
                aux = aux.getNext();
            }
        }
    }

    public void eliminaPosicio(int pos) {
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
