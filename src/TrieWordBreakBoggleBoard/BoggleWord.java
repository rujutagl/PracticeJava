package TrieWordBreakBoggleBoard;

import java.util.*;

class BoggleWord {
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(isWordOnBoard(board, word)){
                res.add(word);
            }
        }
        return res;
    }

    private static boolean isWordOnBoard(char[][] board, String word) {
        for(int m =0; m<board.length; m++ ) {
            for(int n =0; n<board[0].length; n++ ) {
                if(board[m][n] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[m][n] = true;
                    if (isWordOnBoard(board, m, n, word, 1, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isWordOnBoard(char[][] board, int m, int n, String word, int i, boolean[][] visited) {
        System.out.println(i + " m"+m + " n"+n);
        if(i==word.length()) return true;
        //check all surrounding chars
        for(int r = m-1; r<=m+1; r++) {
            for(int c = n-1; c<=n+1; c++) {
                if(r<0 || r>= board.length || c<0 || c>= board[0].length) {
                    continue;
                }
                if(visited[r][c]) {
                    continue;
                }
                if(board[r][c] == word.charAt(i)){
                    visited[r][c] = true;
                    if(isWordOnBoard(board, r, c, word, i+1, visited)){
                        return true;
                    }
                    visited[r][c] = false;
                }
            }
        }
        return false;
    }
}

