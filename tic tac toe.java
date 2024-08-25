import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] board = new String[3][3];      //board initialize
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board.length; j++) {
                board[i][j]="_";

            }
            System.out.println();
        }

        printBoard(board);
        turn(board);
    }


    public static void printBoard(String[][] board){                //printing board
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board.length; j++) {
                if(i!=board.length-1)
                     System.out.print("|__"+board[i][j] +"__|");
                else
                {
                    System.out.print("|  "+board[i][j] +"  |");
                }

            }
            System.out.println();
        }
    }


   public static void turn(String[][]board){
        boolean turns = true;  //true means x turn otherwise o turn
       int x,y;
       Scanner sc= new Scanner(System.in);
       int times=0;         //no of turns

       while( times<9) {
           if (turns) {                   
               System.out.print("X's Turn : ");
               x = sc.nextInt();    //value of [x][]
               y = sc.nextInt();    //value of [][y]
               update(board, x, y, "X");
               printBoard(board);
               wins(board ,"X");
               turns = false;
           }
           else {
               System.out.print("O's Turn : ");
               x = sc.nextInt();
               y = sc.nextInt();
               update(board, x, y, "O");
               printBoard(board);
               wins(board ,"O");

               turns = true;
           }
           times++;
       }
       if(times==9 && !won)
           System.out.println("DRAW");

   }


   public static void update(String[][] board,int x,int y ,String val){  //update the board 
        board[x][y]=val;
   }

//winning algoriithm


   public static void wins(String[][]board , String name){
       //checking row and column win possibilities
        for(int i=0,j=0;i<board.length;i++){
                
                if(board[i][j].equals(board[i][j + 1]) && board[i][j + 2].equals(board[i][j]) && !board[i][j].equals("_") && !board[i][j + 1].equals("_") && !board[i][j + 2].equals("_")) {
                    winner(name);
                }
                else if(board[j][i].equals(board[j + 1][i]) && board[j][i].equals(board[j + 2][i]) && !board[j][i].equals("_") && !board[j + 1][i].equals("_") && !board[j + 2][i].equals("_"))
                       winner(name);

        }
       //for diagnol win possibilities
                if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[1][1].equals("_"))
                    winner(name);
                else if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[2][0].equals("_"))
                    winner(name);



   }
    // winner appericiation
   public static void winner(String name){

            System.out.println("-----------Game Over-------------");
            System.out.println( "--------------Winner of the Game is " + name +" --------------" );
            System.exit(0); // exit game





   }

}
