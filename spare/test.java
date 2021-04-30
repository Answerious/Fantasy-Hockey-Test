import java.io.*;

public class test {
    public static void main(String[] args) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}