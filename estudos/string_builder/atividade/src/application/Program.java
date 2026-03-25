package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("faça boa viagem");
        Comment c2 = new Comment("uau, isso é incrivel");
        Post p1 = new Post(
                sdf.parse("21/06/2025 13:05:44"),
                "Viajando para Nova Zelândia",
                "Vou visitar esse pais maravilhoso",
                12);
        p1.addComment(c1);
        p1.addComment(c2);

        Comment c3 = new Comment("Muito bacana!");
        Comment c4 = new Comment("Que legal");
        Post p2 = new Post(
                sdf.parse("26/10/2023 14:45:00"),
                "Viajando para Europaa",
                "Vou visitar esse lugar bacana",
                60);
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);
    }
}
