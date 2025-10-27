package br.senai.sp.jandira.media_final;

import com.sun.javafx.geom.BaseBounds;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Determinando o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(600);



        //Determinar Titulo do staje (tela/janela)
        stage.setTitle(" Media Final");

        //Painel raiz (root)
        BorderPane root = new BorderPane();

        Label labeTitulo = new Label();
        labeTitulo.setText("Escola \"Professor Vicente Amato\"");
        //Formatação do texto da Letra
        labeTitulo.setStyle("-fx-text-fill: #ff2900; -fx-font-size:20; -fx-font-weight: bold;");
        labeTitulo.setPadding(new Insets(5,0,5,5));


        //Painel de Resultados - Parte de Baixo
        VBox painelResultado = new VBox();
        Label labelAlunoResultado = new Label("Nome do Aluno: ");
        Label labelMediaFinal = new Label("Media Final: ");
        Label labelSituaçao= new Label("Situação: ");
        painelResultado.getChildren().addAll(labelAlunoResultado,labelMediaFinal,labelSituaçao);
        painelResultado.setPadding(new Insets(0,0,10,10));

        Scene scene = new Scene(root);
        stage.setScene(scene);

        //Painel de Botoes
        VBox paineldeBotoes = new VBox();
        Button buttonCalcularMedia = new Button(" Calcular Media ");
        Button buttonLimpar = new Button(" Limpar ");
        Button buttonSair = new Button(" Sair");
        paineldeBotoes.getChildren().addAll(buttonCalcularMedia,buttonLimpar,buttonSair);
        paineldeBotoes.setPadding(new Insets(0,10,10,0));
        paineldeBotoes.setSpacing(10);
        buttonCalcularMedia.setPrefWidth(150);
        buttonLimpar.setPrefWidth(100);
        buttonSair.setPrefWidth(100);
        buttonCalcularMedia.setPrefHeight(50);
        buttonLimpar.setPrefHeight(50);
        buttonSair.setPrefHeight(50);



        //Painel Formulario
         VBox painelFormulario = new VBox();
         Label labelNome = new Label("Nome do Aluno: ");
         Label labelNota1 = new Label(" Nota 1 ");
         Label labelNota2 = new Label(" Nota 2 ");
         Label labelNota3 = new Label(" Nota 3 ");
         Label labelNota4 = new Label(" Nota 4 ");
         TextField textFieldNome = new TextField();
         TextField textFieldNota1 = new TextField();
         TextField textFieldNota2 = new TextField();
         TextField textFieldNota3 = new TextField();
         TextField textFieldNota4 = new TextField();
        painelFormulario.setPadding(new Insets(0,0,10,10));

         painelFormulario.getChildren().addAll(
                labelNome, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );

        root.setTop(labeTitulo);
        root.setBottom(painelResultado);
        root.setRight(paineldeBotoes);
        root.setLeft(painelFormulario);

        //Mostrar stage
        stage.show();

        //Eventos de Cliques dos Botoes
        buttonCalcularMedia.setOnAction(click ->{
            System.out.println(" Botão clicado");
            String nomeDigitado = textFieldNome.getText();
            labelAlunoResultado.setText("Nome do Aluno: "+  nomeDigitado);



            //Calcular Media
            //Obter Notas

            //Criar Um Vetor [] de notas (array)
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

             notasStr[3] = textFieldNota4.getText();
             notas[3] = Double.parseDouble(notasStr[3]);

             // USO DE LOOP USANDO WHILE ( ENQUANTO)
            int i = 0;
            double mediaFinal = 0.0;
            while (i < notas.length) {
                mediaFinal = mediaFinal + notas[i];
                i = i + 1;
            }
            mediaFinal = mediaFinal / notas.length;
            String mediaFinalstr=String.format("%.1f", mediaFinal);

            labelMediaFinal.setText("Media Final: "+  mediaFinalstr);

            //Aprovado ou Reprovado
            String resultado;
            if (mediaFinal >= 6.0) {
                resultado = "Aprovado(a)";
            } else if (mediaFinal < 4) {
                resultado = "Reprovado(a)";
            } else{
                resultado = "Recuperação(a)";
            }

            labelSituaçao.setText("Situação: " + resultado);
        });

        //Botão Limpar
        buttonLimpar.setOnAction(click->{
            textFieldNome.clear();
            textFieldNota1.setText("");
            textFieldNota2.setText("");
            textFieldNota3.setText("");
            textFieldNota4.setText("");
            labelMediaFinal.setText("Media Final: ");
            labelAlunoResultado.setText("Situação: ");
            labelSituaçao.setText("Situação: ");
            textFieldNome.requestFocus();

        });
        //Botão Sair
        buttonSair.setOnAction(click ->{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Fechar Aplicação", ButtonType.YES,ButtonType.NO);
            Optional<ButtonType> botaoPrecionado = alerta.showAndWait();

            if (botaoPrecionado.get() == ButtonType.YES){
                System.exit(0);
            }

        });

    }
}
