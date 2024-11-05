package com.daromi.castl.core.chess

private type BitBoard = Long

final private case class PlayerState(
    pawns: BitBoard,
    rooks: BitBoard,
    knights: BitBoard,
    bishops: BitBoard,
    queens: BitBoard,
    king: BitBoard
)

private object PlayerState:

  // Initial state for the white pieces
  val white: PlayerState = PlayerState(
    pawns   = 0x00_00_00_00_00_00_ff_00L, // White pawns on rank 2
    rooks   = 0x00_00_00_00_00_00_00_81L, // White rooks on a1 and h1
    knights = 0x00_00_00_00_00_00_00_42L, // White knights on b1 and g1
    bishops = 0x00_00_00_00_00_00_00_24L, // White bishops on c1 and f1
    queens  = 0x00_00_00_00_00_00_00_10L, // White queen on d1
    king    = 0x00_00_00_00_00_00_00_08L  // White king on e1
  )

  // Initial state for the black pieces
  val black: PlayerState = PlayerState(
    pawns   = 0x00_ff_00_00_00_00_00_00L, // Black pawns on rank 7
    rooks   = 0x81_00_00_00_00_00_00_00L, // Black rooks on a8 and h8
    knights = 0x42_00_00_00_00_00_00_00L, // Black knights on b8 and g8
    bishops = 0x24_00_00_00_00_00_00_00L, // Black bishops on c8 and f8
    queens  = 0x10_00_00_00_00_00_00_00L, // Black queen on d8
    king    = 0x08_00_00_00_00_00_00_00L  // Black king on e8
  )
