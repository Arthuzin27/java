import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); /* Usado para modificar como a Data será exibida */
       
        LocalDate d01 = LocalDate.now(); /* Somente a data */
        System.out.println(d01);

        LocalDateTime d02 = LocalDateTime.now(); /* Data e hora */
        System.out.println(d02);

        Instant d03 = Instant.now(); /* Data hora GNT - Horário de Londres*/
        System.out.println(d03);

        LocalDate d04 = LocalDate.parse("2022-07-20"); /* Cria sua própria data */
        System.out.println(d04);

        LocalDateTime d05 = LocalDateTime.parse("2022-04-28T01:30:26"); /* Cria data e hora que vc quiser */
        System.out.println(d05);

        Instant d06 = Instant.parse("2022-04-28T01:30:26Z");
        System.out.println(d06);

        Instant d07 = Instant.parse("2022-04-28T01:30:26-03:00");
        System.out.println(d07);

        LocalDate d08 = LocalDate.parse("20/07/2025", fmt1);
        System.out.println(d08);

        
    }
}
