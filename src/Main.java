import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // analisarCandidato(2000.0);
        // analisarCandidato(1900.0);
        // analisarCandidato(2100.0);



        // selecaoCandidatos();

        String [] candidatos = {"Victoria", "Vitor", "Julio", "Gustavo", "Julio Filho", "Lucidalia", "Bia", "João"};

        for(String candidato: candidatos){
            entrandoContato(candidato);
        }

    }

    static void entrandoContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Contato Realizado com Sucesso!");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO MAXÍMO DE TENTATIVAS REALIZADAS");
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Victoria", "Vitor", "Julio", "Gustavo", "Julio Filho", "Lucidalia", "Bia", "João"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados <= 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidado " + candidato + "foi selecionado para vaga!");
                candidatosSelecionados++;
            }
            System.out.println("=====================================");
            System.out.println("Quatidade de candidatos selecionados: " + candidatosSelecionados);
            System.out.println("=====================================");
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioPretendido < salarioBase) {
            System.out.println("LIGAR PARA CANDIDATO!");
        } else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}