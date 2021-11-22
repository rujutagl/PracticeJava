import java.util.Stack;

public class SimplifyFilePath {

    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        for(int i = 0; i< paths.length ; i++){
            if(!s.isEmpty() && paths[i].equals(".."))
                s.pop();
            if(!paths[i].equals("") && !paths[i].equals(".") && !paths[i].equals(".."))
                s.push(paths[i]);
        }
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            sb.insert(0,s.pop()).insert(0,"/");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s="/a/./b/../../c/";
        simplifyPath(s);

    }
}
