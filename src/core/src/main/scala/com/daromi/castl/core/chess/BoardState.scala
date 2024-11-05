package com.daromi.castl.core.chess

final private case class BoardState(
    white: PlayerState = PlayerState.white,
    black: PlayerState = PlayerState.black
):
  override def toString: String = BoardStateFormatter.format(this)

private object BoardState:

  def initial: BoardState = BoardState()
