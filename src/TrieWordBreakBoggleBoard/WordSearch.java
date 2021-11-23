package TrieWordBreakBoggleBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    // TC: O(n*m) SC: O(n*m)
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length ; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i,int j, int count,String word){
        if(count == word.length()){ return true;}

        if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j] != word.charAt(count) ){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ' ;
        boolean found = dfs(board, i+1, j, count+1,word)
                || dfs(board, i-1, j, count+1,word)
                || dfs(board, i, j+1, count+1,word)
                || dfs(board, i, j-1, count+1,word) ;

        board[i][j] = temp;
        return found;
    }

    // WordSearch II
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length ; j++){
                for(String word : words) {
                    if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    // Boggle Game
    // WordSearch II

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length ; j++){
                for(String word : words) {
                    if (board[i][j] == word.charAt(0) && dfsBoggle(board, i, j, 0, word)) {
                        res.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static boolean dfsBoggle(char[][] board, int i,int j, int count,String word){
        if(count == word.length()){ return true;}

        if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j] != word.charAt(count) ){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ' ;
        boolean found = dfsBoggle(board, i+1, j, count+1,word)
                || dfsBoggle(board, i-1, j, count+1,word)
                || dfsBoggle(board, i, j+1, count+1,word)
                || dfsBoggle(board, i, j-1, count+1,word)
                || dfsBoggle(board, i, j+1, count+1,word)
                || dfsBoggle(board, i+1, j+1, count+1,word)
                || dfsBoggle(board, i-1, j-1, count+1,word)
                || dfsBoggle(board, i+1, j-1, count+1,word)
                || dfsBoggle(board, i-1, j+1, count+1,word);

        board[i][j] = temp;
        return found;
    }
}
