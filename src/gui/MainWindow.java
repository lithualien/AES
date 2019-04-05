package gui;

import converter.StringToHex;
import decryption.Decrypt;
import encryption.Encrypt;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainWindow extends JFrame {

    private JPanel mainPanel;

    private JButton encryptButton = new JButton("Užkoduoti");
    private JButton decryptButton = new JButton("Atkoduoti");

    private JTextField toEncrypt = new JTextField();
    private JTextField decryptedText = new JTextField();

    private Encrypt encrypt = new Encrypt();
    private Decrypt decrypt = new Decrypt();

    private StringToHex stringToHex = new StringToHex();
    private int[] hexMessage;
    private int[] newHex;

    private final int[] KEY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public void executeProgram() {
        setUpGUI();
    }

    private void setUpGUI() {
        setMainPanel();
        addToMainPanel();
        setJTextField();
        setJButton();
        setEncryptButton();
        setDecryptButton();
    }

    private void setMainPanel() {
        add(mainPanel); // setting up the mainPanel for usage.
        setVisible(true);
        mainPanel.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 220);
        setResizable(false);
    }

    private void addToMainPanel() {
        mainPanel.add(encryptButton);
        mainPanel.add(decryptButton);
        mainPanel.add(toEncrypt);
        mainPanel.add(decryptedText);
    }

    private void setJTextField() {
        toEncrypt.setBounds(20, 20, 300, 30);
        decryptedText.setBounds(20, 60, 300, 30);
    }

    private void setJButton() {
        encryptButton.setBounds(330, 20, 150, 30);
        decryptButton.setBounds(330, 60, 150, 30);
    }

    private void setEncryptButton() {
        encryptButton.addActionListener(e ->
        {
            try {
                setUpForEncrypt();
                writeToFile();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void setDecryptButton() {
        decryptButton.addActionListener(e ->
        {
            try {
                decryptedText.setText(decrypt.decryptToHex(KEY));
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("AES.txt"));
        for(int i = 0; i < 16; i++) {
            writer.write(Integer.toHexString(hexMessage[i]) + " ");
        }
        writer.close();
    }

    private void setUpForEncrypt() throws IOException {
        char[] temp = toEncrypt.getText().toCharArray();
        int howMany = (temp.length / 16) + 1;
        hexMessage = new int[howMany * 16];
        int counter = 0;

        for(int i = 0; i < temp.length; i += 16) {
            char[] newTemp = new char[16];
            for(int j = 0; j < 16; j++) {
                if((i * 16 + j) > temp.length - 1) {
                    newTemp[j] = ' ';
                }
                else {
                    newTemp[j] = temp[i * counter + j];
                }
            }
            int[] temporary = encrypt.encryptToAES(new String(newTemp), KEY);
            for(int j = 0 ; j < 16; j++) {
                hexMessage[i + j] = temporary[j];
            }
        }
    }

    private String readFile() throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get("AES.txt"));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    private void setHexMessage() throws IOException {
        String[] temp = readFile().split(" ");

        for(int i = 0; i < 16; i++) {
            hexMessage[i] = Integer.parseInt(temp[i], 16);
        }
    }
}
