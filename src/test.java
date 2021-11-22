//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//class RunCommand implements Runnable {
//    int x = 0;
//    String command;
//    public RunCommand(String command){
//        this.command = command;
//    }
//    @Override
//    public void run(){
//        // List<String> input = new ArrayList<String>();
//        // StringTokenizer tokenizer = new StringTokenizer(command);
//        // while (tokenizer.hasMoreTokens()) {
//        //     input.add(tokenizer.nextToken());
//        // }
//        // ProcessBuilder pb = new ProcessBuilder(input);
//        // BufferedReader br = null;
//        // try {
//        //     Process proc = pb.start();
//        //     InputStream is = proc.getInputStream();
//        //     InputStreamReader isr = new InputStreamReader(is);
//        //     br = new BufferedReader(isr);
//        //     // read what the process returned
//        //     String line;
//        //     while ((line = br.readLine()) != null) {
//        //         System.out.println(line);
//        //     }
//        //     br.close();
//        // } catch (java.io.IOException ioe) {
//        //     System.err.println("Error");
//        // } finally {
//        //     if (br != null) {
//        //         try {
//        //             br.close();
//        //         } catch (IOException ex) {
//        //             System.err.println("Exception in close");
//        //         }
//        //     }
//        // }
//        //Build command
//
//        //Run macro on target
//        try {
//            ProcessBuilder pb = new ProcessBuilder(command);
//            pb.directory(new File("root"));
//            pb.redirectErrorStream(true);
//            Process process = pb.start();
//
//            //Read output
//            StringBuilder out = new StringBuilder();
//            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = null, previous = null;
//            while ((line = br.readLine()) != null)
//                if (!line.equals(previous)) {
//                    previous = line;
//                    out.append(line).append('\n');
//                    System.out.println(line);
//                }
//
//            //Check result
//            try {
//                if (process.waitFor() == 0) {
//                    System.out.println("Success!");
//                    System.exit(0);
//                }
//            } catch (InterruptedException i) {
//                System.err.println("Error"+i.getMessage());
//            }
//
//            //Abnormal termination: Log command parameters and output and throw ExecutionException
//            System.err.println(command);
//            System.err.println(out.toString());
//            System.exit(1);
//        }catch (java.io.IOException ioe) {
//            System.err.println("Error");
//        } finally {
//            System.err.println("finally");
//        }
//    }
//}
//
//public class Solution {
//
//    static void processCommand(String command){
//        Thread t = new Thread(new RunCommand(command));
//        t.start();
//    }
//    public static void main(String args[] ) throws Exception {
//
//        List<String> commands = new ArrayList<String>();
//        commands.add("pwd");
//        //Add arguments
//        commands.add("quit");
//        System.out.println(commands);
//        //String commandLine;
//        File wd;
//        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            // show the Java shell prompt and read what command they entered
//            for(String c:commands){
//                // if user entered a return, just loop again
//                if (c.equals("")) {
//                    continue;
//                }
//                if (c.toLowerCase().equals("quit")) { //User wants to end shell
//                    System.exit(0);
//                }
//                processCommand(c);
//            }
//        }
//        //Build command
//    }
//
//}
//
//import java.io.*;
//        import java.util.*;
//        import java.text.*;
//        import java.math.*;
//        import java.util.regex.*;
//
//public class Solution {
//
//    public static void main(String args[] ) throws Exception {
//        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//        String line = null, previous = null;
//        while ((line = console.readLine()) != null){
//            if (!line.equals(previous)) {
//                previous = line;
//                //out.append(line).append('\n');
//                System.out.println(command(line, "/root"));
//            }
//        }
//    }
//    public static ArrayList<String> command(final String cmdline,
//                                            final String directory) {
//        try {
//            Process process =
//                    new ProcessBuilder(new String[] {"bash", "-c", cmdline})
//                            .redirectErrorStream(true)
//                            .directory(new File(directory))
//                            .start();
//
//            ArrayList<String> output = new ArrayList<String>();
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//            String line = null;
//            while ( (line = br.readLine()) != null )
//                output.add(line);
//
//            //There should really be a timeout here.
//            if (0 != process.waitFor())
//                return null;
//
//            return output;
//
//        } catch (Exception e) {
//            //Warning: doing this is no good in high quality applications.
//            //Instead, present appropriate error messages to the user.
//            //But it's perfectly fine for prototyping.
//
//            return null;
//        }
//    }
//}