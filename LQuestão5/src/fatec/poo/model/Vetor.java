public class Vetor {
    private String[] elementos;
    private int tamanho;
    private static final int TAMANHO_INICIAL = 10; // Tamanho inicial do vetor

    // Construtor que recebe o tamanho inicial do vetor
    public Vetor() {
        this.elementos = new String[TAMANHO_INICIAL];
        this.tamanho = 0;
    }

    // Método para inserir uma string na próxima posição disponível do vetor
    public void insert(String elemento) {
        // Verifica se o vetor precisa ser redimensionado
        if (tamanho == elementos.length) {
            redimensionar();
        }

        // Insere o elemento na próxima posição disponível
        elementos[tamanho] = elemento;
        tamanho++;
    }

    // Método para obter o elemento em uma posição específica do vetor
    public String get(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        } else {
            return null;
        }
    }

    // Método para obter o número de elementos inseridos no vetor
    public int size() {
        return tamanho;
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

    // Exemplo de uso
    public static void main(String[] args) {
        Vetor vetor = new Vetor();

        // Inserir elementos no vetor
        vetor.insert("Elemento 1");
        vetor.insert("Elemento 2");
        vetor.insert("Elemento 3");

        // Obter e imprimir um elemento
        System.out.println("Elemento na posição 1: " + vetor.get(1));

        // Obter e imprimir o tamanho do vetor
        System.out.println("Tamanho do vetor: " + vetor.size());
    }
}










