/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import javax.swing.JOptionPane;

/**
 *
 * @author Monica
 */
public class JuegoConTorres {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        try 
        {
            Tablero();
        }
            catch (Error e) 
            {
            JOptionPane.showMessageDialog(null, e.getMessage());
            main(null);                    
            }
            catch (Exception ex)
            {
            System.out.println(ex);
            }
    }
    
    private static void Tablero() 
    {
        JuegoConTorres juegoTorres = new JuegoConTorres();
        int R = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de R"));
        int C = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de C"));
        int N = R*C;     
        String[] muestra = juegoTorres.construir(R, C, N);        
        System.out.print("{ ");
        for (int i = 0; i < muestra.length; i++) 
        {
            if (i == (muestra.length-1)) 
            {
                System.out.print("\"" + muestra[i] + "\"");  
            }
            else
            {
                System.out.print("\"" + muestra[i] + "\",");  
            }
        }
        System.out.print(" }\n");
    }    
    
    public String[] construir(int R, int C, int N)
    {
        String[] res = new String[R];
        if (R < 1 || R > 50 || C < 1 || C > 50)
        {
            throw new Error("El valor de R o de C no se encuentra dentro del rango 1-50");
        }
        String[][] tablero = new String[R][C];
        for (int i = 0; i < R; i++) 
        {
            for (int j = 0; j < C; j++) 
                {   
                    int mod = (i + j) % 2;
                    if (i == 0) 
                    {   
                        pintarTorres(tablero, mod, i, j);
                    }   
                    else 
                    if (i == (R - 1)) 
                    {
                        pintarTorres(tablero, mod, i, j);
                    }
                    else 
                    {
                        tablero[i][j] = ".";
                    }
                }
        }
        for (int i = 0; i < R; i++) 
            {
            String linea = "";
            for (int j = 0; j < C; j++) 
            {
                linea += tablero[i][j];
            }
            res[i] = linea;
            }
        return res;
    }
    
    private void pintarTorres(String[][] tablero, int mod, int i, int j) 
    {
        if (mod == 0) 
        {
            tablero[i][j] = "W";
        } 
        else 
        {
            tablero[i][j] = "B";
        }
    }
}
