// src/main/Main.java

package main;

 

import game.App;

 

class="c">// FILE 1 - Entry point.

class="c">// Starts everything on the Swing Event Dispatch Thread.

class="c">// Double-clicking the compiled .jar executes this first.

 

public class Main{

  public static void main(String[] args) {

    javax.swing.SwingUtilities.invokeLater((null) -> {

      App app = new App();

      app.start();

    });

  

  }

}
