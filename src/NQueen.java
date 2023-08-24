import java.util.*;
import java.util.LinkedList;

public class NQueen {
    public static void main(String[] args) {
        int n =4;
        char[][] board = new char[n][n];
        for ( int i = 0;i<n;i++){
            for ( int j =0; j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solution(0,board,ans);
        int i = 1;
        for (List < String > it: ans) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }

    private static void solution(int i, char[][] board, List<List<String>> ans) {
        if ( i == board.length){
            ans.add(construct(board));
            return;
        }
        for ( int j = 0;j< board.length;j++){
            if (isSafe(j,i,board)) {
                board[j][i] = 'Q';
                solution(i + 1, board, ans);
                board[j][i] ='.';

            }
        }
    }

    private static boolean isSafe(int i, int j, char[][] board) {
        int row = i;
        int col = j;
        while (i>=0 && j >= 0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        i =row;
        j =col;
        while (j>=0){
            if(board[i][j]=='Q') return false;
            j--;
        }
        i =row;
        j =col;
        while (i<board.length && j>=0 ){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        return true;
    }
    static List <String> construct(char[][] board) {
        List <String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
