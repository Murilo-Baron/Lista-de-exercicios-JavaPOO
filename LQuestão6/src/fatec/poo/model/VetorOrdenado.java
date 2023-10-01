public class VetorOrdenado {
    private String[] elementos;
    private int tamanho;
    private static final int TAMANHO_INICIAL = 10; // Tamanho inicial do vetor

    // Construtor que recebe o tamanho inicial do vetor
    public VetorOrdenado() {
        this.elementos = new String[TAMANHO_INICIAL];
        this.tamanho = 0;
    }

    // Método para inserir uma string mantendo o vetor ordenado
    public void insert(String elemento) {
        // Verifica se o vetor precisa ser redimensionado
        if (tamanho == elementos.length) {
            redimensionar();
        }

        // Encontra a posição de inserção para manter o vetor ordenado
        int posicao = 0;
        while (posicao < tamanho && elemento.compareTo(elementos[posicao]) > 0) {
            posicao++;
        }

        // Desloca os elementos para abrir espaço para o novo elemento
        for (int i = tamanho; i > posicao; i--) {
            elementos[i] = elementos[i - 1];
        }

        // Insere o elemento na posição correta
        elementos[posicao] = elemento;
        tamanho++;
    }

    // Método para realizar o merge de dois vetores ordenados
    public static VetorOrdenado merge(VetorOrdenado vetor1, VetorOrdenado vetor2) {
        VetorOrdenado resultado = new VetorOrdenado();

        int i = 0, j = 0;
        while (i < vetor1.tamanho && j < vetor2.tamanho) {
            // Compara os elementos dos dois vetores e insere o menor no vetor resultante
            if (vetor1.elementos[i].compareTo(vetor2.elementos[j]) < 0) {
                resultado.insert(vetor1.elementos[i]);
                i++;
            } else {
                resultado.insert(vetor2.elementos[j]);
                j++;
            }
        }

        // Adiciona os elementos restantes, se houver, de cada vetor ao vetor resultante
        while (i < vetor1.tamanho) {
            resultado.insert(vetor1.elementos[i]);
            i++;
        }

        while (j < vetor2.tamanho) {
            resultado.insert(vetor2.elementos[j]);
            j++;
        }

        return resultado;
    }

    // Método privado para redimensionar o vetor quando necessário
    private void redimensionar() {
        int novoTamanho = elementos.length * 2; // Dobrar o tamanho
        String[] novoArray = new String[novoTamanho];

        // Copiar os elementos para o novo array
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length);

        // Atualizar a referência para o novo array
        elementos = novoArray;
    }

    // Método para imprimir os elementos do vetor
    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(elementos[i]);
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        VetorOrdenado vetor = new VetorOrdenado();

        // Inserir elementos no vetor
        vetor.insert("B");
        vetor.insert("D");
        vetor.insert("A");
        vetor.insert("C");

        // Imprimir vetor ordenado
        System.out.println("Vetor ordenado:");
        vetor.imprimir();

        // Criar outro vetor ordenado
        VetorOrdenado outroVetor = new VetorOrdenado();
        outroVetor.insert("E");
        outroVetor.insert("F");
        outroVetor.insert("A");

        // Realizar o merge dos dois vetores
        VetorOrdenado resultado = VetorOrdenado.merge(vetor, outroVetor);

        // Imprimir resultado do merge
        System.out.println("\nResultado do merge:");
        resultado.imprimir();
    }
}
