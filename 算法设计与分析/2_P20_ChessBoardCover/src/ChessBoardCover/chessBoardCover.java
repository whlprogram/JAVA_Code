package ChessBoardCover;

public class chessBoardCover {//棋盘覆盖 课本P20

	/**
	 * @param args
	 */
	public static int Board[][];//棋盘的布局
	public static int tile = 1;//L型骨牌的编号
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Board = new int[8][8];
		  //定义棋盘初始值
		  for (int i=0;i<8;i++)
			  for (int j=0;j<8;j++)
				  Board[i][j] = 0;
		  
		  ChessBoard(0, 0, 0, 0, 8);
		  //输出新棋盘
		  for (int i=0;i<8;i++)
		  {
			  for (int j=0;j<8;j++)
				  System.out.print(Board[i][j] + " ");
			  System.out.println();
		  }
	}
	//tr:棋盘左上角方格的行号
	//tc:棋盘左上角方格的列号
	//dr:特殊方格所在行号
	//dc:特殊方格所在列号
	//size: size = 2^k ,棋盘规格为2^k * 2^k
	public static void ChessBoard(int tr, int tc, int dr, int dc, int size){
		if(size == 1)
			return;
		int t = tile++;//L型骨牌号
		int s = size/2;//分割棋盘
		//覆盖左上角子棋盘
		if(dr<tr+s && dc<tc+s)
			//特殊方格在此棋盘中
			ChessBoard(tr, tc, dr, dc, s);
		else{//此棋盘中无特殊方格
			//用t号L型骨牌覆盖右下角
			Board[tr+s-1][tc+s-1] = t;
			//覆盖其余方格
			ChessBoard(tr, tc, tr+s-1, tc+s-1, s);	
		}
		//覆盖右上角子棋盘
		if(dr<tr+s && dc>=tc+s)
			//特殊方格在此棋盘中
			ChessBoard(tr, tc+s, dr, dc, s);
		else{//此棋盘中无特殊方格
			//用t号L型骨牌覆盖左下角
			Board[tr+s-1][tc+s] = t;
			//覆盖其余方格
			ChessBoard(tr, tc+s, tr+s-1, tc+s, s);	
		}
		//覆盖左下角子棋盘
		if(dr>=tr+s && dc<tc+s)
			//特殊方格在此棋盘中
			ChessBoard(tr+s, tc, dr, dc, s);
		else{//此棋盘中无特殊方格
			//用t号L型骨牌覆盖右上角
			Board[tr+s][tc+s-1] = t;
			//覆盖其余方格
			ChessBoard(tr+s, tc, tr+s, tc+s-1, s);	
		}
		//覆盖右下角子棋盘
		if(dr>=tr+s && dc>=tc+s)
			//特殊方格在此棋盘中
			ChessBoard(tr+s, tc+s, dr, dc, s);
		else{//此棋盘中无特殊方格
			//用t号L型骨牌覆盖左上角
			Board[tr+s][tc+s] = t;
			//覆盖其余方格
			ChessBoard(tr+s, tc+s, tr+s, tc+s, s);	
		}
			
	}

}
