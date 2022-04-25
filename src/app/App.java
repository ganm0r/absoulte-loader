package app;

import absoluteloader.AbsoluteLoader;

public class App {
    public static void main(String[] args) throws Exception {
        final String INPUT_FILE_NAME = "/home/gndhrv/Documents/Sem VI/SPCC/AbsoluteLoader/lib/inputFile.txt";
        final String OUTPUT_FILE_NAME = "/home/gndhrv/Documents/Sem VI/SPCC/AbsoluteLoader/lib/outputFile.txt";

        AbsoluteLoader.simulate(INPUT_FILE_NAME, OUTPUT_FILE_NAME);
    }
}
