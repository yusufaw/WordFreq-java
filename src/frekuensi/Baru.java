package frekuensi;

import java.io.*;
import java.util.Scanner;

public class Baru {
    public static void main(String[] args) throws Exception {
        String line, kalimat = "";
        Scanner input = new Scanner(System.in);
        System.out.println("************************************************************");
        System.out.println("               Tugas Akhir pemrograman Dasar");
        System.out.println("************************************************************");
        System.out.print("Dimana file yang akan dihitung frekuensi tiap katanya : ");
        String tempat = input.nextLine();

        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Frekuensi tiap kata adalah :");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        File file = new File(tempat);
        if (!file.exists() || !file.canRead()) {
            System.out.println("Can't read " + file);
            return;
        }
        try {
            BufferedReader fin = new BufferedReader(new FileReader(file));
            while (!((line = fin.readLine()) == null)) {
                kalimat += line + " ";
            }
            String[] kata = kalimat.split(" ");
            String[] baru = new String[kata.length];
            int index1 = 0;
            boolean ketemu = false;
            for (int i = 0; i < kata.length; i++) {
                for (int j = 0; j < index1; j++) {
                    if (kata[i].equalsIgnoreCase(baru[j])) {
                        ketemu = true;
                    }
                }
                if (!ketemu) {
                    baru[index1] = kata[i];
                    index1++;
                }
                ketemu = false;
            }
            int hitungkata = 0;
            int[] frekuensiKata = new int[kata.length];
            for (int i = 0; i < baru.length; i++) {
                if (baru[i] != null) {
                    for (int j = 0; j < kata.length; j++) {
                        if (baru[i].equalsIgnoreCase(kata[j])) {
                            hitungkata++;
                        }
                    }
                }
                frekuensiKata[i] = hitungkata;
                hitungkata = 0;
            }
            for (int i = 0; i < baru.length; i++) {
                if (baru[i] != null) {
                    System.out.printf("kata ''%10s''\t mempunyai frekuensi sejumlah %d \n", baru[i], frekuensiKata[i]);
                }
            }
            int max = 0;
            int index2 = 0;
            for (int i = 0; i < baru.length; i++) {
                if (frekuensiKata[i] > max) {
                    max = frekuensiKata[i];
                    index2 = i;
                } else if (frekuensiKata[i] == max) {
                    baru[index2] += " dan " + baru[i];
                }
            }
            System.out.println("");
            System.out.println("------------------------------------------------------------");
            System.out.print("kata dengan frekuensi terbesar adalah: ");
            System.out.printf("kata ''%s'' mempunyai frekuensi tertinggi sejumlah %d \n", baru[index2], max);
            System.out.println("------------------------------------------------------------");
            System.out.println("");
            System.out.print("File akan disimpan dimana : ");
            String output = input.nextLine();
            FileWriter in = new FileWriter(output);
            BufferedWriter out = new BufferedWriter(in);
            for (int i = 0; i < baru.length; i++) {
                if (baru[i] != null) {
                    out.write(baru[i] + " " + frekuensiKata[i]);
                    out.newLine();
                }
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
        System.out.println("~~~End Program~~~");
    }
}