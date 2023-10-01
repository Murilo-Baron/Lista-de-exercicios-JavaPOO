public class Prova {
    private final Gabarito gabarito;
    private String respostasAluno;
    
    // Construtor que recebe o gabarito como parâmetro
    public Prova(Gabarito gabarito) {
        this.gabarito = gabarito;
        this.respostasAluno = "";
    }
    
    // Método para registrar a resposta do aluno
    public void respostaAluno(char resposta) {
        this.respostasAluno += resposta;
    }
    
    // Método que retorna a quantidade de acertos
    public int acertos() {
        int qtdAcertos = 0;
        for (int i = 0; i < respostasAluno.length(); i++) {
            if (respostasAluno.charAt(i) == gabarito.respostaQuestao(i + 1)) {
                qtdAcertos++;
            }
        }
        return qtdAcertos;
    }
    
    // Método que retorna a nota do aluno
    public double nota() {
        int qtdAcertos = acertos();
        double nota = (qtdAcertos < 10) ? qtdAcertos * 0.5 : 5 + (qtdAcertos - 10);
        return nota;
    }
    
    // Método que compara duas provas e retorna a com maior nota ou mais acertos em caso de empate
    public double maior(Prova outraProva) {
        int acertosThis = this.acertos();
        int acertosOutra = outraProva.acertos();

        if (acertosThis > acertosOutra || (acertosThis == acertosOutra && this.nota() > outraProva.nota())) {
            return this.nota();
        } else {
            return outraProva.nota();
        }
    }
}
