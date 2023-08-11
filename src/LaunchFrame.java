import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class LaunchFrame {
    /**
     * those array is a group of "turma arrays"
     */
    Alunos[][] Escola = new Alunos[4][50];
    /**
     * Those array is a group of students, student is a class
     * and receive (name, mail, course, celphone, address
     */
    Alunos[] turma = new Alunos[50];
    /**
     * quantity of Turmas
     */
    int quantidadeTurma = 0;
    /**
     * quantity of students
     */
    int quantidadeAlunos = 0;
    /**
     * It is the answer to order the student list, the default is 0
     */
    int ordenarList = 0;

    /**
     *  This is the Main frame and it have four buttons to "Register", "Show", "grades" and "faults"
     *  and it will redirect you to another window
     */
    public LaunchFrame() {
        JFrame launch = new JFrame();
        launch.setVisible(true);
        launch.setTitle("Sistema escola KLHYPZON");
        launch.setSize(1900, 1200);
        launch.setLayout(null);
        launch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton alunoCad = new JButton("Cadastrar Aluno");
        alunoCad.setBounds(100, 100, 600, 140);
        alunoCad.setFont(new Font("Arial", Font.BOLD, 40));
        alunoCad.setBackground(Color.black);
        alunoCad.setForeground(Color.white);
        alunoCad.addActionListener(this::CadAlunos);

        JButton alunoExb = new JButton("Exibir todos Alunos");
        alunoExb.setBounds(100, 290, 600, 140);
        alunoExb.setFont(new Font("Arial", Font.BOLD, 40));
        alunoExb.setBackground(Color.black);
        alunoExb.setForeground(Color.white);
        alunoExb.addActionListener(Action -> {
            String[] respostas = {"Ordenador por ID", "Crescente", "Decrescente"};
            int resposta = JOptionPane.showOptionDialog(null,
                    "Deseja odenar a lista:",
                    "\n", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, respostas, 0);
            ordenarList = resposta;
            this.ExbAlunos(Action);
        });

        JButton notasAluno = new JButton("Lançar notas");
        notasAluno.setBounds(100, 480, 600, 140);
        notasAluno.setFont(new Font("Arial", Font.BOLD, 40));
        notasAluno.setBackground(Color.black);
        notasAluno.setForeground(Color.white);
        notasAluno.addActionListener(this::addNotas);

        JButton faltasAluno = new JButton("Lançar Faltas");
        faltasAluno.setBounds(100, 670, 600, 140);
        faltasAluno.setFont(new Font("Arial", Font.BOLD, 40));
        faltasAluno.setBackground(Color.black);
        faltasAluno.setForeground(Color.white);
        faltasAluno.addActionListener(this::addFaltas);

        launch.add(faltasAluno);
        launch.add(alunoCad);
        launch.add(alunoExb);
        launch.add(notasAluno);
    }

    JTextField matricula = new JTextField("");
    //This JTextfield is all declarated in global scope to be used in the register funcs
    JTextField nome = new JTextField("", 30);
    JTextField email = new JTextField("", 30);
    //JTextField curso = new JTextField("");
    JTextField telefone = new JTextField("", 11);
    JTextField endereco = new JTextField("", 50);
    JButton alunoExb = new JButton("Adicionar aluno");
    String[] tdsCursos = {"Engenharia", "Direito", "Administração", "Engenharia Software"};
    JComboBox cursos;

    /**
     * CADASTRAR ALUNOS Evoques textfields to been filled with data to register a student by get
     * function who will redirect to "newAluno" newStudent.
     */
    private void CadAlunos(ActionEvent actionEvent) {
        JFrame register = new JFrame();
        register.setVisible(true);
        register.setTitle("Registrar novo aluno");
        register.setSize(900, 650);
        register.setLocationRelativeTo(null);
        register.setLayout(null);
        //Labels e Textfields

        JLabel lMatricula = new JLabel();
        lMatricula.setText("* Matricula: ");
        lMatricula.setFont(new Font("Arial", Font.BOLD, 30));
        lMatricula.setBounds(50, 90, 250, 30);

        matricula.setBounds(350, 90, 350, 40);
        matricula.setFont(new Font("Arial", Font.BOLD, 30));
        matricula.setBackground(Color.lightGray);
        matricula.setText("");

        JLabel lNome = new JLabel();
        lNome.setText("* Nome: ");
        lNome.setFont(new Font("Arial", Font.BOLD, 30));
        lNome.setBounds(50, 160, 200, 30);

        nome.setBounds(350, 160, 350, 40);
        nome.setFont(new Font("Arial", Font.BOLD, 30));
        nome.setBackground(Color.lightGray);
        nome.setText("");


        JLabel lEmail = new JLabel();
        lEmail.setText("* Email: ");
        lEmail.setFont(new Font("Arial", Font.BOLD, 30));
        lEmail.setBounds(50, 230, 200, 30);

        email.setBounds(350, 230, 350, 40);
        email.setFont(new Font("Arial", Font.BOLD, 30));
        email.setBackground(Color.lightGray);
        email.setText("");

        JLabel lCurso = new JLabel();
        lCurso.setText("* Curso: ");
        lCurso.setFont(new Font("Arial", Font.BOLD, 30));
        lCurso.setBounds(50, 300, 200, 30);


        cursos = new JComboBox(tdsCursos);
        cursos.setBounds(350, 300, 350, 40);
        cursos.setBackground(Color.lightGray);
        cursos.addActionListener(Action -> {
            alunoExb.setEnabled(true);
        });

        /*
        //REGISTRO POR TEXTFIELD
        curString alunoCurso = tdsCursos[cursoIndex];
                Alunos novoAluno = new Alunos(
                        nome.getText(), email.getText(), alunoCurso, telefone.getText(), endereco.getText());
                if (quantidadeAlunos <= 50) {
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                    JOptionPane.showMessageDialog(null,
                            "Aluno adicionado com sucesso",
                            "GOOD!", JOptionPane.INFORMATION_MESSAGE);
                    alunoExb.setEnabled(false);

                } else {
                    Escola[quantidadeTurma] = turma;
                    quantidadeAlunos = 0;
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                }so.setBounds(300, 230, 350, 40);
        curso.setFont(new Font("Arial", Font.BOLD, 30));
        curso.setBackground(Color.lightGray);
        curso.setText("");
        curso.addActionListener(Action->{
            alunoExb.setEnabled(true);
        });*/

        JLabel lTelefone = new JLabel();
        lTelefone.setText("* Telefone: ");
        lTelefone.setFont(new Font("Arial", Font.BOLD, 30));
        lTelefone.setBounds(50, 370, 200, 30);

        telefone.setBounds(350, 370, 350, 40);
        telefone.setFont(new Font("Arial", Font.BOLD, 30));
        telefone.setBackground(Color.lightGray);
        telefone.setText("");
        telefone.addActionListener(Action -> {
            alunoExb.setEnabled(true);
        });

        JLabel lEndereco = new JLabel();
        lEndereco.setText("* Endereço: ");
        lEndereco.setFont(new Font("Arial", Font.BOLD, 30));
        lEndereco.setBounds(50, 440, 220, 30);

        endereco.setBounds(350, 440, 350, 40);
        endereco.setFont(new Font("Arial", Font.BOLD, 30));
        endereco.setBackground(Color.lightGray);
        endereco.setText("");
        endereco.addActionListener(Action -> {
            alunoExb.setEnabled(true);
        });


        //Botão


        alunoExb.setBounds(500, 510, 200, 70);
        alunoExb.setBackground(Color.black);
        alunoExb.setForeground(Color.white);
        alunoExb.addActionListener(this::newAluno);
        alunoExb.setEnabled(true);

        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(350, 510, 140, 70);
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(Action ->{
            register.dispose();
        });



        //Adds
        register.add(lMatricula);
        register.add(matricula);
        register.add(cursos);
        register.add(alunoExb);
        register.add(lNome);
        register.add(lEmail);
        register.add(lCurso);
        register.add(lTelefone);
        register.add(lEndereco);
        register.add(nome);
        register.add(email);
        //register.add(curso);
        register.add(telefone);
        register.add(endereco);
        register.add(exitButton);


    }

    /**
     * Create new ALUNO and adds to TURMA with validation by Student's matricula(it was by email) and
     * if the textfields are empty or the email is not valid it will not works
     * @param actionEvent This param show that it will be called by another button.
     */
    public void newAluno(ActionEvent actionEvent) {
        if ((matricula.getText().length() < 2 || nome.getText().length() < 3) || (email.getText().length() < 10)
                || (telefone.getText().length() < 8) || (endereco.getText().length() < 10)) {
            JOptionPane.showMessageDialog(null, "A Matricula deve ser válida \n" +
                    "O nome deve conter ao menos 3 letras\n o email 10, o telefone" +
                    " 8 e o endereco 10, para que seja válido." +
                    "\n Caso já esteja completo, adicione // ao final", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int cursoIndex = cursos.getSelectedIndex();
            if (quantidadeAlunos == 0) {
                String alunoCurso = tdsCursos[cursoIndex];
                Alunos novoAluno = new Alunos(
                        matricula.getText(), nome.getText(), email.getText(), alunoCurso, telefone.getText(), endereco.getText());
                if (quantidadeAlunos <= 50) {
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                    JOptionPane.showMessageDialog(null,
                            "Aluno adicionado com sucesso",
                            "GOOD!", JOptionPane.INFORMATION_MESSAGE);
                    alunoExb.setEnabled(false);

                } else {
                    Escola[quantidadeTurma] = turma;
                    quantidadeAlunos = 0;
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                }

            }else if (!matricula.getText().equals(turma[quantidadeAlunos-1].getMatricula())) {
                String alunoCurso = tdsCursos[cursoIndex];
                Alunos novoAluno = new Alunos(
                        matricula.getText(), nome.getText(), email.getText(), alunoCurso, telefone.getText(), endereco.getText());
                if (quantidadeAlunos <= 50) {
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                    JOptionPane.showMessageDialog(null,
                            "Aluno adicionado com sucesso",
                            "GOOD!", JOptionPane.INFORMATION_MESSAGE);
                    alunoExb.setEnabled(false);
                } else {
                    Escola[quantidadeTurma] = turma;
                    quantidadeAlunos = 0;
                    turma[quantidadeAlunos] = novoAluno;
                    quantidadeAlunos += 1;
                }
            }
        }
    }



    JButton showDados;
    JComboBox dadosAluno;

    /**
     * SHOW STUDENTS
     * Method to show students by Turma. It receive a value to dicide what kind of ordenation it will
     * have. If receive 0 is ID order, if 1 is ascendent and if it is 2 descending. The ascendant and
     * descending method uses MEDIA method(all the grades sum and then divided by 3).
     * It only show id, name, course and MÉDIA.
     * @param actionEvent This param show that it will be called by another button.
     */
    private void ExbAlunos(ActionEvent actionEvent) {
        if (quantidadeAlunos > 0) {
            int alunoAtual = 0;
            JFrame showAlunos = new JFrame();
            showAlunos.setVisible(true);
            showAlunos.setTitle("Mostrar alunos");
            showAlunos.setSize(1500, 900);
            showAlunos.setLocationRelativeTo(null);
            showAlunos.setLayout(null);

            JLabel showTextMatricula = new JLabel();
            showTextMatricula.setText("Matriculas");
            showTextMatricula.setFont(new Font("Arial", Font.BOLD, 30));
            showTextMatricula.setBounds(50, 0, 600, 30);
            showAlunos.add(showTextMatricula);

            JLabel showTextName = new JLabel();
            showTextName.setText("Nomes");
            showTextName.setFont(new Font("Arial", Font.BOLD, 30));
            showTextName.setBounds(250, 0, 600, 30);
            showAlunos.add(showTextName);

            JLabel showTextCurso = new JLabel();
            showTextCurso.setText("Curso");
            showTextCurso.setFont(new Font("Arial", Font.BOLD, 30));
            showTextCurso.setBounds(750, 0, 600, 30);
            showAlunos.add(showTextCurso);

            JLabel showTextMedia = new JLabel();
            showTextMedia.setText("Média");
            showTextMedia.setFont(new Font("Arial", Font.BOLD, 30));
            showTextMedia.setBounds(1200, 0, 600, 30);
            showAlunos.add(showTextMedia);

            dadosAluno = new JComboBox();
            dadosAluno.setBounds(135, 700, 600, 80);
            dadosAluno.setFont(new Font("Arial", Font.BOLD, 30));
            dadosAluno.setBackground(Color.lightGray);
            showAlunos.add(dadosAluno);

            showDados = new JButton("Mostrar dados avançados");
            showDados.setBounds(775, 700, 275, 80);
            showDados.setBackground(Color.black);
            showDados.setForeground(Color.white);
            showDados.addActionListener(this::fichaAluno);
            showAlunos.add(showDados);
            String[] ordenedTurma = ordenarTurma(ordenarList);

            System.out.println(Arrays.toString(ordenedTurma));
            for (int i = 0; i < quantidadeAlunos; i++) {
                alunoAtual = chosedAluno(ordenedTurma[i]);
                JLabel showMatricula = new JLabel();
                showMatricula.setText(turma[alunoAtual].getMatricula());
                showMatricula.setFont(new Font("Arial", Font.BOLD, 30));
                showMatricula.setBounds(50, (30 + (30 * i)), 600, 30);
                showAlunos.add(showMatricula);

                JLabel showName = new JLabel();
                showName.setText(turma[alunoAtual].getNome());
                showName.setFont(new Font("Arial", Font.BOLD, 30));
                showName.setBounds(250, (30 + (30 * i)), 600, 30);
                showAlunos.add(showName);

                JLabel showCurso = new JLabel();
                showCurso.setText(turma[alunoAtual].getCurso());
                showCurso.setFont(new Font("Arial", Font.BOLD, 30));
                showCurso.setBounds(750, (30 + (30 * i)), 600, 30);
                showAlunos.add(showCurso);

                JLabel showMédia = new JLabel();
                showMédia.setText(Integer.toString(calcularMédia(turma[alunoAtual].getNotas())));
                showMédia.setFont(new Font("Arial", Font.BOLD, 30));
                showMédia.setBounds(1200, (30 + (30 * i)), 600, 30);
                showAlunos.add(showMédia);

                dadosAluno.addItem(turma[i].getNome());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sem" +
                    " alunos registrados!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * IT SHOW ANY STUDENT ALL REGISTERED DATA
     * APPROVED IS CALCULATED IF MEDIA IS OVER THAN 70. MEDIA IS 3 GRADES DIVIDED BY 3
     * AND FAULTS IS LESS THAN 15.
     * @param actionEvent This param show that it will be called by another button.
     */
    private void fichaAluno(ActionEvent actionEvent) {
        int selectedAluno = dadosAluno.getSelectedIndex();
        JFrame fichaAlunos = new JFrame();
        fichaAlunos.setVisible(true);
        fichaAlunos.setTitle("Aluno ->" + turma[selectedAluno].getNome());
        fichaAlunos.setSize(900, 900);
        fichaAlunos.setLocationRelativeTo(null);
        fichaAlunos.setLayout(null);

        JLabel showAlunoMatricula = new JLabel();
        showAlunoMatricula.setText("Matricula: " + turma[selectedAluno].getMatricula());
        showAlunoMatricula.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoMatricula.setBounds(20, 20, 400, 30);
        fichaAlunos.add(showAlunoMatricula);

        JLabel showAlunoNome = new JLabel();
        showAlunoNome.setText("NOME: " + turma[selectedAluno].getNome());
        showAlunoNome.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoNome.setBounds(20, 100, 800, 30);
        fichaAlunos.add(showAlunoNome);

        JLabel showAlunoEmail = new JLabel();
        showAlunoEmail.setText("EMAIL: " + turma[selectedAluno].getEmail());
        showAlunoEmail.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoEmail.setBounds(20, 180, 800, 30);
        fichaAlunos.add(showAlunoEmail);

        JLabel showAlunoCurso = new JLabel();
        showAlunoCurso.setText("CURSO: " + turma[selectedAluno].getCurso());
        showAlunoCurso.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoCurso.setBounds(20, 260, 800, 30);
        fichaAlunos.add(showAlunoCurso);

        JLabel showAlunoTelefone = new JLabel();
        showAlunoTelefone.setText("TEL: " + turma[selectedAluno].getTelefone());
        showAlunoTelefone.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoTelefone.setBounds(20, 340, 800, 30);
        fichaAlunos.add(showAlunoTelefone);

        JLabel alunoEndereco = new JLabel();
        alunoEndereco.setText("ENDEREÇO: " + turma[selectedAluno].getEndereco());
        alunoEndereco.setFont(new Font("Arial", Font.BOLD, 30));
        alunoEndereco.setBounds(20, 420, 900, 30);
        fichaAlunos.add(alunoEndereco);


        int[] alunoNotas = turma[selectedAluno].getNotas();
        JLabel showAlunoNotas = new JLabel();
        showAlunoNotas.setText("NOTA 1: " + Integer.toString(alunoNotas[0]) + "  NOTA 2:" +
                " " + Integer.toString(alunoNotas[1]) + "" + "  NOTA 3: " + Integer.toString(alunoNotas[2]));
        showAlunoNotas.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoNotas.setBounds(20, 520, 800, 30);
        fichaAlunos.add(showAlunoNotas);


        JLabel showAlunoMedia = new JLabel();
        showAlunoMedia.setText("MÉDIA: " + calcularMédia(turma[selectedAluno].getNotas()));
        showAlunoMedia.setFont(new Font("Arial", Font.BOLD, 30));
        showAlunoMedia.setBounds(20, 560, 800, 30);
        fichaAlunos.add(showAlunoMedia);


        JLabel alunoFaltas = new JLabel();
        alunoFaltas.setText("FALTAS: " + Integer.toString(
                turma[selectedAluno].getFaltas()) +
                " PERC.:" + percentFaltas(
                turma[selectedAluno].getFaltas()) + "%");
        alunoFaltas.setFont(new Font("Arial", Font.BOLD, 30));
        alunoFaltas.setBounds(20, 600, 400, 30);
        fichaAlunos.add(alunoFaltas);


        JLabel alunoSituacao = new JLabel();
        alunoSituacao.setText("SITUAÇÃO: " + isAprovado(turma[selectedAluno].getNotas(),
                turma[selectedAluno].getFaltas()));
        alunoSituacao.setFont(new Font("Arial", Font.BOLD, 30));
        alunoSituacao.setBounds(20, 640, 600, 30);
        fichaAlunos.add(alunoSituacao);
    }


    JTextField addNotaA = new JTextField();

    /**
     * Method to choose a student to have the grades defined or redefined and it will be chosed by MATRICULA(era id)
     * @param actionEvent This param show that it will be called by another button.
     */
    private void addNotas(ActionEvent actionEvent) {
        if (quantidadeAlunos > 0) {
            JFrame addNotas = new JFrame();
            addNotas.setVisible(true);
            addNotas.setTitle("Adicionar nota ao aluno");
            addNotas.setSize(500, 400);
            addNotas.setLocationRelativeTo(null);
            addNotas.setLayout(null);

            JLabel showTextName = new JLabel();
            showTextName.setText("Insira a Matricula");
            showTextName.setFont(new Font("Arial", Font.BOLD, 30));
            showTextName.setBounds(100, 50, 400, 30);
            addNotas.add(showTextName);

            addNotaA.setBounds(190, 130, 120, 40);
            addNotaA.setFont(new Font("Arial", Font.BOLD, 30));
            addNotaA.setBackground(Color.lightGray);
            addNotaA.setText("");
            addNotas.add(addNotaA);

            JButton notaAdd = new JButton("Adicionar nota a esse aluno");
            notaAdd.setBounds(190, 180, 120, 50);
            notaAdd.setBackground(Color.black);
            notaAdd.setForeground(Color.white);
            notaAdd.addActionListener(this::alunoNota);
            addNotas.add(notaAdd);
        } else {
            JOptionPane.showMessageDialog(null, "Sem" +
                    " alunos registrados!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method you put the grades in 3 Textfields and than click to addGrade
     * by ID chosed Student
     * @param actionEvent This param show that it will be called by another button.
     */
    private void alunoNota(ActionEvent actionEvent) {
        try {
            int idAluno = chosedAluno(addNotaA.getText());
            JFrame alunoNota = new JFrame();
            alunoNota.setVisible(true);
            alunoNota.setTitle("Adicionar nota ao aluno");
            alunoNota.setSize(500, 400);
            alunoNota.setLocationRelativeTo(null);
            alunoNota.setLayout(null);
            int[] notas = turma[idAluno].getNotas();


            JLabel showTextName = new JLabel();
            showTextName.setText("Aluno: " + turma[idAluno].getNome());
            showTextName.setFont(new Font("Arial", Font.BOLD, 30));
            showTextName.setBounds(50, 50, 600, 30);
            alunoNota.add(showTextName);


            JTextField Nota1Aluno = new JTextField();
            Nota1Aluno.setBounds(125, 150, 70, 40);
            Nota1Aluno.setFont(new Font("Arial", Font.BOLD, 30));
            Nota1Aluno.setBackground(Color.lightGray);
            Nota1Aluno.setText(Integer.toString(notas[0]));
            alunoNota.add(Nota1Aluno);

            JTextField Nota2Aluno = new JTextField();
            Nota2Aluno.setBounds(215, 150, 70, 40);
            Nota2Aluno.setFont(new Font("Arial", Font.BOLD, 30));
            Nota2Aluno.setBackground(Color.lightGray);
            Nota2Aluno.setText(Integer.toString(notas[1]));
            alunoNota.add(Nota2Aluno);

            JTextField Nota3Aluno = new JTextField();
            Nota3Aluno.setBounds(305, 150, 70, 40);
            Nota3Aluno.setFont(new Font("Arial", Font.BOLD, 30));
            Nota3Aluno.setBackground(Color.lightGray);
            Nota3Aluno.setText(Integer.toString(notas[2]));
            alunoNota.add(Nota3Aluno);


            JButton notaAdd = new JButton("Adicionar");
            notaAdd.setBounds(350, 280, 120, 50);
            notaAdd.setBackground(Color.black);
            notaAdd.setForeground(Color.white);
            notaAdd.addActionListener(Action -> {
                try {
                    if (Integer.parseInt(Nota1Aluno.getText()) < 0 ||
                            Integer.parseInt(Nota1Aluno.getText()) > 100) {
                        JOptionPane.showMessageDialog(null, "NOTA 1 é INVÁLIDA");
                    } else if (Integer.parseInt(Nota2Aluno.getText()) < 0 ||
                            Integer.parseInt(Nota2Aluno.getText()) > 100) {
                        JOptionPane.showMessageDialog(null, "NOTA 2 é INVÁLIDA");
                    } else if (Integer.parseInt(Nota3Aluno.getText()) < 0 ||
                            Integer.parseInt(Nota3Aluno.getText()) > 100) {
                        JOptionPane.showMessageDialog(null, "NOTA 3 é INVÁLIDA");
                    } else {
                        int[] notasR = {Integer.parseInt(Nota1Aluno.getText()),
                                Integer.parseInt(Nota2Aluno.getText()),
                                Integer.parseInt(Nota3Aluno.getText())};
                        turma[idAluno].setNotas(notasR);
                        JOptionPane.showMessageDialog(null,
                                "Notas adicionadas com sucesso!",
                                "GOOD!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "VALOR NÃO NÚMERICO ADICIONADO!");
                }
            });
            alunoNota.add(notaAdd);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    " Um valor inválido foi inserido!",
                    "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    JTextField addFaltaA = new JTextField();

    /**
     * ADICIONAR FALTAS
     * Methods to applied and remove fault to students
     * @param actionEvent
     */
    private void addFaltas(ActionEvent actionEvent) {
        if (quantidadeAlunos > 0) {
            JFrame addFaltas = new JFrame();
            addFaltas.setVisible(true);
            addFaltas.setTitle("Adicionar FALTAS ao aluno");
            addFaltas.setSize(500, 400);
            addFaltas.setLocationRelativeTo(null);
            addFaltas.setLayout(null);

            JLabel showTextName = new JLabel();
            showTextName.setText("Insira a Matricula");
            showTextName.setFont(new Font("Arial", Font.BOLD, 30));
            showTextName.setBounds(100, 50, 400, 30);
            addFaltas.add(showTextName);

            addFaltaA.setBounds(190, 130, 120, 40);
            addFaltaA.setFont(new Font("Arial", Font.BOLD, 30));
            addFaltaA.setBackground(Color.lightGray);
            addFaltaA.setText("");
            addFaltas.add(addFaltaA);

            JButton notaAdd = new JButton("Faltou!");
            notaAdd.setBounds(190, 180, 120, 50);
            notaAdd.setBackground(Color.black);
            notaAdd.setForeground(Color.white);
            notaAdd.addActionListener(Action -> {
                String[] respostas = {"Sim", "Cancelar"};
                int resposta = JOptionPane.showOptionDialog(null,
                        "Deseja marcar falta para o aluno:" +
                                "\n" + turma[chosedAluno(addFaltaA.getText())].getNome(),
                        "Adicionar falta?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, respostas, 0);
                if (resposta == 0) {
                    turma[chosedAluno(addFaltaA.getText())].setFaltas(
                            turma[chosedAluno(addFaltaA.getText())].getFaltas() + 1
                    );
                }
            });
            JButton notaRmv = new JButton("Retirar falta!");
            notaRmv.setBounds(170, 240, 160, 50);
            notaRmv.setBackground(Color.black);
            notaRmv.setForeground(Color.white);
            notaRmv.addActionListener(Action -> {
                if (turma[chosedAluno(addFaltaA.getText())].getFaltas() == 0) {
                    JOptionPane.showMessageDialog(null, "O aluno não tem faltas!");
                } else {
                    String[] respostas = {"Sim", "Cancelar"};
                    int resposta = JOptionPane.showOptionDialog(null,
                            "Deseja retirar falta do o aluno:" +
                                    "\n" + turma[Integer.parseInt(addFaltaA.getText())].getNome(),
                            "Adicionar falta?", JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, respostas, 0);
                    if (resposta == 0) {
                        turma[Integer.parseInt(addFaltaA.getText())].setFaltas(
                                turma[Integer.parseInt(addFaltaA.getText())].getFaltas() - 1
                        );
                    }
                }
            });
            addFaltas.add(notaRmv);
            addFaltas.add(notaAdd);
        } else {
            JOptionPane.showMessageDialog(null, "Sem" +
                    " alunos registrados!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * return array grades sum divided by 3
     * @param notas STUDENT grades array
     * @return return array grades sum divided by 3
     */
    public int calcularMédia(int[] notas) {
        int media = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i];
        }
        media = media / notas.length;
        return media;
    }

    /**
     * if the student was approved by validation of MEDIA of grades is greater than 70
     * or greater than 50 and faults is less than 16.
     * @param notas
     * @param faltas
     * @return
     */
    public String isAprovado(int[] notas, int faltas) {
        String resultado = "";
        if (calcularMédia(notas) >= 70 && faltas <= 15) {
            resultado = "APROVADO!";
        } else if (calcularMédia(notas) < 50 || faltas > 15) {
            resultado = "REPROVADO!";
        } else {
            resultado = "IRA PARA EXAME!";
        }
        return resultado;
    }

    /**
     * return what percent of faults its if have 200 classes.
     * @param faltas Student quantity of fault
     * @return quantity faults % of 200
     */
    public String percentFaltas(int faltas) {
        int diasLetivosObrigatorios = 200;
        double valor = (faltas / diasLetivosObrigatorios) * 100;
        String percentFaltas = Double.toString(valor);
        return percentFaltas;
    }

    /**
     * To order the "show students"
     * @param tipo tipo is the kind of order it will return to SHOW STUDENTS
     * @return retorna um array da turma ordenada no tipo pedido ao chamar
     */
    public String[] ordenarTurma(int tipo) {
        String[] turmaOrdenada = new String[quantidadeAlunos];
        Alunos[] turmaFake = turma;
        Alunos tempValor = turmaFake[0];
        if (tipo == 1) {
            //Menor -> maior
            for (int i = 0; i < quantidadeAlunos; i++) {
                for (int j = 0; j < quantidadeAlunos-1; j++) {
                    System.out.println("Aqui");
                    if (calcularMédia(turmaFake[j].getNotas()) > calcularMédia(turmaFake[j+1].getNotas())) {
                        System.out.println("Aquiee");
                        tempValor = turmaFake[j];
                        turmaFake[j] = turmaFake[j+1];
                        turmaFake[j+1] = tempValor;
                    }
                }
            }
        }else if (tipo == 2) {
            //Maior -> menor
            for (int i = 0; i < quantidadeAlunos; i++) {
                for (int j = 0; j < quantidadeAlunos-1; j++) {
                    System.out.println("Aqui");
                    if (calcularMédia(turmaFake[j].getNotas()) < calcularMédia(turmaFake[j+1].getNotas())) {
                        System.out.println("Aquiee");
                        tempValor = turmaFake[j];
                        turmaFake[j] = turmaFake[j+1];
                        turmaFake[j+1] = tempValor;
                    }
                }
            }
        }
        for(int i = 0; i < quantidadeAlunos; i++){
            turmaOrdenada[i] = turmaFake[i].getMatricula();
        }
        return turmaOrdenada;
    }

    public int chosedAluno(String matricula){
        int alunoID = 0;
        for(int i = 0; i < quantidadeAlunos; i++){
            if(matricula.equals(turma[i].getMatricula())) {
                alunoID = i;
            }
        }

        return alunoID;
    }
}