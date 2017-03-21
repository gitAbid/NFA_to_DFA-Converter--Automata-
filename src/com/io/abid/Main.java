package com.io.abid;


import sun.misc.Queue;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        HashMap<String, String> nfa = new HashMap<>();
        Stack<String> tempKeys = new Stack<>();
        Stack<String> keys = new Stack<>();
        Queue<String> pendingList = new Queue<>();
        Set<String> lines = new HashSet<String>(10000);

        String line;
        String key;
        String value0;
        String value1;
        String valuesOf01;
        String nfaState = "";
        String currentState = "";
        String subkey[] = new String[100];
        int i = 0;
        int limit = 0;
        int counter = 0;
        int lineSize[]=new int[50];

        System.out.print("Please Enter The Iteration Number :  ");
        Scanner input = new Scanner(System.in);
        limit = input.nextInt();


        try {
            BufferedReader inputTable = new BufferedReader(new FileReader("NFA.txt"));
            BufferedWriter outputTable = new BufferedWriter(new FileWriter("DFA.txt"));
            BufferedReader I_DFA = new BufferedReader(new FileReader("DFA.txt"));
            BufferedWriter DFA = new BufferedWriter(new FileWriter("Perfect_DFA.txt"));
            BufferedReader _DFA= new BufferedReader(new BufferedReader(new FileReader("Perfect_DFA.txt")));
            while ((line = inputTable.readLine()) != null) {
                key = line.substring(0, line.indexOf("|")).trim();
                line = line.substring(line.indexOf("|") + 1, line.length()).trim();
                value0 = line.substring(0, line.indexOf("|")).trim();
                line = line.substring(line.indexOf("|") + 1, line.length()).trim();
                value1 = line.substring(0, line.length()).trim();

                valuesOf01 = value0 + "!" + value1;
                nfa.put(key, valuesOf01);
                tempKeys.push(key);

            }
            while (!tempKeys.isEmpty()) {
                keys.push(tempKeys.pop());
            }


            {
                key = keys.pop();
                valuesOf01 = nfa.get(key);
                value0 = valuesOf01.substring(0, valuesOf01.indexOf("!")).trim();
                value1 = valuesOf01.substring(valuesOf01.indexOf("!") + 1, valuesOf01.length());
                outputTable.write("\t{" + key + "} \t|\t {" + value0 + "} \t|\t {" + value1 + "}\t\n\t");
                outputTable.flush();

                pendingList.enqueue(value0);
                pendingList.enqueue(value1);


                for (int j = 0; j < limit; j++) {
                    currentState = pendingList.dequeue();
                    Convertion(nfa, nfaState, currentState, subkey, i, counter, pendingList, outputTable);
                }

                while ((line = I_DFA.readLine()) != null) {
                    lines.add(line);
                }
                I_DFA.close();

                for (String unique : lines) {
                    DFA.write(unique);
                    DFA.newLine();
                }
            }

            DFA.close();

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }


    private static void Convertion(HashMap<String, String> nfa, String nfaState, String currentState, String[] subkey, int i, int counter, Queue<String> pendingList, BufferedWriter outputTable) throws IOException {

        String state;
        String tempnfaState0;
        String tempnfaState1;
        String nfaState1 = "";
        String OCurrentValue = currentState;

        while (currentState.contains(",")) {
            subkey[i] = currentState.substring(0, currentState.indexOf(",")).trim();
            currentState = currentState.substring(currentState.indexOf(",") + 1, currentState.length());

            i++;

        }
        subkey[i] = currentState;

        while (counter <= i) {
            state = nfa.get(subkey[counter]);
            tempnfaState0 = state.substring(0, state.indexOf("!"));
            tempnfaState1 = state.substring(state.indexOf("!") + 1, state.length());

            nfaState = nfaState + tempnfaState0 + ",";
            nfaState1 = nfaState1 + tempnfaState1 + ",";

            counter++;

        }

        nfaState = nfaState.substring(0, nfaState.length() - 1);
        nfaState1 = nfaState1.substring(0, nfaState1.length() - 1);


        try {
            outputTable.write("\t{" + UniqueSort(OCurrentValue) + "}" + " \t|\t " + "{" + UniqueSort(nfaState) + "}" + " \t|\t " + "{" + UniqueSort(nfaState1) + "}" + "\t\n\t");
            outputTable.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pendingList.enqueue(nfaState);
        pendingList.enqueue(nfaState1);

    }

    public static String UniqueSort(String string) {
        String unique = string;
        String s = "";


        if (unique.contains("0")) {
            s = s + "0,";
        }
        if (unique.contains("1")) {
            s = s + "1,";
        }
        if (unique.contains("2")) {
            s = s + "2,";
        }
        if (unique.contains("3")) {
            s = s + "3,";
        }
        if (unique.contains("4")) {
            s = s + "4,";
        }
        if (unique.contains("5")) {
            s = s + "5,";
        }
        if (unique.contains("6")) {
            s = s + "6,";
        }
        if (unique.contains("7")) {
            s = s + "7,";
        }
        if (unique.contains("8")) {
            s = s + "8,";
        }
        if (unique.contains("9")) {
            s = s + "9,";
        }
        if (unique.contains("a")) {
            s = s + "a,";
        }
        if (unique.contains("b")) {
            s = s + "b,";
        }
        if (unique.contains("c")) {
            s = s + "c,";
        }
        if (unique.contains("d")) {
            s = s + "d,";
        }
        if (unique.contains("e")) {
            s = s + "e,";
        }
        if (unique.contains("f")) {
            s = s + "f,";
        }
        if (unique.contains("g")) {
            s = s + "g,";
        }
        if (unique.contains("h")) {
            s = s + "h,";
        }
        if (unique.contains("i")) {
            s = s + "i,";
        }
        if (unique.contains("j")) {
            s = s + "j,";
        }
        if (unique.contains("k")) {
            s = s + "k,";
        }
        if (unique.contains("1")) {
            s = s + "l,";
        }
        if (unique.contains("m")) {
            s = s + "m,";
        }
        if (unique.contains("n")) {
            s = s + "n,";
        }
        if (unique.contains("o")) {
            s = s + "o,";
        }
        if (unique.contains("p")) {
            s = s + "p,";
        }
        if (unique.contains("q")) {
            s = s + "q,";
        }
        if (unique.contains("r")) {
            s = s + "r,";
        }
        if (unique.contains("s")) {
            s = s + "s,";
        }
        if (unique.contains("t")) {
            s = s + "t,";
        }
        if (unique.contains("u")) {
            s = s + "u,";
        }
        if (unique.contains("v")) {
            s = s + "v,";
        }
        if (unique.contains("w")) {
            s = s + "w,";
        }
        if (unique.contains("x")) {
            s = s + "x,";
        }
        if (unique.contains("y")) {
            s = s + "y,";
        }
        if (unique.contains("z")) {
            s = s + "z,";
        }
      s = s.substring(0, s.length() - 1);
        return s;
    }

}

