package DataStructure;

import java.io.*;
import java.util.Scanner;
//Pouria Hosseini Dokht 400149019
//Amir mahdi jafari 400149012

class TrieTree{
    public static nodee root;
    //O(n*n)
    public boolean insertNewWord(String word,String meaning){
        if (root == null)
            root = new nodee();
        nodee temp = root;
        int n = 0;
        for (int i = 0; i < word.length(); i++) {
            boolean alreadyIn = false;
            if (temp!=null){
                for (int j = 0; j < temp.list.length; j++) {
                    if (temp.list[j] != null && temp.list[j].character == word.charAt(i)){
                        alreadyIn = true;
                        n = j;
                        break;
                    }
                }
            if (!alreadyIn)
                n = switchCase(temp.list,word.charAt(i));
            temp = temp.list[n];
            }
        }
        temp.End_word = true;
        temp.meaning = meaning;
        return true;
    }

    public void ReadFormFile(String path) throws IOException {
        File file = new File(path);

        BufferedReader bf = new BufferedReader(new FileReader(file));
        boolean Firstline = true;
        boolean Secondline = false;

        String word;
        String words[] = new String[2];
        while ((word = bf.readLine()) != null){
            if (Firstline == true){
                words[0] = word;
                Secondline = true;
                Firstline = false;
                continue;
            }
            if(Secondline == true){
                words[1] = word;
                Firstline = true;
                Secondline = false;
                insertNewWord(words[0],words[1]);
                words[0] = null;
                words[1] = null;
            }
        }
    }

    //O(1)
    private int switchCase(nodee[] list, char charAt) {
        int x = 25;
        if (charAt == 'a' || charAt == 'A'){
            list[0] = new nodee();
            list[0].character = charAt;
            x = 0;
        }
        else if (charAt == 'b' || charAt == 'B') {
            list[1] = new nodee();
            list[1].character = charAt;
            x = 1;
        }
        else if (charAt == 'c' || charAt == 'C') {
            list[2] = new nodee();
            list[2].character = charAt;
            x = 2;
        }
        else if (charAt == 'd' || charAt == 'D') {
            list[3] = new nodee();
            list[3].character = charAt;
            x = 3;
        }
        else if (charAt == 'e' || charAt == 'E') {
            list[4] = new nodee();
            list[4].character = charAt;
            x = 4;
        }
        else if (charAt == 'f' || charAt == 'F'){
            list[5] = new nodee();
            list[5].character = charAt;
            x = 5;
        }
        else if (charAt == 'g' || charAt == 'G') {
            list[6] = new nodee();
            list[6].character = charAt;
            x = 6;
        }
        else if (charAt == 'h' || charAt == 'H') {
            list[7] = new nodee();
            list[7].character = charAt;
            x = 7;
        }
        else if (charAt == 'i' || charAt == 'I') {
            list[8] = new nodee();
            list[8].character = charAt;
            x = 8;
        }
        else if (charAt == 'j' || charAt == 'J') {
            list[9] = new nodee();
            list[9].character = charAt;
            x = 9;
        }
        else if (charAt == 'k' || charAt == 'K') {
            list[10] = new nodee();
            list[10].character = charAt;
            x = 10;
        }
        else if (charAt == 'l' || charAt == 'L') {
            list[11] = new nodee();
            list[11].character = charAt;
            x = 11;
        }
        else if (charAt == 'm' || charAt == 'M') {
            list[12] = new nodee();
            list[12].character = charAt;
            x = 12;
        }
        else if (charAt == 'n' || charAt == 'N') {
            list[13] = new nodee();
            list[13].character = charAt;
            x = 13;
        }
        else if (charAt == 'o' || charAt == 'O') {
            list[14] = new nodee();
            list[14].character = charAt;
            x = 14;
        }
        else if (charAt == 'p' || charAt == 'P') {
            list[15] = new nodee();
            list[15].character = charAt;
            x = 15;
        }
        else if (charAt == 'q' || charAt == 'Q') {
            list[16] = new nodee();
            list[16].character = charAt;
            x = 16;
        }
        else if (charAt == 'r' || charAt == 'R') {
            list[17] = new nodee();
            list[17].character = charAt;
            x = 17;
        }
        else if (charAt == 's' || charAt == 'S') {
            list[18] = new nodee();
            list[18].character = charAt;
            x = 18;
        }
        else if (charAt == 't' || charAt == 'T') {
            list[19] = new nodee();
            list[19].character = charAt;
            x = 19;
        }
        else if (charAt == 'u' || charAt == 'U') {
            list[20] = new nodee();
            list[20].character = charAt;
            x = 20;
        }
        else if (charAt == 'v' || charAt == 'V') {
            list[21] = new nodee();
            list[21].character = charAt;
            x = 21;
        }
        else if (charAt == 'w' || charAt == 'W') {
            list[22] = new nodee();
            list[22].character = charAt;
            x = 22;
        }
        else if (charAt == 'x' || charAt == 'X') {
            list[23] = new nodee();
            list[23].character = charAt;
            x = 23;
        }
        else if (charAt == 'y' || charAt == 'Y') {
            list[24] = new nodee();
            list[24].character = charAt;
            x = 24;
        }
        else if (charAt == 'z' || charAt == 'Z') {
            list[25] = new nodee();
            list[25].character = charAt;
            x = 25;
        }
        return x;
    }

    //O(n*n)
    public static String searchMeaning(String word){
        if (root == null)
            return null;
        nodee temp = root;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < temp.list.length; j++) {
                if (temp.list[j] != null && temp.list[j].character == word.charAt(i)){
                    temp = temp.list[j];
                    break;
                }
            }
        }
        if(temp.End_word){
            return temp.meaning;
        }

        return "The Word You are looking for does not exist !!";
    }

    //O(n*n)
    public static boolean deleteWord(String word){
        if (root == null)
            return false;
        nodee temp = root;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < temp.list.length; j++) {
                if (temp.list[j] != null && temp.list[j].character == word.charAt(i)){
                    temp = temp.list[j];
                    break;
                }
            }
        }
        temp.meaning = null;
        temp.End_word = false;
        return true;
    }

    //O(n*n*n)//
    public String findWithPrefix(String prefix){
        if (root == null)
            return null;
        nodee temp = root;
        int count = 0;
        String tempWord = prefix;
        for (int i = 0; i < prefix.length(); i++) {
            for (int j = 0; j < temp.list.length; j++) {
                if (temp.list[j] != null && temp.list[j].character == prefix.charAt(i)){
                    temp = temp.list[j];
                    count++;
                    break;
                }
            }
        }
        char[] cArray = new char[26];
        for (int i = 0; i < prefix.length(); i++) {
            cArray[i] = prefix.charAt(i);
        }
        printAllWords(temp,cArray,prefix.length());
        return null;
    }

    //O(n*n)
    public String ChangeMeaning(String word,String NewMean){
        if (root == null)
            return null;
        nodee temp = root;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < temp.list.length; j++) {
                if (temp.list[j] != null && temp.list[j].character == word.charAt(i)){
                    temp = temp.list[j];
                    break;
                }
            }
        }
        if(temp.End_word){
            temp.meaning = NewMean;
            return temp.meaning;
        }
        return "The Word You are looking for does not exist !!";
    }


    // Print all words in Trie with these 2 methods
    //O(n)
    public void printWord(char[] str, int n) {
        System.out.println();
        for(int i=0; i<n; i++)
        {
            System.out.println(str[i]);
        }
    }
    //O(n*n)
    public void printAllWords(nodee root, char[] wordArray, int pos) {
        if(root == null)
            return;
        if(root.End_word)
        {
            printWord(wordArray, pos);
        }
        for(int i=0; i<26; i++)
        {
            if(root.list[i] != null)
            {
                wordArray[pos] = (char) (i+'a');
                printAllWords(root.list[i], wordArray, pos+1);
            }
        }
    }

}

class nodee {
    public nodee[] list; // تعداد حروف الفبای انگلیسی
    boolean End_word;
    char character;
    String meaning;

    public nodee() {
        this.list = new nodee[26];
        this.End_word = false;
    }
}



public class TrieTreeMain {
    static char[] carray = new char[26];
    private static void MethodeMainMenu(TrieTree tt) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n"+"-----------Main Menu--------------");

        System.out.println("  Please Enter a code to Continue !! "+"\n"+
                "1.Insert Word "+ "\n"
                + "2.Delete Word " + "\n"
                + "3.Search Meaning " + "\n"
                + "4.Find Words With This Prefix " + "\n"
                + "5.Print All Words " + "\n"
                + "6.Add Words With a .txt File " + "\n"
                + "7.Exit");

        int Choosed_code = sc.nextInt();

        if(Choosed_code == 1) {
            System.out.println("Please Enter the Word");
            String word = sc.next();
            System.out.println("Please Enter the Meaning");
            String mean = sc.next();
            tt.insertNewWord(word,mean);
            MethodeMainMenu(tt);
        }else if(Choosed_code == 2) {
            System.out.println("Please Enter the Word you want to delete");
            String word = sc.next();
            tt.deleteWord(word);
            MethodeMainMenu(tt);
        }else if(Choosed_code == 3) {
            System.out.println("Please Enter the Word you want to understand its meaning");
            String word = sc.next();
            System.out.println(tt.searchMeaning(word));
            MethodeMainMenu(tt);
        }else if(Choosed_code == 4) {
            System.out.println("Enter the Prefix you are looking For");
            String prefix = sc.next();
            tt.findWithPrefix(prefix);
            MethodeMainMenu(tt);
        }else if(Choosed_code == 5) {
            System.out.println("Here All the Words in the tree"+"\n");
            tt.printAllWords(tt.root,carray,0);
            MethodeMainMenu(tt);
        }else if(Choosed_code == 6) {
            System.out.println("Please enter the location of file you want to add");
            String path = sc.next();
            tt.ReadFormFile(path);
            MethodeMainMenu(tt);
        }else if(Choosed_code == 7) {
            System.out.println("See You Later ...");
            System.exit(0);
        }


    }


    public static void main(String[] args) throws IOException {
        TrieTree tt = new TrieTree();
        Scanner sc = new Scanner(System.in);
        MethodeMainMenu(tt);
 /*       //tt.printAllWords(tt.root,carray,0);
        //tt.findWithPrefix("He");
        tt.ReadFormFile("C:\\Users\\Pouria\\Desktop\\JetBrains.IntelliJ.IDEA_2022.2.1_Windows\\null.txt");
        //System.out.println(tt.searchMeaning("dog"));
        tt.printAllWords(tt.root,carray,0);*/
    }
}


