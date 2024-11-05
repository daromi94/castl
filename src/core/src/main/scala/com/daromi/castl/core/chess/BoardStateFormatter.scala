package com.daromi.castl.core.chess

private object BoardStateFormatter:

  private val Files = 8

  private val Ranks = 8

  private val FilesLabels = Seq('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')

  def format(boardState: BoardState): String =
    val sb = StringBuilder()

    val filesLabels = FilesLabels.mkString(" ")
    sb.append(s"  $filesLabels\n")

    var rank = Ranks
    sb.append(rank)

    for i <- Ranks * Files - 1 to 0 by -1 do
      val symbol = symbolAt(boardState, i)

      sb.append(' ').append(symbol)

      if i % Files == 0 then
        sb.append(' ').append(rank).append('\n')
        rank -= 1
        if rank > 0 then sb.append(rank)

    sb.append(s"  $filesLabels\n")
    sb.toString()

  private def symbolAt(boardState: BoardState, index: Int): Char =
    val (white, black) = (boardState.white, boardState.black)

    val isPiece = isPieceAt(index)

    if      isPiece(black.pawns)   then 'p'
    else if isPiece(black.rooks)   then 'r'
    else if isPiece(black.knights) then 'n'
    else if isPiece(black.bishops) then 'b'
    else if isPiece(black.queens)  then 'q'
    else if isPiece(black.king)    then 'k'
    else if isPiece(white.pawns)   then 'P'
    else if isPiece(white.rooks)   then 'R'
    else if isPiece(white.knights) then 'N'
    else if isPiece(white.bishops) then 'B'
    else if isPiece(white.queens)  then 'Q'
    else if isPiece(white.king)    then 'K'
    else
      '.'

  private def isPieceAt(index: Int)(bitBoard: BitBoard): Boolean = (bitBoard >> index & 0x01L) > 0
