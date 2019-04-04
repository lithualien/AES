package gui;

import decryption.Decrypt;
import encryption.Encrypt;

import javax.swing.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    private JPanel mainPanel;

    private JButton encryptButton = new JButton("Užkoduoti");
    private JButton decryptButton = new JButton("Atkoduoti");

    private JTextField toEncrypt = new JTextField();
    private JTextField decryptedText = new JTextField();

    private Encrypt encrypt = new Encrypt();
    private Decrypt decrypt = new Decrypt();

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
                char[] temp = toEncrypt.getText().toCharArray();

                char[] newTemp = new char[16];

                for(int i = 0; i < 16; i++) {
                    if(i > temp.length - 1) {
                        newTemp[i] = ' ';
                    }
                    else {
                        newTemp[i] = temp[i];
                    }
                }

                encrypt.encryptToAES(new String(newTemp), KEY);
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
}
