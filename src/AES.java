import decryption.Decrypt;
import encryption.Encrypt;

public class AES {
    private static Encrypt encrypt = new Encrypt();
    private static Decrypt decrypt = new Decrypt();

    private static final int[] KEY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public static void main(String[] args) {
        decrypt.decryptToHex(encrypt.encryptToAES("ABCDEFGHIJKLMNIO", KEY), KEY);
/*

        void AES_Decrypt(byte[] message, byte[] key)
        {
            byte[] state = new byte[16];

            for (int i = 0; i < 16; i++)
                state[i] = message[i];

            int numberOfRounds = 9;

            byte[] expandedKey = new byte[176];

            KeyExpansion(key, expandedKey);

            byte[] tempKey = new byte[16];

            for (int j = 0; j < 16; j++)
                tempKey[j] = expandedKey[160 + j];

            AddRoundKey(state, tempKey);

            rev_shiftrows(state);
            rev_subbytes(state);

            for (int i = numberOfRounds - 1; i >= 0; i--)
            {
                byte[] tempKeys = new byte[16];

                for (int j = 0; j < 16; j++)
                    tempKeys[j] = expandedKey[16 * (i + 1) + j];

                AddRoundKey(state, tempKeys);

                rev_MixColumns(state);
                rev_shiftrows(state);
                rev_subbytes(state);
            }

            AddRoundKey(state, key);

            for (int i = 0; i < 16; i++)
                message[i] = state[i];
        }

        private byte[] splitArray(byte[] array, int offset)
        {
            byte[] temp = new byte[16];

            for (int i = 0; i < 16; i++)
                temp[i] = array[i + offset];

            return temp;
        }

        public static byte[] StringToByteArray(String hex)
        {
            int NumberChars = hex.Length;

            byte[] bytes = new byte[NumberChars / 2];

            for (int i = 0; i < NumberChars; i += 2)
                bytes[i / 2] = Convert.ToByte(hex.Substring(i, 2), 16);

            return bytes;
        }

        public Form1()
        {
            InitializeComponent();
        }

        byte[] key = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

        private void button1_Click(object sender, EventArgs e)
        {
            string x = textBox1.Text;

            char[] message = x.ToCharArray();

            int originalLen = x.Length;

            int lenOfPaddedMessage = originalLen;

            if (lenOfPaddedMessage % 16 != 0)
                lenOfPaddedMessage = (lenOfPaddedMessage / 16 + 1) * 16;

            byte[] paddedMessage = new byte[lenOfPaddedMessage];

            for (int i = 0; i < lenOfPaddedMessage; i++)
            {
                if (i >= originalLen)
                    paddedMessage[i] = 0;
                else
                    paddedMessage[i] = (byte)message[i];
            }

            for (int i = 0; i < lenOfPaddedMessage; i += 16)
            {
                byte[] temp = splitArray(paddedMessage, i);

                AES_Encrypt(temp, key);

                for (int j = 0; j < 16; j++)
                    paddedMessage[j + i] = temp[j];
            }

            System.IO.File.WriteAllText(@"Encrypted.txt", BitConverter.ToString(paddedMessage));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            openFileDialog1 = new OpenFileDialog();

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                System.IO.StreamReader sr = new System.IO.StreamReader(openFileDialog1.FileName);

                textBox1.Text = sr.ReadToEnd();

                sr.Close();

                textBox1.Text = textBox1.Text.Replace("-", "");

                byte[] paddedMessage = StringToByteArray(textBox1.Text);

                for (int i = 0; i < paddedMessage.Length; i += 16)
                {
                    byte[] temp = splitArray(paddedMessage, i);

                    AES_Decrypt(temp, key);

                    for (int j = 0; j < 16; j++)
                        paddedMessage[j + i] = temp[j];
                }

                string x = "";

                for (int i = 0; i < paddedMessage.Length; i++)
                    if (paddedMessage[i] != 0) //kad NULLBYTES nebebūtų
                        x += Convert.ToChar(paddedMessage[i]);

                System.IO.File.WriteAllText(@"Decrypted.txt", x);
                textBox1.Text = x;
            }
        }
    }*/
    }
}
