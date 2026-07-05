# Tic-Tac-Toe (Java)

A console-based Tic-Tac-Toe game built in Java using core OOP principles — interfaces, encapsulation, and dependency injection for cleaner, testable code.

## Features

- Two-player console gameplay with custom player names
- Row, column, and both-diagonal win detection
- Draw detection when the board is full
- Input validation for out-of-bounds and occupied cells

## Design

- `Board` — interface defining board behavior (`makeMove`, `isValidMove`, `isGameOver`, `isDraw`, `displayBoard`), implemented by `TicTacToeBoard`
- `BoardGames` — interface for game lifecycle (`playGame`, `announceResult`), implemented by `TicTacToeGame`
- `Player` — immutable player entity holding name and symbol
- `Scanner` is constructor-injected into `TicTacToeGame` rather than created internally, decoupling the game logic from the I/O source

## Project Structure

```
src/main/
├── Client.java              # entry point / composition root
├── BoardGames.java           # game lifecycle interface
├── board/
│   ├── Board.java
│   └── TicTacToeBoard.java
├── boardgames/
│   └── TicTacToeGame.java
├── players/
│   └── Player.java
└── consts/
    ├── Symbol.java
    └── GameStatus.java
```

## How to Run

```bash
javac -d out $(find src/main -name "*.java")
java -cp out main.Client
```

You'll be prompted for both player names, then asked to enter a row and column (1–3) on each turn.

## Sample Gameplay

```
Enter 1st Player Name
Dwight
Enter 2nd Player Name
Jim
  |   |   | 
  |   |   | 
  |   |   | 
Player's turn Dwight
Enter row between 1 and 3
1
Enter column between 1 and 3
1
```