package fatec.poo.model;

public class Aluno {
    private String matricula;
    private String nome; // Alterei o tipo de int para String para representar o nome corretamente.
    private float p1;
    private float p2;
    private float t1;
    
    public Aluno(String matricula, String nome, float p1, float p2, float t1){
        this.matricula = matricula;
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
        this.t1 = t1;
    }
    
    //calcula a média final do aluno (cada prova tem peso 2,5 e o trabalho tem peso 2)
    //transformado em p1 * 2.5f e assim por diante
    public float calcularMedia(){
        return(p1 * 2.5f + p2 *2.5f + t1 * 2)/7.0f;
    }
    
    public float calcularFinal(){
        float media = calcularMedia();
        if(media < 5.0f){
            return 10.0f - media;
        } else {
            return 0.0f;
        }
    }

    // Método getter para matricula
    public String getMatricula() {
        return matricula;
    }

    // Método setter para matricula
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método getter para nome
    public String getNome() {
        return nome;
    }

    // Método setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para p1
    public float getP1() {
        return p1;
    }

    // Método setter para p1
    public void setP1(float p1) {
        this.p1 = p1;
    }

    // Método getter para p2
    public float getP2() {
        return p2;
    }

    // Método setter para p2
    public void setP2(float p2) {
        this.p2 = p2;
    }

    // Método getter para t1
    public float getT1() {
        return t1;
    }

    // Método setter para t1
    public void setT1(float t1) {
        this.t1 = t1;
    }
}
