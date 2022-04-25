package absoluteloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class AbsoluteLoader {
    public static void simulate(String sourceCodeFile, String outputFile) throws IOException, FileNotFoundException {
        final String HEAD_CARD = "" + 'H';
        final String TEXT_CARD = "" + 'T';
        final String END_CARD = "" + 'E';

        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceCodeFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        String currentLine;

        while((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");

            if(currentLineSplit[0].equals(HEAD_CARD)) {
                continue;
            }

            if(currentLineSplit[0].equals(END_CARD)) {
                break;
            }

            if(currentLineSplit[0].equals(TEXT_CARD)) {
                int currentTextstartingAddress = Integer.parseInt(currentLineSplit[1]);
                int currentTextLength = Integer.parseInt(currentLineSplit[2]);

                Vector<String> currentTextValuesSplit = new Vector<String>();

                for(int i = 3; i < currentLineSplit.length; i++) {
                    String[] currentLineValues = currentLineSplit[i].split("(?<=\\G.{2})");
                    for(int j = 0; j < currentLineValues.length; j++) {
                        currentTextValuesSplit.addElement(currentLineValues[j]);
                    }
                }

                for(int i = 0; i < currentTextLength; i++) {
                    bufferedWriter.write((currentTextstartingAddress + i) + " " + currentTextValuesSplit.get(i));
                    bufferedWriter.newLine();
                }

                bufferedWriter.newLine();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}