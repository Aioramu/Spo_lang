package com.company;

import Parser.Parser;
import lexer.Lexer;
import lexer.Token;
import Poliz.Poliz;
import Poliz.PolizCalculation;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("src/gojang.txt");
        Scanner inp = new Scanner(file);
        Lexer lexer = new Lexer(inp.nextLine());
        LinkedList<Token> tokens = lexer.tokens();
        while (inp.hasNext()) {
            lexer = new Lexer(inp.nextLine());
            tokens.addAll(lexer.tokens());
        }

        System.out.println("ТОКЕНЫ: ");
        for (Token token: tokens)
            System.out.println(token);

        Parser parser = new Parser(tokens);
        parser.lang();

        System.out.println("\nПОЛИЗ:");
        Poliz poliz = new Poliz(tokens);
        LinkedList<Token> testPoliz = poliz.makePoliz();
        for (Token token : testPoliz) {
            System.out.println(token.toString());
        }

        PolizCalculation.calculate(testPoliz);

    }
}
