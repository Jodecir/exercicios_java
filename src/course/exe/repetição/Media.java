package src.course.exe.repetição;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Media {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nome, situacao;
        double n1, n2, n3, n4;
        int quantAlunos;
        int min = 0;
        int max = 10;
        int mediaAprovacao = 8;
        int mediaRecuperacao = 7;

        int count = 0;

        boolean fechado = false;
        String repetir;

        do {
            quantAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Alunos: "));
            
            do {
                nome = JOptionPane.showInputDialog("Insira o nome do Aluno:");
                n1 = Double.parseDouble(JOptionPane.showInputDialog("Nota do 1º Bimestre:"));
                while (n1 > max || n1 < min) {
                    n1 = Double.parseDouble(JOptionPane.showInputDialog("Nota Inválida, Repita o 1º Bimestre:"));
                }
                n2 = Double.parseDouble(JOptionPane.showInputDialog("Nota do 2º Bimestre:"));
                while (n2 > max || n2 < min) {
                    n2 = Double.parseDouble(JOptionPane.showInputDialog("Nota Inválida, Repita o 2º Bimestre:"));
                }
                n3 = Double.parseDouble(JOptionPane.showInputDialog("Nota do 3º Bimestre:"));
                while (n3 > max || n3 < min) {
                    n3 = Double.parseDouble(JOptionPane.showInputDialog("Nota Inválida, Repita o 3º Bimestre:"));
                }
                n4 = Double.parseDouble(JOptionPane.showInputDialog("Nota do 4º Bimestre:"));
                while (n4 > max || n4 < min) {
                    n4 = Double.parseDouble(JOptionPane.showInputDialog("Nota Inválida, Repita o 2º Bimestre:"));
                }

                double media = criarMedia(n1, n2, n3, n4);

                if (media >= mediaAprovacao) {
                    situacao = "Aprovado";
                } else if (media >= mediaRecuperacao ) {
                    situacao = "em Recuperação";
                } else {
                    situacao = "Reprovado";
                }
        
                JOptionPane.showMessageDialog(null, "A Média do aluno " + nome + " é " + media + " e ele está " + situacao);

                count = count + 1;
            } while(count < quantAlunos);
            
            System.out.println("Deseja continuar (s/n): ");
            repetir = scan.next();
            if (repetir.equals("n")) {
                System.out.println("Finalizado aqui...");
                fechado = true;
            }
        } while (fechado == false);
        scan.close();
    }

    public static double criarMedia(double a, double b, double c, double d) {
        return (a + b + c + d) / 4;
    }
}
