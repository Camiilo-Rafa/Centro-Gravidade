/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrogravidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Camil
 */
public class CentroGravidade {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
                     
        int linha; //Armazenha a linha informada no txt
        int coluna; //Armazenha a coluna informada no txt
        int linhaCerta = 0; //Armazena a linha que compõe o centro de gravidade
        int colunaCerta = 0; //Armazena a coluna que compõe o centro de gravidade
        int indice = 2; //Indice do vetor de doubles, descontados os valores informados para a linha e a coluna
        double[] valoresDouble; //Armazena os valores convertidos de String para double
        double[] linhasSomadas; //Armazena as somas de cada linha
        double[] colunasSomadas; //Armazena as somas de cada coluna
        double maiorLinha; //Valor arbitrário para a linha que compõe o centro de gravidade
        double maiorColuna; //Valor arbitrário para a coluna que compõe o centro de gravidade
        double[][] dadosTabulados; //Armazena os valores em formato matricial
        String localArquivo = "centro_gravidade.txt";
        String valoresLinhas = null; //Armazena os valores de todas as linhas lidas
        String linhaLida; //Armazena cada linha lida
        String[] valoresString; //Armazena os valores da String valoresLinhas
        Scanner leitor = new Scanner(System.in); //Caso queira informar o caminho do arquivo pelo console

        //Tratamento de exceções
        try {
            FileReader leitorArquivo = new FileReader(localArquivo); //Lê um arquivo de texto
            BufferedReader buffer = new BufferedReader(leitorArquivo); //Lê um fluxo de caracteres armazenando-os em um buffer

            linhaLida = buffer.readLine(); //Lê uma linha
            valoresLinhas = linhaLida; //Coloca a linha lida na String dados

            while (linhaLida != null) {
                linhaLida = buffer.readLine(); //Lê uma linha
                valoresLinhas += linhaLida; //Contaena a primeira linha lida com as demais
            }
            leitorArquivo.close(); //Fecha o FileReader
        } catch (IOException ioex) {
            System.out.println("ERRO: " + ioex.getMessage());
        }

        //Mostra o tamanho dos dados se houver
        if (valoresLinhas != null) {
            System.out.print("\tTamanho da linha: " + valoresLinhas.length() + "\n");
        } else {
            System.out.println("\tTamanho da linha: " + 0 + "\n");
        }

        //Separa os valores da String dados com base em espaços
        valoresString = valoresLinhas.split(" ");
        valoresDouble = new double[valoresString.length - 1]; //Determina o tamanho do vetor valoresDouble

        //Converte double e adiciona cada valor de do vetor de Strings valoresString em valoresDouble
        for (int i = 0; i < (valoresDouble.length); i++) {
            valoresDouble[i] = Double.valueOf(valoresString[i]).doubleValue();
        }

        linha = (int) valoresDouble[0]; //Obtém o valor da linha informada no txt
        coluna = (int) valoresDouble[1]; //Obtém o valor da coluna informada no txt

        dadosTabulados = new double[linha][coluna]; //Define o tamanho da matriz dadosTabulados
        linhasSomadas = new double[linha]; //Define o tamanho da matriz somatorioLinha
        colunasSomadas = new double[coluna]; //Define o tamanho da matriz somatorioColuna

        System.out.println("\nDados lidos e convertidos para double");
        for (int i = 0; i < valoresDouble.length; i++) {
            System.out.print(valoresDouble[i] + "\n");
        }

        //Passando os dados do vetor valoresDouble para  a matriz dadosTabulados
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                dadosTabulados[i][j] = valoresDouble[indice++];
            }
        }

        System.out.println("\nDados em formato matricial");
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(dadosTabulados[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\nObtendo os somatórios...");
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                linhasSomadas[i] += dadosTabulados[i][j];
                colunasSomadas[i] += dadosTabulados[j][i];
            }
            System.out.println("Linha[" + i + "]-> " + linhasSomadas[i]);
            System.out.println("Coluna[" + i + "]-> " + colunasSomadas[i]);
        }

        maiorLinha = dadosTabulados[0][0];
        maiorColuna = dadosTabulados[0][0];
        //Obtém a linha e a coluna de maior peso, bem como o índice da linha e da coluna
        for (int i = 0; i < linhasSomadas.length; i++) {
            if (maiorLinha < linhasSomadas[i]) {
                maiorLinha = linhasSomadas[i];
                linhaCerta = i;
            }

            if (maiorColuna < colunasSomadas[i]) {
                maiorColuna = colunasSomadas[i];
                colunaCerta = i;
            }
        }

        System.out.println("\nLinha de maior peso: " + maiorLinha + " -  Coluna de maior peso: " + maiorColuna);
        System.out.println("\nCentro de gravidade = [" + linhaCerta + "," + colunaCerta + "]");
    }
}
    
    

